package com.myshop.fabric.impl;

import com.myshop.exceptions.data.fabric.FabricWrongInitDataException;
import com.myshop.exceptions.data.fabric.product.ProductWrongInitDataException;
import com.myshop.fabric.Fabric;
import com.myshop.model.product.Product;


public class ProductFabric implements Fabric<Product> {
    @Override
    public Product getSomeObject(String initData) throws FabricWrongInitDataException {
        String[] formattedData = initData.split("\\W+");
        //Check length our data
        if (formattedData.length != 4) {
            throw new ProductWrongInitDataException(String.format("Unable to create product with such data: %s", initData));
        }
        //Try make Product
        try {
            return new Product(Integer.parseInt(formattedData[0]), formattedData[1], formattedData[2], Integer.parseInt(formattedData[3]));
        } catch (NumberFormatException e) {
            throw new ProductWrongInitDataException(String.format("Unable to create product with such data: %s", initData));
        }
    }
}
