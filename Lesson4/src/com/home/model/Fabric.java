package com.home.model;

import com.home.PersonRegistry;
import com.home.RecruitingOffice;
import com.home.UI.MyReader;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Fabric {
    public Model getModel(String requestedModel, String data) {
        switch (requestedModel) {
            case "Address" -> {
                String[] formattedData = data.split(" ");
                try {
                    return new Address(formattedData[0], formattedData[1]);
                } catch (Exception e) {
                    System.out.println("Wrong input!");
                }
            }
            case "Person" -> {
                String[] formattedData = data.split(" ");
                try {
                    Person person = new Person(Integer.parseInt(formattedData[0]), formattedData[1], Integer.parseInt(formattedData[2]), formattedData[3].toCharArray()[0]);
                    Address address = new Address(formattedData[4], formattedData[5]);
                    person.setAddress(address);
                    return person;

                } catch (Exception e) {
                    System.out.println("Wrong input!");
                }
            }
            case "MilitaryUnit" -> {
                String[] formattedData = data.split(" ");
                try {
                    return new MilitaryUnit(Integer.parseInt(formattedData[0]), formattedData[1]);
                } catch (Exception e) {
                    System.out.println("Wrong input!");
                }
            }
        }
        return null;
    }

    public Model[] getModelArray(String requestedModel, MyReader myReader) throws IOException {
        switch (requestedModel) {
            case "Person" -> {
                List<String> person = myReader.someRead();
                Person[] array = new Person[person.size()];
                for (int i = 0; i < array.length; i++) {
                    array[i] = (Person) getModel("Person", person.get(i));
                }
                return array;
            }
            case "MilitaryUnit" -> {
                List<String> militaryUnit = myReader.someRead();
                MilitaryUnit[] array = new MilitaryUnit[militaryUnit.size()];
                for (int i = 0; i < array.length; i++) {
                    array[i] = (MilitaryUnit) getModel("MilitaryUnit", militaryUnit.get(i));
                }
                return array;
            }
        }
        return null;
    }

    public Model getModel(String requestedModel, MyReader myReader) throws IOException {
        switch (requestedModel) {
            case "PersonRegistry" -> {
                System.out.println("-Please input String like: \"age name height gender country city\"-");
                return new PersonRegistry((Person[]) getModelArray("Person", myReader));

            }
            case "Address" -> {
                System.out.println("-Please input String like: \"country city\"-");
                return getModel("Address", myReader.someRead().get(0));
            }
        }
        return null;
    }

    public Model getModel(String requestedModel, PersonRegistry personRegistry, MyReader myReader) throws IOException {
        switch (requestedModel) {
            case "RecruitingOffice" -> {
                System.out.println("-Please input String like: \"unit_range name\"-");
                return new RecruitingOffice(personRegistry, getModelList("MilitaryUnit", myReader));
            }
        }
        return null;
    }

    public List<MilitaryUnit> getModelList(String requestedModel, MyReader myReader) throws IOException {
        switch (requestedModel) {
            case "MilitaryUnit" -> {
                List<String> militaryUnit = myReader.someRead();
                List<MilitaryUnit> array = new LinkedList<>();
                for (String s : militaryUnit) {
                    array.add((MilitaryUnit) getModel("MilitaryUnit", s));
                }
                return array;
            }
        }
        return null;
    }
}
