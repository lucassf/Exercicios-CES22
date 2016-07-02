package concreteImplementor;

import implementor.IDrawing;

public class DrawingRed implements IDrawing {

    @Override
    public void draw(String form, double x, double y, String measure,double value) {
        System.out.println("Red "+form+" of center ("+x+","+y+") and "+measure+":"+value);
    }
}
