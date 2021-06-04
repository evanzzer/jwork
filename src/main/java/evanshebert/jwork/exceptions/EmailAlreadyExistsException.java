package evanshebert.jwork.exceptions;

import evanshebert.jwork.objects.Jobseeker;

/**
 * Email Already Exist Exception
 *
 * @author Evans Hebert
 * @version 06 May 2021
 */
public class EmailAlreadyExistsException extends Exception {
    private final Jobseeker jobseeker_error;

    /**
     * Default Constructor
     *
     * @param jobseeker_input Jobseeker input
     */
    public EmailAlreadyExistsException(Jobseeker jobseeker_input) {
        super("Jobseeker Email: ");
        jobseeker_error = jobseeker_input;
    }

    /**
     * Retrieve error message
     *
     * @return error message
     */
    public String getMessage() {
        return super.getMessage() + jobseeker_error.getEmail() + " already exists.";
    }
}
