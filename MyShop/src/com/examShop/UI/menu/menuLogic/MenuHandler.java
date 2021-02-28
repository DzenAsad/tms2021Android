package com.examShop.UI.menu.menuLogic;

import com.examShop.UI.menu.MenuCase;
import com.examShop.UI.reader.ShopReader;
import com.examShop.model.shop.Shop;

public abstract class MenuHandler {
    private Shop shop;
    private ShopReader optionalReader;

    public MenuHandler() {
    }

    public MenuHandler(Shop shop, ShopReader optionalReader) {
        this.shop = shop;
        this.optionalReader = optionalReader;
    }

    public Shop getShop() {
        return shop;
    }

    public ShopReader getOptionalReader() {
        return optionalReader;
    }

    public void setOptionalReader(ShopReader optionalReader) {
        this.optionalReader = optionalReader;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    abstract public MenuCase casesSwitch(String cmd);
}
