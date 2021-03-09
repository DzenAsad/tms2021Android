package com.myshop.exceptions.data.fabric.product;

import com.myshop.exceptions.data.fabric.FabricWrongInitDataException;

public class ProductWrongInitDataException extends FabricWrongInitDataException {
    public ProductWrongInitDataException() {
        super();
    }

    public ProductWrongInitDataException(String message) {
        super(message);
    }
}
