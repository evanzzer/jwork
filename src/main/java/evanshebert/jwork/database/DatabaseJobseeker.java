package evanshebert.jwork.database;

import java.util.ArrayList;

import evanshebert.jwork.database.postgres.DatabaseJobseekerPostgre;
import evanshebert.jwork.exceptions.EmailAlreadyExistsException;
import evanshebert.jwork.exceptions.JobseekerNotFoundException;
import evanshebert.jwork.objects.Jobseeker;

/**
 * A list of database about Jobseeker
 *
 * @author Evans Hebert
 * @version 06 May 2021
 */
public class DatabaseJobseeker {
    /**
     * Retrieve a list of jobseeker
     *
     * @return A list of jobseeker
     */
    public static ArrayList<Jobseeker> getDatabaseJobseeker() {
        return DatabaseJobseekerPostgre.getDatabaseJobseeker();
    }

    /**
     * Retrieve the last ID of the database
     *
     * @return Last ID in Integer
     */
    public static int getLastId() {
        return DatabaseJobseekerPostgre.getLastJobseekerId();
    }

    /**
     * Retrieve a specified jobseeker that can be found by ID
     *
     * @return A jobseeker object
     */
    public static Jobseeker getJobseekerById(int id) throws JobseekerNotFoundException {
        return DatabaseJobseekerPostgre.getJobseekerById(id);
    }

    /**
     * Retrieve a login with a specified email and password
     *
     * @param email    Jobseeker's email
     * @param password Jobseeker's password
     * @return Jobseeker if exist, else null
     */
    public static Jobseeker jobseekerLogin(String email, String password) {
        return DatabaseJobseekerPostgre.jobseekerLogin(email, password);
    }

    /**
     * Add a new jobseeker
     *
     * @param jobseeker A jobseeker Object
     * @return State to indicate a jobseeker has been successfully added
     */
    public static boolean addJobseeker(Jobseeker jobseeker) throws EmailAlreadyExistsException {
        return DatabaseJobseekerPostgre.insertJobseeker(jobseeker);
    }

    /**
     * Remove existing jobseeker
     *
     * @param id A jobseeker's ID
     * @return State to indicate a jobseeker has been successfully removed
     */
    public static boolean removeJobseeker(int id) throws JobseekerNotFoundException {
        return DatabaseJobseekerPostgre.removeJobseeker(id);
    }
}