package evanshebert.jwork.objects;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import evanshebert.jwork.enums.InvoiceStatus;
import evanshebert.jwork.enums.PaymentType;

/**
 * Details about invoices.
 * 
 * @author Evans Hebert
 * @version 22 April 2021
 */
public abstract class Invoice
{
    private int id;
    private ArrayList<Job> jobs;
    private Calendar date;
    protected int totalFee;
    private Jobseeker jobseeker;
    private InvoiceStatus invoiceStatus;

    /*
     * Constructor
     * Declares a new Invoice object
     */
    public Invoice(int id, ArrayList<Job> jobs, Jobseeker jobseeker)
    {
        this.id = id;
        this.jobs = jobs;
        this.jobseeker = jobseeker;
        invoiceStatus = InvoiceStatus.Ongoing;
        date = Calendar.getInstance();
    }

    // Getter
    /**
     * Retrieve Invoice ID
     * @return Invoice ID
     */
    public int getId()
    {
        // Get id
        return id;
    }
    
    /**
     * Retrieve Invoice Job
     * @return Invoice Job
     */
    public ArrayList<Job> getJobs()
    {
        // Get ID Job
        return jobs;
    }
    
    /**
     * Retrieve invoice date
     * @return Invoice Date
     */
    public Calendar getDate()
    {
        // Get Date
        return date;
    }
    
    /**
     * Retrieve the amount of fee of an Invoice
     * @return Total Fee of an Invoice
     */
    public int getTotalFee()
    {
        // Get Total Fee
        return totalFee;
    }
    
    /**
     * Retrieve the jobseeker that creates the invoice
     * @return Jobseeker Object
     */
    public Jobseeker getJobseeker()
    {
        // Get jobseeker
        return jobseeker;
    }
    
    /**
     * Retrieve the payment type of the invoice
     * @return Payment Type of the Invoice
     */
    public abstract PaymentType getPaymentType();
    
    /**
     * Retrieve the status of the invoice
     * @return Status of the Invoice
     */
    public InvoiceStatus getInvoiceStatus()
    {
        // Get Status
        return invoiceStatus;
    }

    // Setter
    /**
     * Set the ID of an Invoice
     * @param id ID of an Invoice
     */
    public void setId(int id)
    {
        // Set ID
        this.id = id;
    }
    
    /**
     * Set the Job of an Invoice
     * @param jobs Job of an Invoice
     */
    public void setJobs(ArrayList<Job> jobs)
    {
        // Set Jobs
        this.jobs = jobs;
    }
    
    /**
     * Set the date of an Invoice
     * @param date Invoice Date
     */
    public void setDate(Calendar date)
    {
        // Set Date
        this.date = date;
    }

    /**
     * Set the date of an Invoice by using year, month, and day of Month
     * @param year Invoice Date's year
     * @param month Invoice Date's month
     * @param dayOfMonth Invoice Date
     */
    public void setDate(int year, int month, int dayOfMonth)
    {
        // Set Date
        date = new GregorianCalendar(year, month, dayOfMonth);
    }

    /**
     * Set the total fee of an Invoice
     */
    public abstract void setTotalFee();
    
    /**
     * Set the jobseeker that create the Invoice
     * @param jobseeker The jobseeker
     */
    public void setJobseeker(Jobseeker jobseeker)
    {
        // Set jobseeker
        this.jobseeker = jobseeker;
    }
    
    /**
     * Set the status of the invoice
     * @param invoiceStatus Invoice Status
     */
    public void setInvoiceStatus(InvoiceStatus invoiceStatus)
    {
        // Set Status
        this.invoiceStatus = invoiceStatus;
    }

    // Other Functions
    /**
     * Print out the information of an invoice
     */
    public abstract String toString();
}