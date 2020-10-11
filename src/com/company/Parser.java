package com.company;

import java.util.Stack;

public class Parser {
    public static int Parse(String calculate){
        Stack stack = new Stack();
        String[] tokenList = calculate.split(" ");
        for(int i=0;i<tokenList.length;i++){
            if(isOperator(tokenList[i])){
                Expression leftOp = (Expression)stack.pop();
                Expression num = new Number(tokenList[i+1]);
                stack.push((num));
                Expression rightOp = (Expression)stack.pop();
                Expression operator = getOperatorInstance(tokenList[i], leftOp, rightOp);
                i = i + 1;
                int result = operator.interpreter();
                stack.push(new Number(result));
            }
            else{
                Expression num = new Number(tokenList[i]);
                stack.push(num);
            }
        }
        return(((Expression)stack.pop()).interpreter());
    }

    public static boolean isOperator(String str) {
        if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"))
            return true;
        else
            return false;
    }


    public static Expression getOperatorInstance(String str, Expression left,
                                                Expression right) {
        switch (str) {
            case "+":
                return new Addition(left, right);
            case "-":
                return new Substraction(left, right);
            case "*":
                return new Multiplication(left, right);
            default:
                return null;
        }
    }
    public static void main(String[] args) {
        String calculate = "5 + 5 - 3 * 2 * 2 + 1";
        System.out.println(Parse(calculate));
    }
}
