import java.awt.*;

public abstract class Car implements Movable {

    // INSTANSVARIABLER g
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double xCoord; // x-coordinate of the car
    private double yCoord; // x-coordinate of the car
    private int dir; // direction of the car (0 = -x, 1 = +y, 2 = +x, 3 = -y)
    private double length; // length of car in cm
    private double width; // width of car in cm
    private boolean isAttached;


    //KONSTRUKTOR
    public Car(int doors, double enginepower, Color c, String modelname, double len, double wid) {
        nrDoors = doors;
        enginePower = enginepower;
        color = c;
        modelName = modelname;
        xCoord = 0;
        yCoord = 0;
        dir = 0;
        length = len;
        width = wid;
        isAttached = false;

        stopEngine();
    }

    // METODER
    // Get/Set-Metoder
    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    // Start/Stop - Engine
    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    //Abstrakta metoder
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    };

    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(currentSpeed + speedFactor() * amount, enginePower);
    }

    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(currentSpeed - speedFactor() * amount, 0);
    }

    @Override
    public void move() {
        if      (dir == 0) xCoord -= currentSpeed;
        else if (dir == 1) yCoord += currentSpeed;
        else if (dir == 2) xCoord += currentSpeed;
        else if (dir == 3) yCoord -= currentSpeed;
    }

    @Override
    public void reverse() {
        if      (dir == 0) xCoord += 20;
        else if (dir == 1) yCoord -= 20 ;
        else if (dir == 2) xCoord -= 20;
        else if (dir == 3) yCoord += 20;
    }


    @Override
    public void turnLeft() {
        dir = (dir + 3) % 4;
    }

    @Override
    public void turnRight() {
        dir = (dir + 1) % 4;
    }

    public int getDirection() {
        return dir;
    }

    public Double[] getPosition() {
        return new Double[]{xCoord, yCoord};
    }

    public void follow(Car other) {
        if(isAttached) {
            this.xCoord = other.xCoord;
            this.yCoord = other.yCoord;
            this.dir = other.dir;
        }
    }

    public void attachCar() {
        isAttached = true;
    }
    public void deAttachCar() {
        isAttached = false;
    }

    public void gas(double amount) {
        double beforeGas = getCurrentSpeed();
        if (amount < 0 || amount > 1) {
            throw new IllegalArgumentException("illegal gas-value");
        } else {
            incrementSpeed(amount);
            if (getCurrentSpeed() - beforeGas <0 ) {
                currentSpeed = beforeGas;
            }
        }

    }

    public void brake(double amount) {
        double beforeBreake = getCurrentSpeed();
        if ((amount < 0 || amount > 1)) {
            throw new IllegalArgumentException("illegal gas-value");
        }
        else {decrementSpeed(amount);
            if (getCurrentSpeed() - beforeBreake > 0) {
                currentSpeed = beforeBreake;
            }
        }
    }
} // class Car