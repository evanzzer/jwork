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
        Job job = new Job(1, "Asisten", recruiter, 100000, "Sebuah Kategori");
        // Jobseeker
        Jobseeker jobseeker = new Jobseeker(1, "Tono", "tono@ui.ac.id", "password", "31-02-2021");
        // Invoice
        Invoice invoice = new Invoice(1, 5, "31-02-2021", 1000000, jobseeker);
        
        // Show the name of the recruiter
        System.out.println(recruiter.getName());
        // Change Recruiter
        recruiter.setName("Indira Insiyah Nastiti");
        // Show the name of the recruiter again
        System.out.println(recruiter.getName());
        // Get the Job Name
        job.printData();
        
        // Required Static Method to execute. The Code Below won't work!
        // Soal No.11
        // DatabaseJob.addJob(job);
        // DatabaseRecruiter.addRecruiter(recruiter);
    }
}
