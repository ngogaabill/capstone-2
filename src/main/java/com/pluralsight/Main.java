package com.pluralsight;

import com.pluralsight.ui.UserInterface;
import com.pluralsight.util.Receipt;

public class Main {
    public static void main(String[] args) {
//        UserInterface userInterface = new UserInterface();
//        userInterface.menu();
        Receipt x = new Receipt();
        x.printReceipt();
    }
}