package java.org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    // JDBC URL, username, and password of PostgreSQL server
    private final String url = "jdbc:postgresql://localhost/postgres";
    private final String user = "postgres";
    private final String password = "postgres";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connect() {
        Connection conn = null;
        try {
            // Connect to PostgreSQL database
            conn = DriverManager.getConnection(url, user, password);

            // Check if connection was successful
            if (conn != null) {
                System.out.println("Connected to the PostgreSQL server successfully.");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public static void main(String[] args) {
        Main app = new Main();
        // Connect to the PostgreSQL database
        app.connect();
    }
}