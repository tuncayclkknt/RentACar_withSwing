package View;

import com.formdev.flatlaf.*;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class LoginRegisterView implements IResizeImage{

    private final JPanel panel;
    private final JPanel panel2;

    private final JFrame frame;

    private final JButton btnLoginPage;
    private final JButton btnRegisterPage;

    public LoginRegisterView() {

        FlatLightLaf.setup();

        frame = new JFrame();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,800);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.white);

        panel = new JPanel();
        Border border = new TitledBorder("");
        panel.setBorder(border);
        panel.setBounds(200,10,600,600);
        panel.setLayout(null);
        panel.setBackground(Color.white);

        String profileIconPath = "src/Assets/user.png";
        ImageIcon profileIcon = IResizeImage.resizeImage(profileIconPath,175,175);

        JLabel profileIconLabel = new JLabel(profileIcon);
        profileIconLabel.setBounds(200,35,200,200);

        JLabel descriptionLabel = new JLabel("   Welcome, dear user.");
        descriptionLabel.setFont(new Font("Lucida Sans", Font.BOLD,24));
        descriptionLabel.setBounds(150,270,300,30);

        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 24));
        usernameLabel.setBounds(130,340,140,30);

        JTextField usernameField = new JTextField();
        usernameField.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
        usernameField.setBounds(270,335,200,40);

        JLabel passwordLabel = new JLabel("Password :");
        passwordLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 24));
        passwordLabel.setBounds(130,400,140,30);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 24));
        passwordField.setBounds(270,395,200,40);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBackground(new Color(166,255,228));
        btnLogin.setBounds(235,470,130,50);
        btnLogin.setFont(new Font("Lucida Sans", Font.PLAIN, 20));

        btnLogin.addActionListener(e->{
            MainScreenView view = new MainScreenView();
            view.show();
            this.hide();
        });

        panel.add(btnLogin);
        panel.add(passwordField);
        panel.add(passwordLabel);
        panel.add(usernameField);
        panel.add(descriptionLabel);
        panel.add(usernameLabel);
        panel.add(profileIconLabel);

        panel2 = new JPanel();
        Border border2 = new TitledBorder("");
        panel2.setBorder(border2);
        panel2.setBounds(200,10,600,600);
        panel2.setLayout(null);
        panel2.setBackground(Color.white);

        ImageIcon profileIcon2 = IResizeImage.resizeImage(profileIconPath,150,150);

        JLabel profileIconLabel2 = new JLabel(profileIcon2);
        profileIconLabel2.setBounds(200,20,200,200);

        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 24));
        nameLabel.setBounds(130,270,140,30);

        JTextField nameField = new JTextField();
        nameField.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
        nameField.setBounds(270,265,200,40);

        JLabel surnameLabel = new JLabel("Surname: ");
        surnameLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 24));
        surnameLabel.setBounds(130,330,140,30);

        JTextField surnameField = new JTextField();
        surnameField.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
        surnameField.setBounds(270,325,200,40);

        JLabel usernameLabel2 = new JLabel("Username: ");
        usernameLabel2.setFont(new Font("Lucida Sans", Font.PLAIN, 24));
        usernameLabel2.setBounds(130,390,140,30);

        JTextField usernameField2 = new JTextField();
        usernameField2.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
        usernameField2.setBounds(270,385,200,40);

        JLabel passwordLabel2 = new JLabel("Password :");
        passwordLabel2.setFont(new Font("Lucida Sans", Font.PLAIN, 24));
        passwordLabel2.setBounds(130,450,140,30);

        JPasswordField passwordField2 = new JPasswordField();
        passwordField2.setFont(new Font("Arial", Font.PLAIN, 24));
        passwordField2.setBounds(270,445,200,40);

        JLabel descriptionLabel2 = new JLabel("Enter your information.");
        descriptionLabel2.setFont(new Font("Lucida Sans", Font.BOLD,24));
        descriptionLabel2.setBounds(150,215,300,30);

        JButton btnRegister = new JButton("Register");
        btnRegister.setBackground(new Color(166,255,228));
        btnRegister.setBounds(235,510,130,50);
        btnRegister.setFont(new Font("Lucida Sans", Font.PLAIN, 20));

        panel2.add(profileIconLabel2);
        panel2.add(descriptionLabel2);
        panel2.add(nameLabel);
        panel2.add(surnameLabel);
        panel2.add(nameField);
        panel2.add(surnameField);
        panel2.add(btnRegister);
        panel2.add(passwordField2);
        panel2.add(passwordLabel2);
        panel2.add(usernameField2);
        panel2.add(usernameLabel2);

        btnLoginPage = new JButton("Login Page");
        btnLoginPage.setBackground(new Color(255, 140, 0, 255));
        btnLoginPage.setFont(new Font("Roboto", Font.PLAIN, 20));
        btnLoginPage.setBounds(315,650,170,50);
        btnLoginPage.setEnabled(false);

        btnRegisterPage = new JButton("Register Page");
        btnRegisterPage.setBackground(new Color(255, 140, 0, 255));
        btnRegisterPage.setFont(new Font("Roboto", Font.PLAIN, 20));
        btnRegisterPage.setBounds(515,650,170,50);

        btnRegisterPage.addActionListener(e -> {
            panel.setVisible(false);
            panel2.setVisible(true);
            btnLoginPage.setEnabled(true);
            btnRegisterPage.setEnabled(false);
        });

        btnLoginPage.addActionListener(e -> {
            panel.setVisible(true);
            panel2.setVisible(false);
            btnLoginPage.setEnabled(false);
            btnRegisterPage.setEnabled(true);
        });

        frame.add(btnRegisterPage);
        frame.add(btnLoginPage);
        frame.add(panel);
        frame.add(panel2);
    }

    public void show(){
        panel2.setVisible(false);
        panel.setVisible(true);
        frame.setVisible(true);
    }

    public void hide(){
        panel2.setVisible(false);
        panel.setVisible(false);
        frame.setVisible(false);
    }
}
