package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockMarket {

    private static StockMarket instance;
    private final List<Stock> stockLst = new ArrayList<>();
    private StockMarket(){

    }

    public static StockMarket getInstance() {
        if (instance == null){
            instance = new StockMarket();
        }
        return instance;
    }

    public void addStock(Stock stock){
        stockLst.add(stock);
    }

    public void addAllStocks(ArrayList<Stock> stockArrLst){
        stockLst.addAll(stockArrLst);
    }

    public void deleteStock(Stock stock){
        stockLst.remove(stock);
    }

    public void deleteStocks(ArrayList<Stock> stockArrLst){
        stockLst.removeAll(stockArrLst);
    }

    public void tradeStock(String name, double price){
        for(Stock stock: stockLst) {
            if (stock.getName().equals(name)) {
                stock.setBid(String.valueOf(stock.getPrice()));
                stock.setPrice(price);
            }
        }
    }

    public static void demo(){
        ArrayList<Stock> stock = new ArrayList<>();

        Stock accenture = new Accenture("Accenture", 15.0, "Accenture description", new ArrayList<>(Arrays.asList(1.0,2.3,3.4,5.5,6.6,7.7)));
        accenture.setBid("8.0");
        accenture.setBid("12.0");
        accenture.setBid("15.0");
        accenture.setBid("18.0");
        stock.add(accenture);

        Stock cgi = new Cgi("Cgi", 25.0, "Cgi  Description", new ArrayList<>(Arrays.asList(11.0,9.3,13.4,15.5,16.6,10.7)));
        cgi.setBid("11.0");
        cgi.setBid("12.0");
        cgi.setBid("13.0");
        cgi.setBid("7.0");
        stock.add(cgi);

        StockMarket stockMarket = StockMarket.getInstance();
        stockMarket.addAllStocks(stock);
        System.out.println("-----------------Initial Market--------------------");
        System.out.println(stockMarket);

        stockMarket.tradeStock("Accenture", 10.0);
        stockMarket.tradeStock("Cgi", 19.0);

        System.out.println("-----------------Market after one bid--------------------");
        System.out.println(stockMarket);

        stockMarket.tradeStock("Accenture", 9.0);
        stockMarket.tradeStock("Cgi", 11.0);

        System.out.println("-----------------Market after two bids--------------------");
        System.out.println(stockMarket);

        stockMarket.deleteStock(accenture);
        System.out.println("-----------------Deleted one stock--------------------");
        System.out.println(stockMarket);
    }

    @Override
    public String toString(){
        StringBuilder strBldr = new StringBuilder();
        for(Stock stock: stockLst){
            strBldr.append(stock.toString());
            strBldr.append("Performance: ").append(stock.getMetric()).append("\n");
        }
        return strBldr.toString();
    }
}
