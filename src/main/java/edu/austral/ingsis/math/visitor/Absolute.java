package edu.austral.ingsis.math.visitor;

class Absolute implements Function {

    private final Function value;

    Absolute(Function value){
        this.value = value;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    public Function getValue(){
        return value;
    }
}
