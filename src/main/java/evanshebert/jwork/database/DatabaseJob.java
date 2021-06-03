package evanshebert.jwork.database;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import evanshebert.jwork.database.postgre.DatabaseJobPostgre;
import evanshebert.jwork.database.postgre.DatabaseJobseekerPostgre;
import evanshebert.jwork.enums.JobCategory;
import evanshebert.jwork.exceptions.JobNotFoundException;
import evanshebert.jwork.objects.Job;

/**
 * A list of database about Jobs
 *
 * @author Evans Hebert
 * @version 03 June 2021
 */
public class DatabaseJob {
    private static final ArrayList<Job> JOB_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    /**
     * Retrieve a list of job objects
     *
     * @return A list of job objects
     */
    public static ArrayList<Job> getJobDatabase() {
        // Get listRecruiter
        return DatabaseJobPostgre.getJobDatabase();
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
     * Retrieve a specified job that can be found by ID
     *
     * @return A job object
     */
    public static Job getJobById(int id) throws JobNotFoundException {
        return DatabaseJobPostgre.getJobById(id);
    }

    /**
     * Retrieve a specific job that can be found by Recruiter's ID
     *
     * @return a job array
     */
    public static ArrayList<Job> getJobByRecruiter(int recruiterId) {
        return DatabaseJobPostgre.getJobByRecruiter(recruiterId);
    }

    /**
     * Retrieve a specific job that can be found by job category
     *
     * @return a job array
     */
    public static ArrayList<Job> getJobByCategory(JobCategory category) {
        return DatabaseJobPostgre.getJobByCategory(category);
    }

    /**
     * Add a new job
     *
     * @param job A job Object
     * @return State to indicate a job has been successfully added
     */
    public static boolean addJob(Job job) {
        return DatabaseJobPostgre.insertJob(job);
    }

    /**
     * Remove existing job
     *
     * @param id A job's ID
     * @return State to indicate a job has been successfully removed
     */
    public static boolean removeJob(int id) throws JobNotFoundException {
        return DatabaseJobPostgre.deleteJob(id);
    }
}