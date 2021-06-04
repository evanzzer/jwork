package evanshebert.jwork.exceptions;

/**
 * Job Not Found Exception
 *
 * @author Evans Hebert
 * @version 06 May 2021
 */
public class JobNotFoundException extends Exception {
    private final int job_error;

    /**
     * Default Constructor
     *
     * @param job_input Job Error Input
     */
    public JobNotFoundException(int job_input) {
        super("Job ID: ");
        job_error = job_input;
    }

    /**
     * Retrieve error message
     *
     * @return error message
     */
    public String getMessage() {
        return super.getMessage() + job_error + " not found.";
    }
}
