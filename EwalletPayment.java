/**
 * Details about e-wallet payment.
 * 
 * @author Evans Hebert
 * @version 01 April 2021
 */
public class EwalletPayment extends Invoice
{
    private static final PaymentType PAYMENT_TYPE = PaymentType.EwalletPayment;
    private Bonus bonus;
    
    // Constructor
    public EwalletPayment(int id, Job job, String date, Jobseeker jobseeker, InvoiceStatus invoiceStatus)
    {
        super(id, job, date, jobseeker, invoiceStatus);
    }
    
    // Another Constructor
    public EwalletPayment(int id, Job job, String date, Jobseeker jobseeker, Bonus bonus, InvoiceStatus invoiceStatus)
    {
        super(id, job, date, jobseeker, invoiceStatus);
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
        totalFee = getJob().getFee();
        if (bonus != null && bonus.getActive() && totalFee > bonus.getMinTotalFee()) {
            totalFee += bonus.getExtraFee();
        }
    }
    
    /**
     * Abstract Method from Invoice
     * Print out the information of the invoice
     */
    public void printData()
    {
        // Print out the information of an invoice
        System.out.println(
            "========INVOICE========\n" +
            "ID       : " + getId() + "\n" +
            "Job Name : " + getJob().getName() + "\n" +
            "Date     : " + getDate() + "\n" +
            "Jobseeker: " + getJobseeker().getName() + "\n" +
            "Payment  : " + getPaymentType().toString() + "\n" +
            "Status   : " + getInvoiceStatus() + "\n" + 
            "Total Fee: " + getTotalFee() + 
            (
                (bonus != null && bonus.getActive() && totalFee > bonus.getMinTotalFee()) 
                    ? ("\nReferral Code: " + bonus.getReferralCode()) 
                    : ""
            )
        );
    }
}