import java.awt.*;

public class CarTransport extends Car implements Loadable<Car> {
    // ---------------------------------- INSTANSVARIABLER ----------------------------------
    private Car[] load;
    private boolean trailerIsUp;
    private int nrLoadedCars;

    // ---------------------------------- KONSTRUKTOR ----------------------------------
    public CarTransport(double xCoord, double yCoord) {
        super(2, 100, Color.RED, "CarTransport", 1800, 220, xCoord, yCoord);
        nrLoadedCars = 0;
        load = new Car[6];
        trailerIsUp = true;
    }

    // ---------------------------------- METODER ----------------------------------
    public void trailerUp() {
        trailerIsUp = true;
    }
    public void trailerDown() {
        if (getCurrentSpeed()==0) trailerIsUp = false;
    }
    public int getNrLoadedCars() {
        return nrLoadedCars;
    }

    public Car[] getCars() {
        return load.clone();
    }

    public boolean gettrailerIsUp() {
        return trailerIsUp;
    }

    // ---------------------------------- OVERRIDES ----------------------------------
    @Override
    public void move() {
        if (trailerIsUp) {
            super.move();
            for (int i = 0; i < nrLoadedCars; i++) {
                load[i].follow(this.getPos(), getDirection());
            }
        }
    } // move

    @Override
    public void load(Car c) {
        if (this.getPos().distance(c.getPos()) < 7 && !trailerIsUp) {
            if ((nrLoadedCars < load.length) && (c.getClass() != CarTransport.class)) {
                if (c.getWidth() < (getWidth() - 20)
                        && c.getLength() < 600) {
                    load[nrLoadedCars] = c;
                    nrLoadedCars++;
                    c.attachCar();
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
                c.reverse();
                load[nrLoadedCars - 1] = null;
                nrLoadedCars--;
                c.deAttachCar();
            }
        return c;
    } //unload method
} //class carTransport
