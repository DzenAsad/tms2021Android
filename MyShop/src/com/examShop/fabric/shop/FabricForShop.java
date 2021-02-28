package com.examShop.fabric.shop;


import com.examShop.fabric.Fabric;
import com.examShop.model.shop.Shop;

public class FabricForShop implements Fabric<Shop> {
    @Override
    public Shop getSomeObject(String initData) {
        switch (initData) {
            case ("SHOP"): {
                return new Shop();
            }
            default: {
                return null;
            }
        }
    }

}
