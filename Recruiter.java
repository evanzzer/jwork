/*
 * Recruiter Class
 */
public class Recruiter
{
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private Location location;

    public Recruiter(int id, String name, String email, String phoneNumber, Location location)
    {
        // Constructor
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;
    }

    public int getId()
    {
        // Get ID
        return id;
    }
    
    public String getName()
    {
        // Get Name
        return name;
    }
    
    public String getEmail()
    {
        // Get email
        return email;
    }
    
    public String getPhoneNumber()
    {
        // Get Phone Number
        return phoneNumber;
    }
    
    public Location getLocation()
    {
        // Get location
        return location;
    }
    
    public void setId(int id)
    {
        // Set Id
        this.id = id;
    }
    
    public void setEmail(String email)
    {
        // Set Email
        this.email = email;
    }
    
    public void setName(String name)
    {
        // Set Name
        this.name = name;
    }
    
    public void setPhoneNumber(String phoneNumber)
    {
        // Set Phone Number
        this.phoneNumber = phoneNumber;
    }

    public void setLocation(Location location)
    {
        // Set location
        this.location = location;
    }
    
    public void printData()
    {
        // Print out the name of the recruiter
        System.out.println(name);
    }
}
