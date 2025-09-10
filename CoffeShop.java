package com.example.untitled;

public class CoffeShop {

    public static void main(String[] args) {
        CoffeInstructions coffeInstructions = CoffeeFactrory.getCoffeeInstructions("Эспрессо");
        Barista barista = new Barista(coffeInstructions);
        barista.makeCoffee();
    }

}
