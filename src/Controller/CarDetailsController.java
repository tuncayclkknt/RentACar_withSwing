package Controller;

import Model.CarModel;
import View.CarDetailsView;
import View.MainListItemView;
import View.MainScreenView;

public class CarDetailsController {
    private MainListItemView item;
    private CarModel carModel;
    private CarDetailsView carDetailsView;
    private MainScreenView mainScreenView;

    public CarDetailsController(MainListItemView item, CarModel carModel, CarDetailsView carDetailsView,
                                MainScreenView mainScreenView) {
        this.item = item;
        this.carModel = carModel;
        this.carDetailsView = carDetailsView;

        for (CarModel car: CarModel.getCars()){

            MainListItemView mainListItemView = new MainListItemView(car);
            mainListItemView.addToList();

        }

//        System.out.println("Size" + MainListItemView.getItems().size());
//
//        for (JPanel items: MainScreenView.getCardItems()){
//            mainScreenView.getCarsCards().add(items);
//        }

    }
}
