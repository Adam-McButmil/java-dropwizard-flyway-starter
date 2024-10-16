package org.soniakbew.controllers;

import io.swagger.annotations.Api;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

public class ProjectController {
    @Api("Test API")
    @Path("api/Product")


        ProductService productService;

        public OrderController(OrderService orderService) {this.orderService = orderService;}

        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public Response getOrders() {
            try {
                return Response.ok().entity(orderService.getAllOrders()).build();
            } catch (SQLException e) {
                return Response.serverError().build();
            }
        }

        @GET
        @Path("/{id}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response getOrdersById(@PathParam("id") int id)  {
            try {
                return Response.ok().entity(orderService.getOrderByID(id)).build();
            }
            catch (SQLException e){
                return Response.serverError().build();
            }
            catch (DoesNotExistException e) {
                return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
            }
        }
        @POST
        @Produces(MediaType.APPLICATION_JSON)
        public Response createOrder(OrderRequest orderRequest){
            try{
                return Response
                        .status(Response.Status.CREATED)
                        .entity(orderService.createOrder(orderRequest))
                        .build();
            }
            catch (FailedToCreateException | SQLException e){
                return Response.serverError().build();
            }
            catch (InvalidException e){
                return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
            }
        }

        @PUT
        @Path("/update/{id}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response updateOrder(
                @PathParam("id") int id, OrderRequest orderRequest){
            try {
                orderService.updateOrder(id,orderRequest);
                return Response.noContent().build();
            }catch (SQLException e){
                return Response.serverError().build();
            } catch(InvalidException e){
                return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
            }catch(DoesNotExistException e){
                return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
            }


        }

        @DELETE
        @Path("/{id}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response orderService ( @PathParam("id") int id){
            try {
                orderService.deleteOrder(id);
                return Response.noContent().build();
            } catch (SQLException e) {
                return Response.serverError().build();
            } catch(DoesNotExistException e){
                return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
            }
        }

}
