package edu.austral.ingsis.math.composite;

import java.util.Map;
import java.util.Set;

class Sqrt implements Function {

    private final Function value;

    public Sqrt(Function left) {
        this.value = left;
    }

    @Override
    public double evaluate(Map<String, Function> variables) {
        return Math.sqrt(value.evaluate(variables));
    }

    @Override
    public String print() {
        return "√(" + value.print() + ")";
    }

    @Override
    public Set<String> getVariables() {
        return value.getVariables();
    }
}
