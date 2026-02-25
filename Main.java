import javax.swing.*;

public class Main {


    public static void main(String[] args) {

        TimerListener time = new TimerListener();
        time.cars.add(new Volvo240(0, 300));
        time.cars.add(new Saab95(0, 100));
        time.cars.add(new Scania<Cargo>(0, 400));

        CarController cc = new CarController(time);
        CarView view = new CarView("CarSim 1.0", cc);

        time.obs.add(view);

        Timer timer = new Timer(time.getDelay(), time);


        // Start a new view and send a reference of self
        //time.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        timer.start();
    }
}
