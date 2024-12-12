package Controller;

import Model.Car;
import Model.User;
import View.AdminView;

import javax.swing.*;

public class AdminController {
    private User user;
    private Car car;
    private AdminView adminView;

    public AdminController(User user, Car car, AdminView adminView) {
        this.car = car;
        this.user = user;
        this.adminView = adminView;

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

            new Car(carMake,carModel,Integer.parseInt(carYear),Double.parseDouble(carPrice),carLogoPath,carPhotoPath);
            adminView.getCarTableModel().addRow(new Object[]{carMake,carModel,carYear,
                carLogoPath,carPhotoPath});


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
}
