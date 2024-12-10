package Controller;

import Model.UserModel;
import View.LoginRegisterView;
import View.MainScreenView;

import javax.swing.*;

public class LoginRegisterController {
    private UserModel userModel;
    private LoginRegisterView loginRegisterView;
    private MainScreenView mainScreenView;

    public LoginRegisterController(UserModel userModel, LoginRegisterView loginRegisterView, MainScreenView mainScreenView) {
        this.userModel = userModel;
        this.loginRegisterView = loginRegisterView;

        this.loginRegisterView.addLoginListener(e -> {
            String username = loginRegisterView.getUsernameLogin();
            String password = loginRegisterView.getPasswordLogin();

            if (userModel.check(username,password)){
                loginRegisterView.dispose();
                mainScreenView.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(loginRegisterView, "Invalid username or password.");
            }

        });

        this.loginRegisterView.addRegisterListener(e -> {

            String name = loginRegisterView.getNameRegister();
            String surname = loginRegisterView.getSurnameRegister();
            String username = loginRegisterView.getUsernameRegister();
            String password = loginRegisterView.getPasswordRegister();

            UserModel user = new UserModel(name,surname,username,password,false);

            if (userModel.addUser(user)) {
                JOptionPane.showMessageDialog(loginRegisterView, "User registered successfully!");
            } else {
                JOptionPane.showMessageDialog(loginRegisterView, "Username already exists!");
            }

            //Test
            System.out.println(userModel.getUsers());
        });
    }
}
