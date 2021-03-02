package com.examShop.exceptions.Warehouse;

public class WarehouseWrongInitDataException extends Exception {
    public WarehouseWrongInitDataException(String errString) {
            System.err.print(" Wrong info \"" + errString + "\". Need like \"id_count\".");
    }
}
