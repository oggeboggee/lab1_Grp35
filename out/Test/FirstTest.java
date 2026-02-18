import junit.framework.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.Objects;

// Hej
public class FirstTest {

    Saab95 saab = new Saab95();
    Volvo240 volvo = new Volvo240();

    /*
    @Test
    public void TestGetCar(){
        Assert.assertEquals(Car.getCar(0), saab);
        Assert.assertEquals(Car.getCar(1), volvo);
        Assert.assertEquals(Car.getCar(10), car7);
    }
    */

    @Test
    public void testMain(){
        Main.main();
    }

    @Test
    public void TestGetNrDoorsSaab() {
        Assert.assertTrue(saab.getNrDoors() == 2);
    }

    @Test
    public void TestGetNrDoorsVolvo() {
        Assert.assertTrue(volvo.getNrDoors() == 4);
    }

    @Test
    public void TestEnginePowerSaab() {
        Assert.assertTrue(saab.getEnginePower() == 125);
    }

    @Test
    public void TestEnginePowerVolvo() {
        Assert.assertTrue(volvo.getEnginePower() == 100);
    }

    @Test
    public void TestCarSize() {
        Assert.assertTrue(volvo.getLength() == 480);
        Assert.assertTrue(saab.getLength() == 480);
        Assert.assertTrue(volvo.getWidth() == 171);
        Assert.assertTrue(saab.getWidth() == 179);
    }

    @Test
    public void TestColor(){
        Assert.assertTrue(volvo.getColor() == Color.BLACK);
        Assert.assertTrue(saab.getColor() == Color.red);
        volvo.setColor(Color.cyan);
        saab.setColor(Color.BLUE);
        Assert.assertTrue(volvo.getColor() == Color.cyan);
        Assert.assertTrue(saab.getColor() == Color.BLUE);
    }

    @Test
    public void TestFollow(){
        volvo.startEngine();
        volvo.gas(1);
        volvo.turnLeft();
        volvo.move();
        Assert.assertFalse(volvo.getPosition()[1].equals(saab.getPosition()[1]));
        Assert.assertTrue(volvo.getDirection() != saab.getDirection());
        volvo.follow(saab.getPosition(), saab.getDirection());
        Assert.assertFalse(volvo.getPosition()[1].equals(saab.getPosition()[1]));
        Assert.assertTrue(volvo.getDirection() != saab.getDirection());
        volvo.attachCar();
        volvo.follow(saab.getPosition(), saab.getDirection());
        Assert.assertTrue(volvo.getPosition()[1].equals(saab.getPosition()[1]));
        Assert.assertTrue(volvo.getDirection() == saab.getDirection());
        volvo.deAttachCar();
        volvo.turnLeft();
        volvo.move();
        volvo.follow(saab.getPosition(), saab.getDirection());
        Assert.assertFalse(volvo.getPosition()[1].equals(saab.getPosition()[1]));
        Assert.assertTrue(volvo.getDirection() != saab.getDirection());

    }

    @Test
    public void TestReverse(){
        Assert.assertTrue(volvo.getPosition()[0] == 0);
        Assert.assertTrue(volvo.getPosition()[1] == 0);
        volvo.reverse();
        Assert.assertTrue(volvo.getPosition()[0] == 20);
        Assert.assertTrue(volvo.getPosition()[1] == 0);
        volvo.turnLeft();
        volvo.reverse();
        Assert.assertTrue(volvo.getPosition()[0] == 20);
        Assert.assertTrue(volvo.getPosition()[1] == 20);
        volvo.turnLeft();
        volvo.reverse();
        Assert.assertTrue(volvo.getPosition()[0] == 0);
        Assert.assertTrue(volvo.getPosition()[1] == 20);
        volvo.turnLeft();
        volvo.reverse();
        Assert.assertTrue(volvo.getPosition()[0] == 0);
        Assert.assertTrue(volvo.getPosition()[1] == 0);

    }

    @Test
    public void TestGas() {
        saab.startEngine();
        double speedBefore = saab.getCurrentSpeed();
        saab.gas(1);
        Assert.assertTrue(saab.getCurrentSpeed() > speedBefore);
        saab.stopEngine();
    }

    @Test
    public void TestBrake() {
        saab.startEngine();
        saab.gas(1);
        double speedBefore = saab.getCurrentSpeed();
        saab.brake(0.5);
        Assert.assertTrue(saab.getCurrentSpeed() < speedBefore);
        saab.stopEngine();
    }

    @Test
    public void TestGetDirection() {
        Assert.assertTrue(saab.getDirection() == 0);
        Assert.assertTrue(volvo.getDirection() == 0);
    }

    @Test
    public void TestTurnLeft() {
        saab.turnLeft();
        Assert.assertTrue(saab.getDirection() == 3);
        saab.turnLeft();
        Assert.assertTrue(saab.getDirection() == 2);
        saab.turnLeft();
        Assert.assertTrue(saab.getDirection() == 1);
        saab.turnLeft();
        Assert.assertTrue(saab.getDirection() == 0);

        volvo.turnLeft();
        Assert.assertTrue(volvo.getDirection() == 3);
        volvo.turnLeft();
        Assert.assertTrue(volvo.getDirection() == 2);
        volvo.turnLeft();
        Assert.assertTrue(volvo.getDirection() == 1);
        volvo.turnLeft();
        Assert.assertTrue(volvo.getDirection() == 0);
    }

    @Test
    public void TestTurnRight() {
        saab.turnRight();
        Assert.assertTrue(saab.getDirection() == 1);
        saab.turnRight();
        Assert.assertTrue(saab.getDirection() == 2);
        saab.turnRight();
        Assert.assertTrue(saab.getDirection() == 3);
        saab.turnRight();
        Assert.assertTrue(saab.getDirection() == 0);

        volvo.turnRight();
        Assert.assertTrue(volvo.getDirection() == 1);
        volvo.turnRight();
        Assert.assertTrue(volvo.getDirection() == 2);
        volvo.turnRight();
        Assert.assertTrue(volvo.getDirection() == 3);
        volvo.turnRight();
        Assert.assertTrue(volvo.getDirection() == 0);
    }

    @Test
    public void TestMove() {
        saab.gas(1);
        saab.move();
        Assert.assertTrue(saab.getPosition()[0] == -(saab.getCurrentSpeed()));
        Assert.assertTrue(saab.getPosition()[1] == 0);
        saab.turnLeft();
        saab.move();
        Assert.assertTrue(saab.getPosition()[1] == -(saab.getCurrentSpeed()));
        Assert.assertTrue(saab.getPosition()[0] == -(saab.getCurrentSpeed()));
        saab.turnLeft();
        saab.move();
        Assert.assertTrue(saab.getPosition()[0] == 0);
        Assert.assertTrue(saab.getPosition()[1] == -(saab.getCurrentSpeed()));
        saab.turnLeft();
        saab.move();
        Assert.assertTrue(saab.getPosition()[1] == 0);
        Assert.assertTrue(saab.getPosition()[0] == 0);

        volvo.gas(1);
        volvo.move();
        Assert.assertTrue(volvo.getPosition()[0] == -(volvo.getCurrentSpeed()));
        Assert.assertTrue(volvo.getPosition()[1] == 0);
        volvo.turnLeft();
        volvo.move();
        Assert.assertTrue(volvo.getPosition()[1] == -(volvo.getCurrentSpeed()));
        Assert.assertTrue(volvo.getPosition()[0] == -(volvo.getCurrentSpeed()));
        volvo.turnLeft();
        volvo.move();
        Assert.assertTrue(volvo.getPosition()[0] == 0);
        Assert.assertTrue(volvo.getPosition()[1] == -(volvo.getCurrentSpeed()));
        volvo.turnLeft();
        volvo.move();
        Assert.assertTrue(volvo.getPosition()[1] == 0);
        Assert.assertTrue(volvo.getPosition()[0] == 0);
    }

    @Test
    public void testturbo(){
        Assert.assertFalse(saab.getTurboState());
        saab.setTurboOn();
        Assert.assertTrue(saab.getTurboState());
        saab.setTurboOff();
        Assert.assertFalse(saab.getTurboState());
    }
    @Test
    public void testSpeedFactor(){
        Assert.assertTrue(volvo.speedFactor() == 1.25);
        Assert.assertTrue(saab.speedFactor() == 1.25);
        saab.setTurboOn();
        Assert.assertTrue(saab.speedFactor() == 1.3 * 1.25);
    }


    //SCANIA-TESTER
    Scania<Cargo> scania = new Scania<>();


    @Test
    public void testscaniaload(){
        Assert.assertNull(scania.unload());
        scania.load(Cargo.WOODPALLET);
        Assert.assertEquals(scania.unload(), Cargo.WOODPALLET);
    }

    @Test
    public void testFlaktilt() {
        // INC/DEC-TILT with currentSpeed = 0
        Assert.assertTrue(scania.getFlakTilt() == 0);
        scania.incTilt(50);
        Assert.assertTrue(scania.getFlakTilt() != 0);
        scania.incTilt(50);
        Assert.assertTrue(scania.getFlakTilt() == 70);
        scania.decTilt(80);
        Assert.assertTrue(scania.getFlakTilt() == 0);
        // With currentSpeed > 0
        scania.startEngine();
        scania.gas(1);
        scania.incTilt(50);
        Assert.assertTrue(scania.getFlakTilt() == 0);
        scania.stopEngine();
    }

