import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
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
        saab.startEngine();
    }
   // public void DirectionPosition(){
   //     Assert.assertTrue(saab.getDirection() == 0);
   //     Assert.assertTrue(volvo.getDirection() == 0);
    //    //ska fixa resten
  //  }
}
