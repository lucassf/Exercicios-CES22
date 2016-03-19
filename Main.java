package calculadora;

import java.util.Scanner;

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
