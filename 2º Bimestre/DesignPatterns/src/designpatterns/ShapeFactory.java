package designpatterns;

import refinedAbstraction.SquareShape;
import refinedAbstraction.CircleShape;
import abstraction.Shape;
import implementor.IDrawing;

public class ShapeFactory {
    public Shape getShape(double x, double y, double measure, IDrawing idrawing,
            String shapeType){
        if (shapeType == null){
            return null;
        }
        else if ("Circle".equalsIgnoreCase(shapeType)){
            return new CircleShape(x,y,measure,idrawing);
        }else if ("Square".equalsIgnoreCase(shapeType)){
            return new SquareShape(x,y,measure,idrawing);
        }
        return null;
    }
}
