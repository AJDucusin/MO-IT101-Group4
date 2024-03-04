package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection connect() {
        Connection connection = null;
        try {
            String url = "jdbc:postgresql://localhost:5432/motorPHDB";
            String username = "postgres";
            String password = "admin";
            
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("   ");
            
        } catch (SQLException e) {
            System.out.println("Error connection to the PostgreSQL database.");
            e.printStackTrace();
        }
        return connection;
    }
}
