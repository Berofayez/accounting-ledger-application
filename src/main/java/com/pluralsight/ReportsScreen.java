package com.pluralsight;

import java.time.LocalDate;
import java.util.Scanner;
import static com.pluralsight.Main.transactions;

public class ReportsScreen {
    static Scanner scanner = new Scanner(System.in);
    static void reportsScreen(){


        while (true) {
            System.out.println("\n========== REPORTS MENU ==========");

            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("6) Custom Search");
            System.out.println("0) Back");
            System.out.print("Choose an option: ");

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
                case 6:
                    customSearch();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");

            }
        }

    }

    public static void customSearch() {

        System.out.println("\n========== CUSTOM SEARCH ==========");

        System.out.println("Enter Start Date (yyyy-MM-dd) or press Enter:");
        String startDateString = scanner.nextLine().trim();

        LocalDate startDate = null;
        if(!startDateString.isBlank()){
            startDate = LocalDate.parse(startDateString);
        }


        System.out.println("Enter End Date (yyyy-MM-dd) or press Enter:");
        String endDateString = scanner.nextLine().trim();

        LocalDate endDate = null;
        if(!endDateString.isBlank()){
            endDate = LocalDate.parse(endDateString);
        }

        System.out.println("Enter Description or press Enter:");
        String description = scanner.nextLine().trim();

        System.out.println("Enter Vendor or press Enter:");
        String vendor = scanner.nextLine().trim();

        System.out.println("Enter Amount or press Enter:");
        String amountString = scanner.nextLine().trim();

        Double amount = null;
        if(!amountString.isBlank()){
           amount = Double.parseDouble(amountString);
        }

        boolean found = false;


        for(Transaction transaction : transactions){
            if(startDate != null){
                if(transaction.getDate().isBefore(startDate)){
                    continue;
                }
            }
            if(endDate != null){
                if(transaction.getDate().isAfter(endDate)){
                    continue;
                }
            }

            if(!description.isEmpty()){
                if(!transaction.getDescription().contains(description)){
                    continue;
                }
            }

            if(!vendor.isEmpty()){
                if(!transaction.getVendor().equalsIgnoreCase(vendor)){
                    continue;
                }
            }

            if(amount != null){
                if(transaction.getAmount() != amount){
                    continue;
                }
            }

            if (!found) {
                System.out.printf("%-12s %-10s %-25s %-20s %10s%n",
                        "Date", "Time", "Description", "Vendor", "Amount");
                System.out.println("-------------------------------------------------------------------");
            }

            System.out.println(transaction);
            found = true;

        }
        if(!found){
            System.out.println("No matching transactions found.");
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