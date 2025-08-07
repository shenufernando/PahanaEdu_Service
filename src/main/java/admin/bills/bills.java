package admin.bills;

import java.sql.Date;

public class bills {

    private String billId;
    private Date billDate;
    private String customerName;
    private String items;
    private double total;
    private String paymentMethod;

    // Constructor
    public bills(String billId, Date billDate, String customerName, String items, double total, String paymentMethod) {
        this.billId = billId;
        this.billDate = billDate;
        this.customerName = customerName;
        this.items = items;
        this.total = total;
        this.paymentMethod = paymentMethod;
    }

    // Getters
    public String getBillId() {
        return billId;
    }

    public Date getBillDate() {
        return billDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    // Setters (optional, if needed)
    public void setBillId(String billId) {
        this.billId = billId;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
