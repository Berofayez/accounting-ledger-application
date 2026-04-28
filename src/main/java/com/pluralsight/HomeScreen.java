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
        while(true){
            System.out.println("Welcome to Accounting Ledger Application");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("E) Exit");

            String userInput = scanner.nextLine();
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
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("try again");
                    break;
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

        Transaction transaction = new Transaction(LocalDate.now(), LocalTime.now(), description, vendor, -amount);

        String line = transaction.toCsvFormat();

        try{
            FileWriter fileWriter = new FileWriter("data/transactions.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(line);
            bufferedWriter.newLine();

            bufferedWriter.close();
        }catch (Exception ex){
            System.out.println("error happen");

        }
    }

    static void addDeposit(){
        System.out.println("Enter description for your deposit: ");
        String description = scanner.nextLine();

        System.out.println("Enter the vendor: ");
        String vendor = scanner.nextLine();

        System.out.println("Enter amount: ");
        double amount = scanner.nextDouble();

        Transaction transaction = new Transaction(LocalDate.now(), LocalTime.now(), description, vendor, amount);

        String line = transaction.toCsvFormat();

        try{
            FileWriter fileWriter = new FileWriter("data/transactions.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(line);
            bufferedWriter.newLine();

            bufferedWriter.close();
        }catch (Exception ex){
            System.out.println("error happen");

        }
    }
}
