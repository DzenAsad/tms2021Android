package com.examShop.UI.menu.menuLogic;

import com.examShop.UI.menu.MenuCase;
import com.examShop.UI.reader.ShopReader;
import com.examShop.handlers.AddProductsToWarehouse;
import com.examShop.handlers.BuyProductsFromWarehouse;
import com.examShop.model.shop.Shop;

public class MenuHandlerShopWarehouse extends MenuHandler implements AddProductsToWarehouse, BuyProductsFromWarehouse {
    public MenuHandlerShopWarehouse(Shop shop, ShopReader optionalReader) {
        super(shop, optionalReader);
    }

    @Override
    public MenuCase casesSwitch(String cmd) {
        switch (cmd) {
            case ("1"): {
                addProductsToWarehouse(getShop(), getOptionalReader());
            }
            case ("2"): {
                buyProductsFromWarehouse(getShop(), getOptionalReader());
            }
            case ("0"): {
                return MenuCase.MENU_SHOP;
            }
            default: {
                return MenuCase.MENU_SHOP_WAREHOUSE;
            }
        }
    }
}
