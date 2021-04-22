import java.util.ArrayList;

/**
 * A list of database about Jobseeker
 * 
 * @author Evans Hebert
 * @version 22 April 2021
 */
public class DatabaseJobseeker
{
    private static final ArrayList<Jobseeker> JOBSEEKER_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    /**
     * Retrieve a list of jobseeker
     * @return A list of jobseeker
     */
    public static ArrayList<Jobseeker> getDatabaseJobseeker()
    {
        return JOBSEEKER_DATABASE;
    }

    /**
     * Retrieve the last ID of the database
     * @return Last ID in Integer
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * Retrieve a specified jobseeker that can be found by ID
     * @return A jobseeker object
     */
    public static Jobseeker getJobseekerById(int id)
    {
        for (Jobseeker jobseeker : JOBSEEKER_DATABASE) {
            if (jobseeker.getId() == id) {
                return jobseeker;
            }
        }
        return null;
    }

    /**
     * Add a new jobseeker
     * @param jobseeker A jobseeker Object
     * @return State to indicate a jobseeker has been successfully added
     */
    public static boolean addJobseeker(Jobseeker jobseeker)
    {
        for (Jobseeker existJobseeker : JOBSEEKER_DATABASE) {
            if (jobseeker.getEmail().equals(existJobseeker.getEmail())) {
                return false;
            }
        }
        JOBSEEKER_DATABASE.add(jobseeker);
        lastId = jobseeker.getId();
        return true;
    }
    
    /**
     * Remove existing jobseeker
     * @param id A jobseeker's ID
     * @return State to indicate a jobseeker has been successfully removed
     */
    public static boolean removeJobseeker(int id)
    {
        for (Jobseeker jobseeker : JOBSEEKER_DATABASE) {
            if (jobseeker.getId() == id) {
                JOBSEEKER_DATABASE.remove(jobseeker);
                return true;
            }
        }
        return false;
    }
}