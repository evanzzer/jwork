package evanshebert.jwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import evanshebert.jwork.database.DatabaseJob;
import evanshebert.jwork.database.DatabaseRecruiter;
import evanshebert.jwork.enums.JobCategory;
import evanshebert.jwork.exceptions.RecruiterNotFoundException;
import evanshebert.jwork.objects.Job;
import evanshebert.jwork.objects.Location;
import evanshebert.jwork.objects.Recruiter;

/**
 * The main file of the package. Contains main().
 */
@SpringBootApplication
public class JWork {
    /**
     * Main Function
     */
    public static void main(String[] args) {

        // Location
        Location jakarta = new Location("DKI Jakarta", "Jakarta", "Jakarta Utara");

        // Recruiter
        if (!DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId() + 1, "Evans Hebert", "evans.hebert@ui.ac.id", "123456789", jakarta)))
            System.out.println("Error adding Recruiter!");

        // Job
        try {
            if (!DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, "UI Designer", DatabaseRecruiter.getRecruiterById(1), 1000000, JobCategory.UI)))
                System.out.println("Error adding Job!");
        } catch (RecruiterNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            if (!DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, "UX Designer", DatabaseRecruiter.getRecruiterById(1), 1000000, JobCategory.UX)))
                System.out.println("Error adding Job!");
        } catch (RecruiterNotFoundException e) {
            System.out.println(e.getMessage());
        }

        SpringApplication.run(JWork.class, args);
    }
}