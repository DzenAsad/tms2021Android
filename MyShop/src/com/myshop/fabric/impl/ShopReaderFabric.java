package com.myshop.fabric.impl;

import com.myshop.UI.menu.reader.MyShopConsoleReader;
import com.myshop.UI.menu.reader.MyShopFileReader;
import com.myshop.UI.menu.reader.MyShopReader;
import com.myshop.exceptions.MyShopRuntimeException;
import com.myshop.fabric.Fabric;
import com.myshop.fabric.FabricVariants;


public class ShopReaderFabric implements Fabric<MyShopReader> {
    @Override
    public MyShopReader getSomeObject(String initData) {
        switch (FabricVariants.valueOf(initData)) {
            case SHOP_READER_FROM_CONSOLE: {
                return new MyShopConsoleReader();
            }
            case SHOP_READER_FROM_FILE: {
                return new MyShopFileReader();
            }
            default: {
                throw new MyShopRuntimeException("OOPS!");
            }
        }
    }


}
