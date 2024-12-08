import Controller.LoginRegisterController;
import Model.UserModel;
import View.LoginRegisterView;

public class Main {
    public static void main(String[] args) {

        UserModel u1 = new UserModel("Tuncay","sdg","tncy","123",true);

        LoginRegisterView loginRegisterView = new LoginRegisterView();

        new LoginRegisterController(u1,loginRegisterView);

        loginRegisterView.show();
        
    }
}