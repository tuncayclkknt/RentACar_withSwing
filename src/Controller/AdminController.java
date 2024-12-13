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

    public AdminController(User user, Car car, AdminView adminView,MainScreenView mainScreenView) {
        this.car = car;
        this.user = user;
        this.adminView = adminView;
        this.mainScreenView = mainScreenView;

        this.adminView.addBtnAddCarListener(e->{

            String carMake = adminView.getMakeTextField().getText();
            String carModel = adminView.getModelTextField().getText();
            String carYear = adminView.getYearTextField().getText();
            String carPrice = adminView.getPriceTextField().getText();
            String carLogoPath = adminView.getLogoTextField().getText();
            String carPhotoPath = adminView.getPhotoTextField().getText();

            if (carMake.isEmpty() || carModel.isEmpty() || carYear.isEmpty() || carLogoPath.isEmpty() || carPhotoPath.isEmpty()) {
                JOptionPane.showMessageDialog(adminView, "Fill the gaps!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                Integer.parseInt(carYear);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(adminView, "Enter a numeric value for year!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                Double.parseDouble(carPrice);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(adminView, "Enter a double value for price!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Car newestCar = new Car(carMake,carModel,Integer.parseInt(carYear),Double.parseDouble(carPrice),carLogoPath,carPhotoPath);
            adminView.getCarTableModel().addRow(new Object[]{carMake,carModel,carYear,
                carLogoPath,carPhotoPath});

            MainScreenView.getCardItems().clear();

            for (Car newCar: Car.getCars()){
                if (newCar == newestCar){
                MainListItemView mainListItemView = new MainListItemView(newCar);
                MainListItemView.addToList(mainListItemView);
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


        });

        this.adminView.addBtnUpdateCarListener(e->{

        });

        for (Car car2: Car.getCars()){
            adminView.getCarTableModel().addRow(new Object[]{car2.getMake(), car2.getModel(),
            car2.getYear(),car2.getDailyPrice(), car2.getTinyPhotoPath(),car2.getBigPhotoPath()});
        }

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

    public void refreshMainTable(){ // If conditions ara missing!


        for (Car newCar: Car.getCars()){
            MainListItemView mainListItemView = new MainListItemView(newCar);
            MainListItemView.addToList(mainListItemView);
        }

        for (JPanel listItem : MainListItemView.getMainListItems()){
            MainScreenView.getCardItems().add(listItem);
        }

        for (JPanel items: MainScreenView.getCardItems()){
            this.mainScreenView.getCarsCards().add(items);
        }

        mainScreenView.getCarsCards().setPreferredSize(new Dimension(650,
                MainListItemView.getCounter() * 110 + 30));

        System.out.println("Items size: " + MainListItemView.getMainListItems().size());
        System.out.println("Items size: " + MainScreenView.getCardItems().size());
        System.out.println("Cars size: " + Car.getCars().size());

    }
}
