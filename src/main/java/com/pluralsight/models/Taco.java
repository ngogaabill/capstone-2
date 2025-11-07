package com.pluralsight.models;

import java.util.ArrayList;

public class Taco implements OrderedItem{

    private String tortillaType;
    private String tacoSize;
    private boolean deepFried;
    private ArrayList<Toppings> toppings = new ArrayList<>();

    @Override
    public String description() {
        return "";
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
