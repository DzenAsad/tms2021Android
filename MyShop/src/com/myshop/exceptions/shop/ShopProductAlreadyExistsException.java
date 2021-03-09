package com.myshop.exceptions.shop;

import com.myshop.exceptions.MyShopException;

public class ShopProductAlreadyExistsException extends MyShopException {
    public ShopProductAlreadyExistsException() {
        super();
    }

    public ShopProductAlreadyExistsException(String message) {
        super(message);
    }
}
