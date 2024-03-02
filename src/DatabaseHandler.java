import java.sql.*;

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






//
//
//
//try {
//DatabaseHandler databaseHandler = new DatabaseHandler("bookStore");
//String sql = "INSERT INTO inventory (id, numberOfPages, title, genre, authorName, costPrice, sellingPrice, description) " +
//        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//                try (Connection conn = databaseHandler.getDatabaseConnection();
//PreparedStatement pstmt = conn.prepareStatement(sql)) {
//        pstmt.setString(1, id);
//                    pstmt.setString(2, numberOfPages);
//                    pstmt.setString(3, title);
//                    pstmt.setString(4, genre);
//                    pstmt.setString(5, author);
//                    pstmt.setString(6, costPrice);
//                    pstmt.setString(7, sellingPrice);
//                    pstmt.setString(8, bookDescription);
//
//                    pstmt.executeUpdate();
//                    System.out.println("Record inserted successfully.");
//                }
//                        } catch (SQLException e) {
//        e.printStackTrace();
//            }