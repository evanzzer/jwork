/**
 * Invoice Not Found Exception
 *
 * @author Evans Hebert
 * @version 08 May 2021
 */
public class InvoiceNotFoundException extends Exception {
    private final int invoice_error;

    /**
     * Default Constructor
     * @param invoice_input Bonus input
     */
    public InvoiceNotFoundException(int invoice_input)
    {
        super("Invoice ID: ");
        invoice_error = invoice_input;
    }

    /**
     * Retrieve error message
     * @return error message
     */
    public String getMessage()
    {
        return super.getMessage() + invoice_error + " not found.";
    }
}
