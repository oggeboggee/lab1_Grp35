import java.awt.*;

public class CarTransport extends Car {
    Car[] load;
    boolean trailerIsUp;
    int nrLoadedCars;

    public CarTransport() {
        super(2, 100, Color.RED, "CarTransport", 1800, 220);
        load = new Car[6];
        trailerIsUp = true;
    }

    @Override
    public void move() {
        if (trailerIsUp) {
            super.move();
            for (Car c : load) {
                c.setDirection(getDirection());
                c.setPosition(getPosition());
            }
        }
    }

    public void load(Car c) {

        if ((!trailerIsUp) && ((Math.abs(getPosition()[0] - c.getPosition()[0]) < 5) && (Math.abs(getPosition()[1] - c.getPosition()[1]) < 5))) {

            if ((nrLoadedCars < load.length) && (c.getClass() != CarTransport.class)) {
                if (c.getWidth() < (getWidth() - 20)) {
                    load[nrLoadedCars] = c;
                    nrLoadedCars++;
                }
            }
        }
    } // load


    public void unload() {
        if (!trailerIsUp) {
            if (nrLoadedCars > 0) {
                unloadmove(load[nrLoadedCars - 1]);
                load[nrLoadedCars - 1] = null;
                nrLoadedCars--;
            }
        }
    }


    public void unloadmove(Car c) {
        double newX = 0;
        double newY = 0;
        double xCoord = getPosition()[0];
        double yCoord = getPosition()[1];
        int dir = getDirection();

        if (dir == 2) {
            newX = getPosition()[0] - (c.getLength() / 2 + getLength() / 2);
            newY = yCoord;
        } else if (dir == 0) {
            newX = getPosition()[0] + (c.getLength() / 2 + getLength() / 2);
            newY = yCoord;
        } else if (dir == 1) {
            newY = getPosition()[1] - (c.getLength() / 2 + getLength() / 2);
            newX = xCoord;
        } else if (dir == 3) {
            newY = getPosition()[1] + (c.getLength() / 2 + getLength() / 2);
            newX = xCoord;
        }
        Double[] pos = {newX, newY};
        c.setPosition(pos);


    }
}
