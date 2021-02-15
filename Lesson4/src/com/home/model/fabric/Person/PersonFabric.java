package com.home.model.fabric.Person;

import com.home.exception.MyWrongCastException;
import com.home.model.Address;
import com.home.model.Person;
import com.home.model.fabric.Fabric;


import java.util.List;

public class PersonFabric implements Fabric<Person> {
    @Override
    public Person getSomeObject(List<String> initData) {
        try {
            String[] formattedData = initData.get(0).split(" ");
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
