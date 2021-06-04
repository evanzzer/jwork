package evanshebert.jwork.enums;

import java.util.HashMap;
import java.util.Map;

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

    private static final Map<String, PaymentType> lookup = new HashMap<>();

    static {
        for (PaymentType p : PaymentType.values()) {
            lookup.put(p.toString(), p);
        }
    }
    
    private final String description;
    
    PaymentType(String description)
    {
        this.description = description;
    }
    
    public String toString() 
    {
        return description;
    }

    public static PaymentType get(String p) {
        return lookup.get(p);
    }
}