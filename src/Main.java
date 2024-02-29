import java.io.File;
import java.io.FileInputStream;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {
        File imageFile = new File("F:\\projects\\javaProject\\myCode-bookStoreMAnagementSystem\\src\\imnImg.png");
        FileInputStream fis = new FileInputStream(imageFile);
        byte[] imageData = new byte[(int) imageFile.length()];
        fis.read(imageData);
        fis.close();

        DatabaseHandler databaseHandler = new DatabaseHandler("bookStore");
        String sql = "INSERT INTO users (id, numberOfPages, title, genre, authorName, costPrice, sellingPrice, description, coverPageIcon) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection databaseConnection = databaseHandler.getDatabaseConnection();
             PreparedStatement preparedStatement = databaseConnection.prepareStatement(sql)) {
            preparedStatement.setInt(1, 1); // Assuming 'id' is auto-incremented
            preparedStatement.setInt(2, 300);
            preparedStatement.setString(3, "book 1");
            preparedStatement.setString(4, "genre book 1");
            preparedStatement.setString(5, "author book 1");
            preparedStatement.setDouble(6, 304.30);
            preparedStatement.setDouble(7, 320.10);
            preparedStatement.setString(8, "book 1 description");
            preparedStatement.setBytes(9, imageData);

            preparedStatement.executeUpdate();
            System.out.println("Image inserted successfully.");
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
