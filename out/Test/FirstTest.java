import junit.framework.Assert;
import org.junit.Test;

public class FirstTest {
    @Test
    public void nrDoorsSaab() {
        Saab95 saab = new Saab95();
        Assert.assertTrue(saab.getNrDoors() == 3);
    }
}
