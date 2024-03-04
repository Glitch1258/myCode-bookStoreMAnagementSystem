import java.sql.*;

public class Main {
    public static void main(String[] args) {
        DatabaseHandler databaseHandler = new DatabaseHandler("bookStore");

        Connection connection = databaseHandler.getDatabaseConnection();
        String query = "INSERT INTO admins (userName,password) values (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "sakib2");
            preparedStatement.setString(2, "123456");
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }



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