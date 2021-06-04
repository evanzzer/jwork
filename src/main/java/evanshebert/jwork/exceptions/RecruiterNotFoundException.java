package evanshebert.jwork.exceptions;

/**
 * Recruiter Not Found Exception
 *
 * @author Evans Hebert
 * @version 06 May 2021
 */
public class RecruiterNotFoundException extends Exception {
    private final int recruiter_error;

    /**
     * Default Constructor
     *
     * @param recruiter_input Recruiter Error Input
     */
    public RecruiterNotFoundException(int recruiter_input) {
        super("Recruiter ID: ");
        recruiter_error = recruiter_input;
    }

    /**
     * Retrieve error message
     *
     * @return error message
     */
    public String getMessage() {
        return super.getMessage() + recruiter_error + " not found.";
    }
}
