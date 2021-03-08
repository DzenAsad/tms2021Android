package com.examShop.exceptions.Product;

import com.examShop.exceptions.WrongInitDataException;

public class ProductWrongInitDataException extends WrongInitDataException {
    public ProductWrongInitDataException(String errString) {
        super(errString);
        System.err.print(" Need like \"id_name_type_price\".");
    }
}
