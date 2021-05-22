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

        // Location
        Location jakarta = new Location("DKI Jakarta", "Jakarta", "Jakarta Utara");
        Location bandung = new Location("Jawa Barat", "Bandung", "Kota Bandung");
        Location depok = new Location("Jawa Barat", "Depok", "UI");

        // Recruiter
        if (!DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId() + 1, "Evans Hebert", "evans.hebert@ui.ac.id", "123456789", jakarta)))
            System.out.println("Error adding Recruiter!");
        if (!DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId() + 1, "Evans Hebat", "evans.hebat@ui.ac.id", "123456790", bandung)))
            System.out.println("Error adding Recruiter!");
        if (!DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId() + 1, "Evans The Bird", "bird.supreme@ui.ac.id", "123456777", depok)))
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

        try {
            if (!DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, "AWS Engineer", DatabaseRecruiter.getRecruiterById(2), 1500000, JobCategory.BackEnd)))
                System.out.println("Error adding Job!");
        } catch (RecruiterNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            if (!DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, "Backend Javascript Programmer", DatabaseRecruiter.getRecruiterById(3), 1300000, JobCategory.BackEnd)))
                System.out.println("Error adding Job!");
        } catch (RecruiterNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Jobseeker
        try {
            if (!DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Agen", "agen@email.com", "AgENT123")))
                System.out.println("Error adding jobseeker!");
        } catch (EmailAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        SpringApplication.run(JWork.class, args);
    }
}