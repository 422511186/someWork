package com.hzy.Entity;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GasUpClass  implements Serializable {
    private Integer id;
    private double price;
    private double unitPrice;
    private double mileage;
    private double Average_fuel_consumption;
    private String date;

    public GasUpClass() {
    }

    public GasUpClass(double price, double unitPrice, double mileage) {
        this.price = price;
        this.unitPrice = unitPrice;
        this.mileage = mileage;
        this.Average_fuel_consumption = (price/unitPrice)/mileage;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        date = df.format(new Date());
    }

    public GasUpClass(double price, double unitPrice, double mileage, double average_fuel_consumption) {
        this.price = price;
        this.unitPrice = unitPrice;
        this.mileage = mileage;
        this.Average_fuel_consumption = average_fuel_consumption;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        date = df.format(new Date());
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public double getAverage_fuel_consumption() {
        return Average_fuel_consumption;
    }

    public void setAverage_fuel_consumption(double average_fuel_consumption) {
        Average_fuel_consumption = average_fuel_consumption;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "GasUpClass{" +
                "id=" + id +
                ", price=" + price +
                ", unitPrice=" + unitPrice +
                ", mileage=" + mileage +
                ", Average_fuel_consumption=" + Average_fuel_consumption +
                ", date=" + date +
                '}';
    }
}

