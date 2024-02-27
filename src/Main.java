import java.sql.*;

public class Main {
    public static void main(String[] args) {
        DatabaseHandler databaseHandler = new DatabaseHandler("test");
        //databaseHandler.executeQuery("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY, name TEXT, age INTEGER)");
        //databaseHandler.executeQuery("SELECT * FROM users");
        //databaseHandler.executeQuery("INSERT INTO users (name, age) VALUES ('Alice', 30)");
        //databaseHandler.executeQuery("INSERT INTO users (name, age) VALUES ('Mac', 20)");
        //databaseHandler.executeQuery("INSERT INTO users (name, age) VALUES ('John doe', 35)");
        //databaseHandler.executeQuery("INSERT INTO users (name, age) VALUES ('Mac Miller', 24)");
        try( Statement stmt = databaseHandler.getDatabaseConnection().createStatement()) {

            ResultSet rs =  stmt.executeQuery("SELECT * FROM users");

            // Iterate through the result set
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }
        } catch (SQLException e) { System.err.println("Error: " + e.getMessage());}
        System.out.println("End");

    }




}

