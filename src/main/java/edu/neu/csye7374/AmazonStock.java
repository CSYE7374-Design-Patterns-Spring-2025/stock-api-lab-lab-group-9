package edu.neu.csye7374;

public class AmazonStock extends Stock implements Tradable0{
  private String metric;
  private double previousPrice;

  public AmazonStock(String name, double price, String description) {
    super(name, price, description);
  }

  @Override
  public void setBid(String bid){
    try {
      double numericBid = Double.parseDouble(bid);
      previousPrice = price; // Update previous price
      price += numericBid * 0.02; // Increase price by 2% of the bid
      metric = calculateMetric(); // Update metric after bid
      } catch (NumberFormatException e) {
        System.out.println(e.getMessage());
      }
  }

  private String calculateMetric() {
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
      return metric;
  }
}
