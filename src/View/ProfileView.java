package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ProfileView extends JFrame {

    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;

    private JTextField nameField;
    private JTextField surnameField;
    private JTextField usernameField;
    private JTextField passwordField;

    private JButton btnEdit;
    private JButton btnSave;

    private JPanel showInfoPanel;
    private JPanel editInfoPanel;

    public ProfileView() {

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
        showInfoPanel = new JPanel();
        showInfoPanel.setLayout(null);
        showInfoPanel.setBounds(50,220,300,350);
        showInfoPanel.setBorder(new RoundedBorder(15));
        showInfoPanel.setBackground(new Color(255, 221, 221,50));

        nameLabel = new JLabel();
        nameLabel.setBounds(30,50,240,40);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        nameLabel.setBorder(new RoundedBorder(15));
        showInfoPanel.add(nameLabel);

        surnameLabel = new JLabel();
        surnameLabel.setBounds(30,110,240,40);
        surnameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        surnameLabel.setBorder(new RoundedBorder(15));
        showInfoPanel.add(surnameLabel);

        usernameLabel = new JLabel();
        usernameLabel.setBounds(30,170,240,40);
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        usernameLabel.setBorder(new RoundedBorder(15));
        showInfoPanel.add(usernameLabel);

        passwordLabel = new JLabel();
        passwordLabel.setBounds(30,230,240,40);
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        passwordLabel.setBorder(new RoundedBorder(15));
        showInfoPanel.add(passwordLabel);

        //edit panel
        editInfoPanel = new JPanel();
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

        nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 18));
        nameField.setBounds(140,55,120,30);
        editInfoPanel.add(nameField);

        JLabel surnameLabel2 = new JLabel("   Surname  :");
        surnameLabel2.setBounds(30,110,240,40);
        surnameLabel2.setFont(new Font("Arial", Font.PLAIN, 18));
        surnameLabel2.setBorder(new RoundedBorder(15));
        editInfoPanel.add(surnameLabel2);

        surnameField = new JTextField();
        surnameField.setFont(new Font("Arial", Font.PLAIN, 18));
        surnameField.setBounds(140,115,120,30);
        editInfoPanel.add(surnameField);

        JLabel usernameLabel2 = new JLabel("   Username:");
        usernameLabel2.setBounds(30,170,240,40);
        usernameLabel2.setFont(new Font("Arial", Font.PLAIN, 18));
        usernameLabel2.setBorder(new RoundedBorder(15));
        editInfoPanel.add(usernameLabel2);

        usernameField = new JTextField();
        usernameField.setFont(new Font("Arial", Font.PLAIN, 18));
        usernameField.setBounds(140,175,120,30);
        editInfoPanel.add(usernameField);

        JLabel passwordLabel2 = new JLabel("   Password :");
        passwordLabel2.setBounds(30,230,240,40);
        passwordLabel2.setFont(new Font("Arial", Font.PLAIN, 18));
        passwordLabel2.setBorder(new RoundedBorder(15));
        editInfoPanel.add(passwordLabel2);

        passwordField = new JTextField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 18));
        passwordField.setBounds(140,235,120,30);
        editInfoPanel.add(passwordField);

        btnEdit = new JButton("Edit");
        btnEdit.setFont(new Font("Arial", Font.PLAIN, 18));
        btnEdit.setBounds(250,580,100,30);

        btnSave = new JButton("Save");
        btnSave.setFont(new Font("Arial", Font.PLAIN, 18));
        btnSave.setBounds(250,580,100,30);
        btnSave.setVisible(false);

//        btnEdit.addActionListener(e->{
//            showInfoPanel.setVisible(false);
//            editInfoPanel.setVisible(true);
//            btnSave.setVisible(true);
//            btnEdit.setVisible(false);
//        });
//
//        btnSave.addActionListener(e->{
//            showInfoPanel.setVisible(true);
//            editInfoPanel.setVisible(false);
//            btnSave.setVisible(false);
//            btnEdit.setVisible(true);
//        });

        add(btnSave);
        add(btnEdit);
        add(profileIconLabel);
        add(showInfoPanel);
        add(editInfoPanel);
    }

    public void addEditListener(ActionListener listener){
        btnEdit.addActionListener(listener);
    }

    public void addSaveListener(ActionListener listener){
        btnSave.addActionListener(listener);
    }

//    public boolean isVisibleForScreen(){
//        return isVisible();
//    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public JLabel getSurnameLabel() {
        return surnameLabel;
    }

    public JLabel getUsernameLabel() {
        return usernameLabel;
    }

    public JLabel getPasswordLabel() {
        return passwordLabel;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getSurnameField() {
        return surnameField;
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JTextField getPasswordField() {
        return passwordField;
    }

    public JPanel getShowInfoPanel() {
        return showInfoPanel;
    }

    public JPanel getEditInfoPanel() {
        return editInfoPanel;
    }

    public JButton getBtnEdit() {
        return btnEdit;
    }

    public JButton getBtnSave() {
        return btnSave;
    }
}
