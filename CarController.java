import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController{

    TimerListener time;

    public CarController(TimerListener t){
        time = t;
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : time.cars) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : time.cars) {
            car.brake(gas);
        }
    }

    void startAllCars() {
        for (Car car : time.cars) {
            car.startEngine();
        }
    }
    void stopAllCars() {
        for (Car car : time.cars) {
            car.stopEngine();
        }
    }

    void turboOn() {
        for (Car car : time.cars) {
            if (car.getClass() == Saab95.class) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Car car : time.cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void flakTiltInc(int amount) {
        for (Car car : time.cars) {
            if (car instanceof Scania<?>) {
                ((Scania<?>) car).incTilt(amount);
                System.out.println(((Scania<?>) car).getFlakTilt());
            }
        }
    }

    void flakTiltDec(int amount) {
        for (Car car : time.cars) {
            if (car instanceof Scania<?>) {
                ((Scania<?>) car).decTilt(amount);
                System.out.println(((Scania<?>) car).getFlakTilt());
            }
        }
    }
}
