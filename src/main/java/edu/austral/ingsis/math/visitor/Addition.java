package edu.austral.ingsis.math.visitor;

class Addition implements Function {
    private final Function left;
    private final Function right;

    Addition(Function left, Function right){
        this.left = left;
        this.right = right;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    public Function getLeft(){
        return left;
    }

    public Function getRight(){
        return right;
    }
}
