package evanshebert.jwork;

/**
 * Bonus Not Found Exception
 *
 * @author Evans Hebert
 * @version 06 May 2021
 */
public class BonusNotFoundException extends Exception {
    private final int bonus_error;

    /**
     * Default Constructor
     * @param bonus_input Bonus Error Input
     */
    public BonusNotFoundException(int bonus_input)
    {
        super("Bonus ID: ");
        bonus_error = bonus_input;
    }

    /**
     * Retrieve error message
     * @return error message
     */
    public String getMessage()
    {
        return super.getMessage() + bonus_error + " not found.";
    }
}
