/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin.customer;

/**
 *
 * @author Shay
 */



public class Customer {
    private int accountNo;
    private String customerName;
    private String address;
    private String phone;
    private int unitsConsumed;

    // Constructors
    public Customer() {}

    public Customer(int accountNo, String customerName, String address, String phone, int unitsConsumed) {
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
