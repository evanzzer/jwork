/**
 * Details about invoices.
 * Contains ID, Job ID, Date, Total Fee, and the Jobseeker.
 */
public class Invoice
{
    private int id;
    private int idJob;
    private String date;
    private int totalFee;
    private Jobseeker jobseeker;

    /*
     * Constructor
     * Declares a new Invoice object
     */
    public Invoice(int id, int idJob, String date, int totalFee, Jobseeker jobseeker)
    {
        this.id = id;
        this.idJob = idJob;
        this.date = date;
        this.totalFee = totalFee;
        this.jobseeker = jobseeker;
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
    
    // Other Functions
    /**
     * Function under construction
     */
    public void printData()
    {
        // Some codes to be expected in the future
    }
}
