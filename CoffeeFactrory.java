package com.example.untitled;

public class CoffeeFactrory {

    public static CoffeInstructions getCoffeeInstructions(String coffename){
        if (coffename == null){
            return null;
        }
        if (coffename.equalsIgnoreCase("Эспрессо")){
            return new EspressoInstructons();
        }
        else if (coffename.equalsIgnoreCase("Латте")){
            return new LatteInstructions();
        }
        return null;
    }

}
