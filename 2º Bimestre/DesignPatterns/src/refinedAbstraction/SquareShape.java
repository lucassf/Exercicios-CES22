package refinedAbstraction;

import abstraction.Shape;
import designpatterns.Mediator;
import implementor.IDrawing;

public class SquareShape extends Shape {
    private double x, y, side;
    public SquareShape(double x, double y, double l, IDrawing idrawing) {
        super(idrawing);
        this.x = x;  this.y = y;  this.side = l;
        Mediator.addSquare(this);
    }

    @Override
    public void draw() {
        idrawing.draw("Square",x, y, "side",side);
    }
    @Override
    public void resizeByPercentage(double pct,boolean others) {
        side *= (1.0 + pct/100.0);
        if (others == true){
            Mediator.resizeSquare(pct);
        }
    }
}
