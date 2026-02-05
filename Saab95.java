import java.awt.*;

public final class Saab95 extends Car{
    private boolean turboOn;

    // KONSTRUKTOR
    public Saab95(){
        super(2, 125, Color.red, "Saab95", 480, 179);
	    turboOn = false;
    }

    // METODER
    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
