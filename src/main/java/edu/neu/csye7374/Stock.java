package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

abstract class Stock implements Tradable{
    String name;
    double price;
    String description;
    List<Double> priceHistory = new ArrayList<Double>();

    public Stock() {
    }

    public Stock(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public void addPriceToHistory(double price){
        priceHistory.add(price);
    }

    public void displayPriceHistory(){
        for (Double price : priceHistory) {
            System.out.println(price);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "Stock{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}' + " Price History: " + priceHistory;
    }

}
