import java.util.ArrayList;

/**
 * A list of database about Bonus
 * 
 * @author Evans Hebert
 * @version 22 April 2021
 */
public class DatabaseBonus
{
    private static final ArrayList<Bonus> BONUS_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    /**
     * Retrieve a list of bonus currently available
     * @return A list of bonus
     */
    public static ArrayList<Bonus> getBonusDatabase()
    {
        return BONUS_DATABASE;
    }

    /**
     * Retrieve the last ID of the database
     * @return Last ID in Integer
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * Retrieve a specified bonus by it's ID
     * @return A bonus object
     */
    public static Bonus getBonusById(int id)
    {
        for (Bonus bonus : BONUS_DATABASE) {
            if (bonus.getId() == id) {
                return bonus;
            }
        }
        return null;
    }

    public static Bonus getBonusByReferralCode(String referralCode)
    {
        for (Bonus bonus : BONUS_DATABASE) {
            if (bonus.getReferralCode().equals(referralCode)) {
                return bonus;
            }
        }
        return null;
    }

    /**
     * Add a new bonus
     * @param bonus A bonus Object
     * @return State to indicate a bonus has been successfully added
     */
    public static boolean addBonus(Bonus bonus)
    {
        for (Bonus existBonus : BONUS_DATABASE) {
            if (bonus.getReferralCode().equals(existBonus.getReferralCode())) {
                return false;
            }
        }
        BONUS_DATABASE.add(bonus);
        lastId = bonus.getId();
        return true;
    }

    /**
     * Activate a specified bonus by ID
     * @param id A bonus ID
     * @return State to indicate a bonus has been activated successfully
     */
    public static boolean activateBonus(int id)
    {
        for (Bonus bonus : BONUS_DATABASE) {
            if (bonus.getId() == id) {
                bonus.setActive(true);
                return true;
            }
        }
        return false;
    }

    /**
     * Deactivate a specified bonus by ID
     * @param id A bonus ID
     * @return State to indicate a bonus has been deactivated successfully
     */
    public static boolean deactivateBonus(int id)
    {
        for (Bonus bonus : BONUS_DATABASE) {
            if (bonus.getId() == id) {
                bonus.setActive(false);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Remove existing bonus
     * @param id A Bonus's ID
     * @return State to indicate a bonus has been successfully removed
     */
    public static boolean removeBonus(int id)
    {
        for (Bonus bonus : BONUS_DATABASE) {
            if (bonus.getId() == id) {
                BONUS_DATABASE.remove(bonus);
                return true;
            }
        }
        return false;
    }
}