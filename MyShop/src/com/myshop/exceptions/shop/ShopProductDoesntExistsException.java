package com.myshop.exceptions.shop;

import com.myshop.exceptions.MyShopException;

public class ShopProductDoesntExistsException extends MyShopException {
    public ShopProductDoesntExistsException() {
        super();
    }

    public ShopProductDoesntExistsException(String message) {
        super(message);
    }
}
