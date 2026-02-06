public class VolvoVerkstad extends Verkstad{

    private Volvo240[] cars;

    public VolvoVerkstad(int capacity) {
        super(capacity);
        cars = new Volvo240[capacity];
    }

    @Override
    public void repair() {

    }

    @Override
    public void load(Car car) {

    }

    @Override
    public Car unload() {
        return null;
    }
}
