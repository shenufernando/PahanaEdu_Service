/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pahana_edu_service.resources;

/**
 *
 * @author Shay
 */


import admin.bill.Bill;
import admin.bill.billOperation;
import admin.bills.bill;
import admin.bills.billOperation;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/bills")
public class BillResource {

    billOperation operation = new billOperation();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<bill> getAllBills() {
        return operation.getAllBills();
    }

    @DELETE
    @Path("/{billId}")
    public String deleteBill(@PathParam("billId") String billId) {
        boolean success = operation.deleteBill(billId);
        return success ? "Deleted" : "Failed";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String addBill(bill bill) {
        boolean success = operation.addBill(bill);
        return success ? "Bill Added" : "Error Occurred";
    }
}
