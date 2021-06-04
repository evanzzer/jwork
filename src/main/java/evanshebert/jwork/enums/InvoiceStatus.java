package evanshebert.jwork.enums;

/**
 * Enumeration of Invoice Status
 *
 * @author Evans Hebert
 * @version 27 March 2021
 */
public enum InvoiceStatus {
    Ongoing("Ongoing"),
    Finished("Finished"),
    Cancelled("Cancelled");

    private final String description;

    InvoiceStatus(String description) {
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
}