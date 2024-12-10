package Controller;

import Model.UserModel;
import View.*;

import javax.swing.*;

public class MainScreenController {

    private UserModel userModel;
    private ProfileView profileView;
    private MyRentsView myRentsView;
    private MainScreenView mainScreenView;
    private AdminView adminView;
    private MainListItemView mainListItemView;

    public MainScreenController(UserModel userModel, AdminView adminView, MainScreenView mainScreenView,
                                ProfileView profileView, MyRentsView myRentsView) {
        this.userModel = userModel;
        this.mainScreenView = mainScreenView;
        this.adminView = adminView;
        this.profileView = profileView;
        this.myRentsView = myRentsView;

        this.mainScreenView.addAdminPageListener(e-> {
            adminView.setVisible(true);
        });

        this.mainScreenView.addProfilePageListener(e->{
            profileView.setVisible(true);
        });

        this.mainScreenView.addMyRentsPageListener(e->{
            myRentsView.setVisible(true);
        });

        //test
        System.out.println("Items size: " + MainListItemView.getItems().size());

        for (JPanel listItem : MainListItemView.getItems()){
            MainScreenView.getCardItems().add(listItem);
        }


    }
}
