package edu.neu.csye7374;

public class AppleStock extends Stock implements Tradable1{
  private String metric;

    public AppleStock(String name, double price, String description) {
        super(name, price, description);
        addPriceToHistory(price);
    }

    @Override
    public void setBid(String bid) {
        try {
            double numericBid = Double.parseDouble(bid);
            price += numericBid * 0.03;
            addPriceToHistory(price);
            metric = evaluateMetric();
        } catch (NumberFormatException e) {
            System.out.println("Invalid bid: " + bid);
        }
    }

    private String evaluateMetric() {
        if (priceHistory.size() < 2) {
            return "Not enough data to calculate metric";
        }
        double previousPrice = priceHistory.get(priceHistory.size() - 2);
        double percentageChange = ((price - previousPrice) / previousPrice) * 100;

        if (percentageChange > 2) {
            return String.format("+%.2f%% (Buy more stock!)", percentageChange);
        } else if (percentageChange < -2) {
            return String.format("%.2f%% (Sell stock!)", percentageChange);
        } else {
            return String.format("%.2f%% (Hold stock)", percentageChange);
        }
    }

    @Override
    public String getMetric() {
        return metric;
    }
}
