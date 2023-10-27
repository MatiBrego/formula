package edu.austral.ingsis.math.composite;

import java.util.List;
import java.util.Map;

public class Value implements Function{

    private final double value;

    public Value(double value){
        this.value = value;
    }

    @Override
    public double evaluate(Map<String, Function> variables) {
        return this.value;
    }

    @Override
    public String print() {
        return this.formatValue();
    }

    private String formatValue(){
        if(value % 1 == 0){
            return String.valueOf((int) value);
        }
        return String.valueOf(value);
    }

    @Override
    public List<String> getVariables() {
    	return List.of();
    }
}
