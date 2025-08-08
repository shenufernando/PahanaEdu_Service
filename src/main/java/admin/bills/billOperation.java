package admin.bills;

import db.DBUtilsTest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class billOperation {

    // GET ALL BILLS
    public List<bill> getAllBills() {
        List<bill> bills = new ArrayList<>();
        try (Connection conn = DBUtilsTest.getConnection()) {
            String sql = "SELECT * FROM bills";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                bill bill = new bill();
                bill.setBillId(rs.getString("bill_id"));
                bill.setBillDate(rs.getString("bill_date"));
                bill.setCustomerName(rs.getString("customer_name"));
                bill.setCustomerPhone(rs.getString("customer_phone"));
                bill.setItems(rs.getString("items"));
                bill.setTotalAmount(rs.getDouble("total_amount"));
                bill.setPayment(rs.getString("payment"));
                bills.add(bill);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bills;
    }

    // DELETE BILL
    public boolean deleteBill(String billId) {
        try (Connection conn = DBUtilsTest.getConnection()) {
            String sql = "DELETE FROM bills WHERE bill_id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, billId);
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // ADD BILL (Optional)
    public boolean addBill(bill bill) {
        try (Connection conn = DBUtilsTest.getConnection()) {
            String sql = "INSERT INTO bills (bill_id, bill_date, customer_name, customer_phone, items, total_amount, payment) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, bill.getBillId());
            stmt.setString(2, bill.getBillDate());
            stmt.setString(3, bill.getCustomerName());
            stmt.setString(4, bill.getCustomerPhone());
            stmt.setString(5, bill.getItems());
            stmt.setDouble(6, bill.getTotalAmount());
            stmt.setString(7, bill.getPayment());

            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
