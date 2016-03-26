package ces22;

import java.util.Scanner;

class Calculator {

    //Variáveis foram encapsuladas
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

    public void changeNum(double b) throws IllegalArgumentException {
        double u = operationAns(b);
        a = u; //'a' será alterada somente se não ocorreu uma excessão
    }

    public double getAns() {
        return a;
    }

    private double operationAns(double b) throws IllegalArgumentException {
        double ret = 0;
        if (operation == '+') {
            ret = a + b;
        } else if (operation == '-') {
            ret = a - b;
        } else if (operation == '*') {
            ret = a * b;
        } else if (operation == '/') {
            //Verifica se houve divisão por zero
            if (b == 0) {
                throw new IllegalArgumentException("\nErro: Divisão por zero\n");
            } else {
                ret = a / b;
            }
        }
        return ret;
    }
}

class WrongInputException extends Exception {

    String message;

    WrongInputException(String a) {
        message = a;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

class InputHandler {

    private String input;
    private char[] valid;//Contem os caracteres válidos de entrada.
    private Scanner sc;

    public InputHandler() {
        sc = new Scanner(System.in);
        input = "";
        valid = new char[]{'c', 's', '+', '-', '*', 'x', '/', '='};
    }

    //A leitura da entrada agora é controlada por este método
    public void setInput() {
        if (sc.hasNext()) {
            input = sc.nextLine();
        }
    }

    //Caso seja válida a entrada, o método a retorna. Senão, ocorre uma exceção.
    public String getInput() throws WrongInputException {
        VerifyInput();
        return input;
    }

    //Verifica se a entrada é válida.
    private void VerifyInput() throws WrongInputException {
        boolean isvalid = false;
        for (char a : valid) {
            if (input.equals(String.valueOf(a))) {
                isvalid = true;
            }
        }
        if (!isvalid) {
            try {
                double b;
                b = Integer.parseInt(input);
                isvalid = true;
            } catch (NumberFormatException e) {
                isvalid = false;
            }
        }
        if (!isvalid) {
            throw new WrongInputException("\nErro: Entrada inválida\n");
        }
    }
}

public class Exercicio4 {

    private static Calculator calculator;

    private static boolean exit;
    private static String input;
    private static InputHandler inputhandler;

    public static void main(String args[]) {
        calculator = new Calculator();
        inputhandler = new InputHandler();
        exit = false;
        System.out.println("Calculadora simples ver.0.1\n");
        while (!exit) {
            inputhandler.setInput();//Entrada controlada pelo InputHandler
            try {
                input = inputhandler.getInput();
                char c = input.charAt(0);
                if (c == 's') {
                    exit = true;
                } else if (c == '+') {
                    calculator.add();
                } else if (c == '-') {
                    calculator.subtract();
                } else if (c == '*' || c == 'x') {
                    calculator.multiply();
                } else if (c == '/') {
                    calculator.divide();
                } else if (c == '=') {
                    System.out.println(calculator.getAns());
                } else if (c == 'c') {
                    calculator.clear();
                } else {
                    calculator.changeNum(Integer.parseInt(input));
                }
            }//Tratamento das excessões
            catch (WrongInputException e) {
                System.out.println(e.getMessage());
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
