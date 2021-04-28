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
        // BONUS
        DatabaseBonus.addBonus(new Bonus(DatabaseBonus.getLastId() + 1, "REFERRAL", 50000, 150000, false));
        DatabaseBonus.addBonus(new Bonus(DatabaseBonus.getLastId() + 1, "REFERRAL", 75000, 125000, true));

        DatabaseBonus.getBonusDatabase().forEach(bonus -> System.out.println(bonus.toString()));

        // BOOLEAN OUTPUT CAN BE IGNORED IN THIS CASE! SO JUST ADDING OBJECTS WITHOUT CHECKING THE RESULT IS STILL VALID!
        // Location
        Location location = new Location("Jakarta", "Jakarta Utara", "Tempat Lahir");

        // Recruiter
        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId() + 1, "Evans Hebert", "evans.hebert@ui.ac.id", "081234567890", location));

        // Jobseeker
        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Evans Hebert", "evans.hebert@ui.ac.id", "SuPreMe123", 2021, 3, 11));
        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Someone", "someone@ui.ac.id", "SoMEOnE4", 2021, 2, 11));

        // Job
        DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, "Object Designer", DatabaseRecruiter.getRecruiterById(DatabaseRecruiter.getLastId()), 50000, JobCategory.UI));
        DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, "Layout Designer", DatabaseRecruiter.getRecruiterById(DatabaseRecruiter.getLastId()), 75000, JobCategory.UI));
        DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, "AWS BackEnd Developer", DatabaseRecruiter.getRecruiterById(DatabaseRecruiter.getLastId()), 90000, JobCategory.BackEnd));
        DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, "API Developer", DatabaseRecruiter.getRecruiterById(DatabaseRecruiter.getLastId()), 100000, JobCategory.BackEnd));

        ArrayList<Job> arrayJob1 = DatabaseJob.getJobByCategory(JobCategory.UI);
        ArrayList<Job> arrayJob2 = DatabaseJob.getJobByCategory(JobCategory.BackEnd);

        if (arrayJob1 != null) {
            DatabaseInvoice.addInvoice(new BankPayment(DatabaseInvoice.getLastId() + 1, arrayJob1, DatabaseJobseeker.getJobseekerById(1)));
            ArrayList<Invoice> getInvoice = DatabaseInvoice.getInvoiceByJobseeker(1);
            if (getInvoice != null) {
                getInvoice.forEach(Invoice::setTotalFee);
            } else {
                System.out.println("Tidak ditemukan invoice pada jobseeker yang dicari!");
            }

            DatabaseInvoice.addInvoice(new EwalletPayment(DatabaseInvoice.getLastId() + 1, arrayJob1, DatabaseJobseeker.getJobseekerById(1)));
            getInvoice = DatabaseInvoice.getInvoiceByJobseeker(1);
            if (getInvoice != null) {
                getInvoice.forEach(Invoice::setTotalFee);
            } else {
                System.out.println("Tidak ditemukan invoice pada jobseeker yang dicari!");
            }

            DatabaseInvoice.getInvoiceDatabase().forEach(invoice -> System.out.println(invoice.toString()));

            getInvoice = DatabaseInvoice.getInvoiceByJobseeker(1);
            if (getInvoice != null) {
                getInvoice.forEach(invoice -> DatabaseInvoice.changeInvoiceStatus(invoice.getId(), InvoiceStatus.Finished));
            } else {
                System.out.println("Tidak ditemukan invoice pada jobseeker yang dicari!");
            }
        }

        if (arrayJob2 != null) {
            DatabaseInvoice.addInvoice(new EwalletPayment(DatabaseInvoice.getLastId() + 1, arrayJob2, DatabaseJobseeker.getJobseekerById(2), DatabaseBonus.getBonusById(DatabaseBonus.getLastId())));
            DatabaseBonus.activateBonus(DatabaseBonus.getLastId());

            DatabaseInvoice.getInvoiceDatabase().forEach(Invoice::setTotalFee);
            DatabaseInvoice.getInvoiceDatabase().forEach(invoice -> System.out.println(invoice.toString()));
        }
    }


//    /**
//     * Main Function - CS
//     */
//    public static void main(String[] args)
//    {
//        // Location
//        Location location = new Location("Jakarta", "Jakarta Utara", "Tempat Lahir");
//
//        // BOOLEAN OUTPUT CAN BE IGNORED IN THIS CASE! SO JUST ADDING OBJECTS WITHOUT CHECKING THE RESULT IS STILL VALID!
//        // Recruiter
//        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId() + 1, "Evans Hebert", "evans.hebert@ui.ac.id", "081234567890", location));
//
//        // Jobseeker
//        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Evans Hebert", "evans.hebert@ui.ac.id", "SuPreMe123", 2021, 3, 11));
//        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Evans Hebert", "evans.hebert@ui.ac.id", "PaSsWrD123", 2021, 3, 10));
//        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Indira Insiyah", "indira.insiyah@ui.ac.id", "SmAnGaT123", 2021, 3, 12));
//
//        DatabaseJobseeker.getDatabaseJobseeker().forEach(jobseeker -> System.out.println(jobseeker.toString()));
//
//        // Job
//        DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, "Object Designer", DatabaseRecruiter.getRecruiterById(DatabaseRecruiter.getLastId()), 50000, JobCategory.UI));
//        DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, "Layout Designer", DatabaseRecruiter.getRecruiterById(DatabaseRecruiter.getLastId()), 75000, JobCategory.UI));
//        DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, "AWS BackEnd Developer", DatabaseRecruiter.getRecruiterById(DatabaseRecruiter.getLastId()), 90000, JobCategory.BackEnd));
//
//        ArrayList<Job> jobUI = DatabaseJob.getJobByCategory(JobCategory.UI);
//        if (jobUI != null) {
//            jobUI.forEach(job -> System.out.println(job.toString()));
//        } else {
//            System.out.println("No information for Category UI");
//        }
//    }
}