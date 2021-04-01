/**
 * Details about invoices.
 * 
 * @author Evans Hebert
 * @version 01 April 2021
 */
public abstract class Invoice
{
    private int id;
    private Job job;
    private String date;
    protected int totalFee;
    private Jobseeker jobseeker;
    private InvoiceStatus invoiceStatus;

    /*
     * Constructor
     * Declares a new Invoice object
     */
    public Invoice(int id, Job job, String date, Jobseeker jobseeker, InvoiceStatus invoiceStatus)
    {
        this.id = id;
        this.job = job;
        this.date = date;
        this.jobseeker = jobseeker;
        this.invoiceStatus = invoiceStatus;
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
    public Job getJob()
    {
        // Get ID Job
        return job;
    }
    
    /**
     * Retrieve invoice date
     * @return Invoice Date
     */
    public String getDate()
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
     * Retrive the status of the invoice
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
     * @param idJob Job of an Invoice
     */
    public void setJob(Job job)
    {
        // Set Jobs
        this.job = job;
    }
    
    /**
     * Set the date of an Invoice
     * @param date Invoice Date
     */
    public void setDate(String date)
    {
        // Set Date
        this.date = date;
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
     * @param status Invoice Statuss
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
    public abstract void printData();
}