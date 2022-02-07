package com.example.Bank_wallet.Datas;

public class Client {
    public Integer getId() {
        return id;
    }

    protected Integer id;
    private String title;
    private String firstName;
    private String username;
    private String lastName;
    private String email;
    private String password;
    private String birthday;
    private String idCard;
    private Boolean validity_of_IDCard ;
    private String phoneNumber;
    private String role;
    private String address;
    private String city;
    private String zipCode;
    private String country;

    public Client(String title, String firstName, String username, String lastName, String email, String password, String birthday, String idCard, Boolean validity_of_idCard, String phoneNumber, String role, String address, String city, String zipCode, String country) {
        this.title = title;
        this.firstName = firstName;
        this.username = username;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.idCard = idCard;
        validity_of_IDCard = validity_of_idCard;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Boolean getValidity_of_IDCard() {
        return validity_of_IDCard;
    }

    public void setValidity_of_IDCard(Boolean validity_of_IDCard) {
        this.validity_of_IDCard = validity_of_IDCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
