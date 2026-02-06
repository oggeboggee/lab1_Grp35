import java.awt.*;

public class Scania<T> extends Car {

    private int flakTilt;

    // KONSTRUKTOR
    public Scania() {
        super(2,100, Color.blue, "Scania", 1000, 260);
        flakTilt = 0;
    }

    // METODER
    public void incTilt(int amount) {
        flakTilt = Math.min(flakTilt + amount,70);
    }
    public void decTilt(int amount) {
        flakTilt = Math.max(flakTilt - amount, 0);
    }

    @Override
    public void move() {
        if (flakTilt ==0) super.move();
    }
}