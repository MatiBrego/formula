package edu.austral.ingsis.math.visitor;

class Negate implements Function {
    private final Function value;

    public Negate(Function value){
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
