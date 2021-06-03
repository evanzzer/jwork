package evanshebert.jwork.database.postgres;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import evanshebert.jwork.exceptions.EmailAlreadyExistsException;
import evanshebert.jwork.exceptions.JobseekerNotFoundException;
import evanshebert.jwork.objects.Jobseeker;

public class DatabaseJobseekerPostgre {
    /**
     * Retrieve a list of jobseeker
     *
     * @return A list of jobseeker
     */
    public static ArrayList<Jobseeker> getDatabaseJobseeker() {
        ArrayList<Jobseeker> list = new ArrayList<>();
        try {
            ResultSet rs = DatabaseConnectionPostgre.connection()
                    .createStatement()
                    .executeQuery("SELECT * FROM jobseeker");

            while (rs.next()) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(rs.getDate(5));
                Jobseeker jobseeker = new Jobseeker(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        calendar
                );
                list.add(jobseeker);
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
    public static int getLastJobseekerId() {
        int id = 0;
        try {
            ResultSet rs = DatabaseConnectionPostgre.connection()
                    .createStatement()
                    .executeQuery("SELECT MAX(id) FROM jobseeker");

            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    /**
     * Retrieve a specified jobseeker that can be found by ID
     *
     * @return A jobseeker object
     */
    public static Jobseeker getJobseekerById(int id) throws JobseekerNotFoundException {
        try {
            ResultSet rs = DatabaseConnectionPostgre.connection()
                    .createStatement()
                    .executeQuery("SELECT * FROM jobseeker WHERE id = " + id);

            if (rs.next()) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(rs.getDate(5));
                return new Jobseeker(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        calendar
                );
            } else throw new JobseekerNotFoundException(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Retrieve a login with a specified email and password
     *
     * @param email    Jobseeker's email
     * @param password Jobseeker's password
     * @return Jobseeker if exist, else null
     */
    public static Jobseeker jobseekerLogin(String email, String password) {
        Jobseeker jobseeker = null;
        try {
            ResultSet rs = DatabaseConnectionPostgre.connection()
                    .createStatement()
                    .executeQuery("SELECT * FROM jobseeker WHERE email = '" + email + "' AND password = '" + password + "'");

            if (rs.next()) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(rs.getDate(5));
                jobseeker = new Jobseeker(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        calendar
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return jobseeker;
    }

    /**
     * Add a new jobseeker
     *
     * @param jobseeker A jobseeker Object
     * @return State to indicate a jobseeker has been successfully added
     */
    public static boolean insertJobseeker(Jobseeker jobseeker) throws EmailAlreadyExistsException {
        try {
            Connection c = DatabaseConnectionPostgre.connection();
            ResultSet rs = c.createStatement().executeQuery("SELECT * FROM jobseeker");

            while (rs.next()) {
                if (rs.getString("email").equals(jobseeker.getEmail()))
                    throw new EmailAlreadyExistsException(jobseeker);
            }

            Date date = jobseeker.getJoinDate().getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            c.createStatement().executeUpdate("INSERT INTO jobseeker VALUES(" +
                    jobseeker.getId() + ", '" + jobseeker.getName() + "', '" +
                    jobseeker.getEmail() + "', '" + jobseeker.getPassword() + "', '" +
                    dateFormat.format(date) + "')");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * Remove existing jobseeker
     *
     * @param id A jobseeker's ID
     * @return State to indicate a jobseeker has been successfully removed
     */
    public static boolean deleteJobseeker(int id) throws JobseekerNotFoundException {
        Jobseeker jobseeker = getJobseekerById(id);
        if (jobseeker != null) {
            try {
                DatabaseConnectionPostgre.connection()
                        .createStatement()
                        .executeUpdate("DELETE FROM jobseeker WHERE id = " + id);
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } else throw new JobseekerNotFoundException(id);
    }
}
