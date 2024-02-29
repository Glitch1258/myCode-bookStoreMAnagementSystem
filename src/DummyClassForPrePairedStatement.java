import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DummyClassForPrePairedStatement {
    DummyClassForPrePairedStatement(){}
    String query = "INSERT INTO store (moneySpent, moneyMade , netIncome) VALUES (?,?,?)";
        try (
    Connection databaseConnection = databaseHandler.getDatabaseConnection();
    PreparedStatement preparedStatement = databaseConnection.prepareStatement(query)) {
        preparedStatement.setDouble(1,netIncome);
        preparedStatement.setDouble(2,moneyMade);
        preparedStatement.setDouble(2,moneySpent);
        preparedStatement.executeUpdate();
        System.out.println("Image inserted successfully .");
    } catch (
    SQLException e) {
        System.err.println("Error: " + e.getMessage());
    }
}
