package com.examShop.fabric;


import com.examShop.exceptions.data.fabric.FabricWrongInitDataException;

public interface Fabric<T> {

    T getSomeObject(String initData) throws FabricWrongInitDataException;

}
