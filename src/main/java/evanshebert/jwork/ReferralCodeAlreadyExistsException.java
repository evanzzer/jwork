package evanshebert.jwork;

/**
 * Email Already Exist Exception
 *
 * @author Evans Hebert
 * @version 06 May 2021
 */
public class ReferralCodeAlreadyExistsException extends Exception {
    private final Bonus bonus_error;

    /**
     * Default Constructor
     * @param bonus_input Bonus input
     */
    public ReferralCodeAlreadyExistsException(Bonus bonus_input) {
        super("Referral Code: ");
        bonus_error = bonus_input;
    }

    /**
     * Retrieve error message
     * @return error message
     */
    public String getMessage()
    {
        return super.getMessage() + bonus_error.getReferralCode() + " already exists.";
    }
}
