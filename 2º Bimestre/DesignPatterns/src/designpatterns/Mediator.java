package designpatterns;

import abstraction.Shape;
import java.util.ArrayList;
import java.util.List;

public class Mediator {
    static List<Shape> squareshape = new ArrayList<>();
    static List<Shape> circleshape= new ArrayList<>();
    
    public static void addSquare(Shape s){
        squareshape.add(s);
    }
    
    public static void addCircle(Shape s){
        circleshape.add(s);
    }
    
    public static void resizeSquare(double pct){
        for (Shape shape1:squareshape){
            shape1.resizeByPercentage(pct,false);
            shape1.draw();
        }
    }
    
    public static void resizeCircle(double pct){
        for (Shape shape1:circleshape){
            shape1.resizeByPercentage(pct,false);
            shape1.draw();
        }
    }
}
