import Model.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    HashMap<Position, BufferedImage> map = new HashMap<>();
    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    // To keep track of a single car's position
    //Point volvoPoint = new Point(0, 300);

    // Lägg till Saab och Model.Scania
    BufferedImage saabImage;
    //Point saabPoint = new Point(0,100);

    BufferedImage scaniaImage;
    //Point scaniaPoint = new Point(0,400);

    BufferedImage volvoWorkshopImage;
    //Point volvoWorkshopPoint = new Point(300,300);

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Model.Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    // För att kunna lägga till nya bilar i hashMapen
    public void addCarToMap(Car car) {
        if (car instanceof Volvo240) {
            map.putIfAbsent(car.getPos(), volvoImage);
        }
        else if (car instanceof Saab95) {
            map.putIfAbsent(car.getPos(), saabImage);
        }
        else if (car instanceof Scania<?>) {
            map.putIfAbsent(car.getPos(), scaniaImage);
        }
    }

    public void addCarToMap(ArrayList<Car> cars) {
        for (Car car : cars) {
            addCarToMap(car);
        }
    }

    public void removeCarFromMap(Position pos) {
        map.remove(pos);
    }

    public void addVerkstad(Verkstad<?> v) {
        map.putIfAbsent(v.getPos(), volvoWorkshopImage);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Map.Entry<Position, BufferedImage> entry : map.entrySet()) {
            int x = Math.toIntExact(Math.round(entry.getKey().getX()));
            int y = Math.toIntExact(Math.round(entry.getKey().getY()));
            g.drawImage(entry.getValue(), x, y, null);
        }
    }
}
