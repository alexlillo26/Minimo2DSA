package edu.upc.dsa.services;

import edu.upc.dsa.*;
import edu.upc.dsa.models.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Api(value = "/inventories", description = "Endpoint to Inventory Service")
@Path("/inventories")
@Produces(MediaType.APPLICATION_JSON)
public class InventoryService extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(InventoryService.class);
        return classes;
    }

    private static final Logger logger = Logger.getLogger(InventoryService.class);
    private InventoryManager im;
    private UserManager us;

    public InventoryService() {
        this.im = InventoryManagerImpl.getInstance();
        this.us = UserManagerImpl.getInstance();
    }

    @PUT
    @Path("/{userId}/inventory/items/{itemId}/{quantity}")
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "add an Item to User's Inventory", notes = "Add an item to a user's inventory")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 404, message = "Item not found")
    })
    public Response addItemToUserInventory(@PathParam("userId") String userId, @PathParam("itemId") String itemId, @PathParam("quantity") int quantity) {

        User user = this.us.getUser(userId);
        if (user == null) {
            return Response.status(404).entity("User not found").build();
        }
        Inventory inventory = this.im.getInventory(user.getId());
        if (inventory != null) {
            Item item = StoreManagerImpl.getInstance().getItembyId(itemId);
            if (item != null) {
                boolean itemExists = false;
                for (InventoryItem inventoryItem : inventory.getInventoryitems()) {
                    if (inventoryItem.getItem().getId().equals(itemId)) {
                        int newQuantity = inventoryItem.getQuantity() + quantity;
                        inventoryItem.setQuantity(newQuantity);
                        itemExists = true;
                        break;
                    }
                }
                if (!itemExists) {
                    InventoryItem newInventoryItem = new InventoryItem(item, quantity);
                    inventory.addIvenventoryItem(newInventoryItem);
                }
                logger.info("Item added to inventory " + user.getId());
                GenericEntity<List<InventoryItem>> entity = new GenericEntity<List<InventoryItem>>(inventory.getInventoryitems()) {};
                return Response.status(201).build();
            } else {
                logger.warn("Item not found " + itemId);
                return Response.status(404).entity("Item not found").build();
            }
        } else {
            logger.warn("Inventory not found " + user.getId());
            return Response.status(404).entity("Inventory not found").build();
        }
    }
    @GET
    @Path("/{userId}/inventory/items")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "get all Items of User's Inventory", notes = "Retrieve all items of a user's inventory")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = InventoryItem.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "User not found")
    })
    public Response getAllItemsOfUserInventory(@PathParam("userId") String userId) {
        User user = this.us.getUser(userId);
        if (user == null) {
            return Response.status(404).entity("User not found").build();
        }
        Inventory inventory = this.im.getInventory(userId);
        if (inventory == null) {
            return Response.status(404).entity("{\"message\": \"Inventory not found\"}").build();
        }
        List<InventoryItem> items= inventory.getInventoryitems();
        GenericEntity<List<InventoryItem>> entity = new GenericEntity<List<InventoryItem>>(items) {};
        return Response.status(200).entity(entity).build();


    }
}