import java.awt.*;

public abstract class Car {

    // INSTANSVARIABLER
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name


    //KONSTRUKTOR
    public Car(int doors, double enginepower, Color c, String modelname) {
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
