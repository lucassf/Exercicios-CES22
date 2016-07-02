package abstraction;

import implementor.IDrawing;

public abstract class Shape {
    protected IDrawing idrawing;
    
    protected Shape(IDrawing idrawing){
        this.idrawing = idrawing;
    }

    public abstract void draw();
    public abstract void resizeByPercentage(double pct,boolean others);     
}
