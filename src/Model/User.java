package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class User {
    private String name;
    private String surname;
    private String username;
    private String password;
    private boolean isAdmin;


    private Hashtable<String, User> users;

    //private List<Car> rentedCars;
    private HashMap<Car,Integer> rentedCars;

    private static User loggedInUser;

    public User(String name, String surname, String username,
                String password, boolean isAdmin) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;

        rentedCars = new HashMap<>();

        users = new Hashtable<>();
        users.put(username,this);
        loggedInUser = this;
    }

    public boolean addUser(User user){
        if (!users.containsKey(user.username)){
            users.put(user.username,user);
            return true;
        }
        else
            return false;
    }

    // ************ TRYING ************
    public void addRentedCars(Car car, int quantity){
        loggedInUser.rentedCars.put(car, quantity);
    }

    public boolean check(String username, String password){
        return users.containsKey(username) && users.get(username).getPassword().equals(password);
    }

    //-----------------


    public HashMap<Car, Integer> getRentedCars() {
        return rentedCars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Hashtable<String, User> getUsers() {
        return users;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User user) {
        loggedInUser = user;
    }

}
