package edu.austral.ingsis.math.composite;

import java.util.List;
import java.util.Map;

public interface Function {
    double evaluate(Map<String, Function> variables);
    String print();
    List<String> getVariables();
}