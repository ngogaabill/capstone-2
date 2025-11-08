package com.pluralsight.models;

public class Drink implements OrderedItem {
    private String size;
    private double price;

    public Drink(String size) {
        this.size = size;
    }

//
//    public String getSize() {
//        return size;
//    }

    /**
     *
     * @return drink and price
     */
    @Override
    public String description() {
        return "Drink size " + size;
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
        return String.format("%-20s %10s\n", description(), getPrice());
    }
}
