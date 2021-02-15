package com.home.model.fabric.MilitaryUnit;

import com.home.exception.MyAIOOBException;
import com.home.exception.MyIOBExeption;
import com.home.model.MilitaryUnit;
import com.home.model.fabric.Fabric;

import java.util.List;

public class MilitaryUnitArrayFabric implements Fabric<MilitaryUnit[]> {
    @Override
    public MilitaryUnit[] getSomeObject(List<String> initData) {
        MilitaryUnit[] array = new MilitaryUnit[initData.size()];
        try {
            for (int i = 0; i < array.length; i++) {
                if (initData.size() == 0) {
                    throw new MyIOBExeption();
                }
                String[] formattedData = initData.get(i).split(" ");
                if (formattedData.length < 2) {
                    throw new MyAIOOBException();
                }
                array[i] = new MilitaryUnit(Integer.parseUnsignedInt(formattedData[0]), formattedData[1]);
            }
            return array;
        } catch (MyAIOOBException | MyIOBExeption e) {
            return null;
        } catch (NumberFormatException e) {
            System.out.println("You you entered text instead of number!");
            return null;
        }
    }
}
