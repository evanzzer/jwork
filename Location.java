
/*
 * Location Class
 */
public class Location
{
    private String province;
    private String city;
    private String description;
    
    public Location(String province, String city, String description)
    {
        // Constructor
        this.province = province;
        this.city = city;
        this.description = description;
    }
    
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
    
    public void printData()
    {
        // Print Province
        System.out.println(province);
    }
}
