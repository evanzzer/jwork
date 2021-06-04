package evanshebert.jwork.database.postgre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import evanshebert.jwork.enums.JobCategory;
import evanshebert.jwork.exceptions.JobNotFoundException;
import evanshebert.jwork.objects.Job;
import evanshebert.jwork.objects.Location;
import evanshebert.jwork.objects.Recruiter;

public class DatabaseJobPostgre {
    /**
     * Retrieve a list of job objects
     *
     * @return A list of job objects
     */
    public static ArrayList<Job> getJobDatabase() {
        // Get listRecruiter
        return getData("");
    }

    /**
     * Retrieve the last ID of the database
     *
     * @return Last ID in Integer
     */
    public static int getLastJobId() {
        int id = 0;
        try {
            ResultSet rs = DatabaseConnectionPostgre.connection()
                    .createStatement()
                    .executeQuery("SELECT MAX(id) FROM job");

            if (rs.next()) id = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    /**
     * Retrieve a specified job that can be found by ID
     *
     * @return A job object
     */
    public static Job getJobById(int id) throws JobNotFoundException {
        try {
            ResultSet rs = DatabaseConnectionPostgre.connection()
                    .createStatement()
                    .executeQuery("SELECT j.id, j.name, j.recruiter_id, r.name, r.email, " +
                            "r.phoneNumber, r.province, r.city, r.description, j.fee, j.category " +
                                    "FROM job j INNER JOIN recruiter r ON j.recruiter_id = r.id WHERE j.id = " + id);

            if (rs.next()) {
                return new Job(
                        rs.getInt(1),
                        rs.getString(2),
                        new Recruiter(
                                rs.getInt(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getString(6),
                                new Location(
                                        rs.getString(7),
                                        rs.getString(8),
                                        rs.getString(9)
                                )
                        ),
                        rs.getInt(10),
                        JobCategory.valueOf(rs.getString(11))
                );
            } else throw new JobNotFoundException(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e) {
            System.out.println("Category provided in the database does not exist in this app!");
            return null;
        }
    }

    /**
     * Retrieve a specific job that can be found by Recruiter's ID
     *
     * @return a job array
     */
    public static ArrayList<Job> getJobByRecruiter(int recruiterId) {
        return getData("WHERE j.recruiter_id = " + recruiterId);
    }

    /**
     * Retrieve a specific job that can be found by job category
     *
     * @return a job array
     */
    public static ArrayList<Job> getJobByCategory(JobCategory category) {
        return getData("WHERE j.category = '" + category.toString() + "'");
    }

    /**
     * Add a new job
     *
     * @param job A job Object
     * @return State to indicate a job has been successfully added
     */
    public static boolean insertJob(Job job) {
        try {
            DatabaseConnectionPostgre.connection()
                    .createStatement()
                    .executeUpdate("INSERT INTO job VALUES (" + job.getId() +
                            ", '" + job.getName() + "', " + job.getRecruiter().getId() + ", " +
                            job.getFee() + ", '" + job.getCategory().toString() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Remove existing job
     *
     * @param id A job's ID
     * @return State to indicate a job has been successfully removed
     */
    public static boolean deleteJob(int id) throws JobNotFoundException {
        Job job = getJobById(id);
        if (job != null) {
            try {
                DatabaseConnectionPostgre.connection()
                        .createStatement()
                        .executeUpdate("DELETE FROM job WHERE id = " + id);
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } else throw new JobNotFoundException(id);
    }

    private static ArrayList<Job> getData(String query) {
        ArrayList<Job> list = new ArrayList<>();
        try {
            ResultSet rs = DatabaseConnectionPostgre.connection()
                    .createStatement()
                    .executeQuery("SELECT j.id, j.name, j.recruiter_id, r.name, r.email, " +
                            "r.phoneNumber, r.province, r.city, r.description, j.fee, j.category " +
                            "FROM job j INNER JOIN recruiter r ON j.recruiter_id = r.id " + query);

            while (rs.next()) {
                Job job = new Job(
                        rs.getInt(1),
                        rs.getString(2),
                        new Recruiter(
                                rs.getInt(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getString(6),
                                new Location(
                                        rs.getString(7),
                                        rs.getString(8),
                                        rs.getString(9)
                                )
                        ),
                        rs.getInt(10),
                        JobCategory.valueOf(rs.getString(11))
                );
                list.add(job);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e) {
            System.out.println("Category provided in the database does not exist in this app!");
            return null;
        }
        return list;
    }
}
