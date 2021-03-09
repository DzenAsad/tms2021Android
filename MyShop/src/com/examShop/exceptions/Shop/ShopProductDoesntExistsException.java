package com.examShop.exceptions.Shop;

import com.examShop.exceptions.MyShopException;

public class ShopProductDoesntExistsException extends MyShopException {
    public ShopProductDoesntExistsException() {
        super();
    }

    public ShopProductDoesntExistsException(String message) {
        super(message);
    }
}
