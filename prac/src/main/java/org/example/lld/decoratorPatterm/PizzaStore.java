package org.example.lld.decoratorPatterm;

import org.example.lld.decoratorPatterm.pizzas.BasePizza;
import org.example.lld.decoratorPatterm.pizzas.Farmhouse;
import org.example.lld.decoratorPatterm.toppingsDecorator.ExtraCheese;
import org.example.lld.decoratorPatterm.toppingsDecorator.Mushroom;

public class PizzaStore {
    public static  void main(String[] args){
        BasePizza pizza1 = new Farmhouse();
        System.out.println(pizza1.cost());


        BasePizza pizza2 = new ExtraCheese(new Farmhouse());
        System.out.println(pizza2.cost());

        BasePizza pizza3 = new Mushroom(new ExtraCheese(new Farmhouse()));
        System.out.println(pizza3.cost());
    }
}
