package com.home.model.fabric.Person;

import com.home.model.Address;
import com.home.model.Person;
import com.home.model.fabric.Fabric;

import java.util.List;

public class PersonArrayFabric implements Fabric<Person[]> {
    @Override
    public Person[] getSomeObject(List<String> initData) {
        Person[] array = new Person[initData.size()];

        if (initData.size() == 0) {
            System.err.println("Wrong input! Empty input!");
            return null;
        }
        for (int i = 0; i < array.length; i++) {
            String[] formattedData = initData.get(i).split(" ");
            if (formattedData.length < 6) {
                System.err.println("Wrong input! Need more data!");
                return null;
            }
            try {
                Person person = new Person(Integer.parseInt(formattedData[0]), formattedData[1], Integer.parseInt(formattedData[2]), formattedData[3].toCharArray()[0]);
                Address address = new Address(formattedData[4], formattedData[5]);
                person.setAddress(address);
                array[i] = person;
            } catch (NumberFormatException e) {
                System.err.println("You entered text instead of number!");
                return null;
            }
        }
        return array;

    }
}
