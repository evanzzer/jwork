/**
 * The main file of the package. Contains main().
 * 
 * @author Evans Hebert
 * @version 18 March 2021
 */
public class JWork
{
    /*
     * Main Function
     */
    public static void main(String[] args)
    {
        Location location = new Location("Jakarta", "Jakarta Utara", "Tempat Tinggal");
        Recruiter recruiter = new Recruiter(1, "Evans Hebert", "evans.hebert@ui.ac.id", "081234567890", location);
        Job job = new Job(1, "Asisten", recruiter, 100000, "Sebuah Kategori");
        Jobseeker jobseeker = new Jobseeker(1, "Tono", "tono@ui.ac.id", "password", "31-02-2021");
        Invoice invoice = new Invoice(1, 5, "31-02-2021", 1000000, jobseeker);
    }
}
