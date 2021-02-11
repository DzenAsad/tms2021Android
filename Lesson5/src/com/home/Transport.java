package com.home;

public abstract class Transport {
    private int power;
    private int maxSpeed;
    private int mass;
    private String brand;

    public Transport(int power, int maxSpeed, int mass, String brand) {
        this.power = power;
        this.maxSpeed = maxSpeed;
        this.mass = mass;
        this.brand = brand;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "power=" + power +
                ", maxSpeed=" + maxSpeed +
                ", mass=" + mass +
                ", brand='" + brand + '\'' +
                '}';
    }

    public double getPowerKW(int powerHP) {
        return powerHP * 0.74;
    }
}
