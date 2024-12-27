package Controller;

import Model.Car;
import Model.User;
import View.AdminView;
import View.MainListItemView;
import View.MainView;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import db.DeleteData;
import db.InsertData;
import db.UpdateData;

import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AdminController {
    private User user;
    private Car car;
    private AdminView adminView;
    private MainView mainView;
    private Car newestCar;
    private User newUser;
    private MainListItemsController mainListItemsController;
    private MainController mainController;

    private DeleteData deleteData;
    private InsertData insertData;
    private UpdateData updateData;

    public AdminController(User user, Car car, AdminView adminView, MainView mainView,
                           MainListItemsController mainListItemsController, MainController mainController) {
        this.car = car;
        this.user = user;
        this.adminView = adminView;
        this.mainView = mainView;
        this.mainListItemsController = mainListItemsController;
        this.mainController = mainController;

        deleteData = new DeleteData();
        insertData = new InsertData();
        updateData = new UpdateData();

        System.out.println("User on adminController: " + user.getUsers());

        this.adminView.addReturnMainPageListener(e->{
            adminView.dispose();
            mainView.setVisible(true);
        });

//        refreshTables();
        System.out.println("User on adminController: " + user.getUsers());

        //when you select a row, gaps are fill.
        this.adminView.getCarTable().getSelectionModel().addListSelectionListener(e->{

            int selectedRow = adminView.getCarTable().getSelectedRow();

            if (selectedRow != -1){
                String make =  (String) adminView.getCarTable().getValueAt(selectedRow,1);
                String model =  (String) adminView.getCarTable().getValueAt(selectedRow,2);
                String year =  String.valueOf( adminView.getCarTable().getValueAt(selectedRow,3));
                String price =  String.valueOf(adminView.getCarTable().getValueAt(selectedRow,4));
                String logoPath =  (String) adminView.getCarTable().getValueAt(selectedRow,5);
                String photoPath = (String) adminView.getCarTable().getValueAt(selectedRow,6);

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

            //*********** TEST *************
            System.out.println(User.getLoggedInUser().getRentedCars());

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
            adminView.getCarTableModel().addRow(new Object[]{this.newestCar.getCarId(),carMake,carModel,carYear, carPrice,
                carLogoPath,carPhotoPath});

            insertData.insertCar(newestCar);

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

                adminView.getCarTableModel().setValueAt(carMake,selectedRow,1);
                adminView.getCarTableModel().setValueAt(carModel,selectedRow,2);
                adminView.getCarTableModel().setValueAt(carYear,selectedRow,3);
                adminView.getCarTableModel().setValueAt(carPrice,selectedRow,4);
                adminView.getCarTableModel().setValueAt(carLogoPath,selectedRow,5);
                adminView.getCarTableModel().setValueAt(carPhotoPath,selectedRow,6);

                Car currentCar = Car.getCars().get(adminView.getCarTable().getSelectedRow());

                updateData.updateCar((int)adminView.getCarTable().getValueAt(selectedRow,0),carMake,carModel,Integer.parseInt(carYear),
                        Double.parseDouble(carPrice),carLogoPath,carPhotoPath);

                currentCar.setMake(carMake);
                currentCar.setModel(carModel);
                currentCar.setYear(Integer.parseInt(carYear));
                currentCar.setDailyPrice(Double.parseDouble(carPrice));
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

                deleteData.deleteCar((int)adminView.getCarTable().getValueAt(selectedRow,0));

                adminView.getCarTableModel().removeRow(selectedRow);

//                Car.getCars().remove((int)adminView.getCarTable().getValueAt(selectedRow - 1,0));
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

                insertData.insertUsers(newUser);

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

                if (!selectedUsername.equals(username)){
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(adminView, "You cannot change username!", "Error", JOptionPane.ERROR_MESSAGE);
                    adminView.getUserTable().clearSelection();
                    return;
                }

//                if (user.getUsers().containsKey(username)){
//                    Toolkit.getDefaultToolkit().beep();
//                    JOptionPane.showMessageDialog(adminView, "This username already exist!", "Error", JOptionPane.ERROR_MESSAGE);
//                    return;
//                }

//                User temp = user.getUsers().get(selectedUsername); //Yeahhh, it is for a fixing.

                if (mainController.usersBridge().get(selectedUsername) != null) {

//                    mainController.usersBridge().remove(selectedUsername);
//                    deleteData.deleteUser(selectedUsername);
//                    User addedUser = new User(name,surname,username,password,isAdmin);

                    adminView.getUserTableModel().setValueAt(name,selectedRow,0);
                    adminView.getUserTableModel().setValueAt(surname,selectedRow,1);
//                        adminView.getUserTableModel().setValueAt(username,selectedRow,2);
                    adminView.getUserTableModel().setValueAt(password,selectedRow,3);
                    adminView.getUserTableModel().setValueAt(isAdmin,selectedRow,4);

                    int isAdmin2 = 0;
                    if (isAdmin)
                        isAdmin2 = 1;

                    mainController.usersBridge().get(selectedUsername).setName(name);
                    mainController.usersBridge().get(selectedUsername).setSurname(surname);
                    mainController.usersBridge().get(selectedUsername).setPassword(password);
                    mainController.usersBridge().get(selectedUsername).setAdmin(isAdmin);

                    updateData.updateUser(name,surname,username,password,isAdmin2);
                    adminView.getUserTable().clearSelection();

                    //test
                    System.out.println(user.getUsers());

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

                deleteData.deleteUser(selectedUsername);

            } else {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(adminView,"Select a row.",
                        "Error",JOptionPane.ERROR_MESSAGE);
            }
        });

        //initial cars are add on table
        for (Car car2: Car.getCars()){
            adminView.getCarTableModel().addRow(new Object[]{car2.getCarId(), car2.getMake(), car2.getModel(),
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
                adminView.getCarTableModel().addRow(new Object[]{Car.getNextID(),car2.getMake(), car2.getModel(),
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

        MainView.getCardItems().clear();

        for (Car newCar: Car.getCars()){
            if (newCar == newestCar){
                MainListItemView mainListItemView = new MainListItemView(newCar);
                MainListItemsController.addToList(mainListItemView);
            }
        }

        for (JPanel listItem : MainListItemView.getMainListItems()){
            MainView.getCardItems().add(listItem);
        }

        for (JPanel items: MainView.getCardItems()){ //there is a missing part.
            MainView.getCarsCards().add(items);
        }

        MainView.getCarsCards().setPreferredSize(new Dimension(650,
                MainListItemView.getCounter() * 110 + 30));

        System.out.println("Items size: " + MainListItemView.getMainListItems().size());
        System.out.println("Items size: " + MainView.getCardItems().size());
        System.out.println("Cars size: " + Car.getCars().size());

    }

    public void refreshMainTableForUpdateDelete(){
        MainView.getCardItems().clear();
        MainListItemView.getMainListItems().clear();

        System.out.println("Items size: " + MainListItemView.getMainListItems().size());
        System.out.println("Items size: " + MainView.getCardItems().size());
        System.out.println("Cars size: " + Car.getCars().size());

//        mainView.getCarsCards().removeAll();
        MainListItemsController.clearMainListView();
        // OMG I fixed these bugs, It took 2 days, but I did.
        // OOooooooOO I am better. Bye bye stupid bugs.
        // It is working well, and I know it seems soooo complex, I will find a way to make simple.

        for (Car newCar: Car.getCars()){
            MainListItemView mainListItemView = new MainListItemView(newCar);
            MainListItemsController.addToList(mainListItemView);
            System.out.println("->" + newCar.getMake());
        }

        for (JPanel listItem : MainListItemView.getMainListItems()){
            MainView.getCardItems().add(listItem);
        }

        for (JPanel items: MainView.getCardItems()){ //there is a missing part.
            MainView.getCarsCards().add(items);
        }

        MainView.getCarsCards().setPreferredSize(new Dimension(650,
                MainListItemView.getCounter() * 110 + 30));

        System.out.println("Items size: " + MainListItemView.getMainListItems().size());
        System.out.println("Items size: " + MainView.getCardItems().size());
        System.out.println("Cars size: " + Car.getCars().size());
    }
}
