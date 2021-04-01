/**
 * Enumeration of Invoice Status
 * 
 * @author Evans Hebert
 * @version 27 March 2021
 */
public enum InvoiceStatus
{
    Ongoing("Ongoing"), 
    Finished("Finished"), 
    Cancelled("Cancelled");
    
    private String description;
    
    InvoiceStatus(String description)
    {
        this.description = description;
    }
    
    public String toString()
    {
        return description;
    }
}