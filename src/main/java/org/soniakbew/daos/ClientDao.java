package org.soniakbew.daos;

import org.soniakbew.models.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {
    private Client clientFromResultsSet(
            final ResultSet resultSet
    ) throws SQLException {
        return new Client(
                resultSet.getInt("clientId"),
                resultSet.getString("name")
        );
    }

    public List<Client> getAllClients() throws SQLException {
        List<Client> clients = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT clientId, name FROM `client`;"
            );

            while (resultSet.next()) {
                clients.add(clientFromResultsSet(resultSet));
            }
        }
        return clients;
    }

    public Client getClientById(final int clientId) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection()) {
            String query =
                    "SELECT clientId, name FROM `client` WHERE clientId = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, clientId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return clientFromResultsSet(resultSet);
            }
        }
        return null;
    }
}
