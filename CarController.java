/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

import Model.Car;
import Model.CurrentState;
import Model.Saab95;
import Model.Scania;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarController implements ActionListener {

    CurrentState currentState;

    public CarController(CurrentState t){
        currentState = t;
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : currentState.getCars()) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : currentState.getCars()) {
            car.brake(gas);
        }
    }

    void startAllCars() {
        for (Car car : currentState.getCars()) {
            car.startEngine();
        }
    }
    void stopAllCars() {
        for (Car car : currentState.getCars()) {
            car.stopEngine();
        }
    }

    void turboOn() {
        for (Car car : currentState.getCars()) {
            if (car.getClass() == Saab95.class) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Car car : currentState.getCars()) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void flakTiltInc(int amount) {
        for (Car car : currentState.getCars()) {
            if (car instanceof Scania<?>) {
                ((Scania<?>) car).incTilt(amount);
                System.out.println(((Scania<?>) car).getFlakTilt());
            }
        }
    }

    void flakTiltDec(int amount) {
        for (Car car : currentState.getCars()) {
            if (car instanceof Scania<?>) {
                ((Scania<?>) car).decTilt(amount);
                System.out.println(((Scania<?>) car).getFlakTilt());
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        currentState.update();
    }
}
