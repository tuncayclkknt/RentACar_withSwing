package Controller;

import Model.CarModel;
import Model.UserModel;
import View.*;

import javax.swing.*;

public class MainScreenController {

    private UserModel userModel;
    private ProfileScreenView profileScreenView;
    private MyRentsView myRentsView;
    private MainScreenView mainScreenView;
    private AdminPageView adminPageView;
    private MainScreenListItem mainScreenListItem;

    public MainScreenController(UserModel userModel, AdminPageView adminPageView, MainScreenView mainScreenView,
    ProfileScreenView profileScreenView, MyRentsView myRentsView) {
        this.userModel = userModel;
        this.mainScreenView = mainScreenView;
        this.adminPageView = adminPageView;
        this.profileScreenView = profileScreenView;
        this.myRentsView = myRentsView;

        this.mainScreenView.addAdminPageListener(e-> {
            adminPageView.setVisible(true);
        });

        this.mainScreenView.addProfilePageListener(e->{
            profileScreenView.setVisible(true);
        });

        this.mainScreenView.addMyRentsPageListener(e->{
            myRentsView.setVisible(true);
        });

        //test
        System.out.println("Items size: " + MainScreenListItem.getItems().size());

        for (JPanel listItem : MainScreenListItem.getItems()){
            MainScreenView.getCardItems().add(listItem);
        }


    }
}
