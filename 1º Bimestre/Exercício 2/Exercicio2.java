package ces22;

import java.math.BigDecimal;

class Shape {

    private String name;

    Shape(String s) {
        name = s;
    }

    public String getName() {
        return name;
    }

    public double Area() {
        return 0.0;
    }

}

//Subclasse Quadrado
class Square extends Shape {

    double side;

    public Square(String name) {
        super(name);
        side = 0;
    }

    public void setSide(double side) {
        if (side < 0) {
            side = 0;
        }
        this.side = side;
    }

    public double Area() {
        return side * side;
    }
}

//Subclasse triângulo
class Triangle extends Shape {

    private double[] sides;

    public Triangle(String name) {
        super(name);
        sides = new double[3];
        for (int i = 0; i < 3; i++) {
            sides[i] = 0;
        }
    }

    private boolean isTriangle() {
        int j;
        int k;
        for (int i = 0; i < 3; i++) {
            j = (i + 1) % 3;
            k = (i + 2) % 3;
            if (sides[i] >= sides[j] + sides[k]) {
                return false;
            }
        }
        return true;
    }

    public void setSides(double[] newside) {
        if (newside.length == 3) {
            sides = newside;
        }
    }

    public double Area() {
        if (!isTriangle()) {
            return 0.0;
        }
        double ret;
        double p = 0;
        for (int i = 0; i < 3; i++) {
            p = p + sides[i];
        }
        p = p / 2;
        ret = Math.sqrt(p);
        for (int i = 0; i < 3; i++) {
            ret = ret * Math.sqrt(p - sides[i]);
        }
        return ret;
    }
}

class Exercicio2 {

    public static void main(String[] args) {
        Triangle t1 = new Triangle("T1");
        Triangle t2 = new Triangle("T2");
        Triangle t3 = new Triangle("T3");
        Square s1 = new Square("S1");
        Square s2 = new Square("S2");
        Square s3 = new Square("S3");
        t1.setSides(new double[]{3, 4, 5});
        t2.setSides(new double[]{6, 6, 6});
        t3.setSides(new double[]{2, 6, 9});
        s1.setSide(3);
        s2.setSide(-12);
        s3.setSide(4);
        Shape[] shapes = {t1, t2, t3, s1, s2, s3};
        double area;
        for (Shape shape : shapes) {
            area = shape.Area();
            if (area == 0) {
                System.out.println(shape.getName() + " não é uma figura válida.");
            } else {
                System.out.println(shape.getName() + " tem "
                        + (BigDecimal.valueOf(area)).setScale(3, BigDecimal.ROUND_HALF_UP)
                        + " m2 de area.");
            }
        }
    }
}
