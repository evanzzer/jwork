package evanshebert.jwork.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import evanshebert.jwork.database.DatabaseJob;
import evanshebert.jwork.database.DatabaseRecruiter;
import evanshebert.jwork.objects.Job;
import evanshebert.jwork.enums.JobCategory;
import evanshebert.jwork.exceptions.JobNotFoundException;
import evanshebert.jwork.exceptions.RecruiterNotFoundException;

/**
 * Job Controller for Job Related API
 *
 * @author Evans Hebert
 * @version 04 June 2021
 */
@RequestMapping("/job")
@RestController
public class JobController {
    /**
     * Get All Jobs from Database
     *
     * @return List of Jobs
     */
    @RequestMapping("")
    public ArrayList<Job> getAllJob() {
        return DatabaseJob.getJobDatabase();
    }

    /**
     * Get a specific job by ID
     *
     * @param id job ID to be searched
     * @return A job matching the ID
     */
    @RequestMapping("/{id}")
    public Job getJobById(@PathVariable int id) {
        Job job;
        try {
            job = DatabaseJob.getJobById(id);
        } catch (JobNotFoundException e) {
            e.getMessage();
            return null;
        }
        return job;
    }

    /**
     * Get a list of jobs by Recruiter ID
     *
     * @param recruiterId Recruiter ID as a parameter
     * @return A job matching the Recruiter's ID
     */
    @RequestMapping("/recruiter/{recruiterId}")
    public ArrayList<Job> getJobByRecruiter(@PathVariable int recruiterId) {
        return DatabaseJob.getJobByRecruiter(recruiterId);
    }

    /**
     * Get a list of jobs by Category
     *
     * @param category Job Category as a parameter
     * @return A job matching the category specified
     */
    @RequestMapping("/category/{category}")
    public ArrayList<Job> getJobByCategory(@PathVariable JobCategory category) {
        return DatabaseJob.getJobByCategory(category);
    }

    /**
     * Add a new job
     *
     * @param name        Job's name
     * @param recruiterId Recruiter that is responsible for the job
     * @param fee         Job's fee
     * @param category    Job's category
     * @return A job object that has been successfully created
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Job addJob(@RequestParam(value = "name") String name,
                      @RequestParam(value = "recruiterId") int recruiterId,
                      @RequestParam(value = "fee") int fee,
                      @RequestParam(value = "category") JobCategory category) {
        try {
            Job job = new Job(
                    DatabaseJob.getLastId() + 1,
                    name,
                    DatabaseRecruiter.getRecruiterById(recruiterId),
                    fee,
                    category
            );
            boolean state = DatabaseJob.addJob(job);
            return state ? job : null;
        } catch (RecruiterNotFoundException e) {
            e.getMessage();
            return null;
        }
    }
}
