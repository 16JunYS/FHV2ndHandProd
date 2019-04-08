package com.example.fhv2ndhandprod;

import java.util.Date;

public class Product {
    private long id;
    private String name;
    private String description;
    private String image;
    private double price;
    private String location;
    private Date date;
    private String seller;


    public Product(String name, String description, String image, double price, String location, Date date, String seller) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.location = location;
        this.date = date;
        this.seller = seller;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public double getPrice() {
        return price;
    }

    public String getLocation() {
        return location;
    }

    // the return would be the name of the seller

    public String getEmailSeller() {
        return null;
    }

    // the return would be the phone number of the seller

    public String getPhoneSeller() {
        return null;
    }

    public Date getProductDate() { return date; }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setProductDate (Date date) { this.date = date;}
}
