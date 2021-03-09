package com.examShop.exceptions.Shop;

import com.examShop.exceptions.MyShopException;

public class ShopProductAlreadyExistsException extends MyShopException {
    public ShopProductAlreadyExistsException() {
        super();
    }

    public ShopProductAlreadyExistsException(String message) {
        super(message);
    }
}
