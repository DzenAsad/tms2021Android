package com.examShop.exceptions.Shop;

public class ShopNullProductException extends NullPointerException{
    public ShopNullProductException(int errInt) {
        System.err.print("Exception: Shop don't have Product with this id \"" + errInt + "\".");
    }
}
