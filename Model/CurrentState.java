package Model;

import java.util.ArrayList;
import java.util.Random;


public class CurrentState {
    final int maxCars = 13;
    // Current State
    private ArrayList<Car> cars = new ArrayList<>();
    private Verkstad<Volvo240> volvo240Verkstad = new Verkstad<>(6, 300, 300);
    // Observers
    private ArrayList<signalObserver> obs = new ArrayList<>();
    private CarFactory factory = new VolvoFactory();

    Random random = new Random();

    public ArrayList<Car> getCars() {
        return cars;
    }

    public Verkstad<Volvo240> getVolvo240Verkstad() {
        return volvo240Verkstad;
    }

    public ArrayList<signalObserver> getObs() {
        return obs;
    }

    // Updatera State
    public void update() {
        for (Car car : cars) {
            car.move();
            if (car instanceof Volvo240 && car.getPos().distance(volvo240Verkstad.pos)<10
                    && !car.getIsAttached()){
                volvo240Verkstad.load((Volvo240) car);
                car.stopEngine();
                System.out.println(volvo240Verkstad.nrOfCars());
            }
            notifyObservers();
        }
    }

    public void addCar() {
        int randomInt = random.nextInt(3);

        double x = random.nextDouble(700);
        double y = random.nextDouble(500);

        if (cars.size()<maxCars) {
            switch (randomInt) {
                case 0:
                    factory = new VolvoFactory();
                    break;
                case 1:
                    factory = new SaabFactory();
                    break;
                case 2:
                    factory = new ScaniaFactory();
                    break;
            }
            cars.add(factory.createCar(x,y));
            notifyObservers();
        }
    }

    public void removeCar() {
        if (cars.size()>0) {
            Car car = cars.getLast();
            notifyObservers(car.getPos());
            cars.removeLast();
        }
    }

    public void notifyObservers() {
        for (signalObserver observer : obs) {
            observer.notifyOb();
        }
    }
    public void notifyObservers(Position pos) {
        for (signalObserver observer : obs) {
            observer.notifyOb(pos);
        }
    }
}