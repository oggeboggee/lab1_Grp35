import java.awt.*;

public final class Volvo240 extends Car{
    private double trimFactor;

    // ---------------------------------- KONSTRUKTOR ----------------------------------
    public Volvo240(double xCoord, double yCoord){
        super(4, 100,  Color.BLACK, "Volvo240", 480, 171, xCoord, yCoord);
        trimFactor = 1.25; //1.25

    }

    // ---------------------------------- METODER ----------------------------------
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}
