package org.example.lld.decoratorPatterm.pizzas;

import org.example.lld.decoratorPatterm.pizzas.BasePizza;

public class Farmhouse extends BasePizza {
    @Override
    public int cost() {
        return 120;
    }
}
