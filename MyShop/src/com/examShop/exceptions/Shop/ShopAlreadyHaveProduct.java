package com.examShop.exceptions.Shop;

import com.examShop.model.product.Product;

public class ShopAlreadyHaveProduct extends Exception{
    public ShopAlreadyHaveProduct(Product product){
        System.err.print("Already have this \"" + product.toString() + "\" ");
    }
}
