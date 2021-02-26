package com.examShop.fabric;


public interface Fabric<T> {

    T getSomeObject(String initData);

    public enum FabricCases {}
}
