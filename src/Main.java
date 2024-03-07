import java.sql.*;

public class Main {
    public static void main(String[] args) {
        DatabaseHandler databaseHandler = new DatabaseHandler("bookStore");

        String tableName = "store"; // Specify the name of the table you want to inspect
        //DatabaseHandler databaseHandler = new DatabaseHandler("bookStore");

        try (Connection connection = databaseHandler.getDatabaseConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("PRAGMA table_info(" + tableName + ")");

            // Iterate over the result set to retrieve column names
            while (resultSet.next()) {
                String columnName = resultSet.getString("name");
                System.out.println("Column Name: " + columnName);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }









//==========================================================

    }
}
//
//        try (Connection conn = databaseHandler.getDatabaseConnection();
//             Statement stmt = conn.createStatement()) {
//
//            ResultSet rs = stmt.executeQuery("SELECT * FROM inventory");
//
//            while (rs.next()) {
//                String id = rs.getString("id");
//                int numberOfPages = rs.getInt("numberOfPages");
//                String title = rs.getString("title");
//                String authorName = rs.getString("authorName");
//                int costPrice = rs.getInt("costPrice");
//                int sellingPrice = rs.getInt("sellingPrice");
//                String description = rs.getString("description");
//                String genre = rs.getString("genre");
//
//                // Reading BLOB data from the coverPageIcon column
//                byte[] coverPageIconBytes = rs.getBytes("coverPageIcon");
//
//                System.out.println("ID: " + id + ", NumberOfPages: " + numberOfPages +
//                        ", Title: " + title + ", AuthorName: " + authorName +
//                        ", CostPrice: " + costPrice + ", SellingPrice: " + sellingPrice +
//                        ", Description: " + description + ", CoverPageIcon size: " + coverPageIconBytes.length+" genre"+genre);
//            }
//
//        } catch (SQLException e) {
//            System.err.println("Error: " + e.getMessage());
//        }




//
//databaseHandler.runQuery("CREATE TABLE IF NOT EXISTS admins (" +
//                                 "name TEXT NOT NULL," +
//                                 "password TEXT NOT NULL" +
//                                 ")");



//
//
//
//String tableName = "admins"; // Specify the name of the table you want to inspect
//DatabaseHandler databaseHandler = new DatabaseHandler("bookStore");
//
//        try (Connection connection = databaseHandler.getDatabaseConnection();
//Statement statement = connection.createStatement()) {
//
//ResultSet resultSet = statement.executeQuery("PRAGMA table_info(" + tableName + ")");
//
//// Iterate over the result set to retrieve column names
//            while (resultSet.next()) {
//String columnName = resultSet.getString("name");
//                System.out.println("Column Name: " + columnName);
//            }
//                    } catch (SQLException e) {
//        System.err.println("Error: " + e.getMessage());
//        }