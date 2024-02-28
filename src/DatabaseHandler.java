import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class DatabaseHandler {
    // provide the name of the db in constructor and  all the operations will be performed in that DB
    private Connection databaseConnection;

    DatabaseHandler(String dataBaseName){
        try {
            Class.forName("org.sqlite.JDBC");
            this.databaseConnection = DriverManager.getConnection("jdbc:sqlite:"+dataBaseName+".db");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Table creation

    }

    public void runQuery(String query){
        try (Statement statement = databaseConnection.createStatement()) {
            statement.execute(query);
            //statement.execute("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY, name TEXT, age INTEGER)");
            System.out.println("query executed successfully");
        } catch (SQLException e) {
            System.err.println("Table creation error: " + e.getMessage());
        }

    }

    public Connection getDatabaseConnection() {
        return databaseConnection;
    }
}