package refinedAbstraction;

import abstraction.Shape;
import abstraction.Shape;
import designpatterns.Mediator;
import designpatterns.Mediator;
import implementor.IDrawing;

public class CircleShape extends Shape {
    private double x, y, radius;
    public CircleShape(double x, double y, double radius, IDrawing idrawing) {
        super(idrawing);
        this.x = x;  this.y = y;  this.radius = radius;
        Mediator.addCircle(this);
    }

    @Override
    public void draw() {
        idrawing.draw("Circle",x, y, "radius",radius);
    }
    @Override
    public void resizeByPercentage(double pct,boolean others) {
        radius *= (1.0 + pct/100.0);
        if (others == true){
            Mediator.resizeCircle(pct);
        }
    }
}


