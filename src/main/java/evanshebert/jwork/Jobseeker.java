package evanshebert.jwork;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Information about a jobseeker.
 * Contains ID, name, email, password, and join date of a jobseeker
 * 
 * @author Evans Hebert
 * @version 8 April 2021
 */
public class Jobseeker
{
    private int id;
    private String name;
    private String email;
    private String password;
    public Calendar joinDate;

    /*
     * Constructor
     * Declare a new Jobseeker object
     */ 
    public Jobseeker(int id, String name, String email, String password, Calendar joinDate)
    {
        this.id = id;
        this.name = name;
        this.joinDate = joinDate;
        setEmail(email);
        setPassword(password);
    }

    public Jobseeker(int id, String name, String email, String password, int year, int month, int dayOfMonth)
    {
        this.id = id;
        this.name = name;

        setEmail(email);
        setPassword(password);
        
        joinDate = new GregorianCalendar(year, month, dayOfMonth);
    }

    public Jobseeker(int id, String name, String email, String password)
    {
        this.id = id;
        this.name = name;

        setEmail(email);
        setPassword(password);
        
        joinDate = Calendar.getInstance();
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
    public Calendar getJoinDate()
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
        String regex = "^[a-zA-Z0-9&*_~]+(\\.[a-zA-Z0-9&*_~]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(email);

        this.email = matcher.find() ? email : "";
    }
    
    /**
     * Set the password of a jobseeker
     * @param password Jobseeker's password
     */
    public void setPassword(String password)
    {
        // Set Password
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{6,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        this.password = matcher.find() ? password : "";
    }
    
    /**
     * Set the join date of a jobseeker using Calendar as the data type
     * @param joinDate Jobseeker's join date
     */
    public void setJoinDate(Calendar joinDate)
    {
        // Set Join Date
        this.joinDate = joinDate;
    }

    /**
     * Set the join date of a jobseeker using Calendar as the data type
     * @param year Jobseeker's join date's year
     * @param month Jobseeker's join date's month
     * @param dayOfMonth JobSeeker's join date's day
     */
    public void setJoinDate(int year, int month, int dayOfMonth)
    {
        // Set Join Date
        joinDate = new GregorianCalendar(year, month, dayOfMonth);
    }

    // Other Functions
    /**
     * Return the information of the jobseeker
     * @return Information of the Jobseeker
     */
    public String toString()
    {
        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
        String date = joinDate != null ? format.format(joinDate.getTime()) : "";
        // Return the info
        return "====== JOBSEEKER ======\n" +
            "ID      : " + id + "\n" +
            "Name    : " + name + "\n" +
            "email   : " + email + "\n" +
            "password: " + password + "\n" + 
            "joinDate: " + date;
    }
}