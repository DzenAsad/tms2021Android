package com.home.model.fabric.Address;

import com.home.model.Address;
import com.home.model.fabric.Fabric;

import java.util.List;

public class AddressFabric implements Fabric<Address> {
    @Override
    public Address getSomeObject(List<String> initData) {
        if (initData.size() == 0) {
            System.err.println("Wrong input! Empty input!");
            return null;
        }
        String[] formattedData = initData.get(0).split(" ");
        if (formattedData.length < 2) {
            System.err.println("Wrong input! Need more data!");
            return null;
        }
        return new Address(formattedData[0], formattedData[1]);

    }
}
