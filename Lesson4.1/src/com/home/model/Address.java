package com.home.model;

public class Address {
    private String country;
    private String city;

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return country + ", " + city;
    }

    public static Address createAddress(String string) {
        String[] data = string.split(" ");
        try {
            return new Address(data[0], data[1]);
        } catch (Exception e) {
            System.out.println("Wrong input!");
            return new Address("null", "null");
        }
    }
}
