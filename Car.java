import java.awt.*;

public abstract class Car implements Movable {

    // INSTANSVARIABLER
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double xCoord = 0; // x-coordinate of the car
    private double yCoord = 0; // x-coordinate of the car
    private int dir = 0; // direction of the car (0 = -x, 1 = +y, 2 = +x, 3 = -y)


    //KONSTRUKTOR
    public Car(int doors, double enginepower, Color c, String modelname) {
        nrDoors = doors;
        enginePower = enginepower;
        color = c;
        modelName = modelname;
        xCoord = 0;
        yCoord = 0;
        int dir = 0;
        stopEngine();
    }

    // METODER
    // Get/Set-Metoder
    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    // Start/Stop - Engine
    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    //Abstrakta metoder
    public abstract double speedFactor();

    public void incrementSpeed(double amount){
        currentSpeed = Math.min(currentSpeed + speedFactor() * amount,enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(currentSpeed - speedFactor() * amount,0);
    }

    public void Move(){
        if (dir == 0) xCoord -= currentSpeed;
        else if (dir == 1) yCoord += currentSpeed;
        else if (dir == 2) yCoord -= currentSpeed;
        else if (dir == 3) xCoord += currentSpeed;
    }
    public void turnLeft(){
        dir -= 1;
        if (dir < 0) dir = 3;
    }
    public void turnRight(){
        dir += 1;
        if (dir > 3) dir = 0;
    }

    //Gas/break
    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}
