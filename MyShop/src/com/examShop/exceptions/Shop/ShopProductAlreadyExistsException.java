package com.examShop.exceptions.Shop;

import com.examShop.exceptions.MyShopException;
import com.examShop.model.product.Product;

public class ShopProductAlreadyExistsException extends MyShopException {
    public ShopProductAlreadyExistsException() {
        super();
    }

    public ShopProductAlreadyExistsException(String message) {
        super(message);
    }
}
