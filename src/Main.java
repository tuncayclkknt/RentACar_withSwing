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

        Car mercedes2 = new Suv("Mercedes","G Class 63 AMG",2022,2500,
                "src/Assets/mercedes-benz.png",
                "src/Assets/2022-Mercedes-Benz-G-Class-G-63-AMG.jpg");
        insertData.insertCar(mercedes2);

        Car hyundai1 = new Sedan("Hyundai","i20 N",2023,1700,
                "src/Assets/hyundai-logo.png",
                "src/Assets/Hyundai-i20-N.jpg");
        insertData.insertCar(hyundai1);

        Car hyundai2 = new Suv("Hyundai","Tucson",2020,2000,
                "src/Assets/hyundai-logo.png",
                "src/Assets/hyundai-tucson-2020.jpg");
        insertData.insertCar(hyundai2);

        Car audi1 = new Sedan("Audi","A4",2017,2200,
                "src/Assets/audi-logo.png",
                "src/Assets/2017-Audi-A4.jpg");
        insertData.insertCar(audi1);

        Car audi2 = new Suv("Audi","Q7",2017,2400,
                "src/Assets/audi-logo.png",
                "src/Assets/2017_audi_q7.jpg");
        insertData.insertCar(audi2);

        Car toyota1 = new Sedan("Toyota","Supra MK4",2001,3000,
                "src/Assets/Toyota-Logo.png",
                "src/Assets/supra-7k.jpg");
        insertData.insertCar(toyota1);

        Car toyota2 = new Sedan("Toyota","Cross",2001,1750,
                "src/Assets/Toyota-Logo.png",
                "src/Assets/2022_Toyota_Corolla_Cross.jpg");
        insertData.insertCar(toyota2);

        Car tesla = new Sedan("Tesla","Model Y",2023,2750,
                "src/Assets/tesla-logo.png",
                "src/Assets/tesla-model-y-white.jpeg");
        insertData.insertCar(tesla);

        LoginRegisterView loginRegisterView = new LoginRegisterView();
        MainView mainView = new MainView();
        MainListItemView mainListItemView = new MainListItemView(mercedes1);
        CarDetailsView carDetailsView = new CarDetailsView(mercedes1);
        ProfileView profileView = new ProfileView();
        AdminView adminView = new AdminView();
        MyRentsView myRentsView = new MyRentsView();
        PdfSpecificationsView pdfSpecificationsView = new PdfSpecificationsView();

        MainController mainController = new MainController(u1, adminView, mainView, profileView,myRentsView,loginRegisterView,carDetailsView,
                mainListItemView,pdfSpecificationsView);
        MainListItemsController mainListItemsController = new MainListItemsController(mainView,mainListItemView);
        AdminController adminController = new AdminController(u1,mercedes1,adminView, mainView,mainListItemsController,mainController);
        ProfileController profileController = new ProfileController(loginRegisterView,profileView,adminController,adminView);
        new LoginRegisterController(u1,loginRegisterView, mainView,profileController,adminController,adminView);
        new CarDetailsController(mainListItemView,mercedes1,carDetailsView);
        new PdfSpecificationsController(pdfSpecificationsView);

        loginRegisterView.setVisible(true);

//        System.out.println(Car.getCars());
//        System.out.println(MainListItemView.getMainListItems());
//        System.out.println("Items size: " + MainListItemView.getMainListItems().size());
//        System.out.println("Items size: " + MainView.getCardItems().size() + MainView.getCardItems());
//        System.out.println(MainView.getCarsCards());
//        System.out.println("Users ->" + u1.getUsers());
//        System.out.println(User.getLoggedInUser());
    }
}