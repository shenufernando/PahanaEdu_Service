/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pahana_edu_service.resources;

/**
 *
 * @author Shay
 */



import admin.items.Item;
import admin.items.itemOperation; 
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/books")
public class ItemResource {

    itemOperation op = new itemOperation();

    // ✅ GET all items
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Item> getAllItems() {
        return op.getAllItems();
    }

    // ✅ GET item by code
    @GET
    @Path("/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Item getItemByCode(@PathParam("code") String code) {
        return op.getitemByCode(code);
    }

    // ✅ POST new item
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public String addItem(Item item) {
        return op.addItem(item) ? "Item added successfully." : "Failed to add item.";
    }

    // ✅ PUT update item
    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateItem(Item item) {
        return op.updateItem(item) ? "Item updated successfully." : "Failed to update item.";
    }

    // ✅ DELETE item
    @DELETE
    @Path("/delete/{code}")
    public String deleteItem(@PathParam("code") String code) {
        return op.deleteItem(code) ? "Item deleted successfully." : "Failed to delete item.";
    }
}



