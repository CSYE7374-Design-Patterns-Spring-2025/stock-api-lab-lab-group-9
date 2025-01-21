package edu.neu.csye7374;

public class MetaStock extends Stock implements Tradable1{
  String metric;

  public MetaStock(String name, double price, String description) {
    super(name, price, description);
  }

  @Override
  public void setBid(String bid) {
      try {
          double numericBid = Double.parseDouble(bid);
          price += numericBid * 0.02; 
          metric = String.valueOf(Math.sqrt(price)); 
      } catch (NumberFormatException e) {
          System.err.println("Invalid bid format: " + bid);
      }
  }
  @Override
    public String getMetric(){
        return metric;
    }
  
}
