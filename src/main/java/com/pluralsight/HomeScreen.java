package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import static com.pluralsight.LedgerScreen.ledgerScreen;


public class HomeScreen {
    static Scanner scanner = new Scanner(System.in);
    static void homeScreen(){
        boolean running = true;
        while(running){
            System.out.println("\n===== ACCOUNTING LEDGER =====");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment");
            System.out.println("L) Ledger");
            System.out.println("E) Exit");
            System.out.print("Choose an option: ");

            String userInput = scanner.nextLine().trim().toUpperCase();
            switch (userInput){
                case "D":
                    addDeposit();
                    break;
                case "P":
                    makePayment();
                    break;
                case "L":
                    ledgerScreen();
                    break;
                case "E":
                    System.out.println("Thank you for using Accounting Ledger.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }


    }

    static void makePayment() {
        System.out.println("Enter description for your payment: ");
        String description = scanner.nextLine();

        System.out.println("Enter the vendor: ");
        String vendor = scanner.nextLine();

        System.out.println("Enter amount: ");
        double amount = scanner.nextDouble();

        scanner.nextLine();

        Transaction transaction = new Transaction(LocalDate.now(), LocalTime.now(), description, vendor, -amount);

        saveTransaction(transaction);
    }

    static void addDeposit(){
        System.out.println("Enter description for your deposit: ");
        String description = scanner.nextLine();

        System.out.println("Enter the vendor: ");
        String vendor = scanner.nextLine();

        System.out.println("Enter amount: ");
        double amount = scanner.nextDouble();

        scanner.nextLine();

        Transaction transaction = new Transaction(LocalDate.now(), LocalTime.now(), description, vendor, amount);

        saveTransaction(transaction);
    }

    static void saveTransaction(Transaction transaction){
        String line = transaction.toCsvFormat();

        try{
            FileWriter fileWriter = new FileWriter("data/transactions.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(line);
            bufferedWriter.newLine();

            bufferedWriter.close();
        }catch (Exception ex){
            System.out.println("Error saving transaction.");

        }

    }
}
