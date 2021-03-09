package com.myshop.fabric.impl;

import com.myshop.exceptions.MyShopRuntimeException;
import com.myshop.fabric.Fabric;
import com.myshop.fabric.FabricVariants;
import com.myshop.model.warehouse.Warehouse;

public class WarehouseFabric implements Fabric<Warehouse> {
    @Override
    public Warehouse getSomeObject(String initData) {
        switch (FabricVariants.valueOf(initData)) {
            case WAREHOUSE: {
                return new Warehouse();
            }
            default: {
                throw new MyShopRuntimeException("K.O.");
            }
        }
    }
}
