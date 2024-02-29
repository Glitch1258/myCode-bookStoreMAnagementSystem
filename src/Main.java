import java.io.File;
import java.io.FileInputStream;
import java.sql.*;

public class Main {
    public static void main(String[] args)  {


        DatabaseHandler databaseHandler = new DatabaseHandler("bookStore");
        try( Statement stmt = databaseHandler.getDatabaseConnection().createStatement()) {

            ResultSet rs =  stmt.executeQuery("SELECT * FROM store");

            // Iterate through the result set
            while (rs.next()) {
//                int id = rs.getInt("id");
//                int numberOfPages = rs.getInt("numberOfPages");
//                String title = rs.getString("title");
//                String  authorName = rs.getString("authorName");
//                int costPrice = rs.getInt("costPrice");
//                int sellingPrice = rs.getInt("sellingPrice");
//                String  description = rs.getString("description");
//                System.out.println("ID: " + id + ",numberOfPages : " + numberOfPages + ", title : "+title+
//                        ", authorName : " +authorName+", costPrice : "+costPrice+", sellingPrice : "+sellingPrice+" , description"+description);
                System.out.println("moneySpent : "+rs.getInt("moneySpent")+
                        ", moneyMade  "+rs.getInt("moneyMade")+
                        ", net Income  "+rs.getInt("netIncome") );

            }
        } catch (SQLException e) { System.err.println("Error: " + e.getMessage());}



//

    }
}




































//File imageFile = new File("F:\\projects\\javaProject\\myCode-bookStoreMAnagementSystem\\src\\imnImg.png");
//        FileInputStream fis = new FileInputStream(imageFile);
//        byte[] imageData = new byte[(int) imageFile.length()];
//        fis.read(imageData);
//        fis.close();
//
//        DatabaseHandler databaseHandler = new DatabaseHandler("bookStore");
//        String sql = "INSERT INTO inventory (id, numberOfPages, title, genre, authorName, costPrice, sellingPrice, description, coverPageIcon) " +
//                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//        try (Connection databaseConnection = databaseHandler.getDatabaseConnection();
//             PreparedStatement preparedStatement = databaseConnection.prepareStatement(sql)) {
//            preparedStatement.setInt(1, 5); // Assuming 'id' is auto-incremented
//            preparedStatement.setInt(2, 433);
//            preparedStatement.setString(3, "book 5");
//            preparedStatement.setString(4, "genre book 5");
//            preparedStatement.setString(5, "author book 5");
//            preparedStatement.setDouble(6, 835.50);
//            preparedStatement.setDouble(7, 885.54);
//            preparedStatement.setString(8, "book 5 description");
//            preparedStatement.setBytes(9, imageData);
//
//            preparedStatement.executeUpdate();
//            System.out.println("Image inserted successfully .");
//        } catch (SQLException e) {
//            System.err.println("Error: " + e.getMessage());
//        }