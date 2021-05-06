import java.util.ArrayList;

/**
 * A list of database about Recruiter
 * 
 * @author Evans Hebert
 * @version 06 May 2021
 */
public class DatabaseRecruiter
{
    private static final ArrayList<Recruiter> RECRUITER_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    /**
     * Retrieve a list of recruiter objects
     * @return A list of recruiter objects
     */
    public static ArrayList<Recruiter> getRecruiterDatabase()
    {
        // Get listRecruiter
        return RECRUITER_DATABASE;
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
     * Retrieve a specified recruiter that can be found by ID
     * @return A recruiter object
     */
    public static Recruiter getRecruiterById(int id)
    {
        try {
            for (Recruiter recruiter : RECRUITER_DATABASE) {
                if (recruiter.getId() == id) {
                    return recruiter;
                }
            }
            throw new RecruiterNotFoundException(id);
        } catch (RecruiterNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    /**
     * Add a new recruiter
     * @param recruiter A recruiter Object
     * @return State to indicate a recruiter has been successfully added
     */
    public static boolean addRecruiter(Recruiter recruiter)
    {
        RECRUITER_DATABASE.add(recruiter);
        lastId = recruiter.getId();
        return true;
    }
    
    /**
     * Remove existing recruiter by ID
     * @param id A recruiter's ID
     * @return State to indicate a recruiter has been successfully removed
     */
    public static boolean removeRecruiter(int id)
    {
        try {
            for (Recruiter recruiter : RECRUITER_DATABASE) {
                if (recruiter.getId() == id) {
                    RECRUITER_DATABASE.remove(recruiter);
                    return true;
                }
            }
            throw new RecruiterNotFoundException(id);
        } catch (RecruiterNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}