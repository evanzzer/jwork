/**
 * The main file of the package. Contains main().
 * 
 * @author Evans Hebert
 * @version 18 March 2021
 */
public class JWork
{
    /**
     * Main Function
     */
    public static void main(String[] args)
    {
        // Location
        Location location = new Location("Jakarta", "Jakarta Utara", "Tempat Tinggal");
        // Recruiter
        Recruiter recruiter = new Recruiter(1, "Evans Hebert", "evans.hebert@ui.ac.id", "081234567890", location);
        // Job
        Job job = new Job(1, "Asisten", recruiter, 100000, "Sebuah Kategori");
        // Jobseeker
        Jobseeker jobseeker = new Jobseeker(1, "Tono", "tono@ui.ac.id", "password", "31-02-2021");
        // Invoice
        Invoice invoice = new Invoice(1, 5, "31-02-2021", 1000000, jobseeker);
        
        /*
         * Test out the getter
         * Set the getter and test it out again
         */
        System.out.println("Job old ID: " + job.getId()); // Job
        job.setId(5);
        System.out.println("Job new ID: " + job.getId());
        
        System.out.println("Jobseeker old ID: " + jobseeker.getId()); // Jobseeker
        jobseeker.setId(6);
        System.out.println("Jobseeker new ID: " + jobseeker.getId());
        
        System.out.println("Invoice old ID: " + invoice.getId()); // Invoice
        invoice.setId(7);
        System.out.println("Invoice new ID: " + invoice.getId());
    }
}
