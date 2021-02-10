package com.home;

public abstract class TerraneousTransoprt extends Transport{
    private int wheels;
    private int fuelConsumption;

    public TerraneousTransoprt(int power, int maxSpeed, int mass, String brand, int wheels, int fuelConsumption) {
        super(power, maxSpeed, mass, brand);
        this.wheels = wheels;
        this.fuelConsumption = fuelConsumption;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String toString() {
        return "TerraneousTransoprt{" +
                "wheels=" + wheels +
                ", fuelConsumption=" + fuelConsumption +
                "} " + super.toString();
    }
}
