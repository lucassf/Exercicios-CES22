package testes.calculadora;

import org.junit.Test;
import static org.junit.Assert.*;

public class InputHandlerTest {
    
    static String[][] values;
    
    public InputHandlerTest() {
        
    }
    
    public static void addValues(){
        values = new String[][]{{"4","4"},{"5","45"},{"6","456"},
            {".","456."},{"4","456.4"},{".","456.4"},{"u","456."},{"u","456"},
            {"0","4560"},{".","4560."},{"3","4560.3"},{"c","0"},{"4","4"},
            {"u","0"},{"4","4"},{"5","45"},{"6","456"},{"4","4564"},{"4","45644"},
            {"4","456444"},{"-","-456444"},{".","-456444."},{"4","-456444.4"},
            {"5","-456444.45"},{"2","-456444.45"},{"2","-456444.45"},{"-","456444.45"},
            {"2","456444.45"}};
    }
    
    @Test
    public void test() {
        System.out.println("InputHandlerTest");
        addValues();
        char op;
        InputHandler instance = new InputHandler();
        for (String[] value : values) {
            op = value[0].charAt(0);
            if (op=='c')instance.ResetInput();
            else instance.setInput(op);
            assertEquals(instance.getInput(),value[1]);
        }
        instance.ResetInput();
        assertEquals(instance.getInput(), "0");
    }
}
