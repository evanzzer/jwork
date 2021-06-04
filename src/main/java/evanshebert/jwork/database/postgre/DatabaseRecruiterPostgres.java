package evanshebert.jwork.database.postgre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import evanshebert.jwork.exceptions.RecruiterNotFoundException;
import evanshebert.jwork.objects.Location;
import evanshebert.jwork.objects.Recruiter;

public class DatabaseRecruiterPostgres {
    /**
     * Retrieve a list of recruiter objects
     *
     * @return A list of recruiter objects
     */
    public static ArrayList<Recruiter> getRecruiterDatabase() {
        ArrayList<Recruiter> list = new ArrayList<>();
        try {
            ResultSet rs = DatabaseConnectionPostgre.connection()
                    .createStatement()
                    .executeQuery("SELECT * FROM recruiter");

            while (rs.next()) {
                Recruiter recruiter = new Recruiter(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        new Location(
                                rs.getString(5),
                                rs.getString(6),
                                rs.getString(7)
                        )
                );
                list.add(recruiter);
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
    public static int getLastRecruiterId() {
        int id = 0;
        try {
            ResultSet rs = DatabaseConnectionPostgre.connection()
                    .createStatement()
                    .executeQuery("SELECT MAX(id) FROM recruiter");

            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    /**
     * Retrieve a specified recruiter that can be found by ID
     *
     * @return A recruiter object
     */
    public static Recruiter getRecruiterById(int id) throws RecruiterNotFoundException {
        try {
            ResultSet rs = DatabaseConnectionPostgre.connection()
                    .createStatement()
                    .executeQuery("SELECT * FROM recruiter WHERE id = " + id);

            if (rs.next()) {
                return new Recruiter(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        new Location(
                                rs.getString(5),
                                rs.getString(6),
                                rs.getString(7)
                        )
                );
            } else throw new RecruiterNotFoundException(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Add a new recruiter
     *
     * @param recruiter A recruiter Object
     * @return State to indicate a recruiter has been successfully added
     */
    public static boolean insertRecruiter(Recruiter recruiter) {
        try {
            DatabaseConnectionPostgre.connection()
                    .createStatement()
                    .executeUpdate("INSERT INTO recruiter VALUES(" +
                            recruiter.getId() + ", '" + recruiter.getName() + "', '" +
                            recruiter.getEmail() + "', '" + recruiter.getPhoneNumber() + "', '" +
                            recruiter.getLocation().getProvince() + "', '" +
                            recruiter.getLocation().getCity() +"', '" +
                            recruiter.getLocation().getDescription() + "')"
                    );
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * Remove existing recruiter by ID
     *
     * @param id A recruiter's ID
     * @return State to indicate a recruiter has been successfully removed
     */
    public static boolean deleteRecruiter(int id) throws RecruiterNotFoundException {
        Recruiter recruiter = getRecruiterById(id);
        if (recruiter != null) {
            try {
                DatabaseConnectionPostgre.connection()
                        .createStatement()
                        .executeUpdate("DELETE FROM recruiter WHERE id = " + id);
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } else throw new RecruiterNotFoundException(id);
    }
}