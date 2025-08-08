/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pahana_edu_service.resources;

/**
 *
 * @author Shay
 */


import cashier.customer.cashier_customer;
import cashier.customer.cashier_customeroperation;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import java.awt.PageAttributes.MediaType;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class cashiercustomerResource {

    // POST /api/customers
    @POST
    public Response addCustomer(cashier_customer customer) {
        boolean success = cashier_customeroperation.addCustomer(customer);
        if (success) {
            return Response.status(Response.Status.CREATED).entity(customer).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    // GET /api/customers
    @GET
    public Response getAllCustomers() {
        List<cashier_customer> list = cashier_customeroperation.getAllCustomers();
        return Response.ok(list).build();
    }

    // GET /api/customers/{accountNo}
    @GET
    @Path("/{accountNo}")
    public Response getCustomer(@PathParam("accountNo") int accountNo) {
        cashier_customer c = cashier_customeroperation.getCustomerByAccountNo(accountNo);
        if (c != null) {
            return Response.ok(c).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
