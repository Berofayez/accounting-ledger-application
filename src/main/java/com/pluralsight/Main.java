package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static com.pluralsight.HomeScreen.homeScreen;

public class Main {

    public static ArrayList<Transaction> transactions = new ArrayList<>();
    public static ArrayList<Transaction> deposits = new ArrayList<>();
    public static ArrayList<Transaction> payments = new ArrayList<>();
    public static HashMap<String, Transaction> transactionByVendor = new HashMap<>();

    static Scanner scanner = new Scanner(System.in);

    static void main() {
        transactions = loadTransactions();
        homeScreen();

    }

    public static ArrayList<Transaction> loadTransactions(){
        try {
            FileReader fileReader = new FileReader("data/transactions.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            line = bufferedReader.readLine();

            while (line != null){

                String[] columns = line.split("\\|");

                LocalDate localDate = LocalDate.parse(columns[0]);
                LocalTime localTime = LocalTime.parse(columns[1]);
                String description = columns[2];
                String vendor = columns[3];
                double amount = Double.parseDouble(columns[4]);

                Transaction transaction = new Transaction(localDate, localTime, description, vendor, amount);
                transactions.add(transaction);

                if(amount < 0){
                    payments.add(transaction);
                }else{
                    deposits.add(transaction);
                }
                transactionByVendor.put(vendor, transaction);

                line = bufferedReader.readLine();

            }
            bufferedReader.close();

        }catch (Exception ex){
            System.out.println("error fond");

        }
        return transactions;

    }
}
