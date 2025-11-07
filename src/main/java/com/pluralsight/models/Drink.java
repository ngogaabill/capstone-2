package com.pluralsight.models;

public class Drink implements OrderedItem{

    @Override
    public String description() {
        return "";
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
