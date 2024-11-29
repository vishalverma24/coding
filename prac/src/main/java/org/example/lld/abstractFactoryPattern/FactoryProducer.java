package org.example.lld.abstractFactoryPattern;

import org.example.lld.abstractFactoryPattern.factories.LuxuryCarFactory;
import org.example.lld.abstractFactoryPattern.factories.NormalCarFactory;
import org.example.lld.abstractFactoryPattern.factories.CarFactory;

public class FactoryProducer {

    public static CarFactory getFactory(String factoryType) {
        if (factoryType.equalsIgnoreCase("Luxury")) {
            return new LuxuryCarFactory();
        } else if (factoryType.equalsIgnoreCase("Normal")) {
            return new NormalCarFactory();
        }
        return null;
    }
}
