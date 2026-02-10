import java.util.ArrayList;

public class Verkstad<T extends Car>{

    // ---------------------------------- INSTANSVARIABLER ----------------------------------
    private int xCord;
    private int yCord;

    private int capacity;
    private ArrayList<T> cars;

    // ---------------------------------- KONSTRUKTOR ----------------------------------
    public Verkstad(int capacity) {
        this.capacity = capacity;
        cars = new ArrayList<>(capacity);
    }

    // ---------------------------------- METODER ----------------------------------
    public void load(T car) {
        if (cars.size()<=capacity) {
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
}