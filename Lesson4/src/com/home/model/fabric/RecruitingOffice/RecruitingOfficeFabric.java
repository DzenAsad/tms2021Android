package com.home.model.fabric.RecruitingOffice;

import com.home.exception.MissingMilitaryUnitException;
import com.home.exception.MissingRegistryException;
import com.home.model.*;
import com.home.model.fabric.Fabric;
import com.home.model.fabric.FabricControl;

import java.util.Arrays;
import java.util.List;

public class RecruitingOfficeFabric implements Fabric<RecruitingOffice> {
    private PersonRegistry personRegistry = null;

    public RecruitingOfficeFabric setPersonRegistry(PersonRegistry personRegistry) {
        this.personRegistry = personRegistry;
        return this;
    }

    @Override
    public RecruitingOffice getSomeObject(List<String> initData) {
        FabricControl fabricControl = new FabricControl();
        try {
            //Check personRegistry not null
            if (personRegistry == null) {
                throw new MissingRegistryException();
            }
            //RecruitingOffice init
            List<MilitaryUnit> militaryUnitList = Arrays.asList(fabricControl.getNeedFabric(MilitaryUnit[].class).getSomeObject(initData));
            return new RecruitingOffice(personRegistry, militaryUnitList);
        } catch (MissingRegistryException | MissingMilitaryUnitException e) {
            return null;
        }
    }
}
