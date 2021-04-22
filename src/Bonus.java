/**
 * Details about Bonus.
 * 
 * @author Evans Hebert
 * @version 08 April 2021
 */
public class Bonus
{
    private int id;
    private String referralCode;
    private int extraFee;
    private int minTotalFee;
    private boolean active;
    
    // Constructor
    public Bonus(int id, String referralCode, int extraFee, int minTotalFee, boolean active)
    {
        this.id = id;
        this.referralCode = referralCode;
        this.extraFee = extraFee;
        this.minTotalFee = minTotalFee;
        this.active = active;
    }
    
    // Getter
    /**
     * Retrieve ID of the bonus
     * @return ID of the bonus
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Retrieve a Referral Code
     * @return Referral code
     */
    public String getReferralCode()
    {
        return referralCode;
    }
    
    /**
     * Retrieve extra fee
     * @return Extra Fee
     */
    public int getExtraFee() 
    {
        return extraFee;
    }

    /**
     * Retrieve Minimum of the Total Fee
     * @return The minimum value
     */
    public int getMinTotalFee() 
    {
        return minTotalFee;
    }

    /**
     * Retrieve the status of the bonus
     * @return Status of the bonus
     */
    public boolean getActive() 
    {
        return active;
    }   
    
    // Setter
    /**
     * Set the ID
     * @param id ID of the bonus
     */
    public void setId(int id) 
    {
        this.id = id;
    }

    /**
     * Set the Referral Code
     * @param referralCode The Referral Code
     */
    public void setReferralCode(String referralCode) 
    {
        this.referralCode = referralCode;
    }

    /**
     * Set the Extra Fee
     * @param extraFee Extra Fee of the bonus
     */
    public void setExtraFee(int extraFee) 
    {
        this.extraFee = extraFee;
    }

    /**
     * Set the minimum value
     * @param minTotalFee The minimum value of the fee
     */
    public void setMinTotalFee(int minTotalFee) 
    {
        this.minTotalFee = minTotalFee;
    }

    /**
     * Set if the Bonus is active
     * @param active Bonus status
     */
    public void setActive(boolean active) 
    {
        this.active = active;
    }
    
    /**
     * Return the information of the recruiter
     * @return Information of the Recruiter
     */
    public String toString()
    {
        // Return the information of the recruiter
        return "======== BONUS ========\n" +
            "ID           : " + id + "\n" +
            "Referral Code: " + referralCode + "\n" +
            "Extra Fee    : " + extraFee + "\n" +
            "Min Total Fee: " + minTotalFee + "\n" +
            "Status Active: " + active;
    }    
}