package edu.neu.csye7374;

public class MetaStock extends Stock implements Tradable1{
  String metric;
  private double previousPrice;

  public MetaStock(String name, double price, String description) {
    super(name, price, description);
    addPriceToHistory(price);
  }

  @Override
  public void setBid(String bid) {
      try {
          double numericBid = Double.parseDouble(bid);
          previousPrice = getPreviousPrice();
          price += numericBid * 0.02;
          addPriceToHistory(price); 
          this.metric = calculateMetric(); 
      } catch (NumberFormatException e) {
          System.err.println("Invalid bid format: " + bid);
      }
    }

    private String calculateMetric() {
        if (priceHistory.size() < 2) {
            return "Not enough data to calculate metric"; // Avoid calculation on first bid
        }
        previousPrice = priceHistory.get(priceHistory.size() - 2);
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
    public String getMetric(){
        return this.metric;
    }
  
}
