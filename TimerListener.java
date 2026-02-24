import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* Each step the TimerListener moves all the cars in the list and tells the
 * view to update its images. Change this method to your needs.
 * */
public class TimerListener implements ActionListener {
    CarController cc;

    public TimerListener(CarController CC){
        cc = CC;
    }

    public void actionPerformed(ActionEvent e) {
        cc.moveCars();
    }
}