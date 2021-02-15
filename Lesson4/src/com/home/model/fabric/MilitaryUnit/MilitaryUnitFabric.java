package com.home.model.fabric.MilitaryUnit;

import com.home.exception.MyAIOOBException;
import com.home.exception.MyIOBExeption;
import com.home.model.MilitaryUnit;
import com.home.model.fabric.Fabric;

import java.util.List;

public class MilitaryUnitFabric implements Fabric<MilitaryUnit> {
    @Override
    public MilitaryUnit getSomeObject(List<String> initData) {
        try {
            if (initData.size() == 0) {
                throw new MyIOBExeption();
            }
            String[] formattedData = initData.get(0).split(" ");
            if (formattedData.length < 2) {
                throw new MyAIOOBException();
            }
            return new MilitaryUnit(Integer.parseInt(formattedData[0]), formattedData[1]);
        } catch (MyAIOOBException | MyIOBExeption e) {
            return null;
        } catch (NumberFormatException e) {
            System.out.println("You you entered text instead of number!");
            return null;
        }
    }
}
