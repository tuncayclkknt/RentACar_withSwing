package db;

import java.sql.*;

public class DeleteData {

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

    public void deleteUser(String username){
        String sql = "DELETE FROM Users WHERE username = ?";
        try{
            Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            int deletedUser = pstmt.executeUpdate();
            if(deletedUser > 0){
                System.out.println("User "+ username +" has deleted");
            } else {
                System.out.println("There is no user with such username and password");
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteCar(int id){
        String sql = "DELETE FROM Cars WHERE id = ?";
        try{
            Connection conn= connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            int deletedUser = pstmt.executeUpdate();
            if(deletedUser > 0){
                System.out.println("The product that has an id: "+ id +" has deleted.");
            } else {
                System.out.println("There is no product with such id");
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void dropTable(String tableName) {
        String sql = "DROP TABLE IF EXISTS " + tableName;

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(sql);
            System.out.println("Table " + tableName + " has been dropped.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}