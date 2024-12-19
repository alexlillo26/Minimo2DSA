package edu.upc.dsa.services;

import edu.upc.dsa.models.Message;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Api(value = "/posts", description = "Endpoint to Message Service")
@Path("/posts")
public class MessageService {

    @GET
    @ApiOperation(value = "Get all messages")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Message.class, responseContainer="List"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessages() {
        try {
            List<Message> messages = new ArrayList<>();
            messages.add(new Message("Nuevos elementos disponibles en la tienda"));
            messages.add(new Message("Competición por equipos. El proceso de inscripción consistirá en ..."));

            GenericEntity<List<Message>> entity = new GenericEntity<List<Message>>(messages) {};
            return Response.status(200).entity(entity).build();
        } catch (IllegalArgumentException e) {
            return Response.status(400).entity("Bad Request: " + e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(500).entity("Internal Server Error: " + e.getMessage()).build();
        }
    }
}