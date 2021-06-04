package evanshebert.jwork;

import evanshebert.jwork.objects.Invoice;

/**
 * Fee Calculator - MultiThreading
 *
 * @author Evans Hebert
 * @version 06 May 2021
 */
public class FeeCalculator implements Runnable {
    private final Invoice invoice;

    /**
     * Constructor for defining a thread
     *
     * @param invoice Invoice Thread
     */
    public FeeCalculator(Invoice invoice) {
        this.invoice = invoice;
    }

    /**
     * Run thread
     */
    @Override
    public void run() {
        System.out.println("Calculationg Invoice ID: " + invoice.getId());
        invoice.setTotalFee();
        System.out.println("Finish calculating Invoice ID: " + invoice.getId());
    }

    /**
     * Start thread
     */
    public void start() {
        Thread t = new Thread(this, String.valueOf(invoice.getId()));
        t.start();
    }
}
