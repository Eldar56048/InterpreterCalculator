package com.company;

public class Substraction implements Expression {
    private Expression leftOperand;
    private Expression rightOperand;

    public Substraction(Expression leftOp, Expression rightOp) {
        this.leftOperand = leftOp;
        this.rightOperand = rightOp;
    }

    @Override
    public int interpreter() {
        return leftOperand.interpreter() - rightOperand.interpreter();
    }
}