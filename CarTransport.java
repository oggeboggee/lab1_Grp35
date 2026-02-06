import java.awt.*;

public class CarTransport extends Car implements Loadable<Car> {
    Car[] load;
    boolean trailerIsUp;
    int nrLoadedCars;

    public CarTransport() {
        super(2, 100, Color.RED, "CarTransport", 1800, 220);
        load = new Car[6];
        trailerIsUp = true;
    }

    public void trailerUp() {
        if(!trailerIsUp) trailerIsUp = true;
    }
    public void trailerDown() {
        if (trailerIsUp) trailerIsUp = false;
    }

    @Override
    public void move() {
        if (trailerIsUp) {
            super.move();
            for (int i = 0; i < nrLoadedCars; i++) {
                load[i].setDirection(getDirection());
                load[i].setPosition(getPosition());
            }
        }
    } // move

    public double carDistance(Car c) {
        double diffX =  (Math.abs(getPosition()[0] - c.getPosition()[0]));
        double diffY =  (Math.abs(getPosition()[1] - c.getPosition()[1]));
        return Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY,2));

    }

    @Override
    public void load(Car c) {
        if (carDistance(c) < 7) {
            if ((nrLoadedCars < load.length) && (c.getClass() != CarTransport.class)) {
                if (c.getWidth() < (getWidth() - 20)) {
                    load[nrLoadedCars] = c;
                    nrLoadedCars++;
                }
            }
        }
    } // load


    /**
     * unload the car with the highest index in this load, unload it just behind the CarTransport
     *
     * @return the unloaded car if trailer not is empty and trailer is down before the method is called
     */

    @Override
    public Car unload() {
        Car c = null;
        if ((!trailerIsUp) && (nrLoadedCars > 0)) {
                c = load[nrLoadedCars - 1];
                unloadmove(c);
                load[nrLoadedCars - 1] = null;
                nrLoadedCars--;
            }
        return c;
    } //unload method


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

    } //unloadmove

} //class carTransport
