import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer;

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();
    //Verkstad
    Verkstad<Volvo240> volvo240Verkstad = new Verkstad<>(6, 300, 300);

    public CarController(){
        timer = new Timer(delay, new TimerListener(this));
    }

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240(0, 300));
        cc.cars.add(new Saab95(0, 100));
        cc.cars.add(new Scania<Cargo>(0, 400));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
            if (car instanceof Volvo240 && car.getPos().distance(volvo240Verkstad.pos)<10
                    && !car.getIsAttached()){
                volvo240Verkstad.load((Volvo240) car);
                car.stopEngine();
                System.out.println(volvo240Verkstad.nrOfCars());
            }
            // repaint() calls the paintComponent method of the panel
            frame.drawPanel.repaint();
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(gas);
        }
    }

    void startAllCars() {
        for (Car car : cars) {
            car.startEngine();
        }
    }
    void stopAllCars() {
        for (Car car : cars) {
            car.stopEngine();
        }
    }

    void turboOn() {
        for (Car car : cars) {
            if (car.getClass() == Saab95.class) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void flakTiltInc(int amount) {
        for (Car car : cars) {
            if (car instanceof Scania<?>) {
                ((Scania<?>) car).incTilt(amount);
                System.out.println(((Scania<?>) car).getFlakTilt());
            }
        }
    }

    void flakTiltDec(int amount) {
        for (Car car : cars) {
            if (car instanceof Scania<?>) {
                ((Scania<?>) car).decTilt(amount);
                System.out.println(((Scania<?>) car).getFlakTilt());
            }
        }
    }
}
