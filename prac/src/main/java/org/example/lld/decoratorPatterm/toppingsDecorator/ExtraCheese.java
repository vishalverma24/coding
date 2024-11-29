package org.example.lld.decoratorPatterm.toppingsDecorator;

import org.example.lld.decoratorPatterm.pizzas.BasePizza;

public class ExtraCheese extends Toppings {

    BasePizza basePizza;

    public ExtraCheese(BasePizza pizza) {
        this.basePizza = pizza;
    }

    @Override
    public int cost() {
        return basePizza.cost() + 10;
    }
}
