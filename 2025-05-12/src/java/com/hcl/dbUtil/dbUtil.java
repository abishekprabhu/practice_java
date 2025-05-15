package java.com.hcl.dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbUtil {

    private static final String DRIVER_CLASS = "org.postgresql.Driver";

    private static final String DB_URL = "jdbc:postgresql://localhost/postgres";

    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    public static Connection getConn() throws ClassNotFoundException, SQLException {

        Class.forName(DRIVER_CLASS);

        Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        return con;
    }
}
