package Model;

public class CarModel {
    private String make;
    private String model;
    private int year;
    private double dailyPrice;
    private String tinyPhotoPath;
    private String bigPhotoPath;

    public CarModel(String make, String model, int year, double dailyPrice,
                    String tinyPhotoPath, String bigPhotoPath) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.dailyPrice = dailyPrice;
        this.tinyPhotoPath = tinyPhotoPath;
        this.bigPhotoPath = bigPhotoPath;
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

    public String getTinyPhotoPath() {
        return tinyPhotoPath;
    }

    public void setTinyPhotoPath(String tinyPhotoPath) {
        this.tinyPhotoPath = tinyPhotoPath;
    }

    public String getBigPhotoPath() {
        return bigPhotoPath;
    }

    public void setBigPhotoPath(String bigPhotoPath) {
        this.bigPhotoPath = bigPhotoPath;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }
}
