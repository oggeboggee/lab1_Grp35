import junit.framework.Assert;
import org.junit.Test;

// Hej
public class FirstTest {
    Saab95 saab = new Saab95();
    Volvo240 volvo = new Volvo240();

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
        Assert.assertTrue(saab.getEnginePower()==125);
    }
    @Test
    public void TestEnginePowerVolvo() {
        Assert.assertTrue(volvo.getEnginePower()==100);
    }

    @Test
    public void TestGas() {
        saab.startEngine();
        double speedBefore = saab.getCurrentSpeed();
        saab.gas(1);
        Assert.assertTrue(saab.getCurrentSpeed()>speedBefore);
        saab.stopEngine();
    }
    @Test
    public void TestBrake() {
        saab.startEngine();
        saab.gas(1);
        double speedBefore = saab.getCurrentSpeed();
        saab.brake(0.5);
        Assert.assertTrue(saab.getCurrentSpeed()<speedBefore);
        saab.stopEngine();
    }

    @Test
    public void TestGetDirection() {
        Assert.assertTrue(saab.getDirection() == 0);
        Assert.assertTrue(volvo.getDirection() == 0);
    }
    @Test
    public void TestTurnLeft(){
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
    public void TestTurnRight(){
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
    public void TestMove(){
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


    //SCANIA-TESTER
    Scania<Cargo> scania = new Scania<>();

    @Test
    public void testFlaktilt() {
        // INC/DEC-TILT with currentSpeed = 0
        Assert.assertTrue(scania.getFlakTilt()==0);
        scania.incTilt(50);
        Assert.assertTrue(scania.getFlakTilt()!=0);
        scania.incTilt(50);
        Assert.assertTrue(scania.getFlakTilt()==70);
        scania.decTilt(80);
        Assert.assertTrue(scania.getFlakTilt()==0);
        // With currentSpeed > 0
        scania.startEngine();
        scania.gas(1);
        scania.incTilt(50);
        Assert.assertTrue(scania.getFlakTilt()==0);
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
    public void testVerkstad(){
        // Hämta ut från tom verkstad
        Assert.assertTrue(volvo240Verkstad.unload(volvo.getRegNr())==null);
        // Testa hämta ut en saab som inte finns i verkstaden
        volvo240Verkstad.load(volvo);
        Assert.assertTrue(volvo240Verkstad.unload(saab.getRegNr())==null);

        verkstad.load(volvo);
        verkstad.load(saab);
        Car c = verkstad.unload(volvo.getRegNr());
        Assert.assertTrue(c.getClass()==Volvo240.class);
        c = verkstad.unload(saab.getRegNr());
        Assert.assertTrue(c.getClass()!=Volvo240.class);


        // Lämna in på en full
        saab95Verkstad.load(new Saab95());
        saab95Verkstad.load(new Saab95());
        saab95Verkstad.load(new Saab95());
        saab95Verkstad.load(new Saab95());
        // Capacity är 3
        Assert.assertTrue(saab95Verkstad.nrOfCars() == 3);


    }
}
