package Model;

import java.util.Random;

public class ScaniaFactory implements CarFactory{
    @Override
    public Car createCar(double x, double y) {
        return new Scania<Cargo>(x, y);
    }
}
