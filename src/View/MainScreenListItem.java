package View;

import Model.CarModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainScreenListItem extends JPanel{

    private JButton button;
    private final JLabel makeLabel;
    private final JLabel modelLabel;
    private final JLabel photoLabel;
    private final JLabel priceLabel;

    private CarDetailsView carDetailsView;

    //to put panels manually, top margin is 20 px
    private static int yCoordinate = -90; //it is to solve a bug, I am not sure if there is another way.
    private static int counter = 0;

    public static int getCounter() {
        return counter;
    }

    private static List<JPanel> items = new ArrayList<>();

    public MainScreenListItem(CarModel carModel) {

        ImageIcon angleRight = IResizeImage.resizeImage("src/Assets/angle-right.png",30,30);
        ImageIcon icon2 = IResizeImage.resizeImage(carModel.getTinyPhotoPath(),80,80);

        photoLabel = new JLabel(icon2);
        button = new JButton();
        makeLabel = new JLabel(carModel.getMake());
        modelLabel = new JLabel(carModel.getModel());
        priceLabel = new JLabel(carModel.getDailyPrice() + " TL");

        setLayout(null);

        //add a line border on every panel
        setBorder(new RoundedBorder(15));

        //give the initial position to panel(yCoordinate)
        setBounds(25, yCoordinate, 650, 100);
        button.setBounds(575, 25, 50, 50);
        button.setIcon(angleRight);

        makeLabel.setBounds(115, 20, 130, 30);
        makeLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        modelLabel.setFont(new Font("Arial", Font.ITALIC, 18));
        modelLabel.setBounds(115,50,130,30);

        priceLabel.setBounds(450,35,130,30);
        priceLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        photoLabel.setBounds(10,10,80,80);
        setBackground(Color.white);

        /*
            increase the yCoordinate +80, ever panel has 70px height
                and i want 10 px padding between every element, so 70 + 10 = 80,
                it is the needed gap for every panel.
        */

        yCoordinate += 110;
        counter++;

        button.addActionListener(e->{
            if (carDetailsView == null)
                carDetailsView = new CarDetailsView();

            if (!carDetailsView.isVisibleForScreen())
                carDetailsView.setVisible(true);

        });

        add(photoLabel);
        add(priceLabel);
        add(button);
        add(makeLabel);
        add(modelLabel);

//        items.add(this);
    }

    public void addToList(){
        items.add(this);
    }

    public void addMainListItemListener(ActionListener listener){
        button.addActionListener(listener);
    }

    //I will probably need later
    public JButton getButton() {
        return button;
    }

    //maybe I will need later but I am not sure
    public JLabel getMakeLabel() {
        return makeLabel;
    }

    public static List<JPanel> getItems() {
        return items;
    }
}
