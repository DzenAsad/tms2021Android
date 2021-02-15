package com.home.model.fabric;

import com.home.model.Address;
import com.home.model.MilitaryUnit;
import com.home.model.Person;
import com.home.model.fabric.Address.AddressFabric;
import com.home.model.fabric.MilitaryUnit.MilitaryUnitArrayFabric;
import com.home.model.fabric.MilitaryUnit.MilitaryUnitFabric;
import com.home.model.fabric.Person.PersonArrayFabric;
import com.home.model.fabric.Person.PersonFabric;


public class FabricControl {

    public <T> Fabric<T> getNeedFabric(Class<T> clazz) {
        //Address Fabrics
        if (clazz == Address.class) {
            return (Fabric<T>) new AddressFabric();
        }//Persons Fabrics
        if (clazz == Person.class) {
            return (Fabric<T>) new PersonFabric();
        }
        if (clazz == Person[].class) {
            return (Fabric<T>) new PersonArrayFabric();
        }//MilitaryFabrics
        if (clazz == MilitaryUnit.class) {
            return (Fabric<T>) new MilitaryUnitFabric();
        }
        if (clazz == MilitaryUnit[].class) {
            return (Fabric<T>) new MilitaryUnitArrayFabric();
        }

        return null;
    }
}
