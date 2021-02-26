package com.examShop.fabric;


import com.examShop.UI.reader.ShopReader;
import com.examShop.fabric.reader.FabricForShopReader;

public class FabricControl {

    public <T> Fabric<T> getRequiredFabric(Class<T> clazz) {
        //ShopReader Fabrics
        if (clazz == ShopReader.class) {
            return (Fabric<T>) new FabricForShopReader();
        }


        return null;
    }
}
