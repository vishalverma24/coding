package org.example.lld.factoryPattern;

import org.example.lld.factoryPattern.shapes.Circle;
import org.example.lld.factoryPattern.shapes.Shape;
import org.example.lld.factoryPattern.shapes.Square;

public class ShapeFactory {

    Shape getShape(String input) {
        return switch (input) {
            case "CIRCLE" -> new Circle();
            case "SQUARE" -> new Square();
            default -> null;
        };
    }
}
