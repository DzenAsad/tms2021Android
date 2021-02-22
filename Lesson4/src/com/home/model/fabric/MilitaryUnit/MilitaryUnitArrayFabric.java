package com.home.model.fabric.MilitaryUnit;

import com.home.model.MilitaryUnit;
import com.home.model.fabric.Fabric;

import java.util.List;

public class MilitaryUnitArrayFabric implements Fabric<MilitaryUnit[]> {
    @Override
    public MilitaryUnit[] getSomeObject(List<String> initData) {
        MilitaryUnit[] array = new MilitaryUnit[initData.size()];

        if (initData.size() == 0) {
            System.err.println("Wrong input! Empty input!");
            return null;
        }
        for (int i = 0; i < array.length; i++) {
            String[] formattedData = initData.get(i).split(" ");
            if (formattedData.length < 2) {
                System.err.println("Wrong input! Need more data!");
                return null;
            }
            try {
                array[i] = new MilitaryUnit(Integer.parseUnsignedInt(formattedData[0]), formattedData[1]);
            } catch (NumberFormatException e) {
                System.err.println("You entered text instead of number!");
                return null;
            }
        }
        return array;
    }
}
