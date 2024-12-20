package Controller;

import Model.Car;
import Model.User;
import View.CarDetailsView;
import View.MainListItemView;
import View.MainScreenView;

import javax.swing.*;

public class CarDetailsController {
    private MainListItemView item;
    private CarDetailsView carDetailsView;
    private Car car;

    public CarDetailsController(MainListItemView item, Car carModel, CarDetailsView carDetailsView) {
        this.item = item;
        this.car = carModel;
        this.carDetailsView = carDetailsView;

        this.carDetailsView.addTestButtonListener(e->{

            System.out.println("Button Clicked.");
            JOptionPane.showMessageDialog(carDetailsView,"Test");

        });

        // HOW YOU DON'T WORK!!!!

//        for (Car car: Car.getCars()){
//            MainListItemView mainListItemView = new MainListItemView(car);
//            MainListItemsController.addToList(mainListItemView);
//        }

//        this.carDetailsView.addRentButtonActionListener(e -> handleRentButtonClick());


//        System.out.println("Size" + MainListItemView.getItems().size());
//
//        for (JPanel items: MainScreenView.getCardItems()){
//            mainScreenView.getCarsCards().add(items);
//        }
    }
}
