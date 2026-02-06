public class BilVerkstad extends Verkstad{

    private Car[] cars;

    public BilVerkstad(int capacity) {
        super(capacity);
        cars = new Car[capacity];
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
