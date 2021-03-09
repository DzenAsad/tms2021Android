package com.myshop.fabric.impl;


import com.myshop.exceptions.MyShopRuntimeException;
import com.myshop.fabric.Fabric;
import com.myshop.fabric.FabricVariants;
import com.myshop.model.shop.Shop;

public class ShopFabric implements Fabric<Shop> {
    @Override
    public Shop getSomeObject(String initData) {
        switch (FabricVariants.valueOf(initData)) {
            case SHOP: {
                return new Shop();
            }
            default: {
                throw new MyShopRuntimeException("Arrow in the knee ");
            }
        }
    }
}
