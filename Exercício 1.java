package ces22;

import java.util.Scanner;

class Calculator {

    private double a;
    private char operation;

    public Calculator() {
        clear();
    }

    public void clear() {
        a = 0;
        operation = '+';
    }

    public void add() {
        operation = '+';
    }

    public void subtract() {
        operation = '-';
    }

    public void multiply() {
        operation = '*';
    }

    public void divide() {
        operation = '/';
    }

    public void changeNum(double b) {
        a = operationAns(b);
    }

    public double getAns() {
        return a;
    }

    private double operationAns(double b) {
        double ret = 0;
        if (operation == '+') {
            ret = a + b;
        } else if (operation == '-') {
            ret = a - b;
        } else if (operation == '*') {
            ret = a * b;
        } else if (operation == '/') {
            ret = a / b;
        }
        return ret;
    }
}

public class Main {
    
    private static Calculator calculator;
    private static Scanner sc;
    private static boolean exit;
    private static String input;
    
    public static void main(String args[]){
        sc = new Scanner(System.in);
        calculator=new Calculator();
        exit=false;
        System.out.println("Calculadora simples ver.0.01\n");
        while(!exit&&sc.hasNext()){
            input=sc.nextLine();
            char c = input.charAt(0);
            if (c=='s')exit=true;
            else if (c=='+')calculator.add();
            else if (c=='-')calculator.subtract();
            else if (c=='*'||c=='x')calculator.multiply();
            else if (c=='/')calculator.divide();
            else if (c=='=')System.out.println(calculator.getAns());
            else if (c=='c')calculator.clear();
            else calculator.changeNum(Integer.parseInt(input));
        }
    }
}
