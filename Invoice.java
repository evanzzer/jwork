/**
 * Details about invoices.
 * Contains ID, Job ID, Date, Total Fee, and the Jobseeker.
 * 
 * @author Evans Hebert
 * @version 18 March 2021
 */
public class Invoice
{
    private int id;
    private int idJob;
    private String date;
    private int totalFee;
    private Jobseeker jobseeker;
    private PaymentType paymentType;
    private InvoiceStatus status;

    /*
     * Constructor
     * Declares a new Invoice object
     */
    public Invoice(int id, int idJob, String date, int totalFee, Jobseeker jobseeker, PaymentType paymentType, InvoiceStatus status)
    {
        this.id = id;
        this.idJob = idJob;
        this.date = date;
        this.totalFee = totalFee;
        this.jobseeker = jobseeker;
        this.paymentType = paymentType;
        this.status = status;
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
     * Retrieve Invoice Job ID
     * @return Invoice Job ID
     */
    public int getIdJob()
    {
        // Get ID Job
        return idJob;
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
    public Jobseeker jobseeker()
    {
        // Get jobseeker
        return jobseeker;
    }
    
    /**
     * Retrieve the payment type of the invoice
     * @return Payment Type of the Invoice
     */
    public PaymentType getPaymentType()
    {
        // Get Payment Type
        return paymentType;
    }
    
    /**
     * Retrive the status of the invoice
     * @return Status of the Invoice
     */
    public InvoiceStatus getInvoiceStatus()
    {
        // Get Status
        return status;
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
     * Set the Job ID of an Invoice
     * @param idJob Job ID of an Invoice
     */
    public void setIdJobs(int idJob)
    {
        // Set ID Jobs
        this.idJob = idJob;
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
     * @param totalFee The total fee of an Invoice
     */
    public void setTotalFee(int totalFee)
    {
        // Set Total Fee
        this.totalFee = totalFee;
    }
    
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
     * Set the payment type of the invoice
     * @param paymentType Payment Type of the Invoice
     */
    public void setPaymentType(PaymentType paymentType)
    {
        // Set Payment Type
        this.paymentType = paymentType;
    }
    
    /**
     * Set the status of the invoice
     * @param status Invoice Statuss
     */
    public void setInvoiceStatus(InvoiceStatus status)
    {
        // Set Status
        this.status = status;
    }
        
    // Other Functions
    /**
     * Print out the information of an invoice
     */
    public void printData()
    {
        // Print out the information of an invoice
        System.out.println(
            "========INVOICE========\n" +
            "ID       : " + id + "\n" +
            "ID Job   : " + idJob + "\n" +
            "Date     : " + date + "\n" +
            "Total Fee: " + totalFee + "\n" +
            "Jobseeker: " + jobseeker.getName() + "\n" +
            "Payment  : " + paymentType.toString() + "\n" +
            "Status   : " + status.toString()
        );
    }
}