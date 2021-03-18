/*
 * Job Class
 * 
 * A class that contains information about a job.
 */
public class Job
{
    private int id;
    private String name;
    private Recruiter recruiter;
    private int fee;
    private String category;

    // Constructor
    public Job(int id, String name, Recruiter recruiter, int fee, String category)
    {
        this.id = id;
        this.name = name;
        this.recruiter = recruiter;
        this.fee = fee;
        this.category = category;
    }

    // Getter
    public int getId()
    {
        // Get ID
        return id;
    }
    
    public String getName()
    {
        // Get name
        return name;
    }
    
    public int getFee()
    {
        // Get fee
        return fee;
    }
    
    public String getCategory()
    {
        // Get category
        return category;
    }
    
    public Recruiter getRecruiter()
    {
        // get Recruiter
        return recruiter;
    }
    
    // Setter
    public void setId(int id)
    {
        // Set ID
        this.id = id;
    }
    
    public void setName(String name)
    {
        // Set Name
        this.name = name;
    }
    
    public void setRecruiter(Recruiter recruiter)
    {
        // Set recruiter
        this.recruiter = recruiter;
    }
    
    public void setFee(int fee)
    {
        // Set Fee
        this.fee = fee;
    }
    
    public void setCategory(String category)
    {
        // Set Category
        this.category = category;
    }
    
    // Other Functions
    public void printData()
    {
        // Some codes to be expected in the future
    }
    
}
