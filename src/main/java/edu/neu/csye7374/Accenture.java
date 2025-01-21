package edu.neu.csye7374;

import java.util.List;

public class Accenture extends Stock{

    public Accenture(String name, double price, String description, List<Double> prevPrc){
        super();
        setName(name);
        setPrice(price);
        setDescription(description);
        setPrevPrc(prevPrc);
    }

    @Override
    public String getMetric() {
        int perf = 0;
        double prevPrc = 0;
        for (double price : getPrevPrc().subList(getPrevPrc().size() - 6, getPrevPrc().size())
        ) {
            if (price > prevPrc) {
                perf++;
            } else {
                perf--;
            }
            prevPrc = price;
        }
        return String.valueOf(perf);
    }
}
