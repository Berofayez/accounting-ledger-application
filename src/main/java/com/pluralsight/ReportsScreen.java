package com.pluralsight;

import java.time.LocalDate;
import java.util.Scanner;
import static com.pluralsight.Main.transactions;

public class ReportsScreen {
    static Scanner scanner = new Scanner(System.in);
    static void reportsScreen(){

        while (true) {

            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("0) Back");

            int userInput = Integer.parseInt(scanner.nextLine());

            switch (userInput) {
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
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");

            }
        }

    }

    private static void previousYear() {

        System.out.printf("%-12s %-10s %-25s %-20s %10s%n",
                "Date", "Time", "Description", "Vendor", "Amount");
        System.out.println("-------------------------------------------------------------------");
        LocalDate previousYear = LocalDate.now().minusYears(1);

        for (Transaction transaction : transactions){
            if(transaction.getDate().getYear() == previousYear.getYear()){
                System.out.println(transaction);
            }
        }
    }

    private static void yearToDate() {

        System.out.printf("%-12s %-10s %-25s %-20s %10s%n",
                "Date", "Time", "Description", "Vendor", "Amount");
        System.out.println("-------------------------------------------------------------------");

        for (Transaction transaction : transactions){
            if(transaction.getDate().getYear() == LocalDate.now().getYear()){
                System.out.println(transaction);
            }
        }
    }

    private static void previousMonth() {

        System.out.printf("%-12s %-10s %-25s %-20s %10s%n",
                "Date", "Time", "Description", "Vendor", "Amount");
        System.out.println("-------------------------------------------------------------------");
        LocalDate previousMonth = LocalDate.now().minusMonths(1);

        for (Transaction transaction : transactions){
            if(transaction.getDate().getMonth() == previousMonth.getMonth()
                    && transaction.getDate().getYear() == LocalDate.now().getYear()){
                System.out.println(transaction);
            }
        }

    }

    private static void monthToDate() {

        System.out.printf("%-12s %-10s %-25s %-20s %10s%n",
                "Date", "Time", "Description", "Vendor", "Amount");
        System.out.println("-------------------------------------------------------------------");

        for (Transaction transaction : transactions){
            if(transaction.getDate().getMonth() == LocalDate.now().getMonth()
                    && transaction.getDate().getYear() == LocalDate.now().getYear()){
                System.out.println(transaction);
            }
        }

    }

    private static void searchByVendor() {

        scanner.nextLine();
        System.out.println("Enter the vendor");
        String vendor = scanner.nextLine();

        System.out.printf("%-12s %-10s %-25s %-20s %10s%n",
                "Date", "Time", "Description", "Vendor", "Amount");
        System.out.println("-------------------------------------------------------------------");

        for(Transaction transaction: transactions){
            if (transaction.getVendor().equals(vendor)){
                System.out.println(transaction);
            }
        }
    }
}