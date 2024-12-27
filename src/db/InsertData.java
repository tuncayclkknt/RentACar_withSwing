package db;

import Model.Car;
import Model.User;
import java.sql.*;

public class InsertData {
    private Connection connect(){
        String url = "jdbc:sqlite:RentACarDb";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }

    // insert user
    public void insertUsers(User user){
        String sql = "INSERT INTO Users(name,surname,username,password,isAdmin) VALUES(?,?,?,?,?)";
        try{
            Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user.getName());
            pstmt.setString(2,user.getSurname());
            pstmt.setString(3,user.getUsername());
            pstmt.setString(4,user.getPassword());

            int isAdmin = 0;
            if (user.isAdmin())
                isAdmin = 1;

            pstmt.setInt(5, isAdmin);
            pstmt.executeUpdate();
            System.out.println("User registered successfully");
        } catch (SQLException e){
            System.out.println("Username has already taken");
        }
    }

    // insert car
    public void insertCar(Car car){
        String sql = "INSERT INTO Cars(id,make, model, year, price, logoPath, photoPath) VALUES(?,?,?,?,?,?,?)";
        try{
            Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,car.getCarId());
            pstmt.setString(2, car.getMake());
            pstmt.setString(3, car.getModel());
            pstmt.setInt(4,car.getYear());
            pstmt.setDouble(5,car.getDailyPrice());
            pstmt.setString(6,car.getLogoPath());
            pstmt.setString(7,car.getPhotoPath());
            pstmt.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

//    public void insertCart(Products a, int quantity){
//        String sql = "INSERT INTO Cart(productId ,productName, quantity, price) VALUES(?,?,?,?)";
//        try{
//            Connection conn = this.connect();
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setInt(1,a.getProductId());
//            pstmt.setString(2,a.getName());
//            pstmt.setInt(3,quantity);
//            pstmt.setDouble(4,a.getPrice() * quantity);
//            pstmt.executeUpdate();
//        } catch (SQLException e){
////            System.out.println(e.getMessage());
//        }
//    }

}
