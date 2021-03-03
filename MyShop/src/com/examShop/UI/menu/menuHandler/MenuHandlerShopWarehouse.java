package com.examShop.UI.menu.menuHandler;

import com.examShop.UI.menu.MenuCase;
import com.examShop.UI.reader.ShopReader;
import com.examShop.exceptions.Shop.ShopNotHaveProductException;
import com.examShop.exceptions.Warehouse.WarehouseWrongInitDataException;
import com.examShop.model.product.Product;
import com.examShop.model.shop.Shop;

import java.io.IOException;

public class MenuHandlerShopWarehouse extends MenuHandler {
    public MenuHandlerShopWarehouse() {
    }

    public MenuHandlerShopWarehouse(Shop shop, ShopReader optionalReader) {
        super(shop, optionalReader);
    }

    @Override
    public MenuCase casesSwitch(String cmd) {
        switch (cmd) {
            case ("1"): {
                addProductsToWarehouse(getShop(), getOptionalReader());
                return MenuCase.MENU_SHOP_WAREHOUSE;
            }
            case ("2"): {
                buyProductsFromWarehouse(getShop(), getOptionalReader());
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
//        System.out.println("Enter info {id count}");
        try {
            for (String initData : optionalReader.someRead()) {
                String[] formattedData = initData.split("\\W+");
                if (formattedData.length != 2) {
                    throw new WarehouseWrongInitDataException(initData);
                }
                try {
                    Product product = shop.getProduct(Integer.parseInt(formattedData[0]));
                    int count = Integer.parseInt(formattedData[1]);
                    shop.addProductInWarehouse(product, count);
                } catch (NumberFormatException e) {
                    throw new WarehouseWrongInitDataException(initData);
                }
            }
        } catch (IOException e) {
            System.err.println("No info entered");
        } catch (ShopNotHaveProductException | WarehouseWrongInitDataException e) {
            System.err.println("Add product fail!");
        }
    }

    private void buyProductsFromWarehouse(Shop shop, ShopReader optionalReader) {
        System.out.println("Enter info");
        try {
            for (String initData : optionalReader.someRead()) {
                String[] formattedData = initData.split("\\W+");
                if (formattedData.length != 2) {
                    throw new WarehouseWrongInitDataException(initData);
                }
                try {
                    Product product = shop.getProduct(Integer.parseInt(formattedData[0]));
                    int count = Integer.parseInt(formattedData[1]);
                    shop.buyProductFromWarehouse(product, count);
                } catch (NumberFormatException e) {
                    throw new WarehouseWrongInitDataException(initData);
                }
            }
        } catch (IOException e) {
            System.err.println("No info entered");
        } catch (ShopNotHaveProductException | WarehouseWrongInitDataException e) {
            System.err.println("Add product fail!");
        }

    }
}
