package edu.austral.ingsis.math.visitor;

import java.util.Map;

class EvaluatorVisitor implements Visitor<Double>{

    private final Map<String, Function> variables;

    public EvaluatorVisitor(Map<String, Function> variables){
        this.variables = variables;
    }

    public EvaluatorVisitor(){
        this.variables = Map.of();
    }

    public EvaluatorVisitor setVariables(Map<String, Function> variables){
        return new EvaluatorVisitor(variables);
    }

    public Double evaluate(Function function){
        return function.accept(this);
    }

    @Override
    public Double visit(Absolute absolute) {
        return Math.abs(absolute.getValue().accept(this));
    }

    @Override
    public Double visit(Addition addition) {
        return addition.getLeft().accept(this) + addition.getRight().accept(this);
    }

    @Override
    public Double visit(Division division) {
        return division.getLeft().accept(this) / division.getRight().accept(this);
    }

    @Override
    public Double visit(Multiplication multiplication) {
        return multiplication.getLeft().accept(this) * multiplication.getRight().accept(this);
    }

    @Override
    public Double visit(Negate negate) {
        return -negate.getValue().accept(this);
    }

    @Override
    public Double visit(Power power) {
        return Math.pow(power.getBase().accept(this), power.getExponent().accept(this));
    }

    @Override
    public Double visit(Sqrt sqrt) {
        return Math.sqrt(sqrt.getValue().accept(this));
    }

    @Override
    public Double visit(Subtraction subtraction) {
        return subtraction.getLeft().accept(this) - subtraction.getRight().accept(this);
    }

    @Override
    public Double visit(Value value) {
        return value.getValue();
    }

    @Override
    public Double visit(Variable variable) {
        return variables.get(variable.getIdentifier()).accept(this);
    }
}
