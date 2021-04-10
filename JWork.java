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
        Recruiter recruiter = new Recruiter(1, "Evans Hebert", "evans.hebert@ui.ac.id", "081234567890", location);

        // Job
        Job job = new Job(1, "Asisten", recruiter, 100000, JobCategory.BackEnd);

        // Bonus
        Bonus bonus = new Bonus(1, "PBOASIK", 25000, 150000, true);

        // Jobseeker
        Jobseeker jobseeker1 = new Jobseeker(1, "Tono", "to..no@ui.ac.id", "plain", new GregorianCalendar(2021, 3, 8));

        EwalletPayment invoice1 = new EwalletPayment(1, job, jobseeker1, bonus, InvoiceStatus.Finished);
        BankPayment invoice2 = new BankPayment(2, job, jobseeker1, InvoiceStatus.Finished);

        System.out.println(invoice1.toString());
        System.out.println(invoice2.toString());

        // Case Study
        // Jobseeker jobseeker2 = new Jobseeker(2, "Tono", "tono.bener@ui.ac.id", "KomPleks123", 2021, 3, 8); 
        // Jobseeker jobseeker3 = new Jobseeker(3, "Tono", "terserah", "TeRsEr4h");

        // System.out.println(jobseeker1.toString());
        // System.out.println(jobseeker2.toString());
        // System.out.println(jobseeker3.toString());

        // jobseeker1.setEmail("email.yang.bener@do-main.com");
        // jobseeker1.setPassword("PassBen4r");

        // System.out.println(jobseeker1.toString());
    }
}