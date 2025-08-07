package cashier.bills;

import java.util.List;

public class cashierbill {

    private String billId;
    private String customerId;
    private String customerName;
    private List<BillItem> itemList;
    private String paymentMethod;
    private String cardHolder;
    private String cardNumber;
    private double totalAmount;

    // Inner class representing individual book item
    public static class BillItem {
        private String bookId;
        private String bookName;
        private int quantity;
        private double price;

        public BillItem(String bookId, String bookName, int quantity, double price) {
            this.bookId = bookId;
            this.bookName = bookName;
            this.quantity = quantity;
            this.price = price;
        }

        public double getSubtotal() {
            return quantity * price;
        }

        public String getBookId() {
            return bookId;
        }

        public String getBookName() {
            return bookName;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getPrice() {
            return price;
        }
    }

    // Constructor
    public cashierbill(String billId, String customerId, String customerName, List<BillItem> itemList,
                 String paymentMethod, String cardHolder, String cardNumber) {
        this.billId = billId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.itemList = itemList;
        this.paymentMethod = paymentMethod;
        this.cardHolder = cardHolder;
        this.cardNumber = cardNumber;
        this.totalAmount = calculateTotal();
    }

    private double calculateTotal() {
        double total = 0;
        for (BillItem item : itemList) {
            total += item.getSubtotal();
        }
        return total;
    }

    // Getters
    public String getBillId() {
        return billId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<BillItem> getItemList() {
        return itemList;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    // Printable summary
    public String printBill() {
        StringBuilder sb = new StringBuilder();
        sb.append("📘 Bill ID: ").append(billId).append("\n");
        sb.append("Customer: ").append(customerName).append(" (ID: ").append(customerId).append(")\n");
        sb.append("Payment Method: ").append(paymentMethod).append("\n\n");
        sb.append("Items:\n");

        for (BillItem item : itemList) {
            sb.append(" - ").append(item.getBookName())
              .append(" (x").append(item.getQuantity()).append(") - Rs.")
              .append(item.getSubtotal()).append("\n");
        }

        sb.append("\nTotal Amount: Rs. ").append(totalAmount);
        return sb.toString();
    }
}
