package edu.austral.ingsis.math.composite;

import java.util.List;
import java.util.Map;
import java.util.Set;

class Variable implements Function{

    private final String identifier;

    public Variable(String identifier){
        this.identifier = identifier;
    }

    @Override
    public double evaluate(Map<String, Function> variables) {
        return variables.get(identifier).evaluate(variables);
    }

    @Override
    public String print() {
        return identifier;
    }

    @Override
    public Set<String> getVariables() {
    	return Set.of(identifier);
    }
}
