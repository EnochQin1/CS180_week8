package com.example.cs180.Week9.Debugging.work;
public class ChocolateMilk extends Milk {
    //Grams of added sugar vs plain milk
    private int gramsAddedSugar;
    
    /* Constructor that takes in number of chocolate milk drinks available and grams of added sugar. 
     * This constructor should call the constructor in super class using "Chocolate Milk" as name, "Brown" as color, 
     * and numAvailable as the value given by the first parameter. The constructor should also set the value of the
     * gramsAddedSugar instance variable to the value given by the second parameter.
     */
    public ChocolateMilk(int numAvailable, int gramsAddedSugar) {
        super("Chocolate Milk", "Brown", numAvailable);
        this.gramsAddedSugar = gramsAddedSugar;
    }
    
    //Returns gramsAddedSugar instance variable
    public int getGramsAddedSugar() {
        return gramsAddedSugar;
    }
}
