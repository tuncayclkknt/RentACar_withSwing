package Controller;

import View.CarDetailsView;
import View.MainListItemView;
import View.MainView;

import javax.swing.*;
import java.awt.*;

public class MainListItemsController {
    private MainView mainView;
    private MainListItemView item;
    private CarDetailsView carDetailsView;

    public MainListItemsController(MainView mainView, MainListItemView item) {
        this.mainView = mainView;
        this.item = item;

        //this part needed for create scrollable panel, I found it after ~100 trying and
        //update -> I put this part after creating cars because of counter increment.

        MainView.getCarsCards().setPreferredSize(new Dimension(650,
                MainListItemView.getCounter() * 110 + 30));

        /* I will make the second part(590) dynamic, i found 590 like this;
                every item(panel) has 100 px height and 10 px padding = 110,
                then I have 7 items so 7 x 110 = 770,
                then I add the initial yCoordinate 770 + 20 = 790,
                then I add missing '10x' at the end 790 + 10 = 800.

        '10px' : initial padding is 20, but at the end there is just panel's 10px padding,
                so I need +10 px at the end.

                you can make dynamic using this way...
         */

//        System.out.println("Size" + MainListItemView.getMainListItems().size());

//        for (JPanel listItem : MainListItemView.getMainListItems()){
//            MainView.getCardItems().add(listItem);
//        }

        for (JPanel items: MainView.getCardItems()){
            MainView.getCarsCards().add(items);
        }

        item.getButton().addActionListener(e->{

//            System.out.println("Car detail page.");
            carDetailsView.setVisible(true);
        });

    }

    //Finally, I fixed it B-)
    public static void addToList(MainListItemView item){
        MainListItemView.setyCoordinate(MainListItemView.getyCoordinate() + 110);
        MainListItemView.setCounter(MainListItemView.getCounter() + 1);
        MainListItemView.getMainListItems().add(item);
    }

    //for update btn on admin controller panel.
    public static void clearMainListView(){
        MainListItemView.setyCoordinate(20);
        MainListItemView.setCounter(0);
        MainView.getCarsCards().removeAll();
    }

}
