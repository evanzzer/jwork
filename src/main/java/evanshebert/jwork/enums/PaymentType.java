package evanshebert.jwork.enums;

/**
 * Enumeration of Payment Type
 * 
 * @author Evans Hebert
 * @version 25 March 2021
 */
public enum PaymentType
{
    BankPayment("Bank Payment"), 
    EwalletPayment("E-Wallet Payment");
    
    private final String description;
    
    PaymentType(String description)
    {
        this.description = description;
    }
    
    public String toString() 
    {
        return description;
    }
}