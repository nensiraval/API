package com.example.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

//Serializable : jyare akho model class lavvano hoi tyare serializable no use thay..
public class ModelClass implements Serializable {
    Integer id;
    String tittle;
    String description; String category;
    double price;
    double discountPercentage;
    double rating;
    Integer stock; String[] tags;
    String brand;
    ArrayList<HashMap<String, Object>> reviews;
    ArrayList<String> images;
    String thumbnail ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public ArrayList<HashMap<String, Object>> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<HashMap<String, Object>> reviews) {
        this.reviews = reviews;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public ModelClass(Integer id, String tittle, String description, String category, double price, double discountPercentage,
                      double rating, Integer stock, String[] tags, String brand, ArrayList<HashMap<String, Object>> reviews, ArrayList<String> images, String thumbnail) {
        this.id = id;
        this.tittle = tittle;
        this.description = description;
        this.category = category;
        this.price = price;
        this.discountPercentage = discountPercentage;
        this.rating = rating;
        this.stock = stock;
        this.tags = tags;
        this.brand = brand;
        this.reviews = reviews;
        this.images = images;
        this.thumbnail = thumbnail;
    }
}
