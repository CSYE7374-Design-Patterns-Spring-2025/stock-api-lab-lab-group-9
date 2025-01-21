package edu.neu.csye7374;

public interface Tradable0 extends Tradable{
    @Override
    public default void setBid(String bid){
        System.out.println("Bid: " + bid);
    }

    @Override
    public default String getMetric(){
        return "Default Performance metric";
    }
}
