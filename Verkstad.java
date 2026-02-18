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
    public void load(T car) {
        if (cars.size()<capacity) {
            cars.add(car);
        }
    }

    public T unload(int regNr) {
        for (T car : cars) {
            if (car.getRegNr() == regNr) {
                cars.remove(car);
                return car;
            }
        }
        return null;
    }

    public int nrOfCars() {
        return cars.size();
    }
}