package com.examShop.exceptions.data.fabric.product;

import com.examShop.exceptions.data.WrongInitDataException;
import com.examShop.exceptions.data.fabric.FabricWrongInitDataException;
import com.examShop.model.product.Product;

public class ProductWrongInitDataException extends FabricWrongInitDataException {
     public ProductWrongInitDataException() {
        super();
    }

    public ProductWrongInitDataException(String message) {
        super(message);
    }
}
