package evanshebert.jwork.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import evanshebert.jwork.database.DatabaseJobseeker;
import evanshebert.jwork.exceptions.EmailAlreadyExistsException;
import evanshebert.jwork.exceptions.JobseekerNotFoundException;
import evanshebert.jwork.objects.Jobseeker;

/**
 * Jobseeker Controller for Jobseeker Related API
 *
 * @author Evans Hebert
 * @version 04 June 2021
 */
@RequestMapping("/jobseeker")
@RestController
public class JobseekerController {

    /**
     * Test Page
     *
     * @param name a name
     * @return index test page
     */
    @RequestMapping("")
    public String indexPage(@RequestParam(value = "name", defaultValue = "world") String name) {
        return "Hello " + name;
    }

    /**
     * Get a specific Jobseeker by ID
     *
     * @param id Jobseeker ID to be searched
     * @return Jobseeker matching the ID
     */
    @RequestMapping(value = "/{id}")
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

    /**
     * Jobseeker Login function
     *
     * @param email    Jobseeker email
     * @param password Jobseeker Password
     * @return Jobseeker object if match and exist in database
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Jobseeker loginJobseeker(@RequestParam(value = "email") String email,
                                    @RequestParam(value = "password") String password) {
        return DatabaseJobseeker.jobseekerLogin(email, password);
    }

    /**
     * Add a new Jobseeker
     *
     * @param name     Jobseeker name
     * @param email    Jobseeker email
     * @param password Jobseeker password
     * @return A new Jobseeker object that has been created
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Jobseeker registerJobseeker(@RequestParam(value = "name") String name,
                                       @RequestParam(value = "email") String email,
                                       @RequestParam(value = "password") String password) {
        try {
            Jobseeker jobseeker = new Jobseeker(DatabaseJobseeker.getLastId() + 1, name, email, password);
            boolean status = DatabaseJobseeker.addJobseeker(jobseeker);
            return status ? jobseeker : null;
        } catch (EmailAlreadyExistsException e) {
            e.getMessage();
            return null;
        }
    }
}
