package org.soniakbew.controllers;

import io.swagger.annotations.Api;
import org.soniakbew.services.ClientService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Client API")
@Path("/api/clients")
public class ClientController {
    private final ClientService clientService;
    public ClientController(final ClientService clientService) {
        this.clientService = clientService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClients() {
        try {
            return Response.ok().entity(clientService.getAllClients()).build();
        } catch (SQLException e) {
            return Response.status(
                    Response.Status.INTERNAL_SERVER_ERROR
            ).build();
        }
    }
}
