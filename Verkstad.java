import java.util.ArrayList;

public abstract class Verkstad implements Loadable<Car> {

    private int xCord;
    private int yCord;
    private int capacity;
    
    public Verkstad(int capacity) {
        this.capacity = capacity;
    }

    public abstract void repair();
}