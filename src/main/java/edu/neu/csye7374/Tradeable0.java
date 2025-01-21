package edu.neu.csye7374;

public interface Tradeable0 extends Tradeable{

    @Override
    default void setBid(String bid){

    }

    @Override
    default String getMetric(){
        return "Default Implementation";
    }
}
