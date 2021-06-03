package evanshebert.jwork.objects;

import evanshebert.jwork.enums.JobCategory;

/**
 * Information about a job.
 * Contains ID, Name, Recruiter, Fee, and category of a job.
 * 
 * @author Evans Hebert
 * @version 8 April 2021
 */
public class Job
{
    private int id;
    private String name;
    private Recruiter recruiter;
    private int fee;
    private JobCategory category;

    /*
     * Constructor
     * Declares a new Job object
     */ 
    public Job(int id, String name, Recruiter recruiter, int fee, JobCategory category)
    {
        this.id = id;
        this.name = name;
        this.recruiter = recruiter;
        this.fee = fee;
        this.category = category;
    }

    // Getter
    /**
     * Retrieve the Job ID
     * @return Job ID
     */
    public int getId()
    {
        // Get ID
        return id;
    }
    
    /**
     * Retrieve the Job's name
     * @return Job's name
     */
    public String getName()
    {
        // Get name
        return name;
    }
    
    /**
     * Retrieve the Job Fee
     * @return Job Fee
     */
    public int getFee()
    {
        // Get fee
        return fee;
    }
    
    /**
     * Retrieve the Job Category
     * @return Job Category
     */
    public JobCategory getCategory()
    {
        // Get category
        return category;
    }
    
    /**
     * Retrieve the Job Recruiter
     * @return Job's Recruiter
     */
    public Recruiter getRecruiter()
    {
        // get Recruiter
        return recruiter;
    }
    
    // Setter
    /**
     * Set the Job ID
     * @param id Job ID
     */
    public void setId(int id)
    {
        // Set ID
        this.id = id;
    }
    
    /**
     * Set the Job Name
     * @param name Job Name
     */
    public void setName(String name)
    {
        // Set Name
        this.name = name;
    }
    
    /**
     * Set the Job Recruiter
     * @param recruiter Job Recruiter
     */
    public void setRecruiter(Recruiter recruiter)
    {
        // Set recruiter
        this.recruiter = recruiter;
    }
    
    /**
     * Set the Job's Fee
     * @param fee Job's Fee
     */
    public void setFee(int fee)
    {
        // Set Fee
        this.fee = fee;
    }
    
    /**
     * Set the Job Category
     * @param category Job Category
     */
    public void setCategory(JobCategory category)
    {
        // Set Category
        this.category = category;
    }
    
    // Other Functions
    /**
     * Return out the information of the job
     * @return Information of the Job
     */
    public String toString()
    {
        // Return the information of the job
        return "======== JOB ========\n" +
            "ID       : " + id + "\n" +
            "Name     : " + name + "\n" +
            "Recruiter: " + recruiter.getName() + "\n" +
            "City     : " + recruiter.getLocation().getCity() + "\n" +
            "Fee      : " + fee + "\n" +
            "Category : " + category.toString();
    }

}