package edu.neu.csye7374;

import java.util.List;
import java.util.Stack;

public class Stock implements Tradeable{
    private String name;
    private double price;
    private List<Double> prevPrc = new Stack<>();

    private String description;

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

    public List<Double> getPrevPrc() {
        return prevPrc;
    }

    public void setPrevPrc(List<Double> prevPrc) {
        this.prevPrc = prevPrc;
    }

    @Override
    public String toString(){
        return "Name: " + getName() + "\n"
                + "Current Price: " + getPrice() + "\n"
                + "Previous Price: " + getPrevPrc().get(getPrevPrc().size() - 1) + "\n"
                + "Description: " + getDescription() + ".";
    }


    @Override
    public void setBid(String bid) {
        prevPrc.add(Double.valueOf(bid));
    }

    @Override
    public String getMetric() {
        int perf = 0;
        double prevPrc = 0;
        for (double price: getPrevPrc().subList(getPrevPrc().size()-6, getPrevPrc().size())
        ) {
            if (price > prevPrc) {
                perf++;
            } else {
                perf--;
            }
            prevPrc = price;
        }
        return String.valueOf(perf);
    }
}
