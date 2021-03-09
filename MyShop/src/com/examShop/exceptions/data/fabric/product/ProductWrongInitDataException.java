package com.examShop.exceptions.data.fabric.product;

import com.examShop.exceptions.data.fabric.FabricWrongInitDataException;

public class ProductWrongInitDataException extends FabricWrongInitDataException {
    public ProductWrongInitDataException() {
        super();
    }

    public ProductWrongInitDataException(String message) {
        super(message);
    }
}
