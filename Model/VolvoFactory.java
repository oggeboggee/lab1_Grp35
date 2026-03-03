package Model;

import java.util.Random;

public class VolvoFactory implements CarFactory{

    @Override
    public Car createCar(double x, double y) {

        return new Volvo240(x, y);
    }
}
