package evanshebert.jwork.database;

import java.util.ArrayList;

import evanshebert.jwork.database.postgre.DatabaseInvoicePostgre;
import evanshebert.jwork.enums.InvoiceStatus;
import evanshebert.jwork.exceptions.InvoiceNotFoundException;
import evanshebert.jwork.exceptions.OngoingInvoiceAlreadyExistsException;
import evanshebert.jwork.objects.Invoice;

/**
 * A list of database about Invoices
 *
 * @author Evans Hebert
 * @version 04 June 2021
 */
public class DatabaseInvoice {
    /**
     * Retrieve a list of invoice objects
     *
     * @return A list of invoice objects
     */
    public static ArrayList<Invoice> getInvoiceDatabase() {
        // Get listInvoice
        return DatabaseInvoicePostgre.getInvoiceDatabase();
    }

    /**
     * Retrieve the last ID of the database
     *
     * @return Last ID in Integer
     */
    public static int getLastId() {
        return DatabaseInvoicePostgre.getInvoiceLastId();
    }

    /**
     * Retrieve a specified invoice that can be found by ID
     *
     * @return An invoice object
     */
    public static Invoice getInvoiceById(int id) throws InvoiceNotFoundException {
        return DatabaseInvoicePostgre.getInvoiceById(id);
    }

    /**
     * Get a list of invoices that can be found by jobseeker's ID
     *
     * @param jobseekerId A jobseeker's ID
     * @return A list of invoice objects
     */
    public static ArrayList<Invoice> getInvoiceByJobseeker(int jobseekerId) {
        return DatabaseInvoicePostgre.getInvoiceByJobseeker(jobseekerId);
    }

    /**
     * Add a new invoice
     *
     * @param invoice An invoice Object
     * @return State to indicate an invoice has been successfully added
     */
    public static boolean addInvoice(Invoice invoice) throws OngoingInvoiceAlreadyExistsException {
        return DatabaseInvoicePostgre.insertInvoice(invoice);
    }

    /**
     * Change status of an invoice
     *
     * @param id            An invoice ID
     * @param invoiceStatus Status of the Invoice
     * @return State to indicate an invoice has been successfully changed
     */
    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus) {
        return DatabaseInvoicePostgre.updateInvoiceStatus(id, invoiceStatus);
    }

    /**
     * Remove existing invoice by ID
     *
     * @param id An invoice's ID
     * @return State to indicate an invoice has been successfully removed
     */
    public static boolean removeInvoice(int id) throws InvoiceNotFoundException {
        return DatabaseInvoicePostgre.deleteInvoice(id);
    }
}