package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private ArrayList<OrderedItem> cart;

    public Order() {
        this.cart = new ArrayList<>();
    }

    public void addItem(OrderedItem item) {
        cart.add(item);
    }

    public List<OrderedItem> getAllItems() {
        return cart;
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (OrderedItem c : cart) {
            total += c.getPrice();
        }
        return total;
    }

}
