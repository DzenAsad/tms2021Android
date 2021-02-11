package com.home;

public class HeavyTransport extends TerraneousTransoprt implements CheckLoading {
    private int carryingCapacity;

    public HeavyTransport(int power, int maxSpeed, int mass, String brand, int wheels, int fuelConsumption, int carryingCapacity) {
        super(power, maxSpeed, mass, brand, wheels, fuelConsumption);
        this.carryingCapacity = carryingCapacity;
    }

    @Override
    public String toString() {
        return "HeavyTransport{" +
                "carryingCapacity=" + carryingCapacity +
                "} " + super.toString() + " PowerKW{" + getPowerKW(getPower()) + "} ";
    }

    public void tryLoadCargo(int cargo) {
        System.out.println("Возможно ли загрузить " + cargo + " груза - " + checkPossibilityOfLoading(cargo, carryingCapacity));
    }


}
