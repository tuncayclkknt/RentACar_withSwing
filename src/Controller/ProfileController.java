package Controller;

import Model.User;
import View.LoginRegisterView;
import View.ProfileView;

public class ProfileController {
    private LoginRegisterView loginRegisterView;
    private ProfileView profileView;
    private User user;

    public ProfileController(LoginRegisterView loginRegisterView, ProfileView profileView, User user) {
        this.loginRegisterView = loginRegisterView;
        this.user = user;
        this.profileView = profileView;

        profileView.getNameLabel().setText("   Name       : " + user.getLoggedInUser().getName());
        profileView.getSurnameLabel().setText("   Surname  : " + user.getSurname());
        profileView.getUsernameLabel().setText("   Username: " + user.getUsername());
        profileView.getPasswordLabel().setText("   Password : " + user.getPassword());

    }
}
