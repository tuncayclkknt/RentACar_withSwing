package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class AdminView extends JFrame{

    private DefaultTableModel carTableModel;
    private DefaultTableModel userTableModel;
    private DefaultTableModel rentedCarsModel;

    private JTable carTable;
    private JTable userTable;
    private JTable rentedCarsTable;

    private JTextField makeTextField;
    private JTextField modelTextField;
    private JTextField yearTextField;
    private JTextField priceTextField;
    private JTextField logoTextField;
    private JTextField photoTextField;

    private JTextField nameTextField;
    private JTextField surnameTextField;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JCheckBox isAdminCheckBox;

    private JButton btnAddCar;
    private JButton btnUpdateCar;
    private JButton btnDeleteCar;
    private JButton btnAddUser;
    private JButton btnUpdateUser;
    private JButton btnDeleteUser;

    private JButton btnReturnMainPage;

    public AdminView() {

        setResizable(false);
        setSize(1400,800);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);

        JLayeredPane layeredPane = new JLayeredPane(); //layered pane, I know it is a good explanation.
        setContentPane(layeredPane);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setPreferredSize(new Dimension(1400, 1500));

        JLabel carsLabel = new JLabel("Cars");
        carsLabel.setBounds(20,20,130,30);
        carsLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        contentPanel.add(carsLabel);

        String[] carColumns = {"Id","Make", "Model", "Year", "Price(daily)", "Logo", "Photo"};
        carTableModel = new DefaultTableModel(carColumns,0);
        carTable = new JTable(carTableModel);
        carTable.setDefaultEditor(Object.class,null);
        JScrollPane carTableScroll = new JScrollPane(carTable);
        carTableScroll.setBounds(20,60,660,350);
        contentPanel.add(carTableScroll);

        JPanel carsActionPanel = new JPanel();
        carsActionPanel.setLayout(null);
        carsActionPanel.setBounds(710,60,640,350);
        carsActionPanel.setBorder(new RoundedBorder(15));
        contentPanel.add(carsActionPanel);

        JLabel makeLabel = new JLabel("Make:");
        makeLabel.setBounds(35,35,130,30);
        makeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        carsActionPanel.add(makeLabel);

        makeTextField = new JTextField();
        makeTextField.setBounds(155,30,250,40);
        makeTextField.setFont(new Font("Arial", Font.PLAIN, 18));
        carsActionPanel.add(makeTextField);

        JLabel modelLabel = new JLabel("Model:");
        modelLabel.setBounds(35,85,130,30);
        modelLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        carsActionPanel.add(modelLabel);

        modelTextField = new JTextField();
        modelTextField.setBounds(155,80,250,40);
        modelTextField.setFont(new Font("Arial", Font.PLAIN, 18));
        carsActionPanel.add(modelTextField);

        JLabel yearLabel = new JLabel("Year:");
        yearLabel.setBounds(35,135,130,30);
        yearLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        carsActionPanel.add(yearLabel);

        yearTextField = new JTextField();
        yearTextField.setBounds(155,130,250,40);
        yearTextField.setFont(new Font("Arial", Font.PLAIN, 18));
        carsActionPanel.add(yearTextField);

        JLabel priceLabel = new JLabel("Daily Price:");
        priceLabel.setBounds(35,185,130,30);
        priceLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        carsActionPanel.add(priceLabel);

        priceTextField = new JTextField();
        priceTextField.setBounds(155,180,250,40);
        priceTextField.setFont(new Font("Arial", Font.PLAIN, 18));
        carsActionPanel.add(priceTextField);

        JLabel logoLabel = new JLabel("Logo Path:");
        logoLabel.setBounds(35,235,130,30);
        logoLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        carsActionPanel.add(logoLabel);

        logoTextField = new JTextField();
        logoTextField.setBounds(155,230,250,40);
        logoTextField.setFont(new Font("Arial", Font.PLAIN, 18));
        carsActionPanel.add(logoTextField);

        JLabel photoLabel = new JLabel("Photo Path:");
        photoLabel.setBounds(35,285,130,30);
        photoLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        carsActionPanel.add(photoLabel);

        photoTextField = new JTextField();
        photoTextField.setBounds(155,280,250,40);
        photoTextField.setFont(new Font("Arial", Font.PLAIN, 18));
        carsActionPanel.add(photoTextField);

        btnAddCar = new JButton("ADD");
        btnAddCar.setBounds(455,80,130,40);
        btnAddCar.setFont(new Font("Arial", Font.PLAIN, 18));
//        btnAddCar.setBackground(new Color(53, 151, 0,255));
//        btnAddCar.setForeground(new Color(255, 255, 255,255));
        carsActionPanel.add(btnAddCar);

        btnUpdateCar = new JButton("UPDATE");
        btnUpdateCar.setBounds(455,130,130,40);
        btnUpdateCar.setFont(new Font("Arial", Font.PLAIN, 18));
//        btnUpdateCar.setBackground(new Color(0, 56, 255,255));
//        btnUpdateCar.setForeground(new Color(255, 255, 255,255));
        carsActionPanel.add(btnUpdateCar);

        btnDeleteCar = new JButton("DELETE");
        btnDeleteCar.setBounds(455,180,130,40);
        btnDeleteCar.setFont(new Font("Arial", Font.PLAIN, 18));
//        btnDeleteCar.setBackground(new Color(255, 0, 0,255));
//        btnDeleteCar.setForeground(new Color(255, 255, 255,255));
        carsActionPanel.add(btnDeleteCar);

        //Users
        JLabel userLabel = new JLabel("Users");
        userLabel.setBounds(20,450,130,30);
        userLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        contentPanel.add(userLabel);

        String[] userColumns = {"Name", "Surname", "Username","Password","isAdmin"};
        userTableModel = new DefaultTableModel(userColumns,0);
        userTable = new JTable(userTableModel);
        userTable.setDefaultEditor(Object.class,null);
        JScrollPane userTableScroll = new JScrollPane(userTable);
        userTableScroll.setBounds(20,490,660,300);
        contentPanel.add(userTableScroll);

        JPanel usersActionPanel = new JPanel();
        usersActionPanel.setLayout(null);
        usersActionPanel.setBounds(710,490,640,300);
        usersActionPanel.setBorder(new RoundedBorder(15));
        contentPanel.add(usersActionPanel);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(35,35,130,30);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        usersActionPanel.add(nameLabel);

        nameTextField = new JTextField();
        nameTextField.setBounds(155,30,250,40);
        nameTextField.setFont(new Font("Arial", Font.PLAIN, 18));
        usersActionPanel.add(nameTextField);

        JLabel surnameLabel = new JLabel("Surname:");
        surnameLabel.setBounds(35,85,130,30);
        surnameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        usersActionPanel.add(surnameLabel);

        surnameTextField = new JTextField();
        surnameTextField.setBounds(155,80,250,40);
        surnameTextField.setFont(new Font("Arial", Font.PLAIN, 18));
        usersActionPanel.add(surnameTextField);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(35,135,130,30);
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        usersActionPanel.add(usernameLabel);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(155,130,250,40);
        usernameTextField.setFont(new Font("Arial", Font.PLAIN, 18));
        usersActionPanel.add(usernameTextField);
//
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(35,185,130,30);
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        usersActionPanel.add(passwordLabel);

        passwordTextField = new JTextField();
        passwordTextField.setBounds(155,180,250,40);
        passwordTextField.setFont(new Font("Arial", Font.PLAIN, 18));
        usersActionPanel.add(passwordTextField);
//
        JLabel isAdminLabel = new JLabel("Is Admin:");
        isAdminLabel.setBounds(35,235,130,30);
        isAdminLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        usersActionPanel.add(isAdminLabel);

        isAdminCheckBox = new JCheckBox();
        isAdminCheckBox.setBounds(155,230,250,40);
        isAdminCheckBox.setFont(new Font("Arial", Font.PLAIN, 20));
        usersActionPanel.add(isAdminCheckBox);

        String[] rentedCarsColumns = {"Username", "Car Id", "Car Make","Day Counter","Price"};
        rentedCarsModel = new DefaultTableModel(rentedCarsColumns,0);
        rentedCarsTable = new JTable(rentedCarsModel);
        rentedCarsTable.setDefaultEditor(Object.class,null);
        JScrollPane rentedCarsTableScroll = new JScrollPane(rentedCarsTable);
        rentedCarsTableScroll.setBounds(20,870,660,300);
        contentPanel.add(rentedCarsTableScroll);


        btnAddUser = new JButton("ADD");
        btnAddUser.setBounds(455,80,130,40);
        btnAddUser.setFont(new Font("Arial", Font.PLAIN, 18));
//        btnAddUser.setBackground(new Color(53, 151, 0,255));
//        btnAddUser.setForeground(new Color(255, 255, 255,255));
        usersActionPanel.add(btnAddUser);

        btnUpdateUser = new JButton("UPDATE");
        btnUpdateUser.setBounds(455,130,130,40);
        btnUpdateUser.setFont(new Font("Arial", Font.PLAIN, 18));
//        btnUpdateUser.setBackground(new Color(0, 56, 255,255));
//        btnUpdateUser.setForeground(new Color(255, 255, 255,255));
        usersActionPanel.add(btnUpdateUser);

        btnDeleteUser = new JButton("DELETE");
        btnDeleteUser.setBounds(455,180,130,40);
        btnDeleteUser.setFont(new Font("Arial", Font.PLAIN, 18));
//        btnDeleteUser.setBackground(new Color(255, 0, 0,255));
//        btnDeleteUser.setForeground(new Color(255, 255, 255,255));
        usersActionPanel.add(btnDeleteUser);

        JScrollPane contentPanelScroll = new JScrollPane(contentPanel);
        contentPanelScroll.setBounds(0,0,1380,800);
        layeredPane.add(contentPanelScroll, JLayeredPane.DEFAULT_LAYER);

        btnReturnMainPage = new JButton("Return Main Page");
        btnReturnMainPage.setBounds(1190,10,160,40);
        btnReturnMainPage.setFont(new Font("Arial", Font.PLAIN, 16));
        btnReturnMainPage.setBackground(new Color(0, 56, 255,255));
        btnReturnMainPage.setForeground(new Color(255, 255, 255,255));
        layeredPane.add(btnReturnMainPage, JLayeredPane.PALETTE_LAYER);

//        add(btnReturnMainPage);
//        add(contentPanelScroll);
    }

    public void addReturnMainPageListener(ActionListener listener){
        btnReturnMainPage.addActionListener(listener);
    }

    public void addBtnAddCarListener(ActionListener listener){
        btnAddCar.addActionListener(listener);
    }

    public void addBtnUpdateCarListener(ActionListener listener){
        btnUpdateCar.addActionListener(listener);
    }

    public void addBtnDeleteCarListener(ActionListener listener){
        btnDeleteCar.addActionListener(listener);
    }
    public void addBtnAddUserListener(ActionListener listener){
        btnAddUser.addActionListener(listener);
    }

    public void addBtnUpdateUserListener(ActionListener listener){
        btnUpdateUser.addActionListener(listener);
    }

    public void addBtnDeleteUserListener(ActionListener listener){
        btnDeleteUser.addActionListener(listener);
    }

    public DefaultTableModel getRentedCarsModel() {
        return rentedCarsModel;
    }

    public JTable getRentedCarsTable() {
        return rentedCarsTable;
    }

    public DefaultTableModel getUserTableModel() {
        return userTableModel;
    }

    public DefaultTableModel getCarTableModel() {
        return carTableModel;
    }

    public JCheckBox getIsAdminCheckBox() {
        return isAdminCheckBox;
    }

    public JTextField getPasswordTextField() {
        return passwordTextField;
    }

    public JTextField getUsernameTextField() {
        return usernameTextField;
    }

    public JTextField getSurnameTextField() {
        return surnameTextField;
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public JTextField getPhotoTextField() {
        return photoTextField;
    }

    public JTextField getModelTextField() {
        return modelTextField;
    }

    public JTextField getMakeTextField() {
        return makeTextField;
    }

    public JTextField getLogoTextField() {
        return logoTextField;
    }

    public JTextField getYearTextField() {
        return yearTextField;
    }

    public JTextField getPriceTextField() {
        return priceTextField;
    }

    public JTable getCarTable() {
        return carTable;
    }

    public JTable getUserTable() {
        return userTable;
    }
}