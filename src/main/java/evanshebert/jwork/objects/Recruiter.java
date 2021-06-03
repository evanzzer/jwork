package evanshebert.jwork.objects;

/**
 * Information about a recruiter.
 * Contains ID, Name, email, Phone Number, and Location of a recruiter.
 * 
 * @author Evans Hebert
 * @version 8 April 2021
 */
public class Recruiter
{
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private Location location;

    /*
     * Constructor
     * Declares a new Recruiter Object
     */ 
    public Recruiter(int id, String name, String email, String phoneNumber, Location location)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;
    }
    
    // Getter
    /**
     * Retrieve the Recruiter's ID
     * @return Recruiter's ID
     */
    public int getId()
    {
        // Get ID
        return id;
    }
    
    /**
     * Retrieve the Recruiter's name
     * @return Recruiter's name
     */
    public String getName()
    {
        // Get Name
        return name;
    }
    
    /**
     * Retrieve the Recruiter's email
     * @return Recruiter's email
     */
    public String getEmail()
    {
        // Get email
        return email;
    }
    
    /**
     * Retrieve the Recruiter's Phone Number
     * @return Recruiter's Phone Number
     */
    public String getPhoneNumber()
    {
        // Get Phone Number
        return phoneNumber;
    }
    
    /**
     * Retrieve the Recruiter's Location
     * @return Location Object
     */
    public Location getLocation()
    {
        // Get location
        return location;
    }
    
    // Setter
    /**
     * Set the Recruiter's ID
     * @param id Recruiter's ID
     */
    public void setId(int id)
    {
        // Set Id
        this.id = id;
    }
    
    /**
     * Set the Recruiter's email
     * @param email Recruiter's email
     */
    public void setEmail(String email)
    {
        // Set Email
        this.email = email;
    }
    
    /**
     * Set the Recruiter's name
     * @param name Recruiter's name
     */
    public void setName(String name)
    {
        // Set Name
        this.name = name;
    }
    
    /**
     * Set the Recruiter's Phone Number
     * @param phoneNumber Recruiter's Phone Number
     */
    public void setPhoneNumber(String phoneNumber)
    {
        // Set Phone Number
        this.phoneNumber = phoneNumber;
    }

    /**
     * Set the Recruiter's Location
     * @param location Recruiter's Location
     */
    public void setLocation(Location location)
    {
        // Set location
        this.location = location;
    }
    
    // Other Functions
    /**
     * Return the information of the recruiter
     * @return Information of the Recruiter
     */
    public String toString()
    {
        // Return the information of the recruiter
        return "====== RECRUITER ======\n" +
            "ID          : " + id + "\n" +
            "Name        : " + name + "\n" +
            "email       : " + email + "\n" +
            "Phone Number: " + phoneNumber + "\n" +
            "Location    : " + location.getProvince();
    }
}