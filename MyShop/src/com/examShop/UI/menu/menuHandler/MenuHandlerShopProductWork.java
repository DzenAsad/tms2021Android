package com.examShop.UI.menu.menuHandler;

import com.examShop.UI.menu.MenuCase;
import com.examShop.UI.reader.ShopReader;
import com.examShop.exceptions.Product.ProductWrongInitDataException;
import com.examShop.exceptions.Shop.ShopNotHaveProductException;
import com.examShop.fabric.FabricControl;
import com.examShop.model.product.Product;
import com.examShop.model.shop.Shop;

import java.io.IOException;

public class MenuHandlerShopProductWork extends MenuHandler {
    public MenuHandlerShopProductWork() {
    }

    public MenuHandlerShopProductWork(Shop shop, ShopReader optionalReader) {
        super(shop, optionalReader);
    }

    @Override
    public MenuCase casesSwitch(String cmd) {
        switch (cmd) {
            case ("1"): {
                addProductInShop(getShop(), getOptionalReader());
                return MenuCase.MENU_SHOP_PRODUCT_WORK;
            }
            case ("2"): {
                deleteProductInShop(getShop(), getOptionalReader());
                return MenuCase.MENU_SHOP_PRODUCT_WORK;
            }
            case ("3"): {
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
//        System.out.println("Enter info {id Name price}");
        try {
            for (String initData : optionalReader.someRead()) {
                // TODO: 03.03.2021 return boolean, need info
                shop.addProductInShop((FabricControl.getRequiredFabric(Product.class)).getSomeObject(initData));
            }
        } catch (ProductWrongInitDataException e) {
            System.err.println("AddProductInShop fail!");
        } catch (IOException e) {
            System.err.println("No info entered");
        }
    }

    private void deleteProductInShop(Shop shop, ShopReader optionalReader) {
        System.out.println("Enter info");
        try {
            for (String string : optionalReader.someRead()) {
                shop.removeProductFromWarehouse(shop.getProduct(Integer.parseInt(string)));
                // TODO: 03.03.2021 add, boolean about success meth
                shop.deleteProductInShop(Integer.parseInt(string));
            }
        } catch (IOException e) {
            System.err.println("No info entered");
        } catch (ShopNotHaveProductException e) {
            System.err.println("Delete product fail!");
        }

    }

    private void editProductInShop(Shop shop, ShopReader optionalReader) {
        System.out.println("Enter info");
        try {
            for (String string : optionalReader.someRead()) {
                // TODO: 03.03.2021 add, boolean about success meth
                shop.editProductInShop(FabricControl.getRequiredFabric(Product.class).getSomeObject(string));
            }
        } catch (IOException e) {
            System.err.println("No info entered");
        } catch (ProductWrongInitDataException | ShopNotHaveProductException e) {
            System.err.println("Edit product fail!");
        }
    }
}
