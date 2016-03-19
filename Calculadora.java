package calculadora;

public class Calculator {

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
