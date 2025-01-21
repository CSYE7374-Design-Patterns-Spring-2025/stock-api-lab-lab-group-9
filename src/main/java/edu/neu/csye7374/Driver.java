package edu.neu.csye7374;

/**
 * 
 * @author Shashikar Anthoni Raj
 * 
 */

public class Driver {
    public static void main(String[] args) {
        System.out.println("============ Main Execution Start ===============\n\n");

        // Singleton Stock Market instance
        StockMarket market = StockMarket.getInstance();

        // Create Stock Instances
        Stock amaStock = new AmazonStock("AmazonStock", 131.15, "Amzn Common Stock");
        Stock metaStock = new MetaStock("MetaStock", 101.15, "Meta Common Stock");
        Stock teslaStock = new TeslaStock("TeslaStock", 200.75, "Tesla Common Stock");
        Stock appleStock = new AppleStock("AppleStock", 175.30, "Apple Common Stock");
        Stock googleStock = new GoogleStock("GoogleStock", 280.50, "Google Common Stock");

        // Add stocks to the market
        market.addStock(amaStock);
        market.addStock(metaStock);
        market.addStock(teslaStock);
        market.addStock(appleStock);
        market.addStock(googleStock);

        // Trading operations for Amazon stock
        String[] amazonBids = {"50", "-20", "100", "300", "-50", "200"};
        System.out.println("Trading Amazon Stock:");
        for (String bid : amazonBids) {
            market.tradeStock(amaStock, bid);
        }
        amaStock.displayPriceHistory();

        // Trading operations for Meta stock
        String[] metaBids = {"30", "-10", "200", "-100", "50", "-200"};
        System.out.println("\nTrading Meta Stock:");
        for (String bid : metaBids) {
            market.tradeStock(metaStock, bid);
        }
        metaStock.displayPriceHistory();

        // Trading operations for Tesla stock
        String[] teslaBids = {"500", "-100", "300", "-50", "700", "-200"};
        System.out.println("\nTrading Tesla Stock:");
        for (String bid : teslaBids) {
            market.tradeStock(teslaStock, bid);
        }
        teslaStock.displayPriceHistory();

        // Trading operations for Apple stock
        String[] appleBids = {"400", "-50", "200", "-100", "150", "-50"};
        System.out.println("\nTrading Apple Stock:");
        for (String bid : appleBids) {
            market.tradeStock(appleStock, bid);
        }
        appleStock.displayPriceHistory();

        // Trading operations for Google stock
        String[] googleBids = {"1000", "200", "1500", "500", "700", "300"};
        System.out.println("\nTrading Google Stock:");
        for (String bid : googleBids) {
            market.tradeStock(googleStock, bid);
        }
        googleStock.displayPriceHistory();

        // Display all stocks in the market
        System.out.println("\nAll Stocks in the Market:");
        market.showAllStocks();

        // Remove a stock from the market
        market.removeStock(amaStock);
        System.out.println("\nAfter Removing Amazon Stock:");
        market.showAllStocks();

        System.out.println("\n============ Main Execution End ===============");
    }
}
