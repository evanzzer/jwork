package evanshebert.jwork.database.postgre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Connection Setting to PostgreSQL
 *
 * @author Evans Hebert
 * @version 03 June 2021
 */
public class DatabaseConnectionPostgre {

    /**
     * Connect to a specified PostgreSQL server
     * @return Connection to establish access to data
     */
    public static Connection connection() {
        Connection c = null;
        String db_host = "localhost";
        String db_port = "5432";
        String db_name = "jwork";
        String db_user = "postgres";
        String db_pass = "postgres";

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://" + db_host + ":" + db_port + "/" + db_name, db_user, db_pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return c;
    }
}
