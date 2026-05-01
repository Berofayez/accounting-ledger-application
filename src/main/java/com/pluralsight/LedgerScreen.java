package com.pluralsight;

import java.util.Scanner;
import static com.pluralsight.Main.*;
import static com.pluralsight.ReportsScreen.reportsScreen;

public class LedgerScreen {
    static Scanner scanner = new Scanner(System.in);
    public static void ledgerScreen() {

        while (true) {

            System.out.println("\n========== LEDGER MENU ==========");
            System.out.println("A) All ");
            System.out.println("D) Deposits ");
            System.out.println("P) Payments ");
            System.out.println("R) Reports");
            System.out.println("H) Home");

            String userInput = scanner.nextLine().trim().toUpperCase();
            switch (userInput) {
                case "A":
                    displayAll();
                    break;
                case "D":
                    displayDeposit();
                    break;
                case "P":
                    displayPayment();
                    break;
                case "R":
                    reportsScreen();
                    break;
                case "H":
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

    }

    private static void displayDeposit() {
        System.out.println("========== DEPOSITS ==========");
        System.out.printf("%-12s %-10s %-25s %-20s %10s%n",
                "Date", "Time", "Description", "Vendor", "Amount");
        System.out.println("-------------------------------------------------------------------");
        for(Transaction transaction: transactions){
            if (transaction.getAmount() > 0){
                System.out.println(transaction);
            }
        }
    }

    private static void displayAll() {
        System.out.println("========== ALL TRANSACTIONS ==========");
        System.out.printf("%-12s %-10s %-25s %-20s %10s%n",
                "Date", "Time", "Description", "Vendor", "Amount");
        System.out.println("-------------------------------------------------------------------");
        for(Transaction transaction: transactions){
            System.out.println(transaction);
        }
    }

    private static void displayPayment() {
        System.out.println("========== PAYMENTS ==========");
        System.out.printf("%-12s %-10s %-25s %-20s %10s%n",
                "Date", "Time", "Description", "Vendor", "Amount");
        System.out.println("-------------------------------------------------------------------");
        for(Transaction transaction: transactions){
            if (transaction.getAmount() < 0){
                System.out.println(transaction);
            }
        }
    }
}
