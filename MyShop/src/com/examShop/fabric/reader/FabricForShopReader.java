package com.examShop.fabric.reader;

import com.examShop.UI.reader.ShopReader;
import com.examShop.UI.reader.ShopReaderFromConsole;
import com.examShop.UI.reader.ShopReaderFromFile;
import com.examShop.exceptions.MyShopRuntimeException;
import com.examShop.fabric.Fabric;
import com.examShop.fabric.FabricCase;


public class FabricForShopReader implements Fabric<ShopReader> {
    @Override
    public ShopReader getSomeObject(String initData) {
        switch (FabricCase.valueOf(initData)) {
            case SHOP_READER_FROM_CONSOLE: {
                return new ShopReaderFromConsole();
            }
            case SHOP_READER_FROM_FILE: {
                return new ShopReaderFromFile();
            }
            default: {
                throw new MyShopRuntimeException("OOPS!");
            }
        }
    }


}
