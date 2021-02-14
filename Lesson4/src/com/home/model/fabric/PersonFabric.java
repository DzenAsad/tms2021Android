package com.home.model.fabric;

import com.home.exception.MyWrongCastException;
import com.home.model.Address;
import com.home.model.Person;
import com.home.model.fabric.data.MyData;

public class PersonFabric extends Fabric<Person> {
    @Override
    protected Person getSomeObject(Person typeObj, MyData initData) {
        try {
            String[] formattedData = ((String) initData.getNextData()).split(" ");
            Person person = new Person(Integer.parseInt(formattedData[0]), formattedData[1], Integer.parseInt(formattedData[2]), formattedData[3].toCharArray()[0]);
            Address address = new Address(formattedData[4], formattedData[5]);
            person.setAddress(address);
            return person;

        }catch (MyWrongCastException e) {
            System.out.println("Wrong cast!");
            return null;
        }
    }
}
