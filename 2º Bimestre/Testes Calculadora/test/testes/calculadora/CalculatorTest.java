package testes.calculadora;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import testes.calculadora.Calculator.Operation;

@RunWith(Parameterized.class)
public class CalculatorTest {
    
    static Calculator calculator;
    static double current;
    String expected;
    double a;
    Operation op;
    
    public CalculatorTest(double value,Operation op,String expected) {
        a = value;
        this.op = op;
        this.expected = expected;
    }
    
    @BeforeClass
    public static void setUpClass() {
        calculator = new Calculator();
        current = 0;
        System.out.println("CalculatorTest");
    }
    
    @Parameters
    public static Collection addValues(){
        return Arrays.asList(new Object[][]{
            {555.632,Operation.ADD,"555.632"},{1000,Operation.ADD,"1555.632"}
            ,{0,Operation.MULTIPLY,"0"},{-12,Operation.SUBTRACT,"12"},
            {12,Operation.DIVIDE,"1"}});
    }
    
    @Test
    public void VerifyClass(){
        calculator.changeOperation(op);
        calculator.changeNum(a);
        String ans = calculator.getAns();
        assertEquals(expected, ans);
        
    }
}
