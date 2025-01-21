package edu.neu.csye7374;

public class AmazonStock extends Stock implements Tradable0{
  private String metric;

  public AmazonStock(String name, double price, String description) {
    super(name, price, description);
  }

  @Override
  public void setBid(String bid){
    try {
      double numericBid = Double.parseDouble(bid);
      price += numericBid * 0.05;
      metric = String.valueOf(price / 100);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public String getMetric(){
      return metric;
  }
}
