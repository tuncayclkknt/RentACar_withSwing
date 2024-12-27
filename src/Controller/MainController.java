package Controller;

import Model.Car;
import Model.Sedan;
import Model.Suv;
import Model.User;
import View.*;
import javax.swing.*;
import java.util.Comparator;
import java.util.Hashtable;

public class MainController {

    private User user;
    private ProfileView profileView;
    private CarDetailsView carDetailsView;
    private MyRentsView myRentsView;
    private MainView mainView;
    private AdminView adminView;
    private MainListItemView mainListItemView;
    private LoginRegisterView loginRegisterView;
    private  PdfSpecificationsView pdfSpecificationsView;

    public MainController(User user, AdminView adminView, MainView mainView,
                          ProfileView profileView, MyRentsView myRentsView, LoginRegisterView loginRegisterView,
                          CarDetailsView carDetailsView, MainListItemView mainListItemView,
                          PdfSpecificationsView pdfSpecificationsView) {
        this.user = user;
        this.mainView = mainView;
        this.adminView = adminView;
        this.profileView = profileView;
        this.myRentsView = myRentsView;
        this.loginRegisterView = loginRegisterView;
        this.carDetailsView = carDetailsView;
        this.mainListItemView = mainListItemView;
        this.pdfSpecificationsView = pdfSpecificationsView;

        this.mainView.addAdminPageListener(e-> {
            adminView.setVisible(true);
            mainView.dispose();
            System.out.println("User on mainController: " + user.getUsers());

        });

        this.mainView.addProfilePageListener(e->{
            profileView.setVisible(true);
        });

        this.mainView.addMyRentsPageListener(e->{
            myRentsView.setVisible(true);
        });

        this.mainView.addLogoutListener(e->{
            mainView.dispose();
            profileView.dispose();
            adminView.dispose();
            myRentsView.dispose();
            loginRegisterView.setVisible(true);
            System.out.println(user.getUsers());
        });

        this.mainView.addBtnCreatePDF(e->{
            pdfSpecificationsView.setVisible(true);
        });

        this.mainListItemView.getButton().addActionListener(e->{
            System.out.println("Clicked.");
        });

        this.mainView.addApplySortListener(e->{
            if (this.mainView.getLowToHigh().isSelected()){
                Car.getCars().sort(Comparator.comparingDouble(Car::getDailyPrice));
            } else if (this.mainView.getHighToLow().isSelected()) {
                Car.getCars().sort(Comparator.comparingDouble(Car::getDailyPrice).reversed());
            }
            refreshMainTableForSort();
        });

        this.mainView.addApplyFilterListener(e->{
            if (this.mainView.getSedanCheckBox().isSelected() && !this.mainView.getSuvCheckBox().isSelected()){
                refreshMainTableForFilter(true);
            } else if (!this.mainView.getSedanCheckBox().isSelected() && this.mainView.getSuvCheckBox().isSelected()) {
                refreshMainTableForFilter(false);
            } else{
                //do nothing --- delete this lines *****
            }
        });

        this.mainView.addSearchListener(e->{
            System.out.println(this.mainView.getSearchTextField().getText());
            refreshMainTableForSort();
            System.out.println("Main Card Items: " + MainView.getCardItems());
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
            MainView.getCardItems().add(listItem);
        }
    }

    public void refreshMainTableForSort(){
        MainView.getCardItems().clear();
        MainListItemView.getMainListItems().clear();
        MainListItemsController.clearMainListView();

        System.out.println("Main Card Items after clear: " + MainView.getCardItems());
        String searchText = this.mainView.getSearchTextField().getText();

        for (Car car: Car.getCars()){
            if (car.getMake().contains(searchText) || car.getModel().contains(searchText)
                    ||String.valueOf(car.getYear()).contains(searchText)){
                MainListItemView mainListItemView = new MainListItemView(car);
                MainListItemsController.addToList(mainListItemView);
            }
        }

        for (JPanel listItem : MainListItemView.getMainListItems()){
            MainView.getCardItems().add(listItem);
        }

        for (JPanel items: MainView.getCardItems()){ //there is a missing part.
            MainView.getCarsCards().add(items);
        }
    }

    public void refreshMainTableForFilter(boolean isSedan){
        MainView.getCardItems().clear();
        MainListItemView.getMainListItems().clear();
        MainListItemsController.clearMainListView();

        if (isSedan){
            for (Car car: Car.getCars()){
                if (car instanceof Sedan){
                    MainListItemView mainListItemView = new MainListItemView(car);
                    MainListItemsController.addToList(mainListItemView);
                }
            }
        } else {
            for (Car car: Car.getCars()){
                if (car instanceof Suv){
                    MainListItemView mainListItemView = new MainListItemView(car);
                    MainListItemsController.addToList(mainListItemView);
                }
            }
        }

        for (JPanel listItem : MainListItemView.getMainListItems()){
            MainView.getCardItems().add(listItem);
        }

        for (JPanel items: MainView.getCardItems()){ //there is a missing part.
            MainView.getCarsCards().add(items);
        }
    }

    public Hashtable<String,User> usersBridge(){
        return user.getUsers();
    }
}
