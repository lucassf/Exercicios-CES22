package Test;

import designpatterns.*;
import abstraction.Shape;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class JUnitTest {
    
    static ColorFactory cf;
    static ShapeFactory sf;
    
    static Shape s1, s2, s3, s4, s5;
    
    public JUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        sf = new ShapeFactory();
        cf = new ColorFactory();
        s1 = sf.getShape(5, 6, 12, cf.getColor("Green"), "Square");
        s2 = sf.getShape(8, 14, 16, cf.getColor("Red"), "Square");
        s3 = sf.getShape(0, -3, 4, cf.getColor("Green"), "Circle");
        s4 = sf.getShape(4, 12, 9, cf.getColor("Red"), "Circle");
        s5 = sf.getShape(-3, -6, 1, cf.getColor("Green"), "Circle");
    }
    
    @Test
    public void BridgeAndFactoryTest(){
       System.out.println("\nBridge and Factory patterns Test\n");
       s1.draw();
       s2.draw();
       s3.draw();
       s4.draw();
       s5.draw();
    }
    
    @Test
    public void MediatorTest(){
        System.out.println("\nMediator pattern Test\n");
        s1.resizeByPercentage(50,false);
        s2.resizeByPercentage(50,true);
        s3.resizeByPercentage(100, false);
        s4.resizeByPercentage(-50, true);
        s5.resizeByPercentage(30, true);
    }

}
