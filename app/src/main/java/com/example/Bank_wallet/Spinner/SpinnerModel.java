package com.example.Bank_wallet.Spinner;


import java.util.ArrayList;

public class SpinnerModel {
    String id;
    String phoneNumber;
    String firstName;
    String lastName;
    String account_number;

    public SpinnerModel(String phoneNumber, String firstName, String lastName, String account_number) {
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.account_number = account_number;
    }

    public SpinnerModel(String lastName, String account_number) {
        this.lastName = lastName;
        this.account_number = account_number;
    }

    public SpinnerModel(String account_number, String firstName, String lastName) {
        this.account_number=account_number;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    ArrayList<SpinnerModel> arrayList = new ArrayList<>();


}

