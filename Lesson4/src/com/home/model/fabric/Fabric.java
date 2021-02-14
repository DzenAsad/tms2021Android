package com.home.model.fabric;

import com.home.model.fabric.data.MyData;

public abstract class Fabric<T> {

    protected abstract T getSomeObject(T typeObj, MyData initData);
}
