package com.examShop.UI.menu.menuHandler;

import com.examShop.UI.menu.MenuCase;
import com.examShop.UI.menu.menuHandler.handler.ShopHandler;
import com.examShop.UI.reader.ShopReader;
import com.examShop.model.shop.Shop;

public abstract class MenuHandler {
    private Shop shop;
    private ShopReader optionalReader;

    public MenuHandler() {
    }

    abstract public MenuCase casesSwitch(String command);

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public ShopReader getOptionalReader() {
        return optionalReader;
    }

    public void setOptionalReader(ShopReader optionalReader) {
        this.optionalReader = optionalReader;
    }

    protected void cycleHandler(ShopHandler shopHandler) {
        for (String initData : optionalReader.someRead()) {
            shopHandler.workLogic(shop, initData);
        }
    }
}
