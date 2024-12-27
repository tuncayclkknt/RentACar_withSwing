package Controller;

import Model.User;
import View.AdminView;
import View.LoginRegisterView;
import View.MainView;
import db.InsertData;

import javax.swing.*;
import java.awt.*;

public class LoginRegisterController {
    private User user;
    private LoginRegisterView loginRegisterView;
    private MainView mainView;
    private ProfileController controller;
    private AdminController adminController;
    private AdminView adminView;

    public LoginRegisterController(User user, LoginRegisterView loginRegisterView, MainView mainView,
                                   ProfileController controller,AdminController adminController,AdminView adminView) {
        this.user = user;
        this.loginRegisterView = loginRegisterView;
        this.mainView = mainView;
        this.controller = controller;
        this.adminController = adminController;
        this.adminView = adminView;

        this.loginRegisterView.addLoginListener(e -> {
            String username = loginRegisterView.getUsernameLogin();
            String password = loginRegisterView.getPasswordLogin();

            if (user.check(username,password)){

//                User.setLoginUser(user.getUsers().get(username));

                loginRegisterView.dispose();
                mainView.setVisible(true);

                User.setLoggedInUser(user.getUsers().get(username));
                System.out.println(User.getLoggedInUser());
                controller.setLabels();

                System.out.println("Control for login button ->" + user.getUsers());

                mainView.getBtnAdminPage().setVisible( User.getLoggedInUser().isAdmin() ); //simplify if else
                loginRegisterView.clearLoginInputs();

            } else {
                JOptionPane.showMessageDialog(loginRegisterView, "Invalid username or password.");
            }

        });

        this.loginRegisterView.addRegisterListener(e -> {

            String name = loginRegisterView.getNameRegister();
            String surname = loginRegisterView.getSurnameRegister();
            String username = loginRegisterView.getUsernameRegister();
            String password = loginRegisterView.getPasswordRegister();

            if (name.isEmpty() || surname.isEmpty() || username.isEmpty() || password.isEmpty()) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(loginRegisterView, "Fill the gaps!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            User newUser = new User(name,surname,username,password,false);

            if (user.addUser(newUser)) {

                JOptionPane.showMessageDialog(loginRegisterView, "User registered successfully!");

                adminView.getUserTableModel().setRowCount(1); //clear
                adminController.refreshTables();

                InsertData insertData = new InsertData();
                insertData.insertUsers(newUser);

            } else {
                JOptionPane.showMessageDialog(loginRegisterView, "Username already exists!");
            }

            loginRegisterView.clearRegisterInputs();

            //show login page, I will try to find a short way to do it.
            loginRegisterView.getPanel().setVisible(true);
            loginRegisterView.getPanel2().setVisible(false);
            loginRegisterView.getBtnLoginPage().setEnabled(false);
            loginRegisterView.getBtnRegisterPage().setEnabled(true);

            //Test
            System.out.println(user.getUsers());
        });
    }
}
