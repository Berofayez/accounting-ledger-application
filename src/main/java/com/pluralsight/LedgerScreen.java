package com.pluralsight;

import java.util.Scanner;

import static com.pluralsight.HomeScreen.homeScreen;
import static com.pluralsight.Main.transactions;

public class LedgerScreen {
    static Scanner scanner = new Scanner(System.in);
    public static void ledgerScreen() {

        System.out.println("A) All ");
        System.out.println("D) Deposits ");
        System.out.println("P) Payments ");
        System.out.println("R) Reports");
        System.out.println("H) Home");

        String userInput = scanner.nextLine();
        switch (userInput){
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
                homeScreen();
                break;
            default:
                System.out.println("try again");
                break;
        }

    }

    private static void reportsScreen() {
    }

    private static void displayDeposit() {
    }

    private static void displayAll() {
        for(Transaction transaction: transactions){
            System.out.println(transaction.getDate().toString() + transaction.getTime() +
                    transaction.getDescription() + transaction.getVendor()
                    + transaction.getAmount());
        }
    }

    private static void displayPayment() {
    }
}
