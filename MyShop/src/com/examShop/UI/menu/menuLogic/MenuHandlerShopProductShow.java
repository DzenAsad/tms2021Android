package com.examShop.UI.menu.menuLogic;

import com.examShop.UI.menu.MenuCase;
import com.examShop.UI.reader.ShopReader;
import com.examShop.handlers.ShowProductsByAdding;
import com.examShop.handlers.ShowProductsByPrice;
import com.examShop.model.shop.Shop;

public class MenuHandlerShopProductShow extends MenuHandler implements ShowProductsByPrice, ShowProductsByAdding {
    public MenuHandlerShopProductShow(Shop shop, ShopReader optionalReader) {
        super(shop, optionalReader);
    }

    @Override
    public MenuCase casesSwitch(String cmd) {
        switch (cmd) {
            case ("1"): {
                showProductsByPrice(getShop());
            }
            case ("2"): {
                showProductsByAdding(getShop());
            }
            case ("0"): {
                return MenuCase.MENU_SHOP;
            }
            default:{
                return MenuCase.MENU_SHOP_PRODUCT_SHOW;
            }
        }
    }
}
