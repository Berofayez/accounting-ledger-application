package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static Scanner scanner = new Scanner(System.in);

    static void main() {
        homeScreen();

    }

    static void homeScreen(){
        while(true){
            System.out.println("Welcome to Accounting Ledger Application");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("Ledger");
            System.out.println("E) Exit");

            String userInput = scanner.nextLine();
            switch (userInput){
                case "D":
                    addDeposit();
                    break;
                case "P":
                    System.out.println("payment still not there");
                    break;
                case "L":
                    System.out.println("Ledger still not there");
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

    static void addDeposit(){
        System.out.println("Enter description for your deposit: ");
        String description = scanner.nextLine();

        System.out.println("Enter the vendor: ");
        String vendor = scanner.nextLine();

        System.out.println("Enter amount: ");
        double amount = scanner.nextDouble();

        Transaction transaction = new Transaction(LocalDate.now(), LocalTime.now(), description, vendor, amount);

        String line = transaction.toCsvFormate();

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
