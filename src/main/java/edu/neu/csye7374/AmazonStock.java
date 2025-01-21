package edu.neu.csye7374;

public class AmazonStock extends Stock implements Tradable0{
  private String metric;
  private double previousPrice;

  public AmazonStock(String name, double price, String description) {
    super(name, price, description);
    addPriceToHistory(price);
  }

  @Override
  public void setBid(String bid){
    try {
      double numericBid = Double.parseDouble(bid);
      previousPrice = price; 
      price += numericBid * 0.02; 
      addPriceToHistory(price);
      metric = calculateMetric(); 
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
