package com.home.model.fabric.MilitaryUnit;

import com.home.exception.MyNFException;
import com.home.model.MilitaryUnit;
import com.home.model.fabric.Fabric;

import java.util.List;

public class MilitaryUnitFabric implements Fabric<MilitaryUnit> {
    @Override
    public MilitaryUnit getSomeObject(List<String> initData) {

        if (initData.size() == 0) {
            System.err.println("Wrong input! Empty input!");
            return null;
        }
        String[] formattedData = initData.get(0).split(" ");
        if (formattedData.length < 2) {
            System.err.println("Wrong input! Need more data!");
            return null;
        }
        try {
            return new MilitaryUnit(Integer.parseInt(formattedData[0]), formattedData[1]);
        } catch (NumberFormatException e) {
            throw new MyNFException(e);
        }
    }
}
