package org.soniakbew.validators;
import org.soniakbew.daos.ClientDao;
import org.soniakbew.exceptions.Entity;
import org.soniakbew.exceptions.InvalidException;
import org.soniakbew.models.Client;
import org.soniakbew.models.ClientRequest;
import java.sql.SQLException;
import java.util.List;

public class ClientValidator {
    ClientDao clientDao = new ClientDao();

    public void validateClient(final ClientRequest clientRequest)
            throws InvalidException, SQLException {
        if (!checkClientIdExists(clientRequest.getClientId())) {
            throw new InvalidException(Entity.CLIENT);
        }
    }

    public boolean checkClientIdExists(final int clientId)
            throws SQLException {
        List<Client> clientList = clientDao.getAllClients();
        for (Client c : clientList) {
            if (c.getClientId() == clientId) {
                return true;
            }
        }
        return false;
    }
}
