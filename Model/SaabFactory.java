package Model;

import java.util.Random;

public class SaabFactory implements CarFactory{

    @Override
    public Car createCar(double x, double y) {
        return new Saab95(x, y);
    }
}
