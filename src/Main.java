import Controller.*;
import Model.Car;
import Model.Sedan;
import Model.User;
import View.*;

public class Main {
    public static void main(String[] args) {

        User u1 = new User("Tuncay","Çelikkanat","tncy","123",true);

        Car mercedes1 = new Sedan("Mercedes","C 180 AMG",2018,1200,
                "src/Assets/mercedes-benz.png",
                "src/Assets/mercedes_c180amg_2018.jpg");

        Car mercedes2 = new Sedan("Merco1","C 180 AMG",2018,1200,
                "src/Assets/mercedes-benz.png",
                "src/Assets/mercedes_c180amg_2018.jpg");

        Car mercedes3 = new Sedan("Merceee","C 180 AMG",2018,1200,
                "src/Assets/mercedes-benz.png",
                "src/Assets/mercedes_c180amg_2018.jpg");

        Car mercedes4 = new Sedan("Mercoasdsdf","C 180 AMG",2018,1200,
                "src/Assets/mercedes-benz.png",
                "src/Assets/mercedes_c180amg_2018.jpg");

        Car mercedes5 = new Sedan("dgadsg","C 180 AMG",2018,1200,
                "src/Assets/mercedes-benz.png",
                "src/Assets/mercedes_c180amg_2018.jpg");


        MainListItemView mainListItemView = new MainListItemView(mercedes1);
        LoginRegisterView loginRegisterView = new LoginRegisterView();
        ProfileView profileView = new ProfileView();
        AdminView adminView = new AdminView();
        MyRentsView myRentsView = new MyRentsView();
        CarDetailsView carDetailsView = new CarDetailsView();
        MainScreenView mainScreenView = new MainScreenView();


        new LoginRegisterController(u1,loginRegisterView,mainScreenView);
        new CarDetailsController(mainListItemView,mercedes1,carDetailsView,mainScreenView);
        new ProfileController(loginRegisterView,profileView,u1);
        new MainScreenController(u1, adminView,mainScreenView, profileView,myRentsView);
        new MainScreenListItemsController(mainScreenView);

        loginRegisterView.setVisible(true);

        System.out.println(Car.getCars());
        System.out.println(MainListItemView.getItems());
        System.out.println("Items size: " + MainListItemView.getItems().size());
        System.out.println("Items size: " + MainScreenView.getCardItems().size() + MainScreenView.getCardItems());
        System.out.println(mainScreenView.getCarsCards());

    }
}