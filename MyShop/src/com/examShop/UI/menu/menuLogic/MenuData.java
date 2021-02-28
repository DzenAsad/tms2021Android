package com.examShop.UI.menu.menuLogic;

import com.examShop.UI.menu.MenuCase;
import com.examShop.UI.reader.ShopReader;
import com.examShop.model.shop.Shop;

public abstract class MenuData {
    private Shop shop;
    private ShopReader optionalReader;

    public MenuData(Shop shop, ShopReader optionalReader) {
        this.shop = shop;
        this.optionalReader = optionalReader;
    }


    abstract public MenuCase casesSwitch(String cmd);
}
