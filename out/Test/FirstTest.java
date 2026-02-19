import junit.framework.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.Objects;

public class FirstTest {

    Saab95 saab = new Saab95(0, 0);
    Volvo240 volvo = new Volvo240(0, 0);


    @Test
    public void TestGetCar(){
        /*
        Assert.assertEquals(Car.getCar(0), saab);
        Assert.assertEquals(Car.getCar(1), volvo);
        Assert.assertEquals(Car.getCar(10), car7);
        */
        Car car = Car.getCar(0);
    }

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
        Assert.assertTrue(volvo.getPos().getY() != saab.getPos().getY());
        Assert.assertTrue(volvo.getDirection() != saab.getDirection());
        volvo.follow(saab.getPos(), saab.getDirection());
        Assert.assertTrue(volvo.getPos().getY() != saab.getPos().getY());
        Assert.assertTrue(volvo.getDirection() != saab.getDirection());
        volvo.attachCar();
        volvo.follow(saab.getPos(), saab.getDirection());
        Assert.assertTrue(volvo.getPos().getY() == saab.getPos().getY());
        Assert.assertTrue(volvo.getDirection() == saab.getDirection());
        volvo.deAttachCar();
        volvo.startEngine();
        volvo.gas(1);
        volvo.turnLeft();
        volvo.move();
        volvo.follow(saab.getPos(), saab.getDirection());
        Assert.assertTrue(volvo.getPos().getY() != saab.getPos().getY());
        Assert.assertTrue(volvo.getDirection() != saab.getDirection());

    }

    @Test
    public void TestReverse(){
        Assert.assertTrue(volvo.getPos().getX() == 0);
        Assert.assertTrue(volvo.getPos().getY() == 0);
        volvo.reverse();
        Assert.assertTrue(volvo.getPos().getX() == 20);
        Assert.assertTrue(volvo.getPos().getY() == 0);
        volvo.turnRight();
        volvo.reverse();
        Assert.assertTrue(volvo.getPos().getX() == 20);
        Assert.assertTrue(volvo.getPos().getY() == 20);
        volvo.turnRight();
        volvo.reverse();
        Assert.assertTrue(volvo.getPos().getX() == 0);
        Assert.assertTrue(volvo.getPos().getY() == 20);
        volvo.turnRight();
        volvo.reverse();
        Assert.assertTrue(volvo.getPos().getX() == 0);
        Assert.assertTrue(volvo.getPos().getY() == 0);

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
    public void TestTurnRight() {
        saab.turnRight();
        Assert.assertTrue(saab.getDirection() == 3);
        saab.turnRight();
        Assert.assertTrue(saab.getDirection() == 2);
        saab.turnRight();
        Assert.assertTrue(saab.getDirection() == 1);
        saab.turnRight();
        Assert.assertTrue(saab.getDirection() == 0);

        volvo.turnRight();
        Assert.assertTrue(volvo.getDirection() == 3);
        volvo.turnRight();
        Assert.assertTrue(volvo.getDirection() == 2);
        volvo.turnRight();
        Assert.assertTrue(volvo.getDirection() == 1);
        volvo.turnRight();
        Assert.assertTrue(volvo.getDirection() == 0);
    }

    @Test
    public void TestTurnLeft() {
        saab.turnLeft();
        Assert.assertTrue(saab.getDirection() == 1);
        saab.turnLeft();
        Assert.assertTrue(saab.getDirection() == 2);
        saab.turnLeft();
        Assert.assertTrue(saab.getDirection() == 3);
        saab.turnLeft();
        Assert.assertTrue(saab.getDirection() == 0);

        volvo.turnLeft();
        Assert.assertTrue(volvo.getDirection() == 1);
        volvo.turnLeft();
        Assert.assertTrue(volvo.getDirection() == 2);
        volvo.turnLeft();
        Assert.assertTrue(volvo.getDirection() == 3);
        volvo.turnLeft();
        Assert.assertTrue(volvo.getDirection() == 0);
    }

    @Test
    public void TestMove() {
        saab.startEngine();
        saab.gas(1);
        saab.turnLeft();
        saab.move();
        Assert.assertTrue(saab.getPos().getX() == 0);
        Assert.assertTrue(saab.getPos().getY() == 1.25);
        saab.turnLeft();
        saab.move();
        Assert.assertTrue(saab.getPos().getX() == 1.25);
        Assert.assertTrue(saab.getPos().getY() == 1.25);
        saab.turnLeft();
        saab.move();
        Assert.assertTrue(saab.getPos().getX() == 1.25);
        Assert.assertTrue(saab.getPos().getY() == 0);
        saab.turnLeft();
        saab.move();
        Assert.assertTrue(saab.getPos().getX() == 0);
        Assert.assertTrue(saab.getPos().getY() == 0);

        volvo.startEngine();
        volvo.gas(1);
        volvo.turnLeft();
        volvo.move();
        Assert.assertTrue(volvo.getPos().getX() == 0);
        Assert.assertTrue(volvo.getPos().getY() == 1.25);
        volvo.turnLeft();
        volvo.move();
        Assert.assertTrue(volvo.getPos().getX() == 1.25);
        Assert.assertTrue(volvo.getPos().getY() == 1.25);
        volvo.turnLeft();
        volvo.move();
        Assert.assertTrue(volvo.getPos().getX() == 1.25);
        Assert.assertTrue(volvo.getPos().getY() == 0);
        volvo.turnLeft();
        volvo.move();
        Assert.assertTrue(volvo.getPos().getX() == 0);
        Assert.assertTrue(volvo.getPos().getY() == 0);
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
    Scania<Cargo> scania = new Scania<>(0, 0);


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
        Position pos = new Position(scania.getPos().getX(), scania.getPos().getY());
        //Testar om den rör sig när tilten är 0
        scania.startEngine();
        scania.gas(1);
        scania.turnLeft();
        scania.move();
        //Assert.assertTrue(pos.getX() != scania.getPos().getX() || pos.getY() != scania.getPos().getY());
        Assert.assertTrue(scania.getPos().distance(pos) != 0);

        // Spara ny pos
        pos = new Position(scania.getPos().getX(), scania.getPos().getY());

        // Move med tiltat flak
        scania.stopEngine();
        scania.incTilt(50);
        scania.startEngine();
        scania.gas(1);
        scania.move();
        Assert.assertTrue(scania.getPos().getX() == pos.getX());
        Assert.assertTrue(scania.getPos().getY() == pos.getY());
    }


    // VERKSATDTESTER
    Verkstad<Car> verkstad = new Verkstad<>(5, 0, 0);
    Verkstad<Volvo240> volvo240Verkstad = new Verkstad<>(5, 0, 0);
    Verkstad<Saab95> saab95Verkstad = new Verkstad<>(3, 0, 0);

    @Test
    public void testVerkstad() {
        // Hämta ut från tom verkstad
        Assert.assertTrue(volvo240Verkstad.unload(volvo.getRegNr()) == null);
        // Testa hämta ut en saab som inte finns i verkstaden
        volvo240Verkstad.load(volvo);
        Assert.assertTrue(volvo240Verkstad.unload(saab.getRegNr()) == null);
        volvo240Verkstad.unload(volvo.getRegNr());
        verkstad.load(volvo);
        verkstad.load(saab);
        Car c = verkstad.unload(volvo.getRegNr());
        Assert.assertTrue(c.getClass() == Volvo240.class);
        c = verkstad.unload(saab.getRegNr());
        Assert.assertTrue(c.getClass() != Volvo240.class);


        // Lämna in på en full
        saab95Verkstad.load(new Saab95(0, 0));
        saab95Verkstad.load(new Saab95(0, 0));
        saab95Verkstad.load(new Saab95(0, 0));
        saab95Verkstad.load(new Saab95(0, 0));
        // Capacity är 3
        Assert.assertTrue(saab95Verkstad.nrOfCars() == 3);
    }

    CarTransport carTransport = new CarTransport(0, 0);

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
        Position posCT = new Position(carTransport.getPos().getX(), carTransport.getPos().getY());
        //kontrollerar så att positionen är [0,0]
        Assert.assertTrue(posCT.getX() == 0 && posCT.getY() == 0);

        //testar att köra med rampen nere
        carTransport.trailerDown();
        carTransport.turnLeft();
        carTransport.startEngine();
        carTransport.gas(1);
        carTransport.move();
        Assert.assertTrue(carTransport.getPos().getX() == posCT.getX() && carTransport.getPos().getY() == posCT.getY());

    }


    Volvo240 car1 = new Volvo240(0, 0);
    Volvo240 car2 = new Volvo240(0, 0);
    Volvo240 car3 = new Volvo240(0, 0);
    Volvo240 car4 = new Volvo240(0, 0);
    Volvo240 car5 = new Volvo240(0, 0);
    Volvo240 car6 = new Volvo240(0, 0);
    Volvo240 car7 = new Volvo240(0, 0);

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
