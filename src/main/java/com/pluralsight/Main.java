package com.pluralsight;

import com.pluralsight.ui.UserInterface;
import com.pluralsight.util.Receipt;

public class Main {
    public static void main(String[] args) {
        System.out.println("""
                ──────────────|WELCOME TO TACO GALAXY|────────────── """);
        UserInterface userInterface = new UserInterface();
        userInterface.menu();
    }
}