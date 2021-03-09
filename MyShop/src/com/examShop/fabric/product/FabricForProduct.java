package com.examShop.fabric.product;

import com.examShop.exceptions.data.fabric.FabricWrongInitDataException;
import com.examShop.exceptions.data.fabric.product.ProductWrongInitDataException;
import com.examShop.fabric.Fabric;
import com.examShop.model.product.Product;


public class FabricForProduct implements Fabric<Product> {
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
