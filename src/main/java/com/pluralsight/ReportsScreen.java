package com.pluralsight;

import java.time.LocalDate;
import java.util.Scanner;
import static com.pluralsight.LedgerScreen.ledgerScreen;
import static com.pluralsight.Main.transactionByVendor;
import static com.pluralsight.Main.transactions;

public class ReportsScreen {
    static Scanner scanner = new Scanner(System.in);
    static void reportsScreen(){
        System.out.println("1) Month To Date");
        System.out.println("2) Previous Month");
        System.out.println("3) Year To Date");
        System.out.println("4) Previous Year");
        System.out.println("5) Search by Vendor");
        System.out.println("0) Back");

        int userInput = scanner.nextInt();

        switch (userInput){
            case 1:
                monthToDate();
                break;
            case 2:
                previousMonth();
                break;
            case 3:
                yearToDate();
                break;
            case 4:
                previousYear();
                break;
            case 5:
                searchByVendor();
                break;
            case 0:
                ledgerScreen();
                break;
            default:
                System.out.println("try again");

        }

    }

    private static void previousYear() {
        LocalDate previousYear = LocalDate.now().minusYears(1);
        for (Transaction transaction : transactions){
            if(transaction.getDate().getYear() == previousYear.getYear()){
                System.out.println(transaction.getDate().toString() + transaction.getTime() +
                        transaction.getDescription() + transaction.getVendor()
                        + transaction.getAmount());
            }
        }
    }

    private static void yearToDate() {
        for (Transaction transaction : transactions){
            if(transaction.getDate().getYear() == LocalDate.now().getYear()){
                System.out.println(transaction.getDate().toString() + transaction.getTime() +
                        transaction.getDescription() + transaction.getVendor()
                        + transaction.getAmount());
            }
        }
    }

    private static void previousMonth() {
        LocalDate previousMonth = LocalDate.now().minusMonths(1);
        for (Transaction transaction : transactions){
            if(transaction.getDate().getMonth() == previousMonth.getMonth()
                    && transaction.getDate().getYear() == LocalDate.now().getYear()){
                System.out.println(transaction.getDate().toString() + transaction.getTime() +
                        transaction.getDescription() + transaction.getVendor()
                        + transaction.getAmount());
            }
        }

    }

    private static void monthToDate() {
        for (Transaction transaction : transactions){
            if(transaction.getDate().getMonth() == LocalDate.now().getMonth()
                    && transaction.getDate().getYear() == LocalDate.now().getYear()){
                System.out.println(transaction.getDate().toString() + transaction.getTime() +
                        transaction.getDescription() + transaction.getVendor()
                        + transaction.getAmount());
            }
        }

    }

    private static void searchByVendor() {
        scanner.nextLine();
        System.out.println("Enter the vendor");
        String vendor = scanner.nextLine();
        Transaction transaction = transactionByVendor.get(vendor);
        System.out.println(transaction.getDate().toString() + transaction.getTime() +
                transaction.getDescription() + transaction.getVendor()
                + transaction.getAmount());
    }
}
