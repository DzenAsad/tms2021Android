package com.examShop.fabric.product;

import com.examShop.fabric.Fabric;
import com.examShop.model.product.Product;


public class FabricForProduct implements Fabric<Product> {
    @Override
    public Product getSomeObject(String initData) {
        String[] formattedData = initData.split("\\W+");
        return new Product(Integer.parseInt(formattedData[0]), formattedData[1], Integer.parseInt(formattedData[2]));
    }
}
