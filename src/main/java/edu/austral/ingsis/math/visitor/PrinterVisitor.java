package edu.austral.ingsis.math.visitor;

class PrinterVisitor implements Visitor<String>{

    public String print(Function function){
        return function.accept(this);
    }

    @Override
    public String visit(Absolute absolute) {
        return "|" + absolute.getValue().accept(this) + "|";
    }

    @Override
    public String visit(Addition addition) {
        return "(" + addition.getLeft().accept(this) + " + " + addition.getRight().accept(this) + ")";
    }

    @Override
    public String visit(Division division) {
        return "(" + division.getLeft().accept(this) + " / " + division.getRight().accept(this) + ")";
    }

    @Override
    public String visit(Multiplication multiplication) {
        return "(" + multiplication.getLeft().accept(this) + " * " + multiplication.getRight().accept(this) + ")";
    }

    @Override
    public String visit(Negate negate) {
        return "-" + negate.getValue().accept(this);
    }

    @Override
    public String visit(Power power) {
        return "(" + power.getBase().accept(this) + " ^ " + power.getExponent().accept(this) + ")";
    }

    @Override
    public String visit(Sqrt sqrt) {
        return "sqrt(" + sqrt.getValue().accept(this) + ")";
    }

    @Override
    public String visit(Subtraction subtraction) {
        return "(" + subtraction.getLeft().accept(this) + " - " + subtraction.getRight().accept(this) + ")";
    }

    @Override
    public String visit(Value value) {
        return formatValue(value.getValue());
    }

    @Override
    public String visit(Variable variable) {
        return variable.getIdentifier();
    }

    private String formatValue(double value){
        if(value % 1 == 0){
            return String.valueOf((int) value);
        }
        return String.valueOf(value);
    }
}
