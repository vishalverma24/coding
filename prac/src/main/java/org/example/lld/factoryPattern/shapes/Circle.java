package org.example.lld.factoryPattern.shapes;

public class Circle implements Shape {

    int r;

    public Circle() {
    }
    public Circle(int radius) {
        r = radius;
    }

    @Override
    public void draw() {
        System.out.println("draw Circle");
    }

    @Override
    public double area() {
        return (int) (2*3.14*r);
    }
}
