package com.examShop.model.product;

public class Product {
    private final int ID;
    private String name;
    private String type;
    private int price;

    protected Product(int id) {
        ID = id;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
