package com.examShop.UI.menu.menuHandler;

import com.examShop.UI.menu.MenuCase;
import com.examShop.UI.reader.ShopReader;
import com.examShop.handlers.AddProductInShop;
import com.examShop.handlers.DelelteProductInShop;
import com.examShop.handlers.EditProductInShop;
import com.examShop.model.shop.Shop;

public class MenuHandlerShopProductWork extends MenuHandler implements AddProductInShop, DelelteProductInShop, EditProductInShop {
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
}
