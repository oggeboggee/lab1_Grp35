public class Position implements Cloneable {
    private double x;
    private double y;

    public Position(double xCoord, double yCoord) {
        x = xCoord;
        y = yCoord;
    }

    public double distance(Position otherPosition) {
        double diffX = (Math.abs(x - otherPosition.x));
        double diffY = (Math.abs(y - otherPosition.y));
        return Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void set(Position POS) {
        x = POS.x;
        y = POS.y;
    }

    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }
}