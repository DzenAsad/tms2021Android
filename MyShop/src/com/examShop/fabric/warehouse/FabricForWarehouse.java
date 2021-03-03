package com.examShop.fabric.warehouse;

import com.examShop.fabric.Fabric;
import com.examShop.fabric.FabricCase;
import com.examShop.model.warehouse.Warehouse;

public class FabricForWarehouse implements Fabric<Warehouse> {
    @Override
    public Warehouse getSomeObject(String initData) {
        switch (FabricCase.valueOf(initData)) {
            case WAREHOUSE: {
                return new Warehouse();
            }
            default: {
                return null;
            }
        }
    }
}
