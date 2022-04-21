package com.company.classes;

public class Address {
    private int id;
    private String streetNumber;
    private String street;
    private String city;
    private String country;
    private String postalCode;

    public Address(int id, String streetNumber, String street, String city, String country, String postalCode) {
        this.id = id;
        this.streetNumber = streetNumber;
        this.street = street;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
    }
}
