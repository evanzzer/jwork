
/**
 * Invoice Class
 */
public class Invoice
{
    private int id;
    private int idJob;
    private String date;
    private int totalFee;
    private Jobseeker jobseeker;

    public Invoice(int id, int idJob, String date, int totalFee, Jobseeker jobseeker)
    {
        // Constructor
        this.id = id;
        this.idJob = idJob;
        this.date = date;
        this.totalFee = totalFee;
        this.jobseeker = jobseeker;
    }

    public int getId()
    {
        // Get id
        return id;
    }
    
    public int getIdJob()
    {
        // Get ID Job
        return idJob;
    }
    
    public String getDate()
    {
        // Get Date
        return date;
    }
    
    public int getTotalFee()
    {
        // Get Total Fee
        return totalFee;
    }
    
    public Jobseeker jobseeker()
    {
        // Get jobseeker
        return jobseeker;
    }
    
    public void setId(int id)
    {
        // Set ID
        this.id = id;
    }
    
    public void setIdJobs(int idJob)
    {
        // Set ID Jobs
        this.idJob = idJob;
    }
    
    public void setDate(String date)
    {
        // Set Date
        this.date = date;
    }
    
    public void setTotalFee(int totalFee)
    {
        // Set Total Fee
        this.totalFee = totalFee;
    }
    
    public void setJobseeker(Jobseeker jobseeker)
    {
        // Set jobseeker
        this.jobseeker = jobseeker;
    }
    
    public void printData()
    {
        // code
    }
}
