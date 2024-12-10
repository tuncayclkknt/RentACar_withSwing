package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AdminView extends JFrame{

    public AdminView() {

        setResizable(false);
        setSize(1400,800);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setPreferredSize(new Dimension(1400, 1000));

        JLabel carsLabel = new JLabel("Cars");
        carsLabel.setBounds(20,20,130,30);
        carsLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        contentPanel.add(carsLabel);

        String[] carColumns = {"Make", "Model", "Year", "Price(daily)", "Logo", "Photo"};
        DefaultTableModel model = new DefaultTableModel(carColumns,0);
        JTable carTable = new JTable(model);
        JScrollPane carTableScroll = new JScrollPane(carTable);
        carTableScroll.setBounds(20,60,660,300);
        contentPanel.add(carTableScroll);

        JPanel carsActionPanel = new JPanel();
        carsActionPanel.setLayout(null);
        carsActionPanel.setBounds(710,60,640,300);
        carsActionPanel.setBorder(new RoundedBorder(15));
        contentPanel.add(carsActionPanel);

        JLabel makeLabel = new JLabel("Make:");
        makeLabel.setBounds(35,35,130,30);
        makeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        carsActionPanel.add(makeLabel);

        JTextField makeTextField = new JTextField();
        makeTextField.setBounds(155,30,250,40);
        makeTextField.setFont(new Font("Arial", Font.PLAIN, 18));
        carsActionPanel.add(makeTextField);

        JLabel modelLabel = new JLabel("Model:");
        modelLabel.setBounds(35,85,130,30);
        modelLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        carsActionPanel.add(modelLabel);

        JTextField modelTextField = new JTextField();
        modelTextField.setBounds(155,80,250,40);
        modelTextField.setFont(new Font("Arial", Font.PLAIN, 18));
        carsActionPanel.add(modelTextField);

        JLabel yearLabel = new JLabel("Year:");
        yearLabel.setBounds(35,135,130,30);
        yearLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        carsActionPanel.add(yearLabel);

        JTextField yearTextField = new JTextField();
        yearTextField.setBounds(155,130,250,40);
        yearTextField.setFont(new Font("Arial", Font.PLAIN, 18));
        carsActionPanel.add(yearTextField);

        JLabel logoLabel = new JLabel("Logo Path:");
        logoLabel.setBounds(35,185,130,30);
        logoLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        carsActionPanel.add(logoLabel);

        JTextField logoTextField = new JTextField();
        logoTextField.setBounds(155,180,250,40);
        logoTextField.setFont(new Font("Arial", Font.PLAIN, 18));
        carsActionPanel.add(logoTextField);

        JLabel photoLabel = new JLabel("Photo Path:");
        photoLabel.setBounds(35,235,130,30);
        photoLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        carsActionPanel.add(photoLabel);

        JTextField photoTextField = new JTextField();
        photoTextField.setBounds(155,230,250,40);
        photoTextField.setFont(new Font("Arial", Font.PLAIN, 18));
        carsActionPanel.add(photoTextField);

        JButton btnAddCar = new JButton("ADD");
        btnAddCar.setBounds(455,80,130,40);
        btnAddCar.setFont(new Font("Arial", Font.PLAIN, 18));
//        btnAddCar.setBackground(new Color(53, 151, 0,255));
//        btnAddCar.setForeground(new Color(255, 255, 255,255));
        carsActionPanel.add(btnAddCar);

        JButton btnUpdateCar = new JButton("UPDATE");
        btnUpdateCar.setBounds(455,130,130,40);
        btnUpdateCar.setFont(new Font("Arial", Font.PLAIN, 18));
//        btnUpdateCar.setBackground(new Color(0, 56, 255,255));
//        btnUpdateCar.setForeground(new Color(255, 255, 255,255));
        carsActionPanel.add(btnUpdateCar);

        JButton btnDeleteCar = new JButton("DELETE");
        btnDeleteCar.setBounds(455,180,130,40);
        btnDeleteCar.setFont(new Font("Arial", Font.PLAIN, 18));
//        btnDeleteCar.setBackground(new Color(255, 0, 0,255));
//        btnDeleteCar.setForeground(new Color(255, 255, 255,255));
        carsActionPanel.add(btnDeleteCar);

        //Users
        JLabel userLabel = new JLabel("Users");
        userLabel.setBounds(20,400,130,30);
        userLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        contentPanel.add(userLabel);

        String[] userColumns = {"Need", "Need", "Need"};
        DefaultTableModel model2 = new DefaultTableModel(userColumns,0);
        JTable userTable = new JTable(model2);
        JScrollPane userTableScroll = new JScrollPane(userTable);
        userTableScroll.setBounds(20,440,660,300);
        contentPanel.add(userTableScroll);

        JPanel usersActionPanel = new JPanel();
        usersActionPanel.setLayout(null);
        usersActionPanel.setBounds(710,440,640,300);
        usersActionPanel.setBorder(new RoundedBorder(15));
        contentPanel.add(usersActionPanel);

        JLabel needLabel = new JLabel("Need:");
        needLabel.setBounds(35,35,130,30);
        needLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        usersActionPanel.add(needLabel);

        JTextField needTextField = new JTextField();
        needTextField.setBounds(155,30,250,40);
        needTextField.setFont(new Font("Arial", Font.PLAIN, 18));
        usersActionPanel.add(needTextField);

        JLabel needLabel2 = new JLabel("Need:");
        needLabel2.setBounds(35,85,130,30);
        needLabel2.setFont(new Font("Arial", Font.PLAIN, 20));
        usersActionPanel.add(needLabel2);

        JTextField needTextField2 = new JTextField();
        needTextField2.setBounds(155,80,250,40);
        needTextField2.setFont(new Font("Arial", Font.PLAIN, 18));
        usersActionPanel.add(needTextField2);

//        JLabel yearLabel = new JLabel("Year:");
//        yearLabel.setBounds(35,135,130,30);
//        yearLabel.setFont(new Font("Arial", Font.PLAIN, 20));
//        usersActionPanel.add(yearLabel);
//
//        JTextField yearTextField = new JTextField();
//        yearTextField.setBounds(155,130,250,40);
//        yearTextField.setFont(new Font("Arial", Font.PLAIN, 18));
//        usersActionPanel.add(yearTextField);
//
//        JLabel logoLabel = new JLabel("Logo Path:");
//        logoLabel.setBounds(35,185,130,30);
//        logoLabel.setFont(new Font("Arial", Font.PLAIN, 20));
//        usersActionPanel.add(logoLabel);
//
//        JTextField logoTextField = new JTextField();
//        logoTextField.setBounds(155,180,250,40);
//        logoTextField.setFont(new Font("Arial", Font.PLAIN, 18));
//        usersActionPanel.add(logoTextField);
//
//        JLabel photoLabel = new JLabel("Photo Path:");
//        photoLabel.setBounds(35,235,130,30);
//        photoLabel.setFont(new Font("Arial", Font.PLAIN, 20));
//        usersActionPanel.add(photoLabel);
//
//        JTextField photoTextField = new JTextField();
//        photoTextField.setBounds(155,230,250,40);
//        photoTextField.setFont(new Font("Arial", Font.PLAIN, 18));
//        usersActionPanel.add(photoTextField);

        JButton btnAddUser = new JButton("ADD");
        btnAddUser.setBounds(455,80,130,40);
        btnAddUser.setFont(new Font("Arial", Font.PLAIN, 18));
//        btnAddUser.setBackground(new Color(53, 151, 0,255));
//        btnAddUser.setForeground(new Color(255, 255, 255,255));
        usersActionPanel.add(btnAddUser);

        JButton btnUpdateUser = new JButton("UPDATE");
        btnUpdateUser.setBounds(455,130,130,40);
        btnUpdateUser.setFont(new Font("Arial", Font.PLAIN, 18));
//        btnUpdateUser.setBackground(new Color(0, 56, 255,255));
//        btnUpdateUser.setForeground(new Color(255, 255, 255,255));
        usersActionPanel.add(btnUpdateUser);

        JButton btnDeleteUser = new JButton("DELETE");
        btnDeleteUser.setBounds(455,180,130,40);
        btnDeleteUser.setFont(new Font("Arial", Font.PLAIN, 18));
//        btnDeleteUser.setBackground(new Color(255, 0, 0,255));
//        btnDeleteUser.setForeground(new Color(255, 255, 255,255));
        usersActionPanel.add(btnDeleteUser);


        JScrollPane contentPanelScroll = new JScrollPane(contentPanel);
        contentPanelScroll.setBounds(0,0,1380,800);

        add(contentPanelScroll);
    }
}
