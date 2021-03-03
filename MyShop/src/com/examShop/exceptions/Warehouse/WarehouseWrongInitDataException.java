package com.examShop.exceptions.Warehouse;

import com.examShop.exceptions.WrongInitDataException;

public class WarehouseWrongInitDataException extends WrongInitDataException {
    public WarehouseWrongInitDataException(String errString) {
        super(errString);
        System.err.print(" Need like \"id_count\".\" ");
    }
}
