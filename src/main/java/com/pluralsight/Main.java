package com.pluralsight;

import com.pluralsight.ui.UserInterface;
import com.pluralsight.util.Receipt;

public class Main {
    public static void main(String[] args) {
        System.out.println("""
                --------|Welcome to Taco Galaxy|------------ 
                """);
        UserInterface userInterface = new UserInterface();
        userInterface.menu();

//        Receipt C = new Receipt();
//        C.printReceipt();
    }
}