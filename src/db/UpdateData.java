package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateData {

    private Connection connect(){
        String url = "jdbc:sqlite:RentACarDb";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void updateCar(int id,String make, String model, int year, double price, String logo, String photo){

        String sql = "UPDATE Cars SET make = ?, model = ?, year = ?, price = ?," +
                "logoPath = ?, photoPath = ? WHERE id = ?";

        try {
            Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,make);
            pstmt.setString(2,model);
            pstmt.setInt(3,year);
            pstmt.setDouble(4,price);
            pstmt.setString(5,logo);
            pstmt.setString(6,photo);
            pstmt.setInt(7,id);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Selected car is updated successfully.");
            } else {
                System.out.println("Selected car cannot update.");
            }

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    //there is a problem in here, it for just I will notice
    public void updateUser(String name, String surname, String username, String password,int isAdmin){

        String sql = "UPDATE Users SET name = ?, surname = ?, password = ?," +
                "isAdmin = ? WHERE username = ?";

        try {
            Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,name);
            pstmt.setString(2,surname);
            pstmt.setString(3,password);
            pstmt.setInt(4,isAdmin);
            pstmt.setString(5,username);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Selected car is updated successfully.");
            } else {
                System.out.println("Selected car cannot update.");
            }

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
