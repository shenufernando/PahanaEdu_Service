/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pahana_edu_service.resources;

/**
 *
 * @author Shay
 */



import admin.user.user;
import admin.user.userOperation;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
public class userResource {

    userOperation operation = new userOperation();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<user> getAllUsers() {
        return operation.getAllUsers();
    }

    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public user getUserById(@PathParam("userId") int userId) {
        return operation.getUserById(userId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean addUser(user user) {
        return operation.addUser(user);
    }

    @PUT
    @Path("/{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean updateUser(@PathParam("userId") int userId, user updatedUser) {
        return operation.updateUser(userId, updatedUser.getFullname(), updatedUser.getEmail());
    }

    @DELETE
    @Path("/{userId}")
    public boolean deleteUser(@PathParam("userId") int userId) {
        return operation.deleteUser(userId);
    }
}

