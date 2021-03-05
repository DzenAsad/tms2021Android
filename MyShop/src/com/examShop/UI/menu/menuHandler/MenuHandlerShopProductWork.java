package com.examShop.UI.menu.menuHandler;

import com.examShop.UI.menu.MenuCase;
import com.examShop.UI.reader.ShopReader;
import com.examShop.exceptions.Product.ProductWrongInitDataException;
import com.examShop.fabric.FabricControl;
import com.examShop.model.product.Product;
import com.examShop.model.shop.Shop;


public class MenuHandlerShopProductWork extends MenuHandler {
    public MenuHandlerShopProductWork() {
    }


    @Override
    public MenuCase casesSwitch(String cmd) {
        switch (cmd) {
            case ("1"): {
                System.out.println("Enter info \"id_name_type_price\"");
                addProductInShop(getShop(), getOptionalReader());
                return MenuCase.MENU_SHOP_PRODUCT_WORK;
            }
            case ("2"): {
                System.out.println("Enter info \"id\"");
                deleteProductInShop(getShop(), getOptionalReader());
                return MenuCase.MENU_SHOP_PRODUCT_WORK;
            }
            case ("3"): {
                System.out.println("Enter info \"id_name_type_price\"");
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
        for (String initData : optionalReader.someRead(4)) {
            try {
                if (!shop.addProductInShop((FabricControl.getRequiredFabric(Product.class)).getSomeObject(initData))) {
                    System.out.println(("Add fail, wrong data - " + initData));
                }
            } catch (ProductWrongInitDataException e) {
                System.err.println(" Add fail!");
            }
        }


    }

    private void deleteProductInShop(Shop shop, ShopReader optionalReader) {
        for (String initData : optionalReader.someRead(1)) {
            try {
                if (!shop.deleteProductInShop(Integer.parseInt(initData))) {
                    System.out.println("Delete fail, wrong data - " + initData);
                    continue;
                }
                shop.removeProductFromWarehouse(Integer.parseInt(initData));
            } catch (NumberFormatException e) {
                System.err.println(" Wrong info.");
            }
        }

    }

    private void editProductInShop(Shop shop, ShopReader optionalReader) {
        for (String initData : optionalReader.someRead(4)) {
            try {
                if (!shop.editProductInShop(FabricControl.getRequiredFabric(Product.class).getSomeObject(initData))) {
                    System.out.println("Edit fail, wrong data - " + initData);
                }
            } catch (ProductWrongInitDataException e) {
                System.err.println(" Edit fail!");
            }
        }

    }
}
