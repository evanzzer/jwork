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
        Job job1 = new Job(1, "Asisten", recruiter, 100000, JobCategory.BackEnd);
        Job job2 = new Job(2, "Dosen", recruiter, 200000, JobCategory.DevOps);
        // Jobseeker
        Jobseeker jobseeker = new Jobseeker(1, "Tono", "tono@ui.ac.id", "password", "31-02-2021");
        // Bonus
        Bonus bonus = new Bonus(1, "PBOASIK", 25000, 150000, true);

        // EwalletPayment
        EwalletPayment ewalletPayment1 = new EwalletPayment(1, job1, "01-04-2021", jobseeker, InvoiceStatus.Ongoing);
        EwalletPayment ewalletPayment2 = new EwalletPayment(2, job1, "01-04-2021", jobseeker, bonus, InvoiceStatus.Ongoing);
        EwalletPayment ewalletPayment3 = new EwalletPayment(3, job2, "01-04-2021", jobseeker, bonus, InvoiceStatus.Ongoing);

        ewalletPayment1.setTotalFee();
        ewalletPayment2.setTotalFee();
        ewalletPayment3.setTotalFee();

        ewalletPayment1.printData();
        ewalletPayment2.printData();
        ewalletPayment3.printData();
    }
}