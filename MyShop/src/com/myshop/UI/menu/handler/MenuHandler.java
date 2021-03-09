package com.myshop.UI.menu.handler;

import com.myshop.UI.menu.MenuOption;
import com.myshop.UI.menu.reader.MyShopReader;
import com.myshop.UI.shop.handler.ShopHandler;
import com.myshop.model.shop.Shop;

public abstract class MenuHandler {
    private Shop shop;
    private MyShopReader optionalReader;

    public MenuHandler() {
    }

    abstract public MenuOption casesSwitch(String command);

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public MyShopReader getOptionalReader() {
        return optionalReader;
    }

    public void setOptionalReader(MyShopReader optionalReader) {
        this.optionalReader = optionalReader;
    }

    protected void cycleHandler(ShopHandler shopHandler) {
        for (String initData : optionalReader.someRead()) {
            shopHandler.workLogic(shop, initData);
        }
    }
}
