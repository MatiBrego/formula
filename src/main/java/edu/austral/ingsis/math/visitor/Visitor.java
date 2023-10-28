package edu.austral.ingsis.math.visitor;

interface Visitor<T> {
    T visit(Absolute absolute);
    T visit(Addition addition);
    T visit(Division division);
    T visit(Multiplication multiplication);
    T visit(Negate negate);
    T visit(Power power);
    T visit(Sqrt sqrt);
    T visit(Subtraction subtraction);
    T visit(Value value);
    T visit(Variable variable);
}
