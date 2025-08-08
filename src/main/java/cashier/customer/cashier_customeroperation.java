package cashier.customer;

import db.DBUtilsTest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class cashier_customeroperation {

    // 🔹 Insert new customer
    public static boolean addCustomer(cashier_customer c) {
        String sql = "INSERT INTO customers (account_no, customer_name, address, phone, units_consumed) VALUES (?, ?, ?, ?, 0)";
        try (Connection conn = DBUtilsTest.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, c.getAccountNo());
            stmt.setString(2, c.getCustomerName());
            stmt.setString(3, c.getAddress());
            stmt.setString(4, c.getPhone());

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 🔹 Get all customers
    public static List<cashier_customer> getAllCustomers() {
        List<cashier_customer> list = new ArrayList<>();
        String sql = "SELECT * FROM customers";

        try (Connection conn = DBUtilsTest.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                cashier_customer c = new cashier_customer();
                c.setAccountNo(rs.getInt("account_no"));
                c.setCustomerName(rs.getString("customer_name"));
                c.setAddress(rs.getString("address"));
                c.setPhone(rs.getString("phone"));
                c.setUnitsConsumed(rs.getInt("units_consumed"));
                list.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // 🔹 Get customer by account no
    public static cashier_customer getCustomerByAccountNo(int accountNo) {
        String sql = "SELECT * FROM customers WHERE account_no = ?";
        try (Connection conn = DBUtilsTest.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, accountNo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new cashier_customer(
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
