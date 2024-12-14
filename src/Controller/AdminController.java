package Controller;

import Model.Car;
import Model.User;
import View.AdminView;
import View.MainListItemView;
import View.MainScreenView;

import javax.swing.*;
import java.awt.*;

public class AdminController {
    private User user;
    private Car car;
    private AdminView adminView;
    private MainScreenView mainScreenView;
    private Car newestCar;
    private MainScreenListItemsController mainScreenListItemsController;

    public AdminController(User user, Car car, AdminView adminView,MainScreenView mainScreenView,
                           MainScreenListItemsController mainScreenListItemsController) {
        this.car = car;
        this.user = user;
        this.adminView = adminView;
        this.mainScreenView = mainScreenView;
        this.mainScreenListItemsController = mainScreenListItemsController;

        this.adminView.addReturnMainPageListener(e->{
            adminView.dispose();
            mainScreenView.setVisible(true);
        });

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
                System.out.println(currentCar.getMake());
                currentCar.setMake(carMake);
                System.out.println(currentCar.getMake());

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

        //initial cars are add on table
        for (Car car2: Car.getCars()){
            adminView.getCarTableModel().addRow(new Object[]{car2.getMake(), car2.getModel(),
            car2.getYear(),car2.getDailyPrice(), car2.getTinyPhotoPath(),car2.getBigPhotoPath()});
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
                        car2.getYear(), car2.getDailyPrice(), car2.getTinyPhotoPath(), car2.getBigPhotoPath()});
            }
        }

        for (User user1: user.getUsers().values()){
        if (!user1.getUsername().equals("tncy")){
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
                MainScreenListItemsController.addToList(mainListItemView);
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
        mainScreenListItemsController.clearMainListView();
        // OMG I fixed these bugs, It took 2 days, but I did.
        // OOooooooOO I am better. Bye bye stupid bugs.
        // It is working well, and I know it seems soooo complex, I will find a way to make simple.

        for (Car newCar: Car.getCars()){
            MainListItemView mainListItemView = new MainListItemView(newCar);
            MainScreenListItemsController.addToList(mainListItemView);
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
