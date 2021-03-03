package com.examShop.exceptions.Warehouse;

public class WarehouseNotHaveProductIdException extends Exception {
    public WarehouseNotHaveProductIdException(int id) {
        System.err.print(" Product with this ID \"" + id + "\" not exist! ");
    }
}
