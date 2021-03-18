/**
 * A list of database about Jobs
 */
public class DatabaseJob
{
    private String[] listJob;
    
    /*
     * Constructor
     * Declares a new DatabaseJob Object
     */ 
    public DatabaseJob()
    {
        // Nothing to be assigned since the constructor doesn't have any parameters.
    }
    
    /**
     * Add a new job
     * @param job A job Object
     * @return State to indicate a job has been successfully added
     */
    public boolean addJob(Job job)
    {
        // Codes
        return false;
    }
    
    /**
     * Remove existing job
     * @param job A job Object
     * @return State to indicate a job has been successfully removed
     */
    public boolean removeJob(Job job)
    {
        // Codes
        return false;
    }
    
    /**
     * Retrieve a specified job
     * @return A job object
     */
    public Job getJob()
    {
        // Codes
        return null;
    }
    
    /**
     * Retrieve a list of job currently available
     * @return A list of jobs' name
     */
    public String[] getListJob()
    {
        // Get listJob
        return listJob;
    }
}
