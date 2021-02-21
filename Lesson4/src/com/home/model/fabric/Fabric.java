package com.home.model.fabric;


import java.util.List;

public interface Fabric<T> {

    T getSomeObject(List<String> initData);
}
