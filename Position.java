public class Position implements Cloneable {
    public double x;
    public double y;

    public Position(double xCoord, double yCoord) {
        x = xCoord;
        y = yCoord;
    }

    public double distance(Position otherPosition) {
        double diffX = (Math.abs(x - otherPosition.x));
        double diffY = (Math.abs(y - otherPosition.y));
        return Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2));
    }

    public void set(Position POS) {
        x = POS.x;
        y = POS.y;
    }
}