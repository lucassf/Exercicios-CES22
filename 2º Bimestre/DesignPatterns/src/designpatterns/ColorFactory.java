package designpatterns;

import concreteImplementor.*;
import implementor.IDrawing;

public class ColorFactory {
    public IDrawing getColor(String colorType){
        if (colorType == null){
            return null;
        }
        else if ("Green".equals(colorType)){
            return new DrawingGreen();
        }else if ("Red".equals(colorType)){
            return new DrawingRed();
        }
        return null;
    }
}
