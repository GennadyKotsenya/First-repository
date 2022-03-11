package day9.Task2;

import static java.lang.Math.PI;
import static java.lang.Math.sqrt;

public class TestFigures {
    public static void main(String[] args) {
        Figure[] figures = {
                new Triangle(10, 10, 10, "Red"),
                new Triangle(10, 20, 30, "Green"),
                new Triangle(10, 20, 15, "Red"),
                new Rectangle(5, 10, "Red"),
                new Rectangle(40, 15, "Orange"),
                new Circle(4, "Red"),
                new Circle(10, "Red"),
                new Circle(5, "Blue")
        };
        System.out.println(calculateRedArea(figures));
        System.out.println(calculateRedPerimeter(figures));
    }


    public static double calculateRedPerimeter(Figure[] figures) {
        double sum = 0;

        for (Figure figure : figures) {
            if (figure.getColor().equals("Red"))
                sum += figure.perimeter();
        }
        return sum;
    }

    public static double calculateRedArea(Figure[] figures) {

        double sum = 0;
        for (Figure figure : figures) {
            if (figure.getColor().equals("Red"))
                sum += figure.area();
        }

        return sum;
    }

}


abstract class Figure {

    private String color;

    protected Figure(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract double area();

    public abstract double perimeter();

}

class Circle extends Figure {
    private int r;

    public Circle(int r, String color) {
        super(color);
        this.r = r;
    }


    @Override
    public double area() {
        return PI * (r * r);
    }

    @Override
    public double perimeter() {
        return 2 * PI * r;
    }
}

class Rectangle extends Figure {
    private double wight, height;

    public Rectangle(int wight, int height, String color) {
        super(color);
        this.wight = wight;
        this.height = height;
    }

    @Override
    public double area() {
        return wight * height;
    }

    @Override
    public double perimeter() {
        return 2 * (wight + height);
    }
}

class Triangle extends Figure {
    private double a, b, c;


    public Triangle(double a, double b, double d, String color) {
        super(color);
        this.a = a;
        this.b = b;
        this.c = d;
    }

    @Override
    public double area() {
        double p = perimeter() / 2;
        return sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }
}



