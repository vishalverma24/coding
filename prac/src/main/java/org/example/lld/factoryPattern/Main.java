package org.example.lld.factoryPattern;

import org.example.lld.factoryPattern.shapes.Circle;
import org.example.lld.factoryPattern.shapes.Shape;
import org.example.lld.factoryPattern.shapes.Square;

public class Main {
    public static void main(String[] args){
        Shape one = new Circle(2);

        Shape two = new Square(2);

//        one.draw();
//        System.out.println(one.area());
//
//        two.draw();
//        System.out.println(two.area());


        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.getShape("CIRCLE");

        shape.draw();
        shape.area();
    }
}
