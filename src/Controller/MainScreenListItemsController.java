package Controller;

import View.CarDetailsView;
import View.MainScreenListItem;
import View.MainScreenView;

import javax.swing.*;

public class MainScreenListItemsController {
    private MainScreenView mainScreenView;
    private MainScreenListItem item;
    private CarDetailsView carDetailsView;

    public MainScreenListItemsController(MainScreenView mainScreenView) {
        this.mainScreenView = mainScreenView;

        System.out.println("Size" + MainScreenListItem.getItems().size());

        for (JPanel items: MainScreenView.getCardItems()){
            mainScreenView.getCarsCards().add(items);
        }
    }
}
