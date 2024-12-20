package Controller;

import Model.Car;
import Model.User;
import View.*;

import javax.swing.*;
import java.util.Hashtable;

public class MainController {

    private User user;
    private ProfileView profileView;
    private CarDetailsView carDetailsView;
    private MyRentsView myRentsView;
    private MainScreenView mainScreenView;
    private AdminView adminView;
    private MainListItemView mainListItemView;
    private LoginRegisterView loginRegisterView;

    public MainController(User user, AdminView adminView, MainScreenView mainScreenView,
                          ProfileView profileView, MyRentsView myRentsView, LoginRegisterView loginRegisterView,
                          CarDetailsView carDetailsView, MainListItemView mainListItemView) {
        this.user = user;
        this.mainScreenView = mainScreenView;
        this.adminView = adminView;
        this.profileView = profileView;
        this.myRentsView = myRentsView;
        this.loginRegisterView = loginRegisterView;
        this.carDetailsView = carDetailsView;
        this.mainListItemView = mainListItemView;


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
            System.out.println(user.getUsers());


        });

        this.mainListItemView.getButton().addActionListener(e->{
            System.out.println("Clicked.");
        });

//        this.mainListItemView.addButtonActionListener(e->{
//            System.out.println("Car detail page.");
//            carDetailsView.setVisible(true);
//        });

        //test
        System.out.println("Items size: " + MainListItemView.getMainListItems().size());

        for (Car car: Car.getCars()){
            MainListItemView mainListItemView2 = new MainListItemView(car);
            MainListItemsController.addToList(mainListItemView2);
        }

        for (JPanel listItem : MainListItemView.getMainListItems()){
            MainScreenView.getCardItems().add(listItem);
        }
    }

    public Hashtable<String,User> usersBridge(){
        return user.getUsers();
    }
}