    @Test
    public void testScaniaMove() {
        double x = scania.getPosition()[0];
        double y = scania.getPosition()[1];

        //Testar om den rör sig när tilten är 0
        scania.startEngine();
        scania.gas(1);
        scania.move();
        Assert.assertTrue(x != scania.getPosition()[0]
                || y != scania.getPosition()[1]);

        // Spara ny pos
        x = scania.getPosition()[0];
        y = scania.getPosition()[1];

        // Move med tiltat flak
        scania.stopEngine();
        scania.incTilt(50);
        scania.startEngine();
        scania.gas(1);
        scania.move();
        Assert.assertTrue(scania.getPosition()[0] == x);
        Assert.assertTrue(scania.getPosition()[1] == y);
    }


    // VERKSATDTESTER
    Verkstad<Car> verkstad = new Verkstad<>(5);
    Verkstad<Volvo240> volvo240Verkstad = new Verkstad<>(5);
    Verkstad<Saab95> saab95Verkstad = new Verkstad<>(3);

    @Test
    public void testVerkstad() {
        // Hämta ut från tom verkstad
        Assert.assertTrue(volvo240Verkstad.unload(volvo.getRegNr()) == null);
        // Testa hämta ut en saab som inte finns i verkstaden
        volvo240Verkstad.load(volvo);
        Assert.assertTrue(volvo240Verkstad.unload(saab.getRegNr()) == null);

        verkstad.load(volvo);
        verkstad.load(saab);
        Car c = verkstad.unload(volvo.getRegNr());
        Assert.assertTrue(c.getClass() == Volvo240.class);
        c = verkstad.unload(saab.getRegNr());
        Assert.assertTrue(c.getClass() != Volvo240.class);


        // Lämna in på en full
        saab95Verkstad.load(new Saab95());
        saab95Verkstad.load(new Saab95());
        saab95Verkstad.load(new Saab95());
        saab95Verkstad.load(new Saab95());
        // Capacity är 3
        Assert.assertTrue(saab95Verkstad.nrOfCars() == 3);
    }

    CarTransport carTransport = new CarTransport();

    @Test
    //Testar om värdet för trailerIsUp får rätt värden
    public void FlakCarTransport() {
        Assert.assertTrue(carTransport.gettrailerIsUp() == true);
        carTransport.trailerUp();
        Assert.assertTrue(carTransport.gettrailerIsUp() == true);
        carTransport.trailerDown();
        Assert.assertTrue(carTransport.gettrailerIsUp() == false);

    }

    @Test
    //testar om rampen kan vara nere medans CarTransport kör
    public void testMoveCarTransport() {
        double xCT = carTransport.getPosition()[0];
        double yCT = carTransport.getPosition()[1];
        //kontrollerar så att positionen är [0,0]
        Assert.assertTrue(xCT == 0 && yCT == 0);


        //testar att köra med rampen nere
        carTransport.trailerDown();
        carTransport.startEngine();
        carTransport.gas(1);
        carTransport.move();
        Assert.assertTrue(carTransport.getPosition()[0] == xCT && carTransport.getPosition()[1] == yCT);

    }


    Volvo240 car1 = new Volvo240();
    Volvo240 car2 = new Volvo240();
    Volvo240 car3 = new Volvo240();
    Volvo240 car4 = new Volvo240();
    Volvo240 car5 = new Volvo240();
    Volvo240 car6 = new Volvo240();
    Volvo240 car7 = new Volvo240();

    @Test
    public void loadCarOnCarTransport() {
        carTransport.trailerDown();
        carTransport.load(car1);

        Assert.assertTrue(carTransport.getCars()[0] == car1);
        carTransport.load(car2);
        carTransport.load(car3);
        carTransport.load(car4);
        carTransport.load(car5);
        carTransport.load(car6);
        Assert.assertTrue(carTransport.getCars()[0] == car1);
        Assert.assertTrue(carTransport.getCars()[1] == car2);
        Assert.assertTrue(carTransport.getNrLoadedCars() == 6);
        Assert.assertTrue(carTransport.unload() == car6);
        carTransport.unload();
        carTransport.unload();
        Assert.assertTrue(carTransport.getNrLoadedCars() == 3);
        carTransport.unload();
        carTransport.unload();

        Assert.assertTrue(carTransport.getNrLoadedCars() == 1);
        Assert.assertTrue(carTransport.unload() == car1);
        Assert.assertTrue(carTransport.getNrLoadedCars() == 0);
        Assert.assertNull(carTransport.unload());
        Assert.assertTrue(carTransport.getNrLoadedCars() == 0);
    }

}
