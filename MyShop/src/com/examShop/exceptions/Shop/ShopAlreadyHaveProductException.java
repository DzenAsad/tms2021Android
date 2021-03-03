package com.examShop.exceptions.Shop;

import com.examShop.model.product.Product;

public class ShopAlreadyHaveProductException extends Exception {
    public ShopAlreadyHaveProductException(Product product) {
        System.err.print("Already have this \"" + product.toString() + "\" ");
    }
}
