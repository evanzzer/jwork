package evanshebert.jwork;

/**
 * Fee Calculator - MultiThreading
 *
 * @author Evans Hebert
 * @version 06 May 2021
 */
public class FeeCalculator implements Runnable
{
    private final Invoice invoice;

    public FeeCalculator(Invoice invoice)
    {
        this.invoice = invoice;
    }

    @Override
    public void run()
    {
        System.out.println("Calculationg Invoice ID: " + invoice.getId());
        invoice.setTotalFee();
        System.out.println("Finish calculating Invoice ID: " + invoice.getId());
    }

    public void start()
    {
        Thread t = new Thread(this, String.valueOf(invoice.getId()));
        t.start();
    }
}
