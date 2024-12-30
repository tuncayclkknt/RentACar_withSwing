package View;

import Model.Car;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainListItemView extends JPanel{

    private JButton button;
    private final JLabel makeLabel;
    private final JLabel modelLabel;
    private final JLabel photoLabel;
    private final JLabel priceLabel;

    private CarDetailsView carDetailsView;
    private MainView mainView;

    private Car car;
    private User user;

    //to put panels manually, top margin is 20 px
    private static int yCoordinate = 20; //there still is a bug //I solved, but I am not sure how I did??
    private static int counter = 0;

    private static List<JPanel> mainListItems = new ArrayList<>();

    public MainListItemView(Car car) {
        this.car = car;

        ImageIcon angleRight = IResizeImage.resizeImage("src/Assets/angle-right.png",30,30);
        ImageIcon icon2 = IResizeImage.resizeImage(car.getLogoPath(),80,80);

        photoLabel = new JLabel(icon2);
        button = new JButton();
        makeLabel = new JLabel(car.getMake());
        modelLabel = new JLabel(car.getModel());
        priceLabel = new JLabel(car.getDailyPrice() + " TL");

        setLayout(null);

        //add a line border on every panel
        setBorder(new RoundedBorder(15));

        //give the initial position to panel(yCoordinate)
        setBounds(25, yCoordinate, 650, 100);
        button.setBounds(575, 25, 40, 40);
        button.setIcon(angleRight);

        makeLabel.setBounds(115, 20, 130, 30);
        makeLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        modelLabel.setFont(new Font("Arial", Font.ITALIC, 18));
        modelLabel.setBounds(115,50,300,30);

        priceLabel.setBounds(450,35,130,30);
        priceLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        photoLabel.setBounds(10,10,80,80);
        setBackground(Color.white);

        /*
            increase the yCoordinate +80, ever panel has 70px height
                and i want 10 px padding between every element, so 70 + 10 = 80,
                it is the needed gap for every panel.
        */

        button.addActionListener(e->{

            System.out.println("Car:" + car.getMake());

            if (carDetailsView == null)
                carDetailsView = new CarDetailsView(car);

            if (!carDetailsView.isVisibleForScreen())
                carDetailsView.setVisible(true);

        });

        add(photoLabel);
        add(priceLabel);
        add(button);
        add(makeLabel);
        add(modelLabel);

//        items.add(this); // I added this part and the bug was gone to hell. WTF java??
    }
//
//    public static void addToList(MainListItemView item){
//        yCoordinate += 110;
//        counter++;
//        mainListItems.add(item);
//    }

//    public void clearMainListView(){
//        mainView.getCarsCards().removeAll();
//    }

//    //I will probably need later
//    public JButton getButton() {
//        return button;
//    }
//
//    //maybe I will need later but I am not sure
//    public JLabel getMakeLabel() {
//        return makeLabel;
//    }

    public static List<JPanel> getMainListItems() {
        return mainListItems;
    }

    public static int getyCoordinate() {
        return yCoordinate;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        MainListItemView.counter = counter;
    }

    public static void setyCoordinate(int yCoordinate) {
        MainListItemView.yCoordinate = yCoordinate;
    }

    public Car getCar() {
        return car;
    }

    public JButton getButton() {
        return button;
    }
}
