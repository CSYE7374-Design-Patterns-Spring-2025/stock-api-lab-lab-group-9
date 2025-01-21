package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {
    private static StockMarket instance;
    List<Stock> stockList = new ArrayList<Stock>();

    public StockMarket() {
        instance = null;
    }

    public static StockMarket getInstance() {
        if (instance == null) {
            synchronized (StockMarket.class) {
                if (instance == null) {
                    instance = new StockMarket();
                }
            }
        }
        return instance;
    }

    public void addStock(Stock stock){
        stockList.add(stock);
    }

    public void removeStock(Stock stock) {
        stockList.remove(stock);
    }

    public void tradeStock(Stock stock, String bid) {
        stock.setBid(bid);
        System.out.println(stock.toString() + ", Metric: " + stock.getMetric());
    }

    public void showAllStocks() {
        for (Stock stock : stockList) {
            System.out.println(stock);
        }
    }
}
