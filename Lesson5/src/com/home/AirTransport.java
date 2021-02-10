package com.home;

public abstract class AirTransport extends Transport{
    private int wingspan;
    private int minRunway;

    public AirTransport(int power, int maxSpeed, int mass, String brand, int wingspan, int minRunway) {
        super(power, maxSpeed, mass, brand);
        this.wingspan = wingspan;
        this.minRunway = minRunway;
    }

    @Override
    public String toString() {
        return "AirTransport{" +
                "wingspan=" + wingspan +
                ", minRunway=" + minRunway +
                "} " + super.toString();
    }
}
