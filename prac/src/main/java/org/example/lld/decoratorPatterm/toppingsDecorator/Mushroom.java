package org.example.lld.decoratorPatterm.toppingsDecorator;

import org.example.lld.decoratorPatterm.pizzas.BasePizza;

public class Mushroom extends Toppings {

    BasePizza basePizza;

    public Mushroom(BasePizza pizza) {
        this.basePizza = pizza;
    }

    @Override
    public int cost() {
        return basePizza.cost() + 15;
    }
}
