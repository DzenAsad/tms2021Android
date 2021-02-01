package com.home;


import com.home.model.Address;
import com.home.model.Person;

import java.util.List;

public class RecruitingOffice {
    private final PersonRegistry personRegistry;

    public RecruitingOffice(PersonRegistry personRegistry) {
        this.personRegistry = personRegistry;
    }


    public void showPeople(Address address) {
        List<Person> registeredPersons = this.personRegistry.getPeople(address);
        System.out.println("Recruited people");
        for (Person person : registeredPersons) {
            if (person.getAge() < 27 && person.getAge() > 18 && person.getGender() == 'M') {
                System.out.println(person.getName() + " " + person.getAge() + " " + person.getGender());
            }
        }
    }


}
