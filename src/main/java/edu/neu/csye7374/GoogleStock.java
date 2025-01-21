package edu.neu.csye7374;

public class GoogleStock extends Stock {
    private double searchIndex;

    public GoogleStock(String name, double price, String description) {
        super(name, price, description);
    }

    @Override
    public void setBid(String bid) {
        double bidValue = Double.parseDouble(bid);
        addPriceToHistory(this.price);
        this.price += bidValue * 0.03;
        this.searchIndex = this.price * 1.1 + bidValue * 0.5;
    }

    @Override
    public String getMetric() {
        return "GoogleStock Search Index: " + searchIndex;
    }
}

