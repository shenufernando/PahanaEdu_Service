/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin.customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shay
 */

public class CustomerOperations {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/pahan_aedu";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    // Customer model class
    public static class Customer {
        private int accountNo;
        private String name;
        private String address;
        private String phone;
        private int unitsConsumed;

        public Customer(int accountNo, String name, String address, String phone, int unitsConsumed) {
            this.accountNo = accountNo;
            this.name = name;
            this.address = address;
            this.phone = phone;
            this.unitsConsumed = unitsConsumed;
        }

        public int getAccountNo() { return accountNo; }
        public String getName() { return name; }
        public String getAddress() { return address; }
        public String getPhone() { return phone; }
        public int getUnitsConsumed() { return unitsConsumed; }
    }

    // Fetch all customers
    public static List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM customers";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Customer customer = new Customer(
                    rs.getInt("account_no"),
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getString("phone"),
                    rs.getInt("units_consumed")
                );
                customers.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }

    // Delete a customer by account number
    public static boolean deleteCustomer(int accountNo) {
        String query = "DELETE FROM customers WHERE account_no = ?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, accountNo);
            int affected = pstmt.executeUpdate();
            return affected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
