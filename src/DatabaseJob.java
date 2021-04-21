/**
 * A list of database about Jobs
 * 
 * @author Evans Hebert
 * @version 25 March 2021
 */
public class DatabaseJob
{
    private static String[] listJob;
    
    /**
     * Add a new job
     * @param job A job Object
     * @return State to indicate a job has been successfully added
     */
    public static boolean addJob(Job job)
    {
        // Codes
        return false;
    }
    
    /**
     * Remove existing job
     * @param job A job Object
     * @return State to indicate a job has been successfully removed
     */
    public static boolean removeJob(Job job)
    {
        // Codes
        return false;
    }
    
    /**
     * Retrieve a specified job
     * @return A job object
     */
    public static Job getJob()
    {
        // Codes
        return null;
    }
    
    /**
     * Retrieve a list of job currently available
     * @return A list of jobs' name
     */
    public static String[] getListJob()
    {
        // Get listJob
        return listJob;
    }
}