package admin.bills;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class billOperations {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/pahana_edu";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    // Bill model class
    public static class Bill {
        private String billId;
        private Date billDate;
        private String customerName;
        private String items;
        private double total;
        private String paymentMethod;

        public Bill(String billId, Date billDate, String customerName, String items, double total, String paymentMethod) {
            this.billId = billId;
            this.billDate = billDate;
            this.customerName = customerName;
            this.items = items;
            this.total = total;
            this.paymentMethod = paymentMethod;
        }

        public String getBillId() { return billId; }
        public Date getBillDate() { return billDate; }
        public String getCustomerName() { return customerName; }
        public String getItems() { return items; }
        public double getTotal() { return total; }
        public String getPaymentMethod() { return paymentMethod; }
    }

    // Get all billing records
    public static List<Bill> getAllBills() {
        List<Bill> bills = new ArrayList<>();
        String query = "SELECT * FROM bills";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Bill bill = new Bill(
                    rs.getString("bill_id"),
                    rs.getDate("bill_date"),
                    rs.getString("customer_name"),
                    rs.getString("items"),
                    rs.getDouble("total"),
                    rs.getString("payment_method")
                );
                bills.add(bill);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bills;
    }

    // Delete a bill by bill ID
    public static boolean deleteBill(String billId) {
        String query = "DELETE FROM bills WHERE bill_id = ?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, billId);
            int affected = pstmt.executeUpdate();
            return affected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
