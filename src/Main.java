import Controller.*;
import Model.*;
import View.*;
import db.*;

public class Main {
    public static void main(String[] args) {

        Create.createNewDatabase("RentACarDb");
        Create.createCarTable();
        Create.createUserTable();

        InsertData insertData = new InsertData();

        User u1 = new User("Tuncay","Çelikkanat","","",true);
        insertData.insertUsers(u1);

        Car mercedes1 = new Sedan("Mercedes","C 180 AMG",2018,1200,
                "src/Assets/mercedes-benz.png",
                "src/Assets/mercedes_c180amg_2018.jpg");
        insertData.insertCar(mercedes1);

        Car mercedes2 = new Sedan("Merco1","C 180 AMG",2018,1200,
                "src/Assets/tesla-logo.png",
                "src/Assets/mercedes_c180amg_2018.jpg");
        insertData.insertCar(mercedes2);

        Car mercedes3 = new Sedan("Merceee","C 180 AMG",2018,1200,
                "src/Assets/audi-logo.png",
                "src/Assets/mercedes_c180amg_2018.jpg");
        insertData.insertCar(mercedes3);

        Car mercedes4 = new Sedan("Mercoasdsdf","C 180 AMG",2018,1200,
                "src/Assets/bmw_logo.png",
                "src/Assets/mercedes_c180amg_2018.jpg");
        insertData.insertCar(mercedes4);

        Car mercedes5 = new Sedan("dgadsg","C 180 AMG",2018,1200,
                "src/Assets/Toyota-Logo.png",
                "src/Assets/mercedes_c180amg_2018.jpg");
        insertData.insertCar(mercedes5);

        LoginRegisterView loginRegisterView = new LoginRegisterView();
        MainScreenView mainScreenView = new MainScreenView();
        MainListItemView mainListItemView = new MainListItemView(mercedes1);
        CarDetailsView carDetailsView = new CarDetailsView(mercedes1);
        ProfileView profileView = new ProfileView();
        AdminView adminView = new AdminView();
        MyRentsView myRentsView = new MyRentsView();

        MainController mainController = new MainController(u1, adminView,mainScreenView, profileView,myRentsView,loginRegisterView,carDetailsView,
                mainListItemView);
        MainListItemsController mainListItemsController = new MainListItemsController(mainScreenView,mainListItemView);
        AdminController adminController = new AdminController(u1,mercedes1,adminView,mainScreenView,mainListItemsController,mainController);
        ProfileController profileController = new ProfileController(loginRegisterView,profileView,adminController,adminView);
        new LoginRegisterController(u1,loginRegisterView,mainScreenView,profileController,adminController,adminView);
        new CarDetailsController(mainListItemView,mercedes1,carDetailsView);

        loginRegisterView.setVisible(true);

        System.out.println(Car.getCars());
        System.out.println(MainListItemView.getMainListItems());
        System.out.println("Items size: " + MainListItemView.getMainListItems().size());
        System.out.println("Items size: " + MainScreenView.getCardItems().size() + MainScreenView.getCardItems());
        System.out.println(mainScreenView.getCarsCards());
        System.out.println("Users ->" + u1.getUsers());
        System.out.println(User.getLoggedInUser());
    }
}