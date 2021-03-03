package com.examShop.UI.menu.menuHandler;

import com.examShop.UI.menu.MenuCase;
import com.examShop.UI.reader.ShopReader;
import com.examShop.exceptions.Product.ProductWrongInitDataException;
import com.examShop.fabric.FabricControl;
import com.examShop.model.product.Product;
import com.examShop.model.shop.Shop;

import java.io.IOException;

public class MenuHandlerShopProductWork extends MenuHandler {
    public MenuHandlerShopProductWork() {
    }


    @Override
    public MenuCase casesSwitch(String cmd) {
        switch (cmd) {
            case ("1"): {
                System.out.println("Enter info \"id_name_price\"");
                addProductInShop(getShop(), getOptionalReader());
                return MenuCase.MENU_SHOP_PRODUCT_WORK;
            }
            case ("2"): {
                System.out.println("Enter info \"id\"");
                deleteProductInShop(getShop(), getOptionalReader());
                return MenuCase.MENU_SHOP_PRODUCT_WORK;
            }
            case ("3"): {
                System.out.println("Enter info \"id_name_price\"");
                editProductInShop(getShop(), getOptionalReader());
                return MenuCase.MENU_SHOP_PRODUCT_WORK;
            }
            case ("0"): {
                return MenuCase.MENU_SHOP;
            }
            default: {
                return MenuCase.MENU_SHOP_PRODUCT_WORK;
            }
        }
    }

    private void addProductInShop(Shop shop, ShopReader optionalReader) {
        try {
            for (String initData : optionalReader.someRead()) {
                if (!shop.addProductInShop((FabricControl.getRequiredFabric(Product.class)).getSomeObject(initData))){
                    errLogicMsg(initData);
                }
            }
        } catch (IOException e) {
            System.err.println("No info entered");
        } catch (ProductWrongInitDataException e) {
            System.err.println(" Add fail!");
        }
    }

    private void deleteProductInShop(Shop shop, ShopReader optionalReader) {
        try {
            for (String initData : optionalReader.someRead()) {
                if (!shop.deleteProductInShop(Integer.parseInt(initData))){
                    errLogicMsg(initData);
                    continue;
                }
                shop.removeProductFromWarehouse(shop.getProduct(Integer.parseInt(initData)));
            }
        } catch (IOException e) {
            System.err.println("No info entered");
        } catch (NumberFormatException e) {
        System.err.println("Wrong info.");
    }
    }

    private void editProductInShop(Shop shop, ShopReader optionalReader) {
        try {
            for (String initData : optionalReader.someRead()) {
                if (!shop.editProductInShop(FabricControl.getRequiredFabric(Product.class).getSomeObject(initData))){
                    errLogicMsg(initData);
                }
            }
        } catch (IOException e) {
            System.err.println("No info entered");
        } catch (ProductWrongInitDataException e) {
            System.err.println(" Edit fail!");
        }
    }
}