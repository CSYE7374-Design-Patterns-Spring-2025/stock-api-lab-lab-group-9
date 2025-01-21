package edu.neu.csye7374;

/**
 * 
 * @author Shashikar Anthoni Raj
 * 
 */

public class Driver {
    public static void main(String[] args) {
        System.out.println("============Main Execution Start===================\n\n");

        //your driver code here
        StockMarket market = StockMarket.getInstance();
        Stock amaStock = new AmazonStock("AmazonStck", 131.15, "Amzn Common Stock");
        Stock metaStock = new AmazonStock("MetaStck", 101.15, "Meta Common Stock");
        market.addStock(amaStock);
        market.addStock(metaStock);

        String[] bids = {"10", "20", "55", "25.5", "30", "5"};
        for (String bid:bids){
            market.tradeStock(amaStock, bid);
        }

        for (String bid:bids){
            market.tradeStock(metaStock, bid);
        }

        System.out.println("\nAll Stocks in the Market:");
        market.showAllStocks();

        market.removeStock(amaStock);
        System.out.println("\nAfter Removing TechStock:");
        market.showAllStocks();


        System.out.println("============Main Execution End===================");
   
    }
}



