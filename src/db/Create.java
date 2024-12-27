package db;

import java.sql.*;

public class Create {

    // new table
    public static void createNewDatabase(String fileName){
        String url = "jdbc:sqlite:" + fileName;

        try {
            Connection conn = DriverManager.getConnection(url);
            if (conn != null){
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    // Car table
    public static void createCarTable(){
        String url = "jdbc:sqlite:RentACarDb";
        String sql = "CREATE TABLE IF NOT EXISTS Cars (\n"
                + " id INTEGER PRIMARY KEY,\n"
                + " make VARCHAR(10),\n"
                + " model VARCHAR(12),\n"
                + " year INTEGER ,\n"
                + " price REAL ,\n"
                + " logoPath VARCHAR(50),\n"
                + " photoPath VARCHAR(50)\n"
                + ");";
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("Cars table has been created.");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    // User table
    public static void createUserTable(){
        String url = "jdbc:sqlite:RentACarDb";
        String sql = "CREATE TABLE IF NOT EXISTS Users (\n"
                + " name VARCHAR(15),\n"
                + " surname VARCHAR(15),\n"
                + " username VARCHAR(15) PRIMARY KEY,\n"
                + " password VARCHAR(15),\n"
                + " isAdmin INTEGER\n"
                + ");";
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("Users table has been created.");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

//    public static void createCartTable(){
//        String url = "jdbc:sqlite:RentACarDb";
//        String sql = "CREATE TABLE IF NOT EXISTS Cart (\n"
//                + " productID INTEGER PRIMARY KEY,\n"
//                + " productName VARCHAR(20),\n"
//                + " quantity INTEGER,\n"
//                + " price DOUBLE, \n"
//                + " FOREIGN KEY(productID) REFERENCES Products(productId)\n"
//                + ");";
//        try {
//            Connection conn = DriverManager.getConnection(url);
//            Statement stmt = conn.createStatement();
//            stmt.execute(sql);
//            System.out.println("Cart table has been created.");
//        } catch (SQLException e){
//            System.out.println(e.getMessage());
//        }
//
//    }
}

