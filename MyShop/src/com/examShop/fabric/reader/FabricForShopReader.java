package com.examShop.fabric.reader;

import com.examShop.UI.reader.ShopReader;
import com.examShop.UI.reader.ShopReaderFromConsole;
import com.examShop.UI.reader.ShopReaderFromFile;
import com.examShop.fabric.Fabric;


public class FabricForShopReader implements Fabric<ShopReader> {
    @Override
    public ShopReader getSomeObject(String initData) {
        if (initData.equals("ShopReaderFromConsole")){
            return new ShopReaderFromConsole();
        } else if (initData.equals("ShopReaderFromFile")){
            return new ShopReaderFromFile();
        } else {
            return null;
        }
    }

    public enum FabricCase{
        CONSOLE ("ShopReaderFromConsole"),
        FILE("ShopReaderFromFile");

        private final String someCase;

        FabricCase(String someCase) {
            this.someCase = someCase;
        }

        public String getThisCase(){
            return someCase;
        }
    }

}
