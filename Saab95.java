import java.awt.*;

public class Saab95 extends Car{

    public boolean turboOn;

    // KONSTRUKTOR
    public Saab95(){
        super();
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        modelName = "Saab95";

	    turboOn = false;
        stopEngine();
    }

    // METODER
    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }
}
