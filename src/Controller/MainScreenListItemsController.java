package Controller;

import View.CarDetailsView;
import View.MainListItemView;
import View.MainScreenView;

import javax.swing.*;

public class MainScreenListItemsController {
    private MainScreenView mainScreenView;
    private MainListItemView item;
    private CarDetailsView carDetailsView;

    public MainScreenListItemsController(MainScreenView mainScreenView) {
        this.mainScreenView = mainScreenView;

        System.out.println("Size" + MainListItemView.getItems().size());

        for (JPanel items: MainScreenView.getCardItems()){
            mainScreenView.getCarsCards().add(items);
        }
    }
}
