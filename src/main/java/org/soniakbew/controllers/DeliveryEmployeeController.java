package org.soniakbew.controllers;

import io.swagger.annotations.Api;
import org.soniakbew.exceptions.DoesNotExistException;
import org.soniakbew.services.DeliveryEmployeeService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Delivery Employee API")
@Path("/api/deliveryemployees")
public class DeliveryEmployeeController {
    private final DeliveryEmployeeService deliveryEmployeeService;
    public DeliveryEmployeeController(
            final DeliveryEmployeeService deliveryEmployeeService
    ) {
        this.deliveryEmployeeService = deliveryEmployeeService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDeliveryEmployees() {
        try {
            return Response.ok().entity(
                    deliveryEmployeeService.getAllDeliveryEmployees()
            ).build();
        } catch (SQLException e) {
            return Response.status(
                    Response.Status.INTERNAL_SERVER_ERROR
            ).build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrderById(final @PathParam("id") int id) {
        try {
            return Response.ok().entity(
                    deliveryEmployeeService.getDeliveryEmployeeById(id)
            ).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage()).build();
        } catch (DoesNotExistException e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(e.getMessage()).build();
        }

    }



}
