/**
 * Informations about a jobseeker.
 * Contains ID, name, email, password, and join date of a jobseeker
 * 
 * @author Evans Hebert
 * @version 18 March 2021
 */
public class Jobseeker
{
    private int id;
    private String name;
    private String email;
    private String password;
    private String joinDate;

    /*
     * Constructor
     * Declare a new Jobseeker object
     */ 
    public Jobseeker(int id, String name, String email, String password, String joinDate)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
    }
    
    // Getter
    /**
     * Retrieve ID of a jobseeker
     * @return Jobseeker's ID
     */
    public int getId()
    {
        // Get ID
        return id;
    }
    
    /**
     * Retrieve the name of a jobseeker
     * @return Jobseeker's Name
     */
    public String getName()
    {
        // Get Name
        return name;
    }
    
    /**
     * Retrieve the email of a jobseeker
     * @return Jobseeker's email
     */
    public String getEmail()
    {
        // Get email
        return email;
    }
    
    /**
     * Retrieve the password of a jobseeker
     * @return Jobseeker's password
     */
    public String getPassword()
    {
        // Get Password
        return password;
    }
    
    /**
     * Retrieve the join date of a jobseeker
     * @return Jobseeker's join date
     */
    public String getJoinDate()
    {
        // Get Join Date
        return joinDate;
    }
    
    // Setter
    /**
     * Set the ID of a jobseeker
     * @param id Jobseeker's ID
     */
    public void setId(int id)
    {
        // Set ID
        this.id = id;
    }
    
    /**
     * Set the name of a jobseeker
     * @param name Jobseeker's name
     */
    public void setName(String name)
    {
        // Set Name
        this.name = name;
    }
    
    /**
     * Set the email of a jobseeker
     * @param email Jobseeker's email
     */
    public void setEmail(String email)
    {
        // Set Email
        this.email = email;
    }
    
    /**
     * Set the password of a jobseeker
     * @param password Jobseeker's password
     */
    public void setPassword(String password)
    {
        // Set Password
        this.password = password;
    }
    
    /**
     * Set the join date of a jobseeker
     * @param joinDate Jobseeker's join date
     */
    public void setJoinDate(String joinDate)
    {
        // Set Join Date
        this.joinDate = joinDate;
    }
    
    // Other Functions
    /**
     * Print the name of the jobseeker
     */
    public void printData()
    {
        // Print out the name of Jobseeker
        System.out.println(name);
    }
}
