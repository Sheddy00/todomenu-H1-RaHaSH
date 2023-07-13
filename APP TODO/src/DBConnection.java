import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Remplacez les valeurs par celles de votre base de données
                String url = "jdbc:postgresql://localhost:5432/todoapp";
                String username = "postgres";
                String password = "harizo123";
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

}
