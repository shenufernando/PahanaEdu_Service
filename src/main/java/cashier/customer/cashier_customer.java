package cashier.customer;

public class cashier_customer {
    private int accountNo;
    private String customerName;
    private String address;
    private String phone;
    private int unitsConsumed;

    // Constructors
    public cashier_customer() {}

    public cashier_customer(int accountNo, String customerName, String address, String phone, int unitsConsumed) {
        this.accountNo = accountNo;
        this.customerName = customerName;
        this.address = address;
        this.phone = phone;
        this.unitsConsumed = unitsConsumed;
    }

    // Getters and Setters
    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUnitsConsumed() {
        return unitsConsumed;
    }

    public void setUnitsConsumed(int unitsConsumed) {
        this.unitsConsumed = unitsConsumed;
    }
}
