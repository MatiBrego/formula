package edu.austral.ingsis.math.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Power implements Function{

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
    public List<String> getVariables() {
        List<String> baseVariables = base.getVariables();
        List<String> exponentVariables = exponent.getVariables();
        return new ArrayList<>(baseVariables) {{
            addAll(exponentVariables);
        }};
    }
}
