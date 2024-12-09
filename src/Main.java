import Controller.CarDetailsController;
import Controller.LoginRegisterController;
import Controller.MainScreenController;
import Controller.MainScreenListItemsController;
import Model.CarModel;
import Model.Sedan;
import Model.UserModel;
import View.*;

public class Main {
    public static void main(String[] args) {

        UserModel u1 = new UserModel("Tuncay","sdg","tncy","123",true);

        CarModel mercedes1 = new Sedan("Mercedes","C 180 AMG",2018,1200,
                "src/Assets/mercedes-benz.png",
                "src/Assets/mercedes_c180amg_2018.jpg");

        CarModel mercedes2 = new Sedan("Merco","C 180 AMG",2018,1200,
                "src/Assets/mercedes-benz.png",
                "src/Assets/mercedes_c180amg_2018.jpg");

        CarModel mercedes3 = new Sedan("Merceee","C 180 AMG",2018,1200,
                "src/Assets/mercedes-benz.png",
                "src/Assets/mercedes_c180amg_2018.jpg");

        MainScreenListItem mainScreenListItem = new MainScreenListItem(mercedes2);
        LoginRegisterView loginRegisterView = new LoginRegisterView();
        AdminPageView adminPageView = new AdminPageView();
        ProfileScreenView profileScreenView = new ProfileScreenView();
        MyRentsView myRentsView = new MyRentsView();
        CarDetailsView carDetailsView = new CarDetailsView();
        MainScreenView mainScreenView = new MainScreenView();

        new LoginRegisterController(u1,loginRegisterView,mainScreenView);
        new CarDetailsController(mainScreenListItem,mercedes2,carDetailsView,mainScreenView);
        new MainScreenController(u1,adminPageView,mainScreenView,profileScreenView,myRentsView);
        new MainScreenListItemsController(mainScreenView);

        loginRegisterView.setVisible(true);

        System.out.println(CarModel.getCars());
        System.out.println(MainScreenListItem.getItems());
        System.out.println("Items size: " + MainScreenListItem.getItems().size());
        System.out.println("Items size: " + MainScreenView.getCardItems().size() + MainScreenView.getCardItems());
        System.out.println(mainScreenView.getCarsCards());

        //dynamically
    }
}