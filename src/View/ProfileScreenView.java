package View;

import javax.swing.*;
import java.awt.*;

public class ProfileScreenView extends JFrame {

    public ProfileScreenView() {

        setResizable(false);
        setSize(400,800);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int frameWidth = getWidth();
        int frameHeight = getHeight();

        int x = screenSize.width - frameWidth;
        int y = (screenSize.height - frameHeight - 50) / 2;
        setLocation(x, y);

        ImageIcon profileIcon = IResizeImage.resizeImage("src/Assets/user.png",
                100,100);
        JLabel profileIconLabel = new JLabel(profileIcon);
        profileIconLabel.setBounds(150,50,100,100);

        //show panel
        JPanel showInfoPanel = new JPanel();
        showInfoPanel.setLayout(null);
        showInfoPanel.setBounds(50,220,300,350);
        showInfoPanel.setBorder(new RoundedBorder(15));
        showInfoPanel.setBackground(new Color(255, 221, 221,50));

        JLabel nameLabel = new JLabel("   Name       : Tuncay");
        nameLabel.setBounds(30,50,240,40);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        nameLabel.setBorder(new RoundedBorder(15));
        showInfoPanel.add(nameLabel);

        JLabel surnameLabel = new JLabel("   Surname  : Çelikkanat");
        surnameLabel.setBounds(30,110,240,40);
        surnameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        surnameLabel.setBorder(new RoundedBorder(15));
        showInfoPanel.add(surnameLabel);

        JLabel usernameLabel = new JLabel("   Username: tuncayoski");
        usernameLabel.setBounds(30,170,240,40);
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        usernameLabel.setBorder(new RoundedBorder(15));
        showInfoPanel.add(usernameLabel);

        JLabel passwordLabel = new JLabel("   Password : 1234");
        passwordLabel.setBounds(30,230,240,40);
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        passwordLabel.setBorder(new RoundedBorder(15));
        showInfoPanel.add(passwordLabel);


        //edit panel
        JPanel editInfoPanel = new JPanel();
        editInfoPanel.setLayout(null);
        editInfoPanel.setBounds(50,220,300,350);
        editInfoPanel.setBorder(new RoundedBorder(15));
        editInfoPanel.setBackground(new Color(255, 221, 221,50));
        editInfoPanel.setVisible(false);

        JLabel nameLabel2 = new JLabel("   Name       :");
        nameLabel2.setBounds(30,50,240,40);
        nameLabel2.setFont(new Font("Arial", Font.PLAIN, 18));
        nameLabel2.setBorder(new RoundedBorder(15));
        editInfoPanel.add(nameLabel2);

        JTextField nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 18));
        nameField.setBounds(140,55,120,30);
        editInfoPanel.add(nameField);

        JLabel surnameLabel2 = new JLabel("   Surname  :");
        surnameLabel2.setBounds(30,110,240,40);
        surnameLabel2.setFont(new Font("Arial", Font.PLAIN, 18));
        surnameLabel2.setBorder(new RoundedBorder(15));
        editInfoPanel.add(surnameLabel2);

        JTextField surnameField = new JTextField();
        surnameField.setFont(new Font("Arial", Font.PLAIN, 18));
        surnameField.setBounds(140,115,120,30);
        editInfoPanel.add(surnameField);

        JLabel usernameLabel2 = new JLabel("   Username:");
        usernameLabel2.setBounds(30,170,240,40);
        usernameLabel2.setFont(new Font("Arial", Font.PLAIN, 18));
        usernameLabel2.setBorder(new RoundedBorder(15));
        editInfoPanel.add(usernameLabel2);

        JTextField usernameField = new JTextField();
        usernameField.setFont(new Font("Arial", Font.PLAIN, 18));
        usernameField.setBounds(140,175,120,30);
        editInfoPanel.add(usernameField);

        JLabel passwordLabel2 = new JLabel("   Password :");
        passwordLabel2.setBounds(30,230,240,40);
        passwordLabel2.setFont(new Font("Arial", Font.PLAIN, 18));
        passwordLabel2.setBorder(new RoundedBorder(15));
        editInfoPanel.add(passwordLabel2);

        JTextField passwordField = new JTextField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 18));
        passwordField.setBounds(140,235,120,30);
        editInfoPanel.add(passwordField);

        JButton btnEdit = new JButton("Edit");
        btnEdit.setFont(new Font("Arial", Font.PLAIN, 18));
        btnEdit.setBounds(250,580,100,30);

        JButton btnSave = new JButton("Save");
        btnSave.setFont(new Font("Arial", Font.PLAIN, 18));
        btnSave.setBounds(250,580,100,30);
        btnSave.setVisible(false);

        btnEdit.addActionListener(e->{
            showInfoPanel.setVisible(false);
            editInfoPanel.setVisible(true);
            btnSave.setVisible(true);
            btnEdit.setVisible(false);
        });

        btnSave.addActionListener(e->{
            showInfoPanel.setVisible(true);
            editInfoPanel.setVisible(false);
            btnSave.setVisible(false);
            btnEdit.setVisible(true);
        });


        add(btnSave);
        add(btnEdit);
        add(profileIconLabel);
        add(showInfoPanel);
        add(editInfoPanel);
    }

    public boolean isVisibleForScreen(){
        return isVisible();
    }
}
