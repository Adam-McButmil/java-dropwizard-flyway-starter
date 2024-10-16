package org.soniakbew.daos;
import org.soniakbew.models.DeliveryEmployee;
import org.soniakbew.models.DeliveryEmployeeRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeliveryEmployeeDao {

    public List<DeliveryEmployee> getAllDeliveryEmployees()
            throws SQLException {
        List<DeliveryEmployee> deliveryEmployees = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
"SELECT deliveryEmployeeId, `name`, salary, bankAccountNumber, "
+ "nationalInsuranceNumber FROM deliveryEmployee;"
            );

            while (resultSet.next()) {
                DeliveryEmployee deliveryEmployee = new DeliveryEmployee(
                        resultSet.getInt("deliveryEmployeeID"),
                        resultSet.getString("name"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("bankAccountNumber"),
                        resultSet.getString("nationalInsuranceNumber")
                );

                deliveryEmployees.add(deliveryEmployee);
            }

        }

        return deliveryEmployees;
    }

    public DeliveryEmployee getDeliveryEmployeeById(final int id)
            throws SQLException {

        try (Connection connection = DatabaseConnector.getConnection()) {

            String query = "SELECT deliveryEmployeeId, `name`,"
                    + "salary, bankAccountNumber, "
                    + "nationalInsuranceNumber FROM deliveryEmployee WHERE deliveryEmployeeId=?;";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                DeliveryEmployee deliveryEmployee = new DeliveryEmployee(
                        resultSet.getInt("deliveryEmployeeID"),
                        resultSet.getString("name"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("bankAccountNumber"),
                        resultSet.getString("nationalInsuranceNumber")
                );

                return deliveryEmployee;
            }

        }

        return null;
    }

    public int createDeliveryEmployee(
            final DeliveryEmployeeRequest deliveryEmployee
    ) throws SQLException {
        Connection conn = DatabaseConnector.getConnection();

        String insertStatement = "INSERT INTO deliveryEmployee "
+ "(`name`, salary, bankAccountNumber, "
+ "nationalInsuranceNumber) VALUES (?,?,?,?);";

        PreparedStatement pst = conn.prepareStatement(
                insertStatement, Statement.RETURN_GENERATED_KEYS
        );

        final int nameIndex = 1;
        final int salaryIndex = 2;
        final int bankAccountNumberIndex = 3;
        final int nationalInsuranceNumberIndex = 4;

        pst.setString(nameIndex, deliveryEmployee.getName());
        pst.setDouble(salaryIndex, deliveryEmployee.getSalary());
        pst.setString(
                bankAccountNumberIndex, deliveryEmployee.getBankAccountNumber()
        );
        pst.setString(nationalInsuranceNumberIndex,
deliveryEmployee.getNationalInsuranceNumber()
        );

        pst.executeUpdate();

        ResultSet res = pst.getGeneratedKeys();

        if (res.next()) {
            return res.getInt(1);
        }

        return -1;
    }

    public void updateDeliveryEmployee(
            final int id, final DeliveryEmployeeRequest deliveryEmployee
    ) throws SQLException {
        Connection conn = DatabaseConnector.getConnection();

        String statement = "UPDATE deliveryEmployee SET "
    + "`name`=?, salary=?, bankAccountNumber=?,"
    + " nationalInsuranceNumber=? WHERE deliveryEmployeeId = ?;";
        PreparedStatement pst = conn.prepareStatement(statement);

        final int nameIndex = 1;
        final int salaryIndex = 2;
        final int bankAccountNumberIndex = 3;
        final int nationalInsuranceNumberIndex = 4;
        final int lastInt = 5;
        pst.setString(nameIndex, deliveryEmployee.getName());
        pst.setDouble(salaryIndex, deliveryEmployee.getSalary());
        pst.setString(
                bankAccountNumberIndex, deliveryEmployee.getBankAccountNumber()
        );
        pst.setString(
                nationalInsuranceNumberIndex,
                deliveryEmployee.getNationalInsuranceNumber()
        );
        pst.setInt(lastInt, id);

        pst.executeUpdate();
    }

    public void deleteDeliveryEmployee(final int id) throws SQLException {
        Connection conn = DatabaseConnector.getConnection();
        String statement = "DELETE FROM deliveryEmployee "
                + "WHERE deliveryEmployeeId = ?;";
        PreparedStatement pst = conn.prepareStatement(statement);
        pst.setInt(1, id);
        pst.executeUpdate();
    }
}


