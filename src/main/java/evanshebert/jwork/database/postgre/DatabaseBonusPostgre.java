package evanshebert.jwork.database.postgre;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import evanshebert.jwork.exceptions.BonusNotFoundException;
import evanshebert.jwork.exceptions.ReferralCodeAlreadyExistsException;
import evanshebert.jwork.objects.Bonus;

public class DatabaseBonusPostgre {
    /**
     * Retrieve a list of bonus currently available
     *
     * @return A list of bonus
     */
    public static ArrayList<Bonus> getBonusDatabase() {
        ArrayList<Bonus> list = new ArrayList<>();
        try {
            ResultSet rs = DatabaseConnectionPostgre.connection()
                    .createStatement()
                    .executeQuery("SELECT * FROM bonus");

            while (rs.next()) {
                Bonus bonus = new Bonus(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getBoolean(5)
                );
                list.add(bonus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    /**
     * Retrieve the last ID of the database
     *
     * @return Last ID in Integer
     */
    public static int getLastBonusId() {
        int id = 0;
        try {
            ResultSet rs = DatabaseConnectionPostgre.connection()
                    .createStatement()
                    .executeQuery("SELECT MAX(id) FROM bonus");

            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    /**
     * Retrieve a specified bonus by it's ID
     *
     * @return A bonus object
     */
    public static Bonus getBonusById(int id) throws BonusNotFoundException {
        try {
            ResultSet rs = DatabaseConnectionPostgre.connection()
                    .createStatement()
                    .executeQuery("SELECT * FROM bonus WHERE id = " + id);

            if (rs.next()) {
                return new Bonus(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getBoolean(5)
                );
            } else throw new BonusNotFoundException(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Retrieve a specified bonus by it's code
     *
     * @return A bonus object
     */
    public static Bonus getBonusByReferralCode(String referralCode) throws BonusNotFoundException {
        try {
            ResultSet rs = DatabaseConnectionPostgre.connection()
                    .createStatement()
                    .executeQuery("SELECT * FROM bonus WHERE referralcode = '" + referralCode + "'");

            if (rs.next()) {
                return new Bonus(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getBoolean(5)
                );
            } else throw new BonusNotFoundException(referralCode);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Add a new bonus
     *
     * @param bonus A bonus Object
     * @return State to indicate a bonus has been successfully added
     */
    public static boolean insertBonus(Bonus bonus) throws ReferralCodeAlreadyExistsException {
        try {
            Connection c = DatabaseConnectionPostgre.connection();
            ResultSet rs = c.createStatement().executeQuery("SELECT * FROM bonus WHERE referralcode = '" + bonus.getReferralCode() + "'");

            if (rs.next()) throw new ReferralCodeAlreadyExistsException(bonus);

            c.createStatement().executeUpdate("INSERT INTO bonus VALUES(" +
                    bonus.getId() + ", '" + bonus.getReferralCode() + "', " +
                    bonus.getExtraFee() + ", " + bonus.getMinTotalFee() + ", " +
                    bonus.getActive() + ")");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * Activate a specified bonus by ID
     *
     * @param id A bonus ID
     * @return State to indicate a bonus has been activated successfully
     */
    public static boolean activateBonus(int id) throws BonusNotFoundException {
        Bonus bonus = getBonusById(id);
        if (bonus != null) {
            try {
                DatabaseConnectionPostgre.connection()
                        .createStatement()
                        .executeUpdate("UPDATE bonus SET active = true WHERE id = " + id);
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } else throw new BonusNotFoundException(id);

    }

    /**
     * Deactivate a specified bonus by ID
     *
     * @param id A bonus ID
     * @return State to indicate a bonus has been deactivated successfully
     */
    public static boolean deactivateBonus(int id) throws BonusNotFoundException {
        Bonus bonus = getBonusById(id);
        if (bonus != null) {
            try {
                DatabaseConnectionPostgre.connection()
                        .createStatement()
                        .executeUpdate("UPDATE bonus SET active = false WHERE id = " + id);
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } else throw new BonusNotFoundException(id);
    }

    /**
     * Remove existing bonus
     *
     * @param id A Bonus's ID
     * @return State to indicate a bonus has been successfully removed
     */
    public static boolean deleteBonus(int id) throws BonusNotFoundException {
        Bonus bonus = getBonusById(id);
        if (bonus != null) {
            try {
                DatabaseConnectionPostgre.connection()
                        .createStatement()
                        .executeUpdate("DELETE FROM bonus WHERE id = " + id);
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } else throw new BonusNotFoundException(id);
    }
}
