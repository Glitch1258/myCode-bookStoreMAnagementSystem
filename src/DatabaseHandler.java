import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class DatabaseHandler {
    Connection databaseConnection;

    DatabaseHandler(String dataBaseName){
        try {
            Class.forName("org.sqlite.JDBC");
            this.databaseConnection = DriverManager.getConnection("jdbc:sqlite:"+dataBaseName+".db");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Table creation

    }

    public void createTable(String createTableQuery){
        try (Statement statement = databaseConnection.createStatement()) {
            statement.execute(createTableQuery);
            //statement.execute("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY, name TEXT, age INTEGER)");
            System.out.println("Table created successfully");
        } catch (SQLException e) {
            System.err.println("Table creation error: " + e.getMessage());
        }

    }
}