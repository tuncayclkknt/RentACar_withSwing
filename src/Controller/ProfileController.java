package Controller;

import Model.User;
import View.LoginRegisterView;
import View.ProfileView;

public class ProfileController {
    private LoginRegisterView loginRegisterView;
    private ProfileView profileView;
    private User user;

    public ProfileController(LoginRegisterView loginRegisterView, ProfileView profileView) {
        this.loginRegisterView = loginRegisterView;
        this.profileView = profileView;

    }

    public void setLabels(){
        profileView.getNameLabel().setText("   Name       : " + User.getLoggedInUser().getName());
        profileView.getSurnameLabel().setText("   Surname  : " + User.getLoggedInUser().getSurname());
        profileView.getUsernameLabel().setText("   Username: " + User.getLoggedInUser().getUsername());
        profileView.getPasswordLabel().setText("   Password : " + User.getLoggedInUser().getPassword());

        profileView.getNameField().setText(User.getLoggedInUser().getName());
        profileView.getSurnameField().setText(User.getLoggedInUser().getSurname());
        profileView.getUsernameField().setText(User.getLoggedInUser().getUsername());
        profileView.getPasswordField().setText(User.getLoggedInUser().getPassword());

        profileView.addEditListener(e->{

            profileView.getShowInfoPanel().setVisible(false);
            profileView.getEditInfoPanel().setVisible(true);
            profileView.getBtnSave().setVisible(true);
            profileView.getBtnEdit().setVisible(false);
        });

        profileView.addSaveListener(e->{

            User.getLoggedInUser().setName(profileView.getNameField().getText());
            User.getLoggedInUser().setSurname(profileView.getSurnameField().getText());
            User.getLoggedInUser().setUsername(profileView.getUsernameField().getText());
            User.getLoggedInUser().setPassword(profileView.getPasswordField().getText());

            profileView.getNameLabel().setText("   Name       : " + User.getLoggedInUser().getName());
            profileView.getSurnameLabel().setText("   Surname  : " + User.getLoggedInUser().getSurname());
            profileView.getUsernameLabel().setText("   Username: " + User.getLoggedInUser().getUsername());
            profileView.getPasswordLabel().setText("   Password : " + User.getLoggedInUser().getPassword());

            System.out.println(User.getLoggedInUser().getName());

            profileView.getShowInfoPanel().setVisible(true);
            profileView.getEditInfoPanel().setVisible(false);
            profileView.getBtnSave().setVisible(false);
            profileView.getBtnEdit().setVisible(true);
        });

    }
}
