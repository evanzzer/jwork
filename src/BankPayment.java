import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Details about bank payment.
 * 
 * @author Evans Hebert
 * @version 02 April 2021
 */
public class BankPayment extends Invoice
{
    private static final PaymentType PAYMENT_TYPE = PaymentType.BankPayment;
    private int adminFee;
    
    // Constructor
    public BankPayment(int id, Job job, Jobseeker jobseeker, InvoiceStatus invoiceStatus)
    {
        super(id, job, jobseeker, invoiceStatus);
    }
    
    // Another Constructor
    public BankPayment(int id, Job job, Jobseeker jobseeker, InvoiceStatus invoiceStatus, int adminFee)
    {
        super(id, job, jobseeker, invoiceStatus);
        this.adminFee = adminFee;
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
     * Retrieve Admin Fee of an invoice
     * @return Admin Fee of the Invoice
     */
    public int getAdminFee()
    {
        return adminFee;
    }
    
    /**
     * Set Admin Fee of an invoice
     * @param adminFee The admin fee to be set to an invoice
     */
    public void setAdminFee(int adminFee)
    {
        this.adminFee = adminFee;
    }
    
    /**
     * Abstract Method from Invoice
     * Set the Total Fee of the Invoice
     */
    public void setTotalFee()
    {
        totalFee = getJob().getFee();
        if (adminFee != 0) {
            totalFee -= adminFee;
        }
    }
    
    /**
     * Abstract Method from Invoice
     * Return out the information of the invoice
     * @return Information of the Invoice
     */
    public String toString()
    {
        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
        
        // Print out the information of an invoice
        return "========INVOICE========\n" +
            "ID       : " + getId() + "\n" +
            "Job Name : " + getJob().getName() + "\n" +
            "Date     : " + format.format(getDate().getTime()) + "\n" +
            "Jobseeker: " + getJobseeker().getName() + "\n" +
            "Payment  : " + getPaymentType().toString() + "\n" +
            "Status   : " + getInvoiceStatus() + "\n" + 
            "Admin Fee: " + adminFee + "\n" +
            "Total Fee: " + getTotalFee();
    }
}