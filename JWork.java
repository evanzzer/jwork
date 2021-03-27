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
        // Jobseeker
        Jobseeker jobseeker = new Jobseeker(1, "Tono", "tono@ui.ac.id", "password", "31-02-2021");
        // Invoice
        Invoice invoice = new Invoice(5, 1, "31-02-2021", 100000, jobseeker, PaymentType.BankPayment, InvoiceStatus.Ongoing);
        
        invoice.printData();
    }
}