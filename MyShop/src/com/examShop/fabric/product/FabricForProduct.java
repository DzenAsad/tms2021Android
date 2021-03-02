package com.examShop.fabric.product;

import com.examShop.exceptions.Product.NullProductException;
import com.examShop.fabric.Fabric;
import com.examShop.model.product.Product;


public class FabricForProduct implements Fabric<Product> {
    @Override
    public Product getSomeObject(String initData) {
        String[] formattedData = initData.split("\\W+");
        //Check length our data
        if (formattedData.length != 3) {
            throw new NullProductException(initData);
        }
        //Try make Product
        try {
            return new Product(Integer.parseInt(formattedData[0]), formattedData[1], Integer.parseInt(formattedData[2]));
        } catch (NumberFormatException e) {
            throw new NullProductException(initData);
        }
    }
}
