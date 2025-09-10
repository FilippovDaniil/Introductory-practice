package com.example.untitled;

public class Barista {


    CoffeInstructions coffeInstructions;

    public Barista(CoffeInstructions coffeInstructions) {
        this.coffeInstructions = coffeInstructions;
    }

    public void makeCoffee(){
        System.out.println("Making Coffee ..." + coffeInstructions.getInstructions());
        System.out.println("Making " + coffeInstructions.getCoffeeName());
    }

}
