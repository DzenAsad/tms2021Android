package com.home;

public class СivilAirTransport extends AirTransport implements CheckLoading {
    private int numbPassengers;
    private boolean hasBusinessClass;

    public СivilAirTransport(int power, int maxSpeed, int mass, String brand, int wingspan, int minRunway, int numbPassengers, boolean hasBusinessClass) {
        super(power, maxSpeed, mass, brand, wingspan, minRunway);
        this.numbPassengers = numbPassengers;
        this.hasBusinessClass = hasBusinessClass;
    }

    public int getNumbPassengers() {
        return numbPassengers;
    }

    public void setNumbPassengers(int numbPassengers) {
        this.numbPassengers = numbPassengers;
    }

    public boolean isHasBusinessClass() {
        return hasBusinessClass;
    }

    public void setHasBusinessClass(boolean hasBusinessClass) {
        this.hasBusinessClass = hasBusinessClass;
    }

    @Override
    public String toString() {
        return "СivilAirTransport{" +
                "numbPassengers=" + numbPassengers +
                ", hasBusinessClass=" + hasBusinessClass +
                "} " + super.toString() + " PowerKW{" + getPowerKW(getPower()) + "} ";
    }

    public void tryLoadCargo(int passengers) {
        System.out.println("Возможно ли принять " + passengers + "пассажиров - " + checkPossibilityOfLoading(passengers, numbPassengers));
    }

}
