package com.home.model.fabric.data;

import java.util.LinkedList;
import java.util.List;

public class MyData {
    int count = 0;
    List<Object> initData = new LinkedList<>();


    public Object getNextData() {
        if(initData.isEmpty()) {
            return null;
        }
        if(initData.size() >= count){
            return initData.get(count++);
        }
        return null;
    }
}
