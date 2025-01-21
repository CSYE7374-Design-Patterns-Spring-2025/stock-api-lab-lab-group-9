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
        Stock metaStock = new MetaStock("MetaStck", 101.15, "Meta Common Stock");
        market.addStock(amaStock);
        market.addStock(metaStock);

        String[] amazonBids = {"50", "-20", "100", "300", "-50", "200"};
        for (String bid:amazonBids){
            market.tradeStock(amaStock, bid);
        }

        String[] metaBids = {"30", "-10", "200", "-100", "50", "-200"};

        for (String bid:metaBids){
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



