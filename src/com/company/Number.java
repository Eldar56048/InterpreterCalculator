package com.company;

public class Number implements Expression{

    private int number;

    public Number(int number) {
        this.number = number;
    }

    public Number(String str) {
        this.number = Integer.parseInt(str);
    }

    @Override
    public int interpreter() {
        return number;
    }
}
