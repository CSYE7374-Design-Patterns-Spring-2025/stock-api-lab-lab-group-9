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

        Stock amazon = new Amazon("Amazon", 50.0, "amazon  Description", new ArrayList<>(Arrays.asList(40.0, 42.0, 45.0, 48.0, 49.5, 50.0)));
        amazon.setBid("52.0");
        amazon.setBid("53.5");
        amazon.setBid("54.0");
        amazon.setBid("55.0");
        stock.add(amazon);

        Stock tcs = new Tcs("Tcs", 70.0, "Tcs  Description", new ArrayList<>(Arrays.asList(65.0, 67.0, 68.0, 69.0, 70.0, 72.0)));
        tcs.setBid("74.0");
        tcs.setBid("76.0");
        tcs.setBid("78.0");
        tcs.setBid("80.0");
        stock.add(tcs);

        Stock walmart = new Walmart("Walmart", 30.0, "Walmart  Description", new ArrayList<>(Arrays.asList(25.0, 27.0, 28.0, 29.5, 30.0, 32.0)));
        walmart.setBid("33.0");
        walmart.setBid("35.0");
        walmart.setBid("36.0");
        walmart.setBid("37.0");
        stock.add(walmart);

        StockMarket stockMarket = StockMarket.getInstance();
        stockMarket.addAllStocks(stock);
        System.out.println("-----------------Initial Market--------------------");
        System.out.println(stockMarket);

        stockMarket.tradeStock("Accenture", 10.0);
        stockMarket.tradeStock("Cgi", 19.0);
        stockMarket.tradeStock("Amazon", 55.0);
        stockMarket.tradeStock("Walmart", 36.0);
        stockMarket.tradeStock("TCS", 80.0);

        System.out.println("-----------------Market after one bid--------------------");
        System.out.println(stockMarket);

        stockMarket.tradeStock("Accenture", 9.0);
        stockMarket.tradeStock("Cgi", 11.0);
        stockMarket.tradeStock("Amazon", 58.0);
        stockMarket.tradeStock("Walmart", 38.0);
        stockMarket.tradeStock("TCS", 85.0);

        System.out.println("-----------------Market after two bids--------------------");
        System.out.println(stockMarket);

        stockMarket.tradeStock("Accenture", 12.0);
        stockMarket.tradeStock("Cgi", 22.0);
        stockMarket.tradeStock("Amazon", 60.0);
        stockMarket.tradeStock("Walmart", 40.0);
        stockMarket.tradeStock("TCS", 90.0);

        System.out.println("-----------------Market after three bids--------------------");
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
