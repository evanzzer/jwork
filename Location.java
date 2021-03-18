
/*
 * Location Class
 * 
 * A class that contains informations about a location.
 */
public class Location
{
    private String province;
    private String city;
    private String description;
    
    // Constructor
    public Location(String province, String city, String description)
    {
        this.province = province;
        this.city = city;
        this.description = description;
    }
    
    // Getter
    public String getProvince()
    {
        // Get Province
        return province;
    }
    
    public String getCity()
    {
        // Get City
        return city;
    }
    
    public String getDescription()
    {
        // Get Description
        return description;
    }
    
    // Setter
    public void setProvince(String province)
    {
        // Set Province
        this.province = province;
    }
    
    public void setCity(String city)
    {
        // Set city
        this.city = city;
    }
    
    public void setDescription(String description)
    {
        // Set Description
        this.description = description;
    }
    
    // Other Functions
    public void printData()
    {
        // Print Province
        System.out.println(province);
    }
}
