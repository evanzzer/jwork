package evanshebert.jwork.controller;

import evanshebert.jwork.database.DatabaseBonus;
import evanshebert.jwork.database.DatabaseInvoice;
import evanshebert.jwork.database.DatabaseJob;
import evanshebert.jwork.database.DatabaseJobseeker;
import evanshebert.jwork.enums.InvoiceStatus;
import evanshebert.jwork.exceptions.InvoiceNotFoundException;
import evanshebert.jwork.exceptions.JobNotFoundException;
import evanshebert.jwork.exceptions.JobseekerNotFoundException;
import evanshebert.jwork.objects.BankPayment;
import evanshebert.jwork.objects.EwalletPayment;
import evanshebert.jwork.objects.Invoice;
import evanshebert.jwork.objects.Job;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/invoice")
@RestController
public class InvoiceController
{
    @RequestMapping("")
    public ArrayList<Invoice> getAllInvoice()
    {
        return DatabaseInvoice.getInvoiceDatabase();
    }

    @RequestMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable int id)
    {
        try {
            return DatabaseInvoice.getInvoiceById(id);
        } catch (InvoiceNotFoundException e) {
            e.getMessage();
            return null;
        }
    }

    @RequestMapping("/jobseeker/{jobseekerId}")
    public ArrayList<Invoice> getInvoiceByJobseekerId(@PathVariable int jobseekerId)
    {
        return DatabaseInvoice.getInvoiceByJobseeker(jobseekerId);
    }

    @RequestMapping(value = "/invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@PathVariable int id,
                                       @RequestParam(value = "status") InvoiceStatus status)
    {
        boolean state = DatabaseInvoice.changeInvoiceStatus(id, status);
        if (state) {
            try {
                return DatabaseInvoice.getInvoiceById(id);
            } catch (InvoiceNotFoundException e) {
                e.getMessage();
                return null;
            }
        } else return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean removeInvoice(@PathVariable int id)
    {
        try {
            return DatabaseInvoice.removeInvoice(id);
        } catch (InvoiceNotFoundException e) {
            e.getMessage();
            return false;
        }
    }

    @RequestMapping(value = "/createBankPayment", method = RequestMethod.POST)
    public Invoice addBankPayment(@RequestParam(value = "jobIdList") ArrayList<Integer> jobIdList,
                                  @RequestParam(value = "jobseekerId") int jobseekerId,
                                  @RequestParam(value = "adminFee") int adminFee)
    {
        try {
            ArrayList<Job> job = new ArrayList<>();
            for (int id : jobIdList) {
                job.add(DatabaseJob.getJobById(id));
            }
            Invoice invoice = new BankPayment(DatabaseInvoice.getLastId() + 1, job, DatabaseJobseeker.getJobseekerById(jobseekerId), adminFee);
            invoice.setTotalFee();
            boolean state = DatabaseInvoice.addInvoice(invoice);
            return state ? invoice : null;
        } catch (JobNotFoundException e) {
            e.getMessage();
            return null;
        } catch (JobseekerNotFoundException e) {
            e.getMessage();
            return null;
        }
    }

    @RequestMapping(value = "/createEWalletPayment", method = RequestMethod.POST)
    public Invoice addEWalletPayment(@RequestParam(value = "jobIdList") ArrayList<Integer> jobIdList,
                                     @RequestParam(value = "jobseekerId") int jobseekerId,
                                     @RequestParam(value = "referralCode") String referralCode)
    {
        try {
            ArrayList<Job> job = new ArrayList<>();
            for (int id : jobIdList) {
                job.add(DatabaseJob.getJobById(id));
            }

            Invoice invoice;
            if (referralCode != null && !referralCode.isBlank()) {
                invoice = new EwalletPayment(DatabaseInvoice.getLastId() + 1, job, DatabaseJobseeker.getJobseekerById(jobseekerId), DatabaseBonus.getBonusByReferralCode(referralCode));
            } else {
                invoice = new EwalletPayment(DatabaseInvoice.getLastId() + 1, job, DatabaseJobseeker.getJobseekerById(jobseekerId));
            }
            invoice.setTotalFee();
            boolean state = DatabaseInvoice.addInvoice(invoice);
            return state ? invoice : null;
        } catch (JobNotFoundException e) {
            e.getMessage();
            return null;
        } catch (JobseekerNotFoundException e) {
            e.getMessage();
            return null;
        }
    }
}
