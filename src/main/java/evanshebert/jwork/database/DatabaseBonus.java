package evanshebert.jwork.database;

import java.util.ArrayList;

import evanshebert.jwork.database.postgres.DatabaseBonusPostgre;
import evanshebert.jwork.exceptions.BonusNotFoundException;
import evanshebert.jwork.exceptions.ReferralCodeAlreadyExistsException;
import evanshebert.jwork.objects.Bonus;

/**
 * A list of database about Bonus
 *
 * @author Evans Hebert
 * @version 03 June 2021
 */
public class DatabaseBonus {
    /**
     * Retrieve a list of bonus currently available
     *
     * @return A list of bonus
     */
    public static ArrayList<Bonus> getBonusDatabase() {
        return DatabaseBonusPostgre.getBonusDatabase();
    }

    /**
     * Retrieve the last ID of the database
     *
     * @return Last ID in Integer
     */
    public static int getLastId() {
        return DatabaseBonusPostgre.getLastBonusId();
    }

    /**
     * Retrieve a specified bonus by it's ID
     *
     * @return A bonus object
     */
    public static Bonus getBonusById(int id) throws BonusNotFoundException {
        return DatabaseBonusPostgre.getBonusById(id);
    }

    /**
     * Retrieve a specified bonus by it's code
     *
     * @return A bonus object
     */
    public static Bonus getBonusByReferralCode(String referralCode) throws BonusNotFoundException {
        return DatabaseBonusPostgre.getBonusByReferralCode(referralCode);
    }

    /**
     * Add a new bonus
     *
     * @param bonus A bonus Object
     * @return State to indicate a bonus has been successfully added
     */
    public static boolean addBonus(Bonus bonus) throws ReferralCodeAlreadyExistsException {
        return DatabaseBonusPostgre.insertBonus(bonus);
    }

    /**
     * Activate a specified bonus by ID
     *
     * @param id A bonus ID
     * @return State to indicate a bonus has been activated successfully
     */
    public static boolean activateBonus(int id) throws BonusNotFoundException {
        return DatabaseBonusPostgre.activateBonus(id);
    }

    /**
     * Deactivate a specified bonus by ID
     *
     * @param id A bonus ID
     * @return State to indicate a bonus has been deactivated successfully
     */
    public static boolean deactivateBonus(int id) throws BonusNotFoundException {
        return DatabaseBonusPostgre.deactivateBonus(id);
    }

    /**
     * Remove existing bonus
     *
     * @param id A Bonus's ID
     * @return State to indicate a bonus has been successfully removed
     */
    public static boolean removeBonus(int id) throws BonusNotFoundException {
        return DatabaseBonusPostgre.deleteBonus(id);
    }
}