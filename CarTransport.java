import java.awt.*;

public class CarTransport extends Car implements Loadable<Car> {
    // ---------------------------------- INSTANSVARIABLER ----------------------------------
    Car[] load;
    boolean trailerIsUp;
    int nrLoadedCars;

    // ---------------------------------- KONSTRUKTOR ----------------------------------
    public CarTransport() {
        super(2, 100, Color.RED, "CarTransport", 1800, 220);
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

    // Den här metoden skulle kanske va i car? Eller position? Allt med en position borde kunna kolla hur nära de är
    //      något annat med en position?
    public double carDistance(Car c) {
        double diffX =  (Math.abs(getPosition()[0] - c.getPosition()[0]));
        double diffY =  (Math.abs(getPosition()[1] - c.getPosition()[1]));
        return Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY,2));
    }

    // ---------------------------------- OVERRIDES ----------------------------------
    @Override
    public void move() {
        if (trailerIsUp) {
            super.move();
            for (int i = 0; i < nrLoadedCars; i++) {
                load[i].follow(this);
            }
        }
    } // move

    @Override
    public void load(Car c) {
        if (carDistance(c) < 7 && !trailerIsUp) {
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
