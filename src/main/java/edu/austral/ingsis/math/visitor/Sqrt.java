package edu.austral.ingsis.math.visitor;

class Sqrt implements Function {

    private final Function value;

    public Sqrt(Function left) {
        this.value = left;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    public Function getValue() {
        return value;
    }
}
