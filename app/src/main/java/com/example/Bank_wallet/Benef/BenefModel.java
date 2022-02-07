package com.example.Bank_wallet.Benef;

public class BenefModel {
    String id;
    String name;
    String phone;
    String firstname;
    String lastname;
    String accountnumber;

    public BenefModel(String phone, String firstname, String lastname, String accountnumber) {
        this.phone = phone;
        this.firstname = firstname;
        this.lastname = lastname;
        this.accountnumber = accountnumber;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public BenefModel() {
    }

    public BenefModel(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public BenefModel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
