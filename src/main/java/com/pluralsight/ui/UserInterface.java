package com.pluralsight.ui;

import com.pluralsight.models.*;
import com.pluralsight.util.Receipt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    static Scanner scanner = new Scanner(System.in);
    static Receipt receipt = new Receipt();

    public void menu() {

        boolean exit = false;
        while (!exit) {
            System.out.println("""
                              1) New Order
                              0) Exit (closes the application) 
                    Choice: """);
            int choice = getInput();

            switch (choice) {
                case 1:
                    addOrder();
                    break;
                case 0:
                    exit = true;
                    System.out.println("\uD83C\uDF2E GoodBye, Thanks For Shopping with Taco Galaxy");
                    break;
                default:
                    System.err.println("Wrong Choice, Try Again");
            }
        }
    }

    public void addOrder() {
        Order newOrder = new Order();
        boolean exit = false;

        while (!exit) {
            System.out.println("""
                    ──────────────|Order Menu| ────────
                    Option 1) Add Taco
                    Option 2) Street Taco
                    Option 3) Add Drink
                    Option 4) Add Chip&Salsa
                    Option 5) Checkout
                    Option 0) Cancel Order
                    ──────────────────────────────────
                    Choice: """);
            int choice = getInput();

            switch (choice) {
                case 1:
                    addTaco(newOrder);
                    break;
                case 2:
                    addStreetTaco(newOrder);
                    break;
                case 3:
                    addDrink(newOrder);
                    break;
                case 4:
                    addChipSalsa(newOrder);
                    break;
                case 5:
                    checkOut(newOrder);
                    exit = true;
                    break;
                case 0:
                    System.out.println("❌ Order Cancelled");
                    exit = true;
                    break;
                default:
                    System.err.println("Wrong Choice, Try Again");

            }
        }
    }

    private void addStreetTaco(Order newOrder) {
        System.out.println("""
                ──────────────| STREET TACO |──────────────
                🌮 3-Taco Plate - $11.00
                   • Corn Tortilla
                   • Carne Asada
                   • Onions
                   • Cilantro
                   • Salsa Verde
                   • Lime Wedges
                ──────────────────────────────────────────
                """);

        // Create street taco
        Taco streetTaco = new StreetTaco();

        System.out.print("Would you like to Customize Your taco? (Y/N): ");
        String customize = scanner.nextLine().trim().toUpperCase();
    }

    private void addChipSalsa(Order order) {
        System.out.println("""
                ────────Chips & Salsa ($1.50)────────
                salsa Option:
                             1) Birrieraia Familia Castro
                             2) Taco Nazo
                             3) Los Tacos
                Choice: """);
        int salsaSauce = getInput();

        if (salsaSauce == 1 || salsaSauce == 2 || salsaSauce == 3) {
            ChipsAndSalsa cp = new ChipsAndSalsa(salsaSauce);
            order.addItem(cp);
            System.out.println("✓ Added: " + cp.description() + " - $" +
                    String.format("%.2f", cp.getPrice()));
        } else System.err.println("Wrong choice");
    }

    /**
     * Add Taco to Order
     *
     * @param order
     */
    private void addTaco(Order order) {
        //taco Size Menu
        System.out.println("""
                 ────────Choose Taco Size────────
                         1) Single
                         2) 3-Taco
                         3) Burrito
                Choice: """);
        int tacoSize = getInput();
        //Create a taco
        Taco taco = new Taco();

        switch (tacoSize) {
            case 1 -> {
                taco.setTacoSize("Single");
                taco.getTacoSizePrice(3.50);
            }
            case 2 -> {
                taco.setTacoSize("3-Taco");
                taco.getTacoSizePrice(9.00);
            }
            case 3 -> {
                taco.setTacoSize("Burrito");
                taco.getTacoSizePrice(8.50);
            }
            default -> System.err.println("Wrong Choice");
        }
        //tortilla type menu
        System.out.println("""
                ────────Choose Tortilla Type────────
                        1) Corn 
                        2) Flour 
                        3) Hard shell
                        4) Bowl
                Choice: """);
        int tortillaType = getInput();
        switch (tortillaType) {
            case 1 -> taco.setTortillaType("Corn");
            case 2 -> taco.setTortillaType("Flour");
            case 3 -> taco.setTortillaType("Hard Shell");
            case 4 -> taco.setTortillaType("Bowl");
            default -> System.err.println("Wrong Choice");
        }
        //Meat
        System.out.println(" Do You Want To Add Meat(Y/N)?");
        String wantMeat = scanner.nextLine();
        if (wantMeat.equalsIgnoreCase("Y")) {
            addMeat(taco);
        }
        //cheese
        System.out.println(" Do You Want To Add Cheese(Y/N)?");
        String wantCheese = scanner.nextLine();
        if (wantCheese.equalsIgnoreCase("Y")) {
            addCheese(taco);
        }
        //regular toppings
        System.out.println(" Do You Want To Add Regular Toppings(Y/N)?");
        String wantRegular = scanner.nextLine();
        if (wantRegular.equalsIgnoreCase("Y")) {
            regularToppings(taco);
        }
        //Sauce
        System.out.println(" Do You Want To Add Sauces(Y/N)?");
        String wantSauce = scanner.nextLine();
        if (wantSauce.equalsIgnoreCase("Y")) {
            selectSauces(taco);
        }
        //sides
        System.out.println(" Do You Want To Add Side(Y/N)?");
        String wantSides = scanner.nextLine();
        if (wantSides.equalsIgnoreCase("Y")) {
            AddSides(taco);
        }
        //deepFried
        System.out.println("\uD83D\uDD25 Do You Want To Deep Fry Taco(Y/N)?");
        String deepFry = scanner.nextLine();
        if (deepFry.equalsIgnoreCase("Y")) {
            taco.isDeepFried(true);
        }
        //add Taco to Order
        order.addItem(taco);
        System.out.println(" Added Taco " + taco.toString());
    }

    private void AddSides(Taco taco) {
        String[] sides = {"Lime wedges", "crema"};
        System.out.println("""
                ──────────────|Side Option|──────────────
                              1) Lime wedges
                              2) Crema
                 Choice: """);
        int sideChoice = getInput();
        String sideName = sides[sideChoice - 1];
        Toppings side = new Toppings(sideName, Toppings.SIDE, false);
        System.out.println("✓ Added:" + side.getName());
        taco.addTopping(side);

    }

    /**
     * Add Meat (It's a Premium Topping)
     *
     * @param taco
     */

    private void addMeat(Taco taco) {
        String[] meats = {"carne asada", "al pastor", "carnitas", "pollo", "chorizo", "pescado"};
        System.out.println("""
                 🥩 Meat Options:
                      1) carne asada
                      2) al pastor
                      3) carnitas
                      4) pollo
                      5) chorizo
                      6) pescado
                Choice: """);
        int meatChoice = getInput();

        if (meatChoice >= 1 && meatChoice <= 6) {
            String meatName = meats[meatChoice - 1];
            //do you want extra
            System.out.println("Do you want extra meat?(Y/N)");
            String extraMeat = scanner.nextLine().trim().toUpperCase();
            boolean isExtra = extraMeat.equals("Y");//If the answer is y then true

            double meatPrice = 0.0;
            double extraPrice = 0.0;
            String tacoSize = taco.getTacoSize();

            if (tacoSize.equals("Single")) {
                meatPrice = 1.0;
                extraPrice = 0.50;
            } else if (tacoSize.equals("3-Taco")) {
                meatPrice = 2.0;
                extraPrice = 1.00;
            } else if (tacoSize.equals("Burrito")) {
                meatPrice = 3.0;
                extraPrice = 1.50;
            }
            //add meat topping
            PremiumToppings meat = new PremiumToppings(meatName, Toppings.MEAT, isExtra, meatPrice, extraPrice);
            taco.addTopping(meat);

            double totalMeatPrice = 0.0;
            if (isExtra) {
                totalMeatPrice = meatPrice + extraPrice;
            } else {
                totalMeatPrice = meatPrice;
            }
            String msg = "";
            if (isExtra) {
                msg = " Extra";
            }
            System.out.printf("✓ Added: %s%s - $%.2f%n", meatName, msg, totalMeatPrice);
            taco.addToppingPrice(totalMeatPrice);//send the total meatPrice to the Overall taco Price

        } else {
            System.err.println("Wrong choice");
        }
    }

    /**
     * Add Cheese To Taco
     *
     * @param taco
     */
    private void addCheese(Taco taco) {
        String[] cheeseTopps = {"Queso Fresco", "Oaxaca", "Cotija", "Cheddar"};
        System.out.println("""
                🧀 ────────Cheese Toppings ────────
                         1- Queso Fresco
                         2- Oaxaca
                         3- Cotija
                         4- Cheddar 
                Choice: """);
        int cheeseChoice = getInput();
        String cheeseName = cheeseTopps[cheeseChoice - 1];
        System.out.println("Do you want extra? (Y/N)");
        String extraChoice = scanner.nextLine().trim();
        boolean isExtra = extraChoice.equalsIgnoreCase("y");

        double price = 0.0;
        double extraPrice = 0.0;

        if (taco.getTacoSize().equals("Single")) {
            price = 0.75;
            extraPrice = 0.30;
        } else if (taco.getTacoSize().equals("3-Taco")) {
            price = 1.50;
            extraPrice = 0.60;
        } else if (taco.getTacoSize().equals("Burrito")) {
            price = 2.25;
            extraPrice = 0.90;
        }

        double totalCheesePrice = 0.0;
        String msg = "";
        if (isExtra) {
            totalCheesePrice = price + extraPrice;
            msg = " Extra";
        } else {
            totalCheesePrice = price;
            msg = "";
        }
        PremiumToppings cheese = new PremiumToppings(cheeseName, Toppings.CHEESE, isExtra, price, extraPrice);
        taco.addTopping(cheese);
        taco.addToppingPrice(totalCheesePrice);//send the total meatPrice to the Overall taco Price.

        System.out.printf("✓ Added: %s%s - $%.2f%n", cheeseName, msg, totalCheesePrice);

    }

    /**
     * Add Sauce to your Taco
     *
     * @param taco
     */
    private void selectSauces(Taco taco) {
        String[] sauces = {"salsa verde", "salsa roja", "chipotle", "habanero", "mild", "extra hot"};
        System.out.println("""
                 🌶️──────────────|Sauce Toppings Menu|──────────────
                                 1- salsa verde
                                 2- salsa roja
                                 3- chipotle
                                 4- habanero
                                 5- mild
                                 6- extra hot
                Choice(1/2/3): """);
        String sauceChoices = scanner.nextLine().trim();
        String[] selectedSauce = sauceChoices.split("\\/");

        for (String s : selectedSauce) {
            try {
                int index = Integer.parseInt(s.trim());
                if (index >= 1 && index <= 6) {
                    Toppings sauce = new Toppings(sauces[index - 1], Toppings.SAUCE, false);
                    System.out.println("✓ Added Topping: " + sauce.getName());
                    taco.addTopping(sauce);
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong entry" + s);
            }
        }
    }

    /**
     * Add Free Toppings To taco
     *
     * @param taco
     */
    private void regularToppings(Taco taco) {
        String[] regualarTopps = {"lettuce", "cilantro", "onions ", "tomatoes", "jalapeños", "radishes", "pico de", "guacamole", "corn"};
        System.out.println("""
                🥬──────────────|Regular Toppings menu|──────────────
                             1- lettuce 
                             2- cilantro 
                             3- onions
                             4- tomatoes 
                             5- jalapeños 
                             6- radishes
                             7- pico de
                             8- guacamole
                             9- corn
                Choice(i.e 1/2/3)""");
        String choices = scanner.nextLine().trim();
        String[] toppingChoices = choices.split("\\/"); //["2","4"] -> [2,4]

        //convert the string input into a array of numbers
        for (String c : toppingChoices) {
            try {
                int index = Integer.parseInt(c.trim());
                if (index >= 1 && index <= 9) {
                    Toppings regular = new Toppings(regualarTopps[index - 1], Toppings.REGULAR, false);
                    System.out.println("✓ Added Topping: " + regular.getName());
                    taco.addTopping(regular);

                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong entry" + c);
            }
        }
    }

    /**
     * Add A drink to the order
     *
     * @param order
     */
    private void addDrink(Order order) {
        System.out.print("""
                              Fountain Drinks
                ──────────────|Choose Your Size|──────────────
                       S - Small  ($2.00)
                       M - Medium ($2.50)
                       L - Large  ($3.00)
                
                Choice (S/M/L): """);

        String drinkSize = scanner.nextLine().trim().toUpperCase();
        System.out.println("""
                ──────────────|Choose Matching Flavor|──────────────
                              (S)trawberry
                              (C)hocolate
                              (V)anilla
                         Choice: """);
        String flavor = scanner.nextLine().trim().toUpperCase();
        if (drinkSize.matches("[SML]") && flavor.matches("[SCV]")) {
            Drink drink = new Drink(drinkSize, flavor);
            order.addItem(drink);
            System.out.println("✓ Added: " + drink.description() + " - $" +
                    String.format("%.2f", drink.getPrice()));
        } else {
            System.out.println("Please choose Correct Options");
        }
    }

    /**
     * Check Out the order or cancel Order
     *
     * @param order
     */
    public static void checkOut(Order order) {

        List<OrderedItem> items = order.getAllItems();
        displayOrderSummary(items);
        System.out.print("Confirm order? (Y/N): ");
        String confirm = scanner.nextLine().trim().toUpperCase();

        if (confirm.equals("Y")) {
            receipt.printReceipt(order);//error it's not creating the file right away its waiting untill the program is closed
            System.out.println("Order confirmed!");
            return;
        } else {
            System.out.println("Order not confirmed.");
        }
    }

    /**
     * Display Order Summary
     *
     * @param items
     */
    public static void displayOrderSummary(List<OrderedItem> items) {
//
        System.out.println("──────────────|TACO GALAXY - ORDER SUMMARY|──────────────");
        System.out.println();
        double total = 0.0;
        int itemNumber = 1;

        for (OrderedItem item : items) {
            if (item instanceof Taco) {
                Taco taco = (Taco) item;
                System.out.println("─ Item #" + itemNumber + " ──────────────────────────────────");
                System.out.println(" " + taco.getTacoSize() + " Taco");
                System.out.println(" Tortilla: " + taco.getTortillaType());

                if (taco.isDeepFried()) {
                    System.out.println(" DEEP FRIED ");
                }
                // Display toppings
                ArrayList<Toppings> toppings = taco.getToppings();
                if (!toppings.isEmpty()) {
                    System.out.println(" Toppings:");

                    // Group toppings by type
                    for (Toppings topping : toppings) {
                        if (topping.getType().equals(Toppings.MEAT)) {
                            String meatLabel = topping.getName();
                            if (topping.isExtra()) {
                                meatLabel += " (Extra)";
                            }
                            System.out.printf("   • %-30s $%.2f%n", meatLabel, topping.getPrice());
                        }
                    }
                    for (Toppings topping : toppings) {
                        if (topping.getType().equals(Toppings.CHEESE)) {
                            String cheeseLabel = topping.getName();
                            if (topping.isExtra()) {
                                cheeseLabel += " (Extra)";
                            }
                            System.out.printf("   • %-30s $%.2f%n", cheeseLabel, topping.getPrice());
                        }
                    }
                    for (Toppings topping : toppings) {
                        if (topping.getType().equals(Toppings.REGULAR)) {
                            System.out.println("   • " + topping.getName());
                        }
                    }
                    for (Toppings topping : toppings) {
                        if (topping.getType().equals(Toppings.SAUCE)) {
                            System.out.println("   • " + topping.getName());
                        }
                    }
                }
                System.out.printf(" %-40s $%.2f%n", "Subtotal:", taco.getPrice());
            } else {
                // format for drinks and chips
                System.out.println("─ Item #" + itemNumber + " ──────────────────────────────────");
                System.out.printf(" %-40s $%.2f%n", item.description(), item.getPrice());
            }
            total += item.getPrice();
            itemNumber++;
            System.out.println();
        }

        System.out.println("──────────────────────────────────────────────");
        System.out.printf("  %-38s $%.2f%n", "TOTAL:", total);
    }

    /**
     * @return Value or -1 for type mismatch
     */
    private static int getInput() {
        if (scanner.hasNextInt()) {
            int value = scanner.nextInt();
            scanner.nextLine();
            return value;
        } else {
            scanner.nextLine();//consume Invalid input
            return -1;
        }
    }

}