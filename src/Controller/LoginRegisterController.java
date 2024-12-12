package Controller;

import Model.User;
import View.LoginRegisterView;
import View.MainScreenView;

import javax.swing.*;

public class LoginRegisterController {
    private User user;
    private LoginRegisterView loginRegisterView;
    private MainScreenView mainScreenView;
    private ProfileController controller;
    private AdminController adminController;

    public LoginRegisterController(User user, LoginRegisterView loginRegisterView, MainScreenView mainScreenView,
                                   ProfileController controller,AdminController adminController) {
        this.user = user;
        this.loginRegisterView = loginRegisterView;

        this.loginRegisterView.addLoginListener(e -> {
            String username = loginRegisterView.getUsernameLogin();
            String password = loginRegisterView.getPasswordLogin();

            if (user.check(username,password)){

//                User.setLoginUser(user.getUsers().get(username));

                loginRegisterView.dispose();
                mainScreenView.setVisible(true);

                User.setLoggedInUser(user.getUsers().get(username));
                System.out.println(User.getLoggedInUser());
                controller.setLabels();

                adminController.refreshTables();

            } else {
                JOptionPane.showMessageDialog(loginRegisterView, "Invalid username or password.");
            }

        });

        this.loginRegisterView.addRegisterListener(e -> {

            String name = loginRegisterView.getNameRegister();
            String surname = loginRegisterView.getSurnameRegister();
            String username = loginRegisterView.getUsernameRegister();
            String password = loginRegisterView.getPasswordRegister();

            User newUser = new User(name,surname,username,password,false);

            if (user.addUser(newUser)) {
                JOptionPane.showMessageDialog(loginRegisterView, "User registered successfully!");
            } else {
                JOptionPane.showMessageDialog(loginRegisterView, "Username already exists!");
            }

            //Test
            System.out.println(user.getUsers());
        });
    }
}
