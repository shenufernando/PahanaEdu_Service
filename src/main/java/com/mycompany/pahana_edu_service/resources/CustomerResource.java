/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pahana_edu_service.resources;




import admin.customer.Customer;
import admin.customer.CustomerOperation;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/customers")
public class CustomerResource {

    CustomerOperation operation = new CustomerOperation();

    // Get all customers
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getAllCustomers() {
        return operation.getAllCustomers();
    }

    // Delete customer by account number
    @DELETE
    @Path("/{accountNo}")
    public boolean deleteCustomer(@PathParam("accountNo") int accountNo) {
        return operation.deleteCustomer(accountNo);
    }

    // Add new customer
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean addCustomer(Customer customer) {
        return operation.addCustomer(customer);
    }

    // Optional: Get a specific customer
    @GET
    @Path("/{accountNo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomer(@PathParam("accountNo") int accountNo) {
        return operation.getCustomerByAccountNo(accountNo);
    }
}
