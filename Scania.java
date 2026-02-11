import java.awt.*;
import java.util.ArrayList;

public class Scania<Cargo> extends Car implements Loadable<Cargo>{

    // ---------------------------------- INSTANSVARIABLER ----------------------------------
    private ArrayList<Cargo> cargo;
    private int flakTilt;

    // ---------------------------------- KONSTRUKTOR ----------------------------------

    public Scania() {
        super(2,100, Color.blue, "Scania", 1800, 260);
        cargo = new ArrayList<>();
        flakTilt = 0;
    }

    // ---------------------------------- METODER ----------------------------------

    public int getFlakTilt() {
        return flakTilt;
    }

    public void incTilt(int amount) {
        if (getCurrentSpeed()==0) flakTilt = Math.min(flakTilt + amount,70);
    }

    public void decTilt(int amount) {
        if (getCurrentSpeed()==0) flakTilt = Math.max(flakTilt - amount, 0);
    }

    // ---------------------------------- OVERRIDES ----------------------------------

    @Override
    public void move() {
        if (flakTilt == 0) super.move();
    }

    @Override
    public void load(Cargo c) {
        cargo.add(c);
    }

    @Override
    public Cargo unload() {
        if (cargo.isEmpty()) return null;
        else return cargo.removeFirst();
    }
}