import java.sql.*;

public class Main {
    public static void main(String[] args) {
        DatabaseHandler databaseHandler = new DatabaseHandler("bookStore");

        try (Connection conn = databaseHandler.getDatabaseConnection();
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM inventory");

            while (rs.next()) {
                int id = rs.getInt("id");
                int numberOfPages = rs.getInt("numberOfPages");
                String title = rs.getString("title");
                String authorName = rs.getString("authorName");
                int costPrice = rs.getInt("costPrice");
                int sellingPrice = rs.getInt("sellingPrice");
                String description = rs.getString("description");

                // Reading BLOB data from the coverPageIcon column
                byte[] coverPageIconBytes = rs.getBytes("coverPageIcon");

                System.out.println("ID: " + id + ", NumberOfPages: " + numberOfPages +
                        ", Title: " + title + ", AuthorName: " + authorName +
                        ", CostPrice: " + costPrice + ", SellingPrice: " + sellingPrice +
                        ", Description: " + description + ", CoverPageIcon size: " + coverPageIconBytes.length);
            }

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
