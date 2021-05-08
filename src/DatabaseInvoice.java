import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A list of database about Invoices
 *
 * @author Evans Hebert
 * @version 08 May 2021
 */
public class DatabaseInvoice
{
    private static final ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    /**
     * Retrieve a list of invoice objects
     * @return A list of invoice objects
     */
    public static ArrayList<Invoice> getInvoiceDatabase()
    {
        // Get listInvoice
        return INVOICE_DATABASE;
    }

    /**
     * Retrieve the last ID of the database
     * @return Last ID in Integer
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * Retrieve a specified invoice that can be found by ID
     * @return An invoice object
     */
    public static Invoice getInvoiceById(int id)
    {
        try {
            for (Invoice invoice : INVOICE_DATABASE) {
                if (invoice.getId() == id) {
                    return invoice;
                }
            }
            throw new InvoiceNotFoundException(id);
        } catch (InvoiceNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Get a list of invoices that can be found by jobseeker's ID
     * @param jobseekerId A jobseeker's ID
     * @return A list of invoice objects
     */
    public static ArrayList<Invoice> getInvoiceByJobseeker(int jobseekerId)
    {
        List<Invoice> findInvoices = INVOICE_DATABASE
                .stream()
                .filter(invoice -> invoice.getJobseeker().getId() == jobseekerId)
                .collect(Collectors.toList());
        return (findInvoices.size() != 0) ? new ArrayList<>(findInvoices) : null;
    }

    /**
     * Add a new invoice
     * @param invoice An invoice Object
     * @return State to indicate an invoice has been successfully added
     */
    public static boolean addInvoice(Invoice invoice)
    {
        try {
            for (Invoice existInvoice : INVOICE_DATABASE) {
                if ((existInvoice.getJobseeker() == invoice.getJobseeker() && existInvoice.getInvoiceStatus() == InvoiceStatus.Ongoing)
                     || (existInvoice.getId() == invoice.getId() && existInvoice.getInvoiceStatus() == InvoiceStatus.Ongoing)) {
                    throw new OngoingInvoiceAlreadyExistsException(existInvoice);
                }
            }
            INVOICE_DATABASE.add(invoice);
            lastId = invoice.getId();
            return true;
        } catch (OngoingInvoiceAlreadyExistsException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Change status of an invoice
     * @param id An invoice ID
     * @param invoiceStatus Status of the Invoice
     * @return State to indicate an invoice has been successfully changed
     */
    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus)
    {
        for (Invoice invoice : INVOICE_DATABASE) {
            if (invoice.getId() == id) {
                invoice.setInvoiceStatus(invoiceStatus);
                return true;
            }
        }
        return false;
    }

    /**
     * Remove existing invoice by ID
     * @param id An invoice's ID
     * @return State to indicate an invoice has been successfully removed
     */
    public static boolean removeInvoice(int id)
    {
        try {
            for (Invoice invoice : INVOICE_DATABASE) {
                if (invoice.getId() == id) {
                    INVOICE_DATABASE.remove(invoice);
                    return true;
                }
            }
            throw new InvoiceNotFoundException(id);
        } catch (InvoiceNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}