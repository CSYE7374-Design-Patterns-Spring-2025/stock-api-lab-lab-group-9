package edu.neu.csye7374;

public interface Tradable1 extends Tradable{
    @Override
    public default String getMetric(){
        return "Default Performance metric";
    }
}
