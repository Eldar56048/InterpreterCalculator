package com.company;

public class Multiplication implements Expression {
    private Expression leftOperand;
    private Expression rightOperand;

    public Multiplication(Expression leftOp, Expression rightOp) {
        this.leftOperand = leftOp;
        this.rightOperand = rightOp;
    }

    @Override
    public int interpreter() {
        return leftOperand.interpreter() * rightOperand.interpreter();
    }
}