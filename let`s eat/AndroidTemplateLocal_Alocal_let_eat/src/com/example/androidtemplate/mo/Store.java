package com.example.androidtemplate.mo;

/**
 *
 */
public class Store {

    private String name;
    private int img;
    private String address;
    private String cuisine;
    private String price;
    private int rating;

    private double lat;
    private double lng;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public Store(String name, int img, String address, String cuisine, String price, int rating, double lat, double lng) {
        this.name = name;
        this.img = img;
        this.address = address;
        this.cuisine = cuisine;
        this.price = price;
        this.rating = rating;
        this.lat = lat;
        this.lng = lng;
    }
}
