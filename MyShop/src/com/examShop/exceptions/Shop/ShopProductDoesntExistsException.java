package com.examShop.exceptions.Shop;

import com.examShop.exceptions.MyShopException;
import com.examShop.model.product.Product;

public class ShopProductDoesntExistsException extends MyShopException {
    public ShopProductDoesntExistsException() {
        super();
    }

    public ShopProductDoesntExistsException(String message) {
        super(message);
    }
}
