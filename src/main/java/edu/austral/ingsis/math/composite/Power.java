package edu.austral.ingsis.math.composite;

import java.util.*;

class Power implements Function{

    private final Function base;
    private final Function exponent;

    public Power(Function base, Function exponent){
        this.base = base;
        this.exponent = exponent;
    }


    @Override
    public double evaluate(Map<String, Function> variables) {
        return Math.pow(base.evaluate(variables), exponent.evaluate(variables));
    }

    @Override
    public String print() {
        return "(" + base.print() + " ^ " + exponent.print()+ ")";
    }

    @Override
    public Set<String> getVariables() {
        Set<String> baseVariables = base.getVariables();
        Set<String> exponentVariables = exponent.getVariables();
        return new HashSet<>(baseVariables) {{
            addAll(exponentVariables);
        }};
    }
}
