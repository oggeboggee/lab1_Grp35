import java.awt.*;
import java.util.ArrayList;

public class Scania<T> extends Car implements Loadable<T>{

    private ArrayList<T> last;
    private int flakTilt;

    // KONSTRUKTOR
    public Scania() {
        super(2,100, Color.blue, "Scania", 1800, 260);
        last = new ArrayList<>();
        flakTilt = 0;
    }

    public int getFlakTilt() {
        return flakTilt;
    }

    // METODER
    public void incTilt(int amount) {
        if (getCurrentSpeed()==0) flakTilt = Math.min(flakTilt + amount,70);
    }
    public void decTilt(int amount) {
        if (getCurrentSpeed()==0) flakTilt = Math.max(flakTilt - amount, 0);
    }

    @Override
    public void move() {
        if (flakTilt == 0) super.move();
    }

    @Override
    public void load(T t) {
        last.add(t);
    }

    @Override
    public T unload() {
        if (last.isEmpty()) return null;
        else return last.removeFirst();
    }
}