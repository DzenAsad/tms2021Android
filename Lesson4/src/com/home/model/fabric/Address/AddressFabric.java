package com.home.model.fabric.Address;

import com.home.exception.MyAIOOBException;
import com.home.exception.MyIOBException;
import com.home.model.Address;
import com.home.model.fabric.Fabric;

import java.util.List;

public class AddressFabric implements Fabric<Address> {
    @Override
    public Address getSomeObject(List<String> initData) {
        try {
            if (initData.size() == 0) {
                throw new MyIOBException();
            }
            String[] formattedData = initData.get(0).split(" ");
            if (formattedData.length < 2) {
                throw new MyAIOOBException();
            }
            return new Address(formattedData[0], formattedData[1]);
        } catch (MyAIOOBException | MyIOBException e) {
            return null;
        }
    }
}
