package com.examShop.exceptions.Shop;

public class ShopNotHaveProductException extends Exception {
    public ShopNotHaveProductException(int id) {
        System.err.print(" Product with this ID \"" + id + "\" not exist! ");
    }
}
