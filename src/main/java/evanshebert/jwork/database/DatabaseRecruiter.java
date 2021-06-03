package evanshebert.jwork.database;

import java.util.ArrayList;

import evanshebert.jwork.database.postgre.DatabaseRecruiterPostgres;
import evanshebert.jwork.exceptions.RecruiterNotFoundException;
import evanshebert.jwork.objects.Recruiter;

/**
 * A list of database about Recruiter
 *
 * @author Evans Hebert
 * @version 03 June 2021
 */
public class DatabaseRecruiter {
    /**
     * Retrieve a list of recruiter objects
     *
     * @return A list of recruiter objects
     */
    public static ArrayList<Recruiter> getRecruiterDatabase() {
        // Get listRecruiter
        return DatabaseRecruiterPostgres.getRecruiterDatabase();
    }

    /**
     * Retrieve the last ID of the database
     *
     * @return Last ID in Integer
     */
    public static int getLastId() {
        return DatabaseRecruiterPostgres.getLastRecruiterId();
    }

    /**
     * Retrieve a specified recruiter that can be found by ID
     *
     * @return A recruiter object
     */
    public static Recruiter getRecruiterById(int id) throws RecruiterNotFoundException {
        return DatabaseRecruiterPostgres.getRecruiterById(id);
    }

    /**
     * Add a new recruiter
     *
     * @param recruiter A recruiter Object
     * @return State to indicate a recruiter has been successfully added
     */
    public static boolean addRecruiter(Recruiter recruiter) {
        return DatabaseRecruiterPostgres.insertRecruiter(recruiter);
    }

    /**
     * Remove existing recruiter by ID
     *
     * @param id A recruiter's ID
     * @return State to indicate a recruiter has been successfully removed
     */
    public static boolean removeRecruiter(int id) throws RecruiterNotFoundException {
        return DatabaseRecruiterPostgres.deleteRecruiter(id);
    }
}