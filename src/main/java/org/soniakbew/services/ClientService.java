package org.soniakbew.services;

import org.soniakbew.daos.ClientDao;
import org.soniakbew.models.Client;

import java.sql.SQLException;
import java.util.List;

public class ClientService {
    private final ClientDao clientDao;
    public ClientService(final ClientDao clientDao) {
        this.clientDao = clientDao;
    }
    public List<Client> getAllClients() throws SQLException {
        return clientDao.getAllClients();
    }
    public Client getClientById(final int id) throws SQLException {
        return clientDao.getClientById(id);
    }
}
