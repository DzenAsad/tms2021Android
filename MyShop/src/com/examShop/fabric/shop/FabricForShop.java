package com.examShop.fabric.shop;


import com.examShop.fabric.Fabric;
import com.examShop.model.shop.Shop;

public class FabricForShop implements Fabric<Shop> {
    @Override
    public Shop getSomeObject(String initData) {
        if (initData.equals("Shop")){
            return new Shop();
        } else {
            return null;
        }
    }

    public enum FabricCase{
        SHOP ("Shop");

        private final String someCase;

        FabricCase(String someCase) {
            this.someCase = someCase;
        }

        public String getThisCase(){
            return someCase;
        }
    }
}
