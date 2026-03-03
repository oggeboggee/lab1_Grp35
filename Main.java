import Model.*;

import javax.swing.*;

public class Main {


    public static void main() {

        final int delay = 50;

        CurrentState currentState = new CurrentState();


        CarController cc = new CarController(currentState);
        CarView view = new CarView("CarSim 1.0", cc);

        view.drawPanel.addCarToMap(currentState.getCars());
        view.drawPanel.addVerkstad(currentState.getVolvo240Verkstad());

        currentState.getObs().add(view);

        Timer timer = new Timer(delay, cc);

        // Start the timer
        timer.start();
    }
}
