/**
 * Enumeration of Invoice Status
 * 
 * @author Evans Hebert
 * @version 27 March 2021
 */
public enum InvoiceStatus
{
    Ongoing, Finished, Cancelled;
    
    public String toString()
    {
        switch (this)
        {
            case Ongoing:
                return "Ongoing";
            case Finished:
                return "Finished";
            case Cancelled:
                return "Cancelled";
            default:
                return "Not Registered";
        }
    }
}