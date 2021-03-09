package com.myshop.fabric;


import com.myshop.exceptions.data.fabric.FabricWrongInitDataException;

public interface Fabric<T> {

    T getSomeObject(String initData) throws FabricWrongInitDataException;

}
