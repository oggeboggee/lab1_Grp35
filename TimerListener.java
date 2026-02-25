import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/* Each step the TimerListener moves all the cars in the list and tells the
 * view to update its images. Change this method to your needs.
 * */
public class TimerListener implements ActionListener {
    // Current State
    ArrayList<Car> cars = new ArrayList<>();
    Verkstad<Volvo240> volvo240Verkstad = new Verkstad<>(6, 300, 300);
    // Observers
    ArrayList<signalObserver> obs = new ArrayList<>();

    // Delay for timer
    private final int delay = 50;

    public int getDelay(){
        return delay;
    }

    public TimerListener() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Car car : cars) {
            car.move();
            if (car instanceof Volvo240 && car.getPos().distance(volvo240Verkstad.pos)<10
                    && !car.getIsAttached()){
                volvo240Verkstad.load((Volvo240) car);
                car.stopEngine();
                System.out.println(volvo240Verkstad.nrOfCars());
            }
            // repaint() calls the paintComponent method of the panel
            //frame.drawPanel.repaint();
            notifyObservers();
        }
    }
    public void notifyObservers() {
        for (signalObserver observer : obs) {
            observer.notifyOb();
        }
    }
}