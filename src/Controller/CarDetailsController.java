package Controller;

import Model.Car;
import View.CarDetailsView;
import View.MainListItemView;
import View.MainScreenView;

public class CarDetailsController {
    private MainListItemView item;
    private Car car;
    private CarDetailsView carDetailsView;

    public CarDetailsController(MainListItemView item, Car carModel, CarDetailsView carDetailsView) {
        this.item = item;
        this.car = carModel;
        this.carDetailsView = carDetailsView;

        for (Car car: Car.getCars()){
            MainListItemView mainListItemView = new MainListItemView(car);
            MainListItemsController.addToList(mainListItemView);
        }

//        System.out.println("Size" + MainListItemView.getItems().size());
//
//        for (JPanel items: MainScreenView.getCardItems()){
//            mainScreenView.getCarsCards().add(items);
//        }

    }
}
