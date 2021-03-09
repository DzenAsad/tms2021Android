package com.myshop.fabric;


import com.myshop.UI.menu.Menu;
import com.myshop.UI.menu.handler.MenuHandler;
import com.myshop.UI.menu.reader.MyShopReader;
import com.myshop.exceptions.MyShopRuntimeException;
import com.myshop.fabric.impl.*;
import com.myshop.model.product.Product;
import com.myshop.model.shop.Shop;
import com.myshop.model.warehouse.Warehouse;

public class Fabrics {

    public static <T> Fabric<T> getRequiredFabric(Class<T> clazz) {
        //ShopReader Fabrics
        if (clazz == MyShopReader.class) {
            return (Fabric<T>) new ShopReaderFabric();
        }
        //MenuHUD Fabrics
        if (clazz == Menu.class) {
            return (Fabric<T>) new MenuFabric();
        }
        //Shop Fabrics
        if (clazz == Shop.class) {
            return (Fabric<T>) new ShopFabric();
        }
        //Product Fabrics
        if (clazz == Product.class) {
            return (Fabric<T>) new ProductFabric();
        }
        //MenuHandler Fabric
        if (clazz == MenuHandler.class) {
            return (Fabric<T>) new MenuHandlerFabric();
        }
        //Warehouse Fabric
        if (clazz == Warehouse.class) {
            return (Fabric<T>) new WarehouseFabric();
        }

        throw new MyShopRuntimeException("Annihilation");
    }

}
