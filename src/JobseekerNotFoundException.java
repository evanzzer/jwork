/**
 * Jobseeker Not Found Exception
 *
 * @author Evans Hebert
 * @version 06 May 2021
 */
public class JobseekerNotFoundException extends Exception {
    private final int jobseeker_error;

    /**
     * Default Constructor
     * @param jobseeker_input Jobseeker Error Input
     */
    public JobseekerNotFoundException(int jobseeker_input)
    {
        super("Jobseeker ID: ");
        jobseeker_error = jobseeker_input;
    }

    /**
     * Retrieve error message
     * @return error message
     */
    public String getMessage()
    {
        return super.getMessage() + jobseeker_error + " not found.";
    }
}
