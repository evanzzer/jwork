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
        // Jobseeker
        Jobseeker jobseeker1 = new Jobseeker(1, "Tono", "to..no@ui.ac.id", "plain", new GregorianCalendar(2021, 3, 8));
        Jobseeker jobseeker2 = new Jobseeker(2, "Tono", "tono.bener@ui.ac.id", "KomPleks123", 2021, 3, 8);
        Jobseeker jobseeker3 = new Jobseeker(3, "Tono", "terserah", "TeRsEr4h");

        System.out.println(jobseeker1.toString());
        System.out.println(jobseeker2.toString());
        System.out.println(jobseeker3.toString());

        jobseeker1.setEmail("email.yang.bener@do-main.com");
        jobseeker1.setPassword("PassBen4r");

        System.out.println(jobseeker1.toString());
    }
}