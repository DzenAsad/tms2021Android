package com.home.model;

import java.util.LinkedList;
import java.util.List;

public class MilitaryUnit implements Model {
    String name;
    int limit;
    List<Person> personSet = new LinkedList<>();

    MilitaryUnit(int limit, String name)  {
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
        SUCCESS;
    }
}
