package com.home.model;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RecruitingOffice {
    private final PersonRegistry personRegistry;
    private List<MilitaryUnit> militaryUnits = new LinkedList<>();

    public RecruitingOffice(PersonRegistry personRegistry, MilitaryUnit militaryUnit) {
        militaryUnits.add(militaryUnit);
        this.personRegistry = personRegistry;
    }

    public RecruitingOffice(PersonRegistry personRegistry, List<MilitaryUnit> militaryUnits) {
        this.militaryUnits = militaryUnits;
        this.personRegistry = personRegistry;
    }

    public List<Person> getPeople(Address address) {
        List<Person> registeredPersons = new LinkedList<>();
        for (Person person : personRegistry.getPeople(address)) {
            if (person.getAge() < 27 && person.getAge() > 18 && person.getGender() == 'M') {
                registeredPersons.add(person);
            }
        }
        return registeredPersons;
    }


    public void loadUnits(Address address) {
        MilitaryUnit.ResultUnit resultUnit = null;
        for (Person person : getPeople(address)) {
            for (MilitaryUnit militaryUnit : this.militaryUnits) {
                resultUnit = militaryUnit.addRecruit(person);
                if (resultUnit == MilitaryUnit.ResultUnit.ALREADY_IN) {
                    System.out.println(person.getName() + " already in " + militaryUnit.getName());
                    break;
                } else if (resultUnit == MilitaryUnit.ResultUnit.UNIT_FULL) {
                    System.out.println(person.getName() + " can't join " + militaryUnit.getName() + ", full");
                } else {
//                    resultUnit == MilitaryUnit.ResultUnit.SUCCESS;
                    System.out.println(person.getName() + " go to " + militaryUnit.getName());
                    break;
                }
            }
            if (resultUnit == MilitaryUnit.ResultUnit.UNIT_FULL) {
                System.out.println(person.getName() + "free :)");
            }
        }
        showFreeUnits();
    }


    private void showFreeUnits() {
        int countFreeUnit = 0;
        for (MilitaryUnit militaryUnit : this.militaryUnits) {
            if (militaryUnit.getFree() > 0) {
                System.out.print(militaryUnit.getName() + " has free " + militaryUnit.getFree() + " ");
                System.out.println(Arrays.deepToString(militaryUnit.sortListPerson()));
                countFreeUnit++;
            }
        }
        if (countFreeUnit == 0) {
            System.out.println("All units load");
        }
    }
}
