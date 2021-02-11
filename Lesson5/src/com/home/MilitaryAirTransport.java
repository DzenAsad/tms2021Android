package com.home;

public class MilitaryAirTransport extends AirTransport {
    private boolean ejectionSystem;
    private int rocketsOnBoard;

    public MilitaryAirTransport(int power, int maxSpeed, int mass, String brand, int wingspan, int minRunway) {
        super(power, maxSpeed, mass, brand, wingspan, minRunway);
    }

    public boolean isEjectionSystem() {
        return ejectionSystem;
    }

    public void setEjectionSystem(boolean ejectionSystem) {
        this.ejectionSystem = ejectionSystem;
    }

    public int getRocketsOnBoard() {
        return rocketsOnBoard;
    }

    public void setRocketsOnBoard(int rocketsOnBoard) {
        this.rocketsOnBoard = rocketsOnBoard;
    }

    @Override
    public String toString() {
        return "MilitaryAirTransport{" +
                "ejectionSystem=" + ejectionSystem +
                ", rocketsOnBoard=" + rocketsOnBoard +
                "} " + super.toString() + " PowerKW{" + getPowerKW(getPower()) + "} ";
    }

    public void shoot() {
        if (rocketsOnBoard > 0) {
            System.out.println("Ракета пошла...");
            --rocketsOnBoard;
        } else {
            System.out.println("Боеприпасы отсутствуют");
        }
    }

    public void useCatapult() {
        if (ejectionSystem) {
            System.out.println("Катапультирование прошло успешно");

        } else {
            System.out.println("У вас нет такой системы");
        }
    }
}
