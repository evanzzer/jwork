/*
 * Jobseeker Class
 */
public class Jobseeker
{
    private int id;
    private String name;
    private String email;
    private String password;
    private String joinDate;

    public Jobseeker(int id, String name, String email, String password, String joinDate)
    {
        // Constructor
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
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
    
    public String getPassword()
    {
        // Get Password
        return password;
    }
    
    public String getJoinDate()
    {
        // Get Join Date
        return joinDate;
    }
    
    public void setId(int id)
    {
        // Set ID
        this.id = id;
    }
    
    public void setName(String name)
    {
        // Set Name
        this.name = name;
    }
    
    public void setEmail(String email)
    {
        // Set Email
        this.email = email;
    }
    
    public void setPassword(String password)
    {
        // Set Password
        this.password = password;
    }
    
    public void setJoinDate(String joinDate)
    {
        // Set Join Date
        this.joinDate = joinDate;
    }
    
    public void printDate()
    {
        // Print out the name of Jobseeker
        System.out.println(name);
    }
}
