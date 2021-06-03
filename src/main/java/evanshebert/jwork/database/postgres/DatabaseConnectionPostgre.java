package evanshebert.jwork.database.postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionPostgre {

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
