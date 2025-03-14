package nnminh.playground.watchstoreandroid.data.model;

import java.util.List;

public class Product {
    private String name;
    private float price;
    private List<String> assets;
    private int sold;
    private float rating;

    public Product(String name, float price, List<String> assets, int sold, float rating) {
        this.name = name;
        this.price = price;
        this.assets = assets;
        this.sold = sold;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<String> getAssets() {
        return assets;
    }

    public void setAssets(List<String> assets) {
        this.assets = assets;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
