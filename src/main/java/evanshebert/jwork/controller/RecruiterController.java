package evanshebert.jwork.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import evanshebert.jwork.DatabaseRecruiter;
import evanshebert.jwork.Location;
import evanshebert.jwork.Recruiter;
import evanshebert.jwork.RecruiterNotFoundException;

@RequestMapping("/recruiter")
@RestController
public class RecruiterController
{
    @RequestMapping("")
    public ArrayList<Recruiter> getAllRecruiter()
    {
        return DatabaseRecruiter.getRecruiterDatabase();
    }

    @RequestMapping("/{id}")
    public Recruiter getRecruiterById(@PathVariable int id)
    {
        try {
            return DatabaseRecruiter.getRecruiterById(id);
        } catch (RecruiterNotFoundException e) {
            e.getMessage();
            return null;
        }
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Recruiter addRecruiter(@RequestParam(value = "name") String name,
                                  @RequestParam(value = "email") String email,
                                  @RequestParam(value = "phoneNumber") String phoneNumber,
                                  @RequestParam(value = "province") String province,
                                  @RequestParam(value = "city") String city,
                                  @RequestParam(value = "description") String description)
    {
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
