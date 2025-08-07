package cashier.customer;

public class cashier_customer {
    private String accountNo;
    private String name;
    private String address;
    private String phone;
    
    // Constructor
    public cashier_customer(String accountNo, String name, String address, String phone, int units) {
        this.accountNo = accountNo;
        this.name = name;
        this.address = address;
        this.phone = phone;
        
    }

    cashier_customer(String string, String string0, String string1, String string2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Getters
    public String getAccountNo() {
        return accountNo;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    

    // Setters (optional, if you need to update fields later)
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    
}
