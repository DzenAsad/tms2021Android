package com.home.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MilitaryUnit {
    private String name;
    private int limit;
    private List<Person> personSet = new LinkedList<>();

    public MilitaryUnit(int limit, String name) {
        this.name = name;
        this.limit = limit;
    }

    public ResultUnit addRecruit(Person person) {
        if (personSet.size() >= limit) {
            return ResultUnit.UNIT_FULL;
        } else if (checkHasAlready(person)) {
            return ResultUnit.ALREADY_IN;
        } else {
            personSet.add(person);
            return ResultUnit.SUCCESS;
        }
    }

    public int getFree() {
        return limit - personSet.size();
    }

    private boolean checkHasAlready(Person person) {
        for (Person personInSet : personSet) {
            if (person.equals(personInSet)) {
                return true;
            }
        }
        return false;
    }

    public List<Person> getPersonSet() {
        return personSet;
    }

    public String getName() {
        return name;
    }

    public enum ResultUnit {
        UNIT_FULL,
        ALREADY_IN,
        SUCCESS
    }

    public void sortListPerson() {
        String[] tmpArrPerson = new String[personSet.size()];
        for (int i = 0; i < tmpArrPerson.length; i++) {
            tmpArrPerson[i] = personSet.get(i).getSurname() + " " + personSet.get(i).getName();
        }
        Arrays.sort(tmpArrPerson);
        for (int i = 0; i < tmpArrPerson.length; i++) {

            tmpArrPerson[i] = i + 1 + ". " + tmpArrPerson[i];
        }
        System.out.println(Arrays.deepToString(tmpArrPerson));
    }
}
