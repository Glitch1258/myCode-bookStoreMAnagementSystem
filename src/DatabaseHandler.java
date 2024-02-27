import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHandler {
    DatabaseHandler(){
        // Load SQLite JDBC driver
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.err.println("SQLite JDBC driver not found");
            e.printStackTrace();
            return;
        }

        // Connection and table creation
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db");
             Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY, name TEXT, age INTEGER)");
            System.out.println("Table created successfully");
        } catch (SQLException e) {
            System.err.println("Table creation error: " + e.getMessage());
        }

    }


}
