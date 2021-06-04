package evanshebert.jwork.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Enumeration of Payment Type
 *
 * @author Evans Hebert
 * @version 25 March 2021
 */
public enum PaymentType {
    BankPayment("Bank Payment"),
    EwalletPayment("E-Wallet Payment");

    private static final Map<String, PaymentType> lookup = new HashMap<>();

    static {
        for (PaymentType p : PaymentType.values()) {
            lookup.put(p.toString(), p);
        }
    }

    private final String description;

    PaymentType(String description) {
        this.description = description;
    }

    /**
     * Convert an enum to string
     *
     * @return String description of an enum
     */
    public String toString() {
        return description;
    }

    /**
     * Convert provided string to an enum
     *
     * @return A specific enum
     */
    public static PaymentType get(String p) {
        return lookup.get(p);
    }
}