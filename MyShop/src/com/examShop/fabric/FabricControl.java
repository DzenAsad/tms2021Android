package com.examShop.fabric;


import com.examShop.UI.menu.MenuHUD;
import com.examShop.UI.reader.ShopReader;
import com.examShop.fabric.menu.FabricForMenuHUD;
import com.examShop.fabric.product.FabricForProduct;
import com.examShop.fabric.reader.FabricForShopReader;
import com.examShop.fabric.shop.FabricForShop;
import com.examShop.model.product.Product;
import com.examShop.model.shop.Shop;

public class FabricControl {

    public static <T> Fabric<T> getRequiredFabric(Class<T> clazz) {
        //ShopReader Fabrics
        if (clazz == ShopReader.class) {
            return (Fabric<T>) new FabricForShopReader();
        }
        //MenuHUD Fabrics
        if (clazz == MenuHUD.class) {
            return (Fabric<T>) new FabricForMenuHUD();
        }
        //Shop Fabrics
        if (clazz == Shop.class) {
            return (Fabric<T>) new FabricForShop();
        }
        //Shop Product
        if (clazz == Product.class) {
            return (Fabric<T>) new FabricForProduct();
        }

        return null;
    }
}
