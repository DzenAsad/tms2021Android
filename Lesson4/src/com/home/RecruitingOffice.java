package com.home;


import com.home.model.Address;
import com.home.model.Person;

import java.util.LinkedList;
import java.util.List;

public class RecruitingOffice {
    private final Person[] recruits;

    public RecruitingOffice(PersonRegistry personRegistry, Address address) {
        List<Person> registeredPersons = personRegistry.getPeople(address);
        List<Person> tmpListPersons = new LinkedList<>();
        // Checking of requirements
        for (Person person : registeredPersons) {
            if (person.getAge() < 27 && person.getAge() > 18 && person.getGender() == 'M') {
                tmpListPersons.add(person);
            }
        }
        // List to Array
        Person[] tmpArrPersons = new Person[tmpListPersons.size()];
        for (int i = 0; i < tmpArrPersons.length; i++) {
            tmpArrPersons[i] = tmpListPersons.get(i);
        }

        this.recruits = tmpArrPersons;
    }


    public void showPeople() {
        System.out.println("Recruited people");
        for (Person person : this.recruits) {
            System.out.println(person.getName() + " " + person.getAge() + " " + person.getGender());
        }
    }


}
