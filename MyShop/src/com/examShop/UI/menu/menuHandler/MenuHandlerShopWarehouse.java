package com.examShop.UI.menu.menuHandler;

import com.examShop.UI.menu.MenuCase;
import com.examShop.UI.reader.ShopReader;
import com.examShop.exceptions.Shop.ShopNullProductException;
import com.examShop.exceptions.Warehouse.WarehouseWrongInitDataException;
import com.examShop.model.product.Product;
import com.examShop.model.shop.Shop;

public class MenuHandlerShopWarehouse extends MenuHandler {
    public MenuHandlerShopWarehouse() {
    }


    @Override
    public MenuCase casesSwitch(String cmd) {
        switch (cmd) {
            case ("1"): {
                System.out.println("Enter info \"id_count\"");
                addProductsToWarehouse(getShop(), getOptionalReader());
                return MenuCase.MENU_SHOP_WAREHOUSE;
            }
            case ("2"): {
                System.out.println("Enter info \"id_count\"");
                System.out.println(buyProductsFromWarehouse(getShop(), getOptionalReader()));
                return MenuCase.MENU_SHOP_WAREHOUSE;
            }
            case ("0"): {
                return MenuCase.MENU_SHOP;
            }
            default: {
                return MenuCase.MENU_SHOP_WAREHOUSE;
            }
        }
    }

    private void addProductsToWarehouse(Shop shop, ShopReader optionalReader) {
        try {
            for (String initData : optionalReader.someRead(2)) {
                String[] formattedData = initData.split("\\W+");
                if (formattedData.length != 2) {
                    throw new WarehouseWrongInitDataException(initData);
                }
                Product product = shop.getProduct(Integer.parseInt(formattedData[0]));
                int count = Integer.parseInt(formattedData[1]);
                shop.addProductInWarehouse(product, count);
            }
        } catch (WarehouseWrongInitDataException | ShopNullProductException e) {
            System.err.println(" Add product fail!");
        }
    }

    private String buyProductsFromWarehouse(Shop shop, ShopReader optionalReader) {
        int quantity = 0;
        int money = 0;
        try {
            for (String initData : optionalReader.someRead(2)) {
                String[] formattedData = initData.split("\\W+");
                if (formattedData.length != 2) {
                    throw new WarehouseWrongInitDataException(initData);
                }
                Product product = shop.getProduct(Integer.parseInt(formattedData[0]));
                int count = Integer.parseInt(formattedData[1]);
                if (shop.buyProductFromWarehouse(product, count)) {
                    quantity += count;
                    money += count * product.getPrice();
                }
            }
        } catch (WarehouseWrongInitDataException | ShopNullProductException e) {
            System.err.println(" Buy product fail!");
        }
        return "Bought:" + quantity + " Money:" + money;
    }
}
