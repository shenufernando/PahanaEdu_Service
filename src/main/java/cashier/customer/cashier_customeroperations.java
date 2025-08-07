package cashier.customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class cashier_customeroperations {

    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/pahan_aedu";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Add a new customer (no units)
    public static boolean addCustomer(String accountNo, String name, String address, String phone) {
        String sql = "INSERT INTO cashier_customer (account_no, name, address, phone) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, accountNo);
            ps.setString(2, name);
            ps.setString(3, address);
            ps.setString(4, phone);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get all customers (no units)
    public static List<cashier_customer> getAllCustomers() {
        List<cashier_customer> list = new ArrayList<>();
        String sql = "SELECT * FROM cashier_customer";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                cashier_customer customer = new cashier_customer(
                        rs.getString("account_no"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("phone")
                );
                list.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // Get customer by account number (no units)
    public static cashier_customer getCustomerByAccount(String accountNo) {
        String sql = "SELECT * FROM cashier_customer WHERE account_no = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, accountNo);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new cashier_customer(
                            rs.getString("account_no"),
                            rs.getString("name"),
                            rs.getString("address"),
                            rs.getString("phone")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Delete a customer by account number
    public static boolean deleteCustomer(String accountNo) {
        String sql = "DELETE FROM cashier_customer WHERE account_no = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, accountNo);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
