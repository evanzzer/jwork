import java.util.ArrayList;

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
        // Jobseeker
        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Evans Hebert", "evans.hebert@ui.ac.id", "SuPreMe123", 2021, 3, 11));
        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Someone", "someone@ui.ac.id", "SoMEOnE4", 2021, 2, 11));
//        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Someone v2", "someone@ui.ac.id", "SoMEOnE5", 2021, 1, 10));
//        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Nobody", "nobody@ui.ac.id", "NoBodiiiiiiEe4", 2021, 3, 11));

        // BONUS
        DatabaseBonus.addBonus(new Bonus(DatabaseBonus.getLastId() + 1, "REFERRAL", 50000, 150000, false));
//        DatabaseBonus.addBonus(new Bonus(DatabaseBonus.getLastId() + 1, "REFERRAL", 75000, 125000, true));

        // Location
        Location location = new Location("Jakarta", "Jakarta Utara", "Tempat Lahir");

        // Recruiter
        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId() + 1, "Evans Hebert", "evans.hebert@ui.ac.id", "081234567890", location));

        // Job
        DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, "Object Designer", DatabaseRecruiter.getRecruiterById(DatabaseRecruiter.getLastId()), 50000, JobCategory.UI));
        DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, "Layout Designer", DatabaseRecruiter.getRecruiterById(DatabaseRecruiter.getLastId()), 75000, JobCategory.UI));
        DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, "AWS BackEnd Developer", DatabaseRecruiter.getRecruiterById(DatabaseRecruiter.getLastId()), 90000, JobCategory.BackEnd));
        DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, "API Developer", DatabaseRecruiter.getRecruiterById(DatabaseRecruiter.getLastId()), 100000, JobCategory.BackEnd));

        // Exceptions
//        DatabaseJob.removeJob(10);
//        DatabaseJob.getJobById(2); // Berhasil
//        DatabaseJob.getJobById(7);
//        DatabaseJobseeker.removeJobseeker(4);
//        DatabaseJobseeker.getJobseekerById(1); // Berhasil
//        DatabaseJobseeker.getJobseekerById(7);
//        DatabaseRecruiter.removeRecruiter(8);
//        DatabaseRecruiter.getRecruiterById(1); // Berhasil
//        DatabaseRecruiter.getRecruiterById(8);
//        DatabaseBonus.removeBonus(7);
//        DatabaseBonus.getBonusById(1); // Berhasil
//        DatabaseBonus.getBonusById(7);
        // EmailAlreadyExistsException sudah diimplementasikan
        // ReferralCodeAlreadyExistsException sudah diimplementasikan

        // Print Database
//        DatabaseJob.getJobDatabase().forEach(job -> System.out.println(job.toString()));
//        DatabaseJobseeker.getDatabaseJobseeker().forEach(jobseeker -> System.out.println(jobseeker.toString()));
//        DatabaseRecruiter.getRecruiterDatabase().forEach(recruiter -> System.out.println(recruiter.toString()));
//        DatabaseBonus.getBonusDatabase().forEach(bonus -> System.out.println(bonus.toString()));

        // Invoice
        DatabaseInvoice.addInvoice(new BankPayment(DatabaseInvoice.getLastId() + 1, DatabaseJob.getJobByCategory(JobCategory.UI), DatabaseJobseeker.getJobseekerById(1)));
        // Error
        DatabaseInvoice.addInvoice(new BankPayment(DatabaseInvoice.getLastId() + 1, DatabaseJob.getJobByCategory(JobCategory.BackEnd), DatabaseJobseeker.getJobseekerById(1), 50000));
        // Error
        DatabaseInvoice.addInvoice(new BankPayment(1, DatabaseJob.getJobByCategory(JobCategory.UI), DatabaseJobseeker.getJobseekerById(2)));
        // Success
        DatabaseInvoice.addInvoice(new EwalletPayment(DatabaseInvoice.getLastId() + 1, DatabaseJob.getJobByCategory(JobCategory.BackEnd), DatabaseJobseeker.getJobseekerById(2), DatabaseBonus.getBonusById(1)));
        // Error
        DatabaseInvoice.removeInvoice(10);
        // Error
        DatabaseInvoice.getInvoiceById(7);

        DatabaseInvoice.getInvoiceDatabase().forEach(invoice -> System.out.println(invoice.toString()));
    }
}