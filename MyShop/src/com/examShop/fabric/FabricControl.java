package com.examShop.fabric;


import com.examShop.UI.menu.MenuHUD;
import com.examShop.UI.menu.menuHandler.MenuHandler;
import com.examShop.UI.reader.ShopReader;
import com.examShop.fabric.menu.FabricForMenuHUD;
import com.examShop.fabric.menuHandler.FabricForMenuHandler;
import com.examShop.fabric.product.FabricForProduct;
import com.examShop.fabric.reader.FabricForShopReader;
import com.examShop.fabric.shop.FabricForShop;
import com.examShop.fabric.warehouse.FabricForWarehouse;
import com.examShop.model.product.Product;
import com.examShop.model.shop.Shop;
import com.examShop.model.warehouse.Warehouse;

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
        //Product Fabrics
        if (clazz == Product.class) {
            return (Fabric<T>) new FabricForProduct();
        }
        //MenuHandler Fabric
        if (clazz == MenuHandler.class) {
            return (Fabric<T>) new FabricForMenuHandler();
        }
        //Warehouse Fabric
        if (clazz == Warehouse.class) {
            return (Fabric<T>) new FabricForWarehouse();
        }


        return null;
    }

}
