package evanshebert.jwork.exceptions;

import evanshebert.jwork.objects.Invoice;

/**
 * Ongoing Invoice Already Exists Exception
 *
 * @author Evans Hebert
 * @version 08 May 2021
 */
public class OngoingInvoiceAlreadyExistsException extends Exception {
    private final Invoice invoice_error;

    /**
     * Default Constructor
     * @param invoice_input Bonus input
     */
    public OngoingInvoiceAlreadyExistsException(Invoice invoice_input)
    {
        super("Ongoing invoice ");
        invoice_error = invoice_input;
    }

    /**
     * Retrieve error message
     * @return error message
     */
    public String getMessage()
    {
        return super.getMessage() + invoice_error.getId() + " already exists.";
    }
}
