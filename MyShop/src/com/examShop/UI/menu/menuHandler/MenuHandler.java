package com.examShop.UI.menu.menuHandler;

import com.examShop.UI.menu.MenuCase;
import com.examShop.UI.reader.ShopReader;
import com.examShop.model.shop.Shop;

public abstract class MenuHandler {
    private Shop shop;
    private ShopReader optionalReader;

    public MenuHandler() {
    }

    abstract public MenuCase casesSwitch(String cmd);

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

    void errLogicMsg(String string){
        System.err.println("Err: \"" + string + "\"");
    }
}
