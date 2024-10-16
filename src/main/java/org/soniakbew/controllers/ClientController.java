package org.soniakbew.controllers;

import org.soniakbew.services.ClientService;

public class ClientController {
    private final ClientService clientService;
    public ClientController(final ClientService clientService) {
        this.clientService = clientService;
    }
}
