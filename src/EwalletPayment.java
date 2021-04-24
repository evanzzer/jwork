import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * Details about e-wallet payment.
 * 
 * @author Evans Hebert
 * @version 22 April 2021
 */
public class EwalletPayment extends Invoice
{
    private static final PaymentType PAYMENT_TYPE = PaymentType.EwalletPayment;
    private Bonus bonus;
    
    // Constructor
    public EwalletPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker)
    {
        super(id, jobs, jobseeker);
    }
    
    // Another Constructor
    public EwalletPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker, Bonus bonus, InvoiceStatus invoiceStatus)
    {
        super(id, jobs, jobseeker);
        this.bonus = bonus;
    }
    
    // Getter
    /**
     * Retrieve Payment Type of an Invoice
     * @return Payment Type
     */
    public PaymentType getPaymentType()
    {
        return PAYMENT_TYPE;
    }
    
    /**
     * Retrieve Bonus of an invoice
     * @return Bonus of the Invoice
     */
    public Bonus getBonus()
    {
        return bonus;
    }
    
    /**
     * Set Bonus of an invoice
     * @param bonus The bonus to be set to an invoice
     */
    public void setBonus(Bonus bonus)
    {
        this.bonus = bonus;
    }
    
    /**
     * Abstract Method from Invoice
     * Set the Total Fee of the Invoice
     */
    public void setTotalFee()
    {
        getJobs().forEach(job -> totalFee += job.getFee());
        if (bonus != null && bonus.getActive() && totalFee > bonus.getMinTotalFee()) {
            totalFee += bonus.getExtraFee();
        }
    }
    
    /**
     * Abstract Method from Invoice
     * Return information of the invoice
     * @return Information of the Invoice
     */
    public String toString()
    {
        // Print out the information of an invoice
        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
        List<String> jobNames = getJobs()
                .stream()
                .map(Job::getName)
                .collect(Collectors.toList());

        return "======== INVOICE ========\n" +
            "ID       : " + getId() + "\n" +
            "Job Name : " + String.join(",", jobNames) + "\n" +
            "Date     : " + format.format(getDate().getTime()) + "\n" +
            "Jobseeker: " + getJobseeker().getName() + "\n" +
            "Payment  : " + getPaymentType().toString() + "\n" +
            "Status   : " + getInvoiceStatus() + "\n" + 
            "Total Fee: " + getTotalFee() + 
            (
                (bonus != null && bonus.getActive() && totalFee > bonus.getMinTotalFee()) 
                    ? ("\nReferral Code: " + bonus.getReferralCode()) 
                    : ""
            );
    }
}