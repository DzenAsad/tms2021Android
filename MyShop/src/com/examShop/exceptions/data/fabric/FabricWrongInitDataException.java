package com.examShop.exceptions.data.fabric;

import com.examShop.exceptions.data.WrongInitDataException;
import com.examShop.model.product.Product;

public class FabricWrongInitDataException extends WrongInitDataException {
    public FabricWrongInitDataException() {
        super();
    }

    public FabricWrongInitDataException(String message) {
        super(message);
    }
}
