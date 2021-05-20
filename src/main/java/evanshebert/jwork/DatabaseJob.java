package evanshebert.jwork;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A list of database about Jobs
 * 
 * @author Evans Hebert
 * @version 06 May 2021
 */
public class DatabaseJob
{
    private static final ArrayList<Job> JOB_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    /**
     * Retrieve a list of job objects
     * @return A list of job objects
     */
    public static ArrayList<Job> getJobDatabase()
    {
        // Get listRecruiter
        return JOB_DATABASE;
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
     * Retrieve a specified job that can be found by ID
     * @return A job object
     */
    public static Job getJobById(int id) throws JobNotFoundException
    {
        for (Job job : JOB_DATABASE) {
            if (job.getId() == id) {
                return job;
            }
        }
        throw new JobNotFoundException(id);
    }

    /**
     * Retrieve a specific job that can be found by Recruiter's ID
     * @return a job array
     */
    public static ArrayList<Job> getJobByRecruiter(int recruiterId)
    {
        List<Job> findJob = JOB_DATABASE
                .stream()
                .filter(job -> job.getRecruiter().getId() == recruiterId)
                .collect(Collectors.toList());
        return (findJob.size() != 0) ? new ArrayList<>(findJob) : null;
    }

    /**
     * Retrieve a specific job that can be found by job category
     * @return a job array
     */
    public static ArrayList<Job> getJobByCategory(JobCategory category)
    {
        List<Job> findJob = JOB_DATABASE
                .stream()
                .filter(job -> job.getCategory() == category)
                .collect(Collectors.toList());
        return (findJob.size() != 0) ? new ArrayList<>(findJob) : null;
    }

    /**
     * Add a new job
     * @param job A job Object
     * @return State to indicate a job has been successfully added
     */
    public static boolean addJob(Job job)
    {
        JOB_DATABASE.add(job);
        lastId = job.getId();
        return true;
    }
    
    /**
     * Remove existing job
     * @param id A job's ID
     * @return State to indicate a job has been successfully removed
     */
    public static boolean removeJob(int id)
    {
        try {
            for (Job job : JOB_DATABASE) {
                if (job.getId() == id) {
                    JOB_DATABASE.remove(job);
                    return true;
                }
            }
            throw new JobNotFoundException(id);
        } catch (JobNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}