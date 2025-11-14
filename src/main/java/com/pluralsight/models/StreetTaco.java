package com.pluralsight.models;

public class StreetTaco extends Taco {
    public StreetTaco() {
        super();
        setTacoSize("3-Taco");
        setTortillaType("Corn");
        getTacoSizePrice(9.00);

        loadStreetTacoToppings();
    }

    /**
     * Load the Topping that come with street taco
     */
    private void loadStreetTacoToppings() {
        PremiumToppings carneAsada = new PremiumToppings("carne Asada", Toppings.MEAT, false, 2.0, 1.0);
        addTopping(carneAsada);
        addTopping(new Toppings("Onions", Toppings.REGULAR, false));
        addTopping(new Toppings("cilantro", Toppings.REGULAR, false));
        addTopping(new Toppings("salsa verde", Toppings.SAUCE, false));
        addTopping(new Toppings("Lime wedges", Toppings.SIDE, false));
    }

    @Override
    public String toString() {
        return "Street Taco " + super.toString();
    }
}
