package com.home.model.fabric;

import com.home.exception.MyWrongCastException;
import com.home.model.Address;
import com.home.model.fabric.data.MyData;

public class AddressFabric extends Fabric<Address> {
    @Override
    public Address getSomeObject(Address typeObj, MyData initData) {
        try {
            if (!(initData.getNextData() instanceof String)) {
                throw new MyWrongCastException();
            }
            String[] formattedData = ((String) initData.getNextData()).split(" ");
            return new Address(formattedData[0], formattedData[1]);
        } catch (MyWrongCastException e) {
            System.out.println("Wrong cast!");
            return null;
        }
    }
}
