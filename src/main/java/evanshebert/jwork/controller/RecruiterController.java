package evanshebert.jwork.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import evanshebert.jwork.database.DatabaseRecruiter;
import evanshebert.jwork.exceptions.RecruiterNotFoundException;
import evanshebert.jwork.objects.Location;
import evanshebert.jwork.objects.Recruiter;

/**
 * Recruiter Controller for Recruiter Related API
 *
 * @author Evans Hebert
 * @version 04 June 2021
 */
@RequestMapping("/recruiter")
@RestController
public class RecruiterController {
    /**
     * Get All Recruiter from Database
     *
     * @return List of Recruiter
     */
    @RequestMapping("")
    public ArrayList<Recruiter> getAllRecruiter() {
        return DatabaseRecruiter.getRecruiterDatabase();
    }

    /**
     * Get a specific Recruiter by ID
     *
     * @param id Recruiter ID to be searched
     * @return Recruiter matching the ID
     */
    @RequestMapping("/{id}")
    public Recruiter getRecruiterById(@PathVariable int id) {
        try {
            return DatabaseRecruiter.getRecruiterById(id);
        } catch (RecruiterNotFoundException e) {
            e.getMessage();
            return null;
        }
    }

    /**
     * Add a new recruiter
     *
     * @param name        Recruiter name
     * @param email       Recruiter Email
     * @param phoneNumber Recruiter Phone Number
     * @param province    Recruiter Location Province
     * @param city        Recruiter Location City
     * @param description Recruiter Location Description
     * @return A recruiter object that has been successfully added
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Recruiter addRecruiter(@RequestParam(value = "name") String name,
                                  @RequestParam(value = "email") String email,
                                  @RequestParam(value = "phoneNumber") String phoneNumber,
                                  @RequestParam(value = "province") String province,
                                  @RequestParam(value = "city") String city,
                                  @RequestParam(value = "description") String description) {
        Recruiter recruiter = new Recruiter(
                DatabaseRecruiter.getLastId() + 1,
                name,
                email,
                phoneNumber,
                new Location(province, city, description)
        );
        boolean status = DatabaseRecruiter.addRecruiter(recruiter);
        return status ? recruiter : null;
    }
}
