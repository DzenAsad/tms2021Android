package com.home;

public class LightTransport extends TerraneousTransoprt {
    private String bodyType;
    private int passengers;

    public LightTransport(int power, int maxSpeed, int mass, String brand, int wheels, int fuelConsumption, String bodyType, int passengers) {
        super(power, maxSpeed, mass, brand, wheels, fuelConsumption);
        this.bodyType = bodyType;
        this.passengers = passengers;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "LightTransport{" +
                "bodyType='" + bodyType + '\'' +
                ", passengers=" + passengers +
                "} " + super.toString() + " PowerKW{" + getPowerKW(getPower()) + "} ";
    }

    public void doSomeInfo(int time) {
        System.out.println("За время " + time + "ч, автомобиль " + getBrand()
                + " двигаясь с максимальной скоростью " + getMaxSpeed() + "км/ч проедет " + rangeOverTime(time)
                + " км и израсходует " + fuelOverRange(rangeOverTime(time)) + " литров топлива.");
    }

    private int rangeOverTime(int hours) {
        return getMaxSpeed() * hours;
    }

    private int fuelOverRange(int range) {
        return range / getFuelConsumption();
    }
}
