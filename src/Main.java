import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        DatabaseHandler databaseHandler = new  DatabaseHandler("test");
        System.out.println("Hello world!");

    }
}
