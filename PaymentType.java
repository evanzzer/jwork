/**
 * Enumeration of Payment Type
 * 
 * @author Evans Hebert
 * @version 25 March 2021
 */
public enum PaymentType
{
    BankPayment, EwalletPayment;
    
    public String toString() {
        switch(this) {
            case BankPayment:
                return "Bank Payment";
            case EwalletPayment:
                return "E-Wallet Payment";
            default:
                return "Not Registered";
        }
    }
}
