package Controller;

import Model.CarModel;
import View.CarDetailsView;
import View.MainScreenListItem;
import View.MainScreenView;

import javax.swing.*;

public class CarDetailsController {
    private MainScreenListItem item;
    private CarModel carModel;
    private CarDetailsView carDetailsView;
    private MainScreenView mainScreenView;

    public CarDetailsController(MainScreenListItem item, CarModel carModel,CarDetailsView carDetailsView,
                                MainScreenView mainScreenView) {
        this.item = item;
        this.carModel = carModel;
        this.carDetailsView = carDetailsView;

        for (CarModel car: CarModel.getCars()){

            MainScreenListItem mainScreenListItem = new MainScreenListItem(car);
            mainScreenListItem.addToList();

        }

//        System.out.println("Size" + MainScreenListItem.getItems().size());
//
//        for (JPanel items: MainScreenView.getCardItems()){
//            mainScreenView.getCarsCards().add(items);
//        }

    }
}
