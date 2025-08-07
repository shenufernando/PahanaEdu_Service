package cashier.bills;

import cashier.bills.*;
import java.util.ArrayList;
import java.util.List;

public class cashierbillOperation {

    public static class BillItem {
        private String bookId;
        private String bookName;
        private int quantity;
        private double unitPrice;

        public BillItem(String bookId, String bookName, int quantity, double unitPrice) {
            this.bookId = bookId;
            this.bookName = bookName;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
        }

        public double getTotalPrice() {
            return quantity * unitPrice;
        }

        @Override
        public String toString() {
            return bookName + " (x" + quantity + ") - Rs." + getTotalPrice();
        }
    }

    private String customerId;
    private String customerName;
    private List<BillItem> items;
    private String paymentMethod;
    private String cardHolder;
    private String cardNumber;
    private String cvv;

    public cashierbillOperation(String customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.items = new ArrayList<>();
    }

    public void addItem(String bookId, String bookName, int qty, double unitPrice) {
        BillItem item = new BillItem(bookId, bookName, qty, unitPrice);
        items.add(item);
    }

    public void setPaymentDetails(String method, String cardHolder, String cardNumber, String cvv) {
        this.paymentMethod = method;
        this.cardHolder = cardHolder;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    public double calculateTotal() {
        return items.stream().mapToDouble(BillItem::getTotalPrice).sum();
    }

    public String generateBill() {
        StringBuilder sb = new StringBuilder();
        sb.append("📘 Pahana Edu Bill\n");
        sb.append("----------------------------\n");
        sb.append("Customer ID: ").append(customerId).append("\n");
        sb.append("Customer Name: ").append(customerName).append("\n");
        sb.append("Payment Method: ").append(paymentMethod).append("\n\n");
        sb.append("Items:\n");

        for (BillItem item : items) {
            sb.append("- ").append(item.toString()).append("\n");
        }

        sb.append("\nTotal: Rs. ").append(calculateTotal());
        return sb.toString();
    }
}
