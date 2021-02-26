package com.examShop.fabric;


import com.examShop.UI.menu.MenuHUD;
import com.examShop.UI.reader.ShopReader;
import com.examShop.fabric.menu.FabricForMenuHUD;
import com.examShop.fabric.reader.FabricForShopReader;

public class FabricControl {

    public <T> Fabric<T> getRequiredFabric(Class<T> clazz) {
        //ShopReader Fabrics
        if (clazz == ShopReader.class) {
            return (Fabric<T>) new FabricForShopReader();
        }
        //MenuHUD Fabrics
        if (clazz == MenuHUD.class) {
            return (Fabric<T>) new FabricForMenuHUD();
        }

        return null;
    }
}
