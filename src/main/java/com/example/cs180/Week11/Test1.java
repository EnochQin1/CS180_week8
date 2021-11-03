package com.example.cs180.Week11;

import java.util.*;

import static com.example.cs180.Week11.Operation.DIVIDE;
import static com.example.cs180.Week11.Operation.MULTIPLY;
import static com.example.cs180.Week11.Operation.ADD;
import static com.example.cs180.Week11.Operation.SUBTRACT;

enum Operation
{
    ADD, SUBTRACT, MULTIPLY, DIVIDE
}
public class Test1 {

    public static double basicCalculator(Operation operation, int num1, int num2) {
        double result = 0;
        if (operation.equals(ADD)) {
            result = num1 + num2;
        } else if (operation.equals(SUBTRACT)) {
            result = num1 - num2;
        } else if (operation.equals(MULTIPLY)) {
            result = num1 * num2;
        } else if (operation.equals(DIVIDE)) {
            if (num2 == 0) {
                System.out.println("Can't divide by 0");
            } else {
                result = ((double) num1) / num2;
            }
        }
        return result;
    }
    public static void main(final String[] args) {
        System.out.println(basicCalculator(Operation.DIVIDE, 1, 2));
    }
}
