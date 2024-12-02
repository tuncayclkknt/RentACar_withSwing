package View;

import Cars.Car;

import javax.swing.*;
import java.awt.*;

public class MainScreenListItem {

    private final JButton button;
    private final JLabel makeLabel;
    private final JLabel modelLabel;
    private final JLabel photoLabel;
    private final JLabel priceLabel;
    private final JPanel panel;

    //to put panels manually, top margin is 20 px
    private static int yCoordinate = 20;
    private static int counter = 0;

    public static int getCounter() {
        return counter;
    }

    public MainScreenListItem(Car car) {

        ImageIcon angleRight = IResizeImage.resizeImage("src/Assets/angle-right.png",30,30);
        ImageIcon icon2 = IResizeImage.resizeImage(car.getTinyPhotoPath(),80,80);

        photoLabel = new JLabel(icon2);
        button = new JButton();
        makeLabel = new JLabel(car.getMake());
        modelLabel = new JLabel(car.getModel());
        priceLabel = new JLabel(car.getDailyPrice() + " TL");
        panel = new JPanel();

        panel.setLayout(null);

        //add a line border on every panel
        panel.setBorder(new RoundedBorder(15));

        //give the initial position to panel(yCoordinate)
        panel.setBounds(25, yCoordinate, 650, 100);
        button.setBounds(575, 25, 50, 50);
        button.setIcon(angleRight);

        makeLabel.setBounds(115, 20, 130, 30);
        makeLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        modelLabel.setFont(new Font("Arial", Font.ITALIC, 18));
        modelLabel.setBounds(115,50,130,30);

        priceLabel.setBounds(450,35,130,30);
        priceLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        photoLabel.setBounds(10,10,80,80);
        panel.setBackground(Color.white);

        /*
            increase the yCoordinate +80, ever panel has 70px height
                and i want 10 px padding between every element, so 70 + 10 = 80,
                it is the needed gap for every panel.
        */

        yCoordinate += 110;
        counter++;

        panel.add(photoLabel);
        panel.add(priceLabel);
        panel.add(button);
        panel.add(makeLabel);
        panel.add(modelLabel);
    }

    //I will probably need later
    public JButton getButton() {
        return button;
    }

    //maybe I will need later but I am not sure
    public JLabel getMakeLabel() {
        return makeLabel;
    }

    //return every item's panel view.
    public JPanel getPanel() {
        return panel;
    }

}
