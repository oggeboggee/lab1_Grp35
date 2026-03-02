package Model;

import java.util.ArrayList;

public class Verkstad<T extends Car>{

    // ---------------------------------- INSTANSVARIABLER ----------------------------------
    public Position pos;
    private int capacity;
    private ArrayList<T> cars;

    // ---------------------------------- KONSTRUKTOR ----------------------------------
    public Verkstad(int capacity, double xCoord, double yCoord) {
        this.capacity = capacity;
        cars = new ArrayList<>(capacity);
        pos = new Position(xCoord, yCoord);
    }

    // ---------------------------------- METODER ----------------------------------


    public Position getPos() {
        return pos;
    }

    public void load(T car) {
        if (cars.size()<capacity && !car.getIsAttached()) {
            cars.add(car);
            car.attachCar();
        }
    }

    public T unload(int regNr) {
        for (T car : cars) {
            if (car.getRegNr() == regNr) {
                cars.remove(car);
                car.deAttachCar();
                return car;
            }
        }
        return null;
    }

    public int nrOfCars() {
        return cars.size();
    }
}