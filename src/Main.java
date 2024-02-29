import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
/*ALTER TABLE your_table_name
MODIFY COLUMN id INT AUTO_INCREMENT,
AUTO_INCREMENT = (SELECT MAX(id) FROM your_table_name);
*/
public class Main {
    public static void main(String[] args) throws Exception  {

        File imageFile = new File("F:\\projects\\javaProject\\myCode-bookStoreMAnagementSystem\\src\\imnImg.png");
        FileInputStream fis = new FileInputStream(imageFile);
        byte[] imageData = new byte[(int) imageFile.length()];

//ss



       DatabaseHandler databaseHandler = new DatabaseHandler("bookStore");
        databaseHandler.runQuery("INSERT INTO users (id, numberOfPages , title , genre , authorName , costPrice ," +
                " sellingPrice , description , coverPageIcon) VALUES (1, 300 , 'book 1' , 'genre book 1' ," +
                " 'author book 1' , '304.30' , 320.10 , 'book 1 description' ,"+imageData+" )");

//        try( Statement stmt = databaseHandler.getDatabaseConnection().createStatement()) {
//
//            ResultSet rs =  stmt.executeQuery("SELECT * FROM inventory");
//
//            // Iterate through the result set
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                int age = rs.getInt("age");
//                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
//            }
//        } catch (SQLException e) { System.err.println("Error: " + e.getMessage());}
        System.out.println("End");


    }


}

