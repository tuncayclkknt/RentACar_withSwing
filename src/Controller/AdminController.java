package Controller;

import Model.Car;
import Model.User;
import View.AdminView;
import View.MainListItemView;
import View.MainScreenView;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class AdminController {
    private User user;
    private Car car;
    private AdminView adminView;
    private MainScreenView mainScreenView;
    private Car newestCar;
    private User newUser;
    private MainListItemsController mainListItemsController;
    private MainController mainController;

    public AdminController(User user, Car car, AdminView adminView,MainScreenView mainScreenView,
                           MainListItemsController mainListItemsController,MainController mainController) {
        this.car = car;
        this.user = user;
        this.adminView = adminView;
        this.mainScreenView = mainScreenView;
        this.mainListItemsController = mainListItemsController;
        this.mainController = mainController;

        System.out.println("User on adminController: " + user.getUsers());

        this.adminView.addReturnMainPageListener(e->{
            adminView.dispose();
            mainScreenView.setVisible(true);
        });

//        refreshTables();
        System.out.println("User on adminController: " + user.getUsers());

        //when you select a row, gaps are fill.
        this.adminView.getCarTable().getSelectionModel().addListSelectionListener(e->{

            int selectedRow = adminView.getCarTable().getSelectedRow();

            if (selectedRow != -1){
                String make =  (String) adminView.getCarTable().getValueAt(selectedRow,0);
                String model =  (String) adminView.getCarTable().getValueAt(selectedRow,1);
                String year =  String.valueOf( adminView.getCarTable().getValueAt(selectedRow,2));
                String price =  String.valueOf(adminView.getCarTable().getValueAt(selectedRow,3));
                String logoPath =  (String) adminView.getCarTable().getValueAt(selectedRow,4);
                String photoPath = (String) adminView.getCarTable().getValueAt(selectedRow,5);

                adminView.getMakeTextField().setText(make);
                adminView.getModelTextField().setText(model);
                adminView.getYearTextField().setText(year);
                adminView.getPriceTextField().setText(price);
                adminView.getLogoTextField().setText(logoPath);
                adminView.getPhotoTextField().setText(photoPath);
            }
        });

        //when you select a row, gaps are fill.
        this.adminView.getUserTable().getSelectionModel().addListSelectionListener(e->{

            int selectedRow = adminView.getUserTable().getSelectedRow();

            if (selectedRow != -1){
                String name = (String) adminView.getUserTable().getValueAt(selectedRow,0);
                String surname = (String) adminView.getUserTable().getValueAt(selectedRow,1);
                String username = (String) adminView.getUserTable().getValueAt(selectedRow,2);
                String password = (String) (adminView.getUserTable().getValueAt(selectedRow,3));
                boolean isAdmin = (Boolean) adminView.getUserTable().getValueAt(selectedRow,4);

                adminView.getNameTextField().setText(name);
                adminView.getSurnameTextField().setText(surname);
                adminView.getUsernameTextField().setText(username);
                adminView.getPasswordTextField().setText(password);
                adminView.getIsAdminCheckBox().setSelected(isAdmin);
            }
        });

        this.adminView.addBtnAddCarListener(e->{

            //maybe there is a simpler way.
            String carMake = adminView.getMakeTextField().getText();
            String carModel = adminView.getModelTextField().getText();
            String carYear = adminView.getYearTextField().getText();
            String carPrice = adminView.getPriceTextField().getText();
            String carLogoPath = adminView.getLogoTextField().getText();
            String carPhotoPath = adminView.getPhotoTextField().getText();

            if (carMake.isEmpty() || carModel.isEmpty() || carYear.isEmpty() || carLogoPath.isEmpty() || carPhotoPath.isEmpty()) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(adminView, "Fill the gaps!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                Integer.parseInt(carYear);
            } catch (NumberFormatException ex) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(adminView, "Enter a numeric value for year!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                Double.parseDouble(carPrice);
            } catch (NumberFormatException ex) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(adminView, "Enter a double value for price!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            newestCar = new Car(carMake,carModel,Integer.parseInt(carYear),Double.parseDouble(carPrice),carLogoPath,carPhotoPath);
            adminView.getCarTableModel().addRow(new Object[]{carMake,carModel,carYear, carPrice,
                carLogoPath,carPhotoPath});

            adminView.getMakeTextField().setText("");
            adminView.getModelTextField().setText("");
            adminView.getYearTextField().setText("");
            adminView.getPriceTextField().setText("");
            adminView.getLogoTextField().setText("");
            adminView.getPhotoTextField().setText("");

            refreshMainTableForAddition();

        });

        this.adminView.addBtnUpdateCarListener(e->{

            int selectedRow = adminView.getCarTable().getSelectedRow();

            if (selectedRow != -1){

                //maybe there is a simpler way.
                String carMake = adminView.getMakeTextField().getText();
                String carModel = adminView.getModelTextField().getText();
                String carYear = adminView.getYearTextField().getText();
                String carPrice = adminView.getPriceTextField().getText();
                String carLogoPath = adminView.getLogoTextField().getText();
                String carPhotoPath = adminView.getPhotoTextField().getText();

                if (carMake.isEmpty() || carModel.isEmpty() || carYear.isEmpty() || carLogoPath.isEmpty() ||
                        carPhotoPath.isEmpty() || carPrice.isEmpty()) {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(adminView, "Fill the gaps!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    Integer.parseInt(carYear);
                } catch (NumberFormatException ex) {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(adminView, "Enter a numeric value for year!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    Double.parseDouble(carPrice);
                } catch (NumberFormatException ex) {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(adminView, "Enter a double value for price!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                adminView.getCarTableModel().setValueAt(carMake,selectedRow,0);
                adminView.getCarTableModel().setValueAt(carModel,selectedRow,1);
                adminView.getCarTableModel().setValueAt(carYear,selectedRow,2);
                adminView.getCarTableModel().setValueAt(carPrice,selectedRow,3);
                adminView.getCarTableModel().setValueAt(carLogoPath,selectedRow,4);
                adminView.getCarTableModel().setValueAt(carPhotoPath,selectedRow,5);

                Car currentCar = Car.getCars().get(adminView.getCarTable().getSelectedRow());

                currentCar.setMake(carMake);
                currentCar.setModel(carModel);
                currentCar.setYear(Integer.parseInt(carYear));
                currentCar.setDailyPrice(Integer.parseInt(carPrice));
                currentCar.setLogoPath(carLogoPath);
                currentCar.setPhotoPath(carPhotoPath);

//                adminView.getMakeTextField().setText("");
//                adminView.getModelTextField().setText("");
//                adminView.getYearTextField().setText("");
//                adminView.getPriceTextField().setText("");
//                adminView.getLogoTextField().setText("");
//                adminView.getPhotoTextField().setText("");

                refreshMainTableForUpdateDelete();

            }
            else{
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(adminView,"Select a row.",
                        "Error",JOptionPane.ERROR_MESSAGE);
            }
        });

        this.adminView.addBtnDeleteCarListener(e->{

            //it is also selected car id.
            int selectedRow = adminView.getCarTable().getSelectedRow();

            if (selectedRow != -1){
                adminView.getCarTableModel().removeRow(selectedRow);

                Car.getCars().remove(selectedRow);
                refreshMainTableForUpdateDelete();
            } else {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(adminView,"Select a row.",
                        "Error",JOptionPane.ERROR_MESSAGE);
            }

        });

        this.adminView.addBtnAddUserListener(e->{

            String name = adminView.getNameTextField().getText();
            String surname = adminView.getSurnameTextField().getText();
            String username = adminView.getUsernameTextField().getText();
            String password = adminView.getPasswordTextField().getText();
            boolean isAdmin = adminView.getIsAdminCheckBox().isSelected();


//            adminView.getUserTableModel().setRowCount(0);
//            refreshTables();

            for(User testUser: user.getUsers().values()){
                System.out.println("->" + testUser);
            }

            if (name.isEmpty() || surname.isEmpty() || username.isEmpty() || password.isEmpty()){
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(adminView, "Fill the gaps!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            newUser = new User(name,surname,username,password,isAdmin);
            if (user.addUser(newUser)){
                adminView.getUserTableModel().addRow(new Object[]{name,surname,username,password,isAdmin});

                adminView.getNameTextField().setText("");
                adminView.getSurnameTextField().setText("");
                adminView.getUsernameTextField().setText("");
                adminView.getPasswordTextField().setText("");
                adminView.getIsAdminCheckBox().setSelected(false);
            }
            else
                JOptionPane.showMessageDialog(adminView,"Error");

        });

        this.adminView.addBtnUpdateUserListener(e->{

            int selectedRow = adminView.getUserTable().getSelectedRow();

            if (selectedRow != -1) {
                String selectedUsername = String.valueOf(adminView.getUserTableModel().getValueAt(selectedRow,2));

                String name = adminView.getNameTextField().getText();
                String surname = adminView.getSurnameTextField().getText();
                String username = adminView.getUsernameTextField().getText();
                String password = adminView.getPasswordTextField().getText();
                boolean isAdmin = adminView.getIsAdminCheckBox().isSelected();

                if (name.isEmpty() || surname.isEmpty() || username.isEmpty() || password.isEmpty()) {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(adminView, "Fill the gaps!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

//                if (user.getUsers().containsKey(username)){
//                    Toolkit.getDefaultToolkit().beep();
//                    JOptionPane.showMessageDialog(adminView, "This username already exist!", "Error", JOptionPane.ERROR_MESSAGE);
//                    return;
//                }

                User temp = user.getUsers().get(selectedUsername); //Yeahhh, it is for a fixing.

                if (mainController.usersBridge().get(selectedUsername) != null) {

                    mainController.usersBridge().remove(selectedUsername);

                    if (user.addUser(new User(name,surname,username,password,isAdmin))){


                        adminView.getUserTableModel().setValueAt(name,selectedRow,0);
                        adminView.getUserTableModel().setValueAt(surname,selectedRow,1);
                        adminView.getUserTableModel().setValueAt(username,selectedRow,2);
                        adminView.getUserTableModel().setValueAt(password,selectedRow,3);
                        adminView.getUserTableModel().setValueAt(isAdmin,selectedRow,4);

//                        mainController.usersBridge().get(selectedUsername).setName(name);
//                        mainController.usersBridge().get(selectedUsername).setSurname(surname);
//                        mainController.usersBridge().get(selectedUsername).setUsername(username);
//                        mainController.usersBridge().get(selectedUsername).setPassword(password);
//                        mainController.usersBridge().get(selectedUsername).setAdmin(isAdmin);

//                        adminView.getNameTextField().setText("");
//                        adminView.getSurnameTextField().setText("");
//                        adminView.getUsernameTextField().setText("");
//                        adminView.getPasswordTextField().setText("");
//                        adminView.getIsAdminCheckBox().setSelected(false);

                        //test
                        System.out.println(user.getUsers());
                    } else {
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(adminView, "This username already exist!", "Error", JOptionPane.ERROR_MESSAGE);

                        user.getUsers().put(temp.getUsername(),temp);
                    }
                } else {
                    System.out.println("user.getUsers().get(username) is null!!!");
                }
            }
        });

        this.adminView.addBtnDeleteUserListener(e->{

            int selectedRow = adminView.getUserTable().getSelectedRow();
            String selectedUsername = String.valueOf(adminView.getUserTableModel().getValueAt(selectedRow,2));

            if (selectedRow != -1){

                adminView.getUserTableModel().removeRow(selectedRow);
                user.getUsers().remove(selectedUsername);

            } else {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(adminView,"Select a row.",
                        "Error",JOptionPane.ERROR_MESSAGE);
            }
        });

        //initial cars are add on table
        for (Car car2: Car.getCars()){
            adminView.getCarTableModel().addRow(new Object[]{car2.getMake(), car2.getModel(),
            car2.getYear(),car2.getDailyPrice(), car2.getLogoPath(),car2.getPhotoPath()});
        }

        //initial users are add on table
        for (User user1: user.getUsers().values()){
            adminView.getUserTableModel().addRow(new Object[]{user1.getName(),user1.getSurname(),
                    user1.getUsername(),user1.getPassword(),user1.isAdmin()});
        }
    }

    public void refreshTables(){
        for (Car car2: Car.getCars()){
            if (!Car.getCars().contains(car2)) {
                adminView.getCarTableModel().addRow(new Object[]{car2.getMake(), car2.getModel(),
                        car2.getYear(), car2.getDailyPrice(), car2.getLogoPath(), car2.getPhotoPath()});
            }
        }

        for (User user1: user.getUsers().values()){
        if (!user1.getUsername().isEmpty())
            {
                adminView.getUserTableModel().addRow(new Object[]{user1.getName(),user1.getSurname(),
                    user1.getUsername(),user1.getPassword(),user1.isAdmin()});
            }
        }
    }

    public void refreshMainTableForAddition(){ // If conditions ara missing!

        MainScreenView.getCardItems().clear();

        for (Car newCar: Car.getCars()){
            if (newCar == newestCar){
                MainListItemView mainListItemView = new MainListItemView(newCar);
                MainListItemsController.addToList(mainListItemView);
            }
        }

        for (JPanel listItem : MainListItemView.getMainListItems()){
            MainScreenView.getCardItems().add(listItem);
        }

        for (JPanel items: MainScreenView.getCardItems()){ //there is a missing part.
            this.mainScreenView.getCarsCards().add(items);
        }

        mainScreenView.getCarsCards().setPreferredSize(new Dimension(650,
                MainListItemView.getCounter() * 110 + 30));

        System.out.println("Items size: " + MainListItemView.getMainListItems().size());
        System.out.println("Items size: " + MainScreenView.getCardItems().size());
        System.out.println("Cars size: " + Car.getCars().size());

    }

    public void refreshMainTableForUpdateDelete(){
        MainScreenView.getCardItems().clear();
        MainListItemView.getMainListItems().clear();

        System.out.println("Items size: " + MainListItemView.getMainListItems().size());
        System.out.println("Items size: " + MainScreenView.getCardItems().size());
        System.out.println("Cars size: " + Car.getCars().size());

//        mainScreenView.getCarsCards().removeAll();
        mainListItemsController.clearMainListView();
        // OMG I fixed these bugs, It took 2 days, but I did.
        // OOooooooOO I am better. Bye bye stupid bugs.
        // It is working well, and I know it seems soooo complex, I will find a way to make simple.

        for (Car newCar: Car.getCars()){
            MainListItemView mainListItemView = new MainListItemView(newCar);
            MainListItemsController.addToList(mainListItemView);
            System.out.println("->" + newCar.getMake());
        }

        for (JPanel listItem : MainListItemView.getMainListItems()){
            MainScreenView.getCardItems().add(listItem);
        }

        for (JPanel items: MainScreenView.getCardItems()){ //there is a missing part.
            this.mainScreenView.getCarsCards().add(items);
        }

        mainScreenView.getCarsCards().setPreferredSize(new Dimension(650,
                MainListItemView.getCounter() * 110 + 30));

        System.out.println("Items size: " + MainListItemView.getMainListItems().size());
        System.out.println("Items size: " + MainScreenView.getCardItems().size());
        System.out.println("Cars size: " + Car.getCars().size());
    }
}
