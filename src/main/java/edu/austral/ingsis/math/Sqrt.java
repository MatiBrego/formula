package edu.austral.ingsis.math;

import java.util.List;
import java.util.Map;

public class Sqrt implements Function {

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
    public List<String> getVariables() {
        return value.getVariables();
    }
}
