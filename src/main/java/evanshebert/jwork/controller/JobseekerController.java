package evanshebert.jwork.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import evanshebert.jwork.DatabaseJobseeker;
import evanshebert.jwork.EmailAlreadyExistsException;
import evanshebert.jwork.Jobseeker;
import evanshebert.jwork.JobseekerNotFoundException;

@RequestMapping("/jobseeker")
@RestController
public class JobseekerController {

    @RequestMapping("")
    public String indexPage(@RequestParam(value = "name", defaultValue = "world") String name) {
        return "Hello " + name;
    }

    @RequestMapping("/{id}")
    public Jobseeker getJobseekerById(@PathVariable int id) {
        Jobseeker jobseeker;
        try {
            jobseeker = DatabaseJobseeker.getJobseekerById(id);
        } catch (JobseekerNotFoundException e) {
            e.getMessage();
            return null;
        }
        return jobseeker;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Jobseeker addJobseeker(@RequestParam(value = "name") String name,
                                  @RequestParam(value = "email") String email,
                                  @RequestParam(value = "password") String password) {
        Jobseeker jobseeker = new Jobseeker(DatabaseJobseeker.getLastId() + 1, name, email, password);
        try {
            DatabaseJobseeker.addJobseeker(jobseeker);
        } catch (EmailAlreadyExistsException e) {
            e.getMessage();
            return null;
        }
        return jobseeker;
    }
}
