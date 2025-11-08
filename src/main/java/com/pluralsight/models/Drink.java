package com.pluralsight.models;

public class Drink implements OrderedItem {
    private String size;
    private double price;
    private String flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        if (flavor.equalsIgnoreCase("S")) {
            this.flavor = "Strawberry";
        } else if (flavor.equalsIgnoreCase("C")) {
            this.flavor = "Chocolate";
        } else this.flavor = "Vanilla";
    }

    /**
     *
     * @return drink and price
     */
    @Override
    public String description() {
        return String.format("Drink size %s - %s", size, this.flavor);
    }

    /**
     * @return Price based on drink size
     */
    @Override
    public double getPrice() {
        double price = 0.0;
        if (size.equalsIgnoreCase("s")) {
            price = 2.00;
        } else if (size.equalsIgnoreCase("m")) {
            price = 2.50;
        } else if (size.equalsIgnoreCase("l")) {
            price = 3.00;
        }
        return price;
    }

    @Override
    public String toString() {
        return String.format("%-20s %8s\n", description(), getPrice());
    }
}
