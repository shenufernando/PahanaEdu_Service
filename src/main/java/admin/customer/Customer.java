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
    private String name;
    private String address;
    private String phone;
    private int unitsConsumed;

    // Constructor
    public Customer(int accountNo, String name, String address, String phone, int unitsConsumed) {
        this.accountNo = accountNo;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.unitsConsumed = unitsConsumed;
    }

    // Getters
    public int getAccountNo() {
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

    public int getUnitsConsumed() {
        return unitsConsumed;
    }

    // Setters (optional, if you plan to update fields later)
    public void setAccountNo(int accountNo) {
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

    public void setUnitsConsumed(int unitsConsumed) {
        this.unitsConsumed = unitsConsumed;
    }
}
