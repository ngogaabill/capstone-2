package com.pluralsight.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {

    /**
     * Write Order To Receipt File
     */
    public void printReceipt() {
        StringBuilder receiptFileName = new StringBuilder(generateTimestamp()).append(".txt");
        String date = String.valueOf(LocalDate.now());

        try (BufferedWriter bf = new BufferedWriter(new FileWriter(String.valueOf(receiptFileName)))) {
            bf.write("------- TACO GALAXY -------\n");
            bf.write("        ORDER SUMMARY       \n");
            bf.write("Date: " + date + "\n");
            bf.write("----------------------------\n");
            bf.write(String.format("%-20s %10s\n", "Description", "Price"));
            bf.write("----------------------------\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Get the D&T stamp for receipt filename creation
     *
     * @return Date n Time String
     */
    public static String generateTimestamp() {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        return currentTime.format(dateTimeFormatter);

    }
}
