package io.kpsoft.test;

public class MathUtils {
    public int add(int a, int b){
        return a+b;
    }

    public int subtract(int a, int b){
        return a-b;
    }

    public int multiply(int a, int b){
        return a*b;
    }

    public int divide(int a, int b){
        return a/b;
    }
    //Compute Circle Area
    public double calculateCircleArea(double circleRadius){
        return Math.PI * circleRadius * circleRadius;
    }
}
