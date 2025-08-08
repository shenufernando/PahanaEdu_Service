/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin.customer;


/**
 *
 * @author Shay
 */



import db.DBUtilsTest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerOperation {

    // Get all customers
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();

        try (Connection conn = DBUtilsTest.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM customers")) {

            while (rs.next()) {
                Customer c = new Customer(
                    rs.getInt("account_no"),
                    rs.getString("customer_name"),
                    rs.getString("address"),
                    rs.getString("phone"),
                    rs.getInt("units_consumed")
                );
                customers.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }

    // Delete a customer by account number
    public boolean deleteCustomer(int accountNo) {
        String query = "DELETE FROM customers WHERE account_no = ?";
        try (Connection conn = DBUtilsTest.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, accountNo);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Add new customer
    public boolean addCustomer(Customer customer) {
        String query = "INSERT INTO customers (account_no, customer_name, address, phone, units_consumed) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBUtilsTest.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, customer.getAccountNo());
            ps.setString(2, customer.getCustomerName());
            ps.setString(3, customer.getAddress());
            ps.setString(4, customer.getPhone());
            ps.setInt(5, customer.getUnitsConsumed());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Optional: Get single customer by account_no
    public Customer getCustomerByAccountNo(int accountNo) {
        String query = "SELECT * FROM customers WHERE account_no = ?";
        try (Connection conn = DBUtilsTest.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, accountNo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Customer(
                    rs.getInt("account_no"),
                    rs.getString("customer_name"),
                    rs.getString("address"),
                    rs.getString("phone"),
                    rs.getInt("units_consumed")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
