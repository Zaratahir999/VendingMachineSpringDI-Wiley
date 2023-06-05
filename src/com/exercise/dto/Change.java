package com.exercise.dto;

public class Change {
   
	private int quarters;
    private int dimes;
    private int nickels;
    private int pennies;

    public Change(int totalChange) {
        int remainingChange = totalChange;

        quarters = remainingChange / 25;
        remainingChange %= 25;

        dimes = remainingChange / 10;
        remainingChange %= 10;

        nickels = remainingChange / 5;
        remainingChange %= 5;

        pennies = remainingChange;
    }

    public int getQuarters() {
        return quarters;
    }

    public int getDimes() {
        return dimes;
    }

    public int getNickels() {
        return nickels;
    }

    public int getPennies() {
        return pennies;
    }
}
