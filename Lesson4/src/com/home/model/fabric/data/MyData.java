package com.home.model.fabric.data;

import java.util.LinkedList;
import java.util.List;

public class MyData {
    int count = 0;
    List<Object> initData = new LinkedList<>();
    MyData myLink;

    MyData(){
        myLink = this;
    }

    public Object getNextData() {
        if(initData.isEmpty()) {
            return null;
        }
        if(initData.size() >= count){
            return initData.get(count++);
        }
        return null;
    }

    public MyData addNextData(Object object){
        initData.add(object);
        return myLink;
    }
}