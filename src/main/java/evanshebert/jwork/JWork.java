package evanshebert.jwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main file of the package. Contains main().
 */
@SpringBootApplication
public class JWork {
    /**
     * Main Function
     */
    public static void main(String[] args) {

        /* Defined in the SQL Table
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
        */

        SpringApplication.run(JWork.class, args);
    }
}