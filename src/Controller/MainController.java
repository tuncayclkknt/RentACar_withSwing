package Controller;

import Model.User;
import View.*;

import javax.swing.*;
import java.util.Hashtable;

public class MainController {

    private User user;
    private ProfileView profileView;
    private MyRentsView myRentsView;
    private MainScreenView mainScreenView;
    private AdminView adminView;
    private MainListItemView mainListItemView;
    private LoginRegisterView loginRegisterView;

    public MainController(User user, AdminView adminView, MainScreenView mainScreenView,
                          ProfileView profileView, MyRentsView myRentsView, LoginRegisterView loginRegisterView) {
        this.user = user;
        this.mainScreenView = mainScreenView;
        this.adminView = adminView;
        this.profileView = profileView;
        this.myRentsView = myRentsView;
        this.loginRegisterView = loginRegisterView;


        this.mainScreenView.addAdminPageListener(e-> {
            adminView.setVisible(true);
            mainScreenView.dispose();
            System.out.println("User on mainController: " + user.getUsers());

        });

        this.mainScreenView.addProfilePageListener(e->{
            profileView.setVisible(true);
        });

        this.mainScreenView.addMyRentsPageListener(e->{
            myRentsView.setVisible(true);
        });

        this.mainScreenView.addLogoutListener(e->{
            mainScreenView.dispose();
            profileView.dispose();
            adminView.dispose();
            myRentsView.dispose();
            loginRegisterView.setVisible(true);
        });

        //test
        System.out.println("Items size: " + MainListItemView.getMainListItems().size());

        for (JPanel listItem : MainListItemView.getMainListItems()){
            MainScreenView.getCardItems().add(listItem);
        }
    }
}
