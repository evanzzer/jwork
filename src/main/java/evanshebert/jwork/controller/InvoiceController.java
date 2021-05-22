package evanshebert.jwork.controller;

import evanshebert.jwork.*;
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

    @RequestMapping("/{jobseekerId}")
    public ArrayList<Invoice> getInvoiceByJobseekerId(@PathVariable int jobseekerId)
    {
        return DatabaseInvoice.getInvoiceByJobseeker(jobseekerId);
    }

    @RequestMapping(value = "/invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@RequestParam(value = "id") int id,
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
    public Invoice addBankPayment(@RequestParam(value = "jobIdList") ArrayList<Integer> jobIdList,
                                  @RequestParam(value = "jobseekerId") int jobseekerId,
                                  @RequestParam(value = "bonus") String bonus)
    {
        try {
            ArrayList<Job> job = new ArrayList<>();
            for (int id : jobIdList) {
                job.add(DatabaseJob.getJobById(id));
            }
            Invoice invoice = new EwalletPayment(DatabaseInvoice.getLastId() + 1, job, DatabaseJobseeker.getJobseekerById(jobseekerId), DatabaseBonus.getBonusByReferralCode(bonus));
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
