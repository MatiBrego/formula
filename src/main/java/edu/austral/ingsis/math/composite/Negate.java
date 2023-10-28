package edu.austral.ingsis.math.composite;

import java.util.List;
import java.util.Map;

class Negate implements Function{
    private final Function value;

    public Negate(Function value){
        this.value = value;
    }

    @Override
    public double evaluate(Map<String, Function> variables) {
        return -value.evaluate(variables);
    }

    @Override
    public String print() {
        return "-"+ value.print();
    }

    @Override
    public List<String> getVariables() {
        return value.getVariables();
    }
}
