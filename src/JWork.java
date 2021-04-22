import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * The main file of the package. Contains main().
 */
public class JWork
{
    /**
     * Main Function
     */
    public static void main(String[] args)
    {       
        // Location
        Location location = new Location("Jakarta", "Jakarta Utara", "Tempat Lahir");

        // Recruiter
        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId() + 1, "Evans Hebert", "evans.hebert@ui.ac.id", "081234567890", location));

        // Jobseeker
        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Evans Hebert", "evans.hebert@ui.ac.id", "SuPreMe123", 2021, 3, 11));
        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Evans Hebert", "evans.hebert@ui.ac.id", "PaSsWrD123", 2021, 3, 10));
        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Indira Insiyah", "indira.insiyah@ui.ac.id", "SmAnGaT123", 2021, 3, 12));

        DatabaseJobseeker.getDatabaseJobseeker().forEach(jobseeker -> System.out.println(jobseeker.toString()));

        // Job
        DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, "Object Designer", DatabaseRecruiter.getRecruiterById(DatabaseRecruiter.getLastId()), 50000, JobCategory.UI));
        DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, "Layout Designer", DatabaseRecruiter.getRecruiterById(DatabaseRecruiter.getLastId()), 75000, JobCategory.UI));
        DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, "AWS BackEnd Developer", DatabaseRecruiter.getRecruiterById(DatabaseRecruiter.getLastId()), 90000, JobCategory.BackEnd));

        ArrayList<Job> jobUI = DatabaseJob.getJobByCategory(JobCategory.UI);
        if (jobUI != null) {
            jobUI.forEach(job -> System.out.println(job.toString()));
        } else {
            System.out.println("No information for Category UI");
        }
    }
}