package Model;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String make;
    private String model;
    private int year;
    private double dailyPrice;
    private String logoPath;
    private String photoPath;

    private static int nextID = 1;
    private int carId;

    private static final List<Car> cars = new ArrayList<>();

    public Car(String make, String model, int year, double dailyPrice,
               String logoPath, String photoPath) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.dailyPrice = dailyPrice;
        this.logoPath = logoPath;
        this.photoPath = photoPath;
        this.carId = nextID++;

        cars.add(this);
    }
//
//    public void addCar(Car car){
//        cars.add(car);
//    }


    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public static List<Car> getCars() {
        return cars;
    }

    public static int getNextID() {
        return nextID;
    }
}
