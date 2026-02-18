import java.awt.*;
import java.util.ArrayList;

public abstract class Car implements Movable {

    // ---------------------------------- KLASSVARIABEL----------------------------------
    private static ArrayList<Car> allCars = new ArrayList<>(100);

    // ---------------------------------- INSTANSVARIABLER ----------------------------------
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    public Position pos;
    private int dir; // direction of the car (0 = -x, 1 = +y, 2 = +x, 3 = -y)
    //
    // btw +y är nedåt så jag switchade turnLeft() och turnRight() metoderna
    //
    private double length; // length of car in cm
    private double width; // width of car in cm
    private boolean isAttached;
    private final int regNr;
    private boolean EngineOn;

    public static Car getCar(int i) {
        return allCars.get(i);
    }

    // ---------------------------------- KONSTRUKTOR ----------------------------------
    public Car(int doors, double enginepower, Color c, String modelname, double len, double wid, double xCoord, double yCoord) {
        allCars.add(this);

        nrDoors = doors;
        enginePower = enginepower;
        color = c;
        modelName = modelname;
        pos = new Position(xCoord, yCoord);
        dir = 0;
        length = len;
        width = wid;
        isAttached = false;
        regNr = allCars.indexOf(this);
        stopEngine();
    }

    // ---------------------------------- GET/SET_METODER ------------------------------------
    public int getRegNr() {
        return regNr;
    }

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

    public int getDirection() {
        return dir;
    }

    public void attachCar() {
        isAttached = true;
    }

    public void deAttachCar() {
        isAttached = false;
    }


    // ---------------------------------- SPEED_METODER ----------------------------------
    public void startEngine() {
        EngineOn = true;
    }

    public void stopEngine() {
        currentSpeed = 0;
        EngineOn = false;
    }

    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }

    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(currentSpeed + speedFactor() * amount, enginePower);
    }

    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(currentSpeed - speedFactor() * amount, 0);
    }

    public void gas(double amount) {
        if (EngineOn) {
            double beforeGas = getCurrentSpeed();
            if (amount < 0 || amount > 1) {
                throw new IllegalArgumentException("illegal gas-value");
            } else {
                incrementSpeed(amount);
                if (getCurrentSpeed() - beforeGas < 0) {
                    currentSpeed = beforeGas;
                }
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

    // ---------------------------------- MOVABLE_METODER ----------------------------------
    @Override
    public void move() {
        if      (dir == 0) {
            if (pos.x - currentSpeed >= 0) pos.x -= currentSpeed;
            else {
                pos.x = 0;
                vänd();
            }
        }
        else if (dir == 3) {
            if (pos.y - currentSpeed >= 0) pos.y -= currentSpeed;
            else {
                pos.y = 0;
                vänd();
            }
        }
        else if (dir == 2) {
            if (pos.x + currentSpeed <= 700) pos.x += currentSpeed;
            else {
                pos.x = 700;
                vänd();
            }
        }
        else if (dir == 1) {
            if (pos.y + currentSpeed <= 500) pos.y += currentSpeed;
            else {
                pos.y = 500;
                vänd();
            }
        }
    }
    private void vänd(){
        stopEngine();
        turnRight();
        turnRight();
        startEngine();
    }

    @Override
    public void reverse() {
        if      (dir == 0) pos.x += 20;
        else if (dir == 1) pos.y -= 20 ;
        else if (dir == 2) pos.x -= 20;
        else if (dir == 3) pos.y += 20;
    }

    @Override
    public void turnLeft() {
        dir = (dir + 1) % 4;
    }

    @Override
    public void turnRight() {
        dir = (dir + 3) % 4;
    }

    public void follow(Position POS, int direction) {
        if(isAttached) {
            pos.set(POS);
            dir = direction;
        }
    }
} // class Car