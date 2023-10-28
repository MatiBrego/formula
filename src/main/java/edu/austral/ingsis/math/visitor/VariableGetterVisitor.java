package edu.austral.ingsis.math.visitor;

import java.util.HashSet;
import java.util.Set;

class VariableGetterVisitor implements Visitor<Set<String>>{

    public Set<String> getVariables(Function function){
        return function.accept(this);
    }

    @Override
    public Set<String> visit(Absolute absolute) {
        return absolute.getValue().accept(this);
    }

    @Override
    public Set<String> visit(Addition addition) {
        return joinSets(addition.getLeft(), addition.getRight());
    }

    @Override
    public Set<String> visit(Division division) {
        return joinSets(division.getLeft(), division.getRight());
    }

    @Override
    public Set<String> visit(Multiplication multiplication) {
        return joinSets(multiplication.getLeft(), multiplication.getRight());
    }

    @Override
    public Set<String> visit(Negate negate) {
        return negate.getValue().accept(this);
    }

    @Override
    public Set<String> visit(Power power) {
        return joinSets(power.getBase(), power.getExponent());
    }

    @Override
    public Set<String> visit(Sqrt sqrt) {
        return sqrt.getValue().accept(this);
    }

    @Override
    public Set<String> visit(Subtraction subtraction) {
        return joinSets(subtraction.getLeft(), subtraction.getRight());
    }

    @Override
    public Set<String> visit(Value value) {
        return new HashSet<>();
    }

    @Override
    public Set<String> visit(Variable variable) {
        return Set.of(variable.getIdentifier());
    }

    private Set<String> joinSets(Function left, Function right) {
        Set<String> leftVariables = left.accept(this);
        Set<String> rightVariables = right.accept(this);
        Set<String> variables = new HashSet<>();
        variables.addAll(leftVariables);
        variables.addAll(rightVariables);
        return variables;
    }
}
