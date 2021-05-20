package evanshebert.jwork.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import evanshebert.jwork.DatabaseJob;
import evanshebert.jwork.DatabaseRecruiter;
import evanshebert.jwork.Job;
import evanshebert.jwork.JobCategory;
import evanshebert.jwork.JobNotFoundException;
import evanshebert.jwork.RecruiterNotFoundException;

@RequestMapping("/job")
@RestController
public class JobController
{

    @RequestMapping("")
    public ArrayList<Job> getAllJob()
    {
        return DatabaseJob.getJobDatabase();
    }

    @RequestMapping("/{id}")
    public Job getJobById(@PathVariable int id)
    {
        Job job;
        try {
            job = DatabaseJob.getJobById(id);
        } catch (JobNotFoundException e) {
            e.getMessage();
            return null;
        }
        return job;
    }

    @RequestMapping("/recruiter/{recruiterId}")
    public ArrayList<Job> getJobByRecruiter(@PathVariable int recruiterId)
    {
        return DatabaseJob.getJobByRecruiter(recruiterId);
    }

    @RequestMapping("/category/{category}")
    public ArrayList<Job> getJobByCategory(@PathVariable JobCategory category)
    {
        return DatabaseJob.getJobByCategory(category);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Job addJob(@RequestParam(value = "name") String name,
                      @RequestParam(value = "recruiterId") int recruiterId,
                      @RequestParam(value = "fee") int fee,
                      @RequestParam(value = "category") JobCategory category)
    {
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
