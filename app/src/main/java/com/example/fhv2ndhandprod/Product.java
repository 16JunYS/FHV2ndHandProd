package com.example.fhv2ndhandprod;

import java.util.Date;

public class Product {
    private long id;
    private String name;
    private String description;
    private double price;
    private String location;
    private Date date;
    private String seller;
    private int smallImageName;
    private int bigImageName;

    public Product(long id, String name, String description, double price, String location, Date date, String seller,  int smallImageName, int bigImageName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.location = location;
        this.date = date;
        this.seller = seller;
        this.smallImageName = smallImageName;
        this.bigImageName = bigImageName;

    }
    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
    public Product() {

    }

    public long getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    public void setName (String name) {
        this.name = name;

    }

    public double getPrice() {

        return price;

    }

    public void setPrice(double price) {

        this.price = price;

    }

    public String getDescription() {

        return  description;

    }

    public void setDescription(String description) {

        this.description = description;
    }

    public Date getData() {

        return date;
    }

    public void setData (Date date) {

        this.date = date;

    }

    public String getLocation() {

        return location;
    }

    public void setLocation(String location) {

        this.location = location;

    }


    public void setBigImageName(int bigName) {

        this.bigImageName = bigName;

    }

    public int getBigImageName() {

        return this.bigImageName;

    }

    public int getSmallImageName( ) {

        return this.smallImageName;

    }

    public void setSmallImageName(int smallName) {

        this.smallImageName = smallName;

    }

}
