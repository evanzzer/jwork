/**
 * Informations about a location.
 * Contains province, city, and description of a location.
 * 
 * @author Evans Hebert
 * @version 8 April 2021
 */
public class Location
{
    private String province;
    private String city;
    private String description;
    
    /*
     * Constructor
     * Declare a new Location object.
     */ 
    public Location(String province, String city, String description)
    {
        this.province = province;
        this.city = city;
        this.description = description;
    }
    
    // Getter
    /**
     * Retrieve the province of the location
     * @return Location's province
     */
    public String getProvince()
    {
        // Get Province
        return province;
    }
    
    /**
     * Retrieve the city of the location
     * @return Location's city
     */
    public String getCity()
    {
        // Get City
        return city;
    }
    
    /**
     * Retrieve the description of the location
     * @return Location's description
     */
    public String getDescription()
    {
        // Get Description
        return description;
    }
    
    // Setter
    /**
     * Set the province of the location
     * @param province Location's province
     */
    public void setProvince(String province)
    {
        // Set Province
        this.province = province;
    }
    
    /**
     * Set the city of the location
     * @param city Location's city
     */
    public void setCity(String city)
    {
        // Set city
        this.city = city;
    }
    
    /**
     * Set the description of the location
     * @param province Location's description
     */
    public void setDescription(String description)
    {
        // Set Description
        this.description = description;
    }
    
    // Other Functions
    /**
     * Return out the information of a location
     * @return Information of a Location
     */
    public String toString()
    {
        // Return Province
        return "Province   : " + province + "\n" +
            "City       : " + city + "\n" +
            "Description: " + description;
    }
}