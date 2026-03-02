import Model.*;

import javax.swing.*;

public class Main {


    public static void main(String[] args) {

        final int delay = 50;

        CurrentState currentState = new CurrentState();
        // Lägga till en egen add metod i currentState???
        currentState.getCars().add(new Volvo240(0, 300));
        currentState.getCars().add(new Saab95(0, 100));
        currentState.getCars().add(new Scania<Cargo>(0, 400));

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
