package edu.austral.ingsis.math;

import java.util.List;
import java.util.Map;

public class Absolute implements Function{

    private final Function value;

    public Absolute(Function value){
        this.value = value;
    }

    @Override
    public double evaluate(Map<String, Function> variables) {
        return Math.abs(value.evaluate(variables));
    }

    @Override
    public String print() {
        return "|"+ value.print() + "|";
    }

    @Override
    public List<String> getVariables() {
    	return value.getVariables();
    }
}
