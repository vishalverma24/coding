package org.example.lld.factoryPattern.shapes;

public class Square implements Shape {

    int a;

    public Square() {
    }
    public Square(int length) {
        a = length;
    }

    @Override
    public void draw() {
        System.out.println("draw Square");
    }

    @Override
    public double area() {
        return a * a;
    }
}
