package edu.neu.csye7374;

public interface Tradeable1 extends Tradeable{

    @Override
    default String getMetric(){
        return "Default Implementation";
    }
}
