package com.examShop.exceptions.Product;

public class ProductWrongInitDataException extends NullPointerException {
    public ProductWrongInitDataException(String errString) {
        System.err.print("Wrong info \"" + errString + "\". Need like \"id_name_price\".");
    }
}
