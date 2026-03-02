package Model;

import java.util.Random;

public class CarFactory {
    Car car;

    public Car createCar() {

        Random r = new Random();
        int r1 = r.nextInt(2);

        double x1 = r.nextDouble(700);
        double y1 = r.nextDouble(500);

        switch (r1) {
            case 0:
                car = new Volvo240(x1, y1);
                break;
            case 1:
                car = new Saab95(x1, y1);
                break;
            case 2:
                car = new Scania(x1, y1);
                break;
        }
        return car;

    }

}
