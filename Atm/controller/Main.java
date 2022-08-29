package com.josh.miniproject.atm.Atm.controller;

import com.josh.miniproject.atm.Atm.dao.ForgotPin;
import com.josh.miniproject.atm.Atm.dao.InsertCustomer;
import com.josh.miniproject.atm.Atm.dao.Transaction;
import com.josh.miniproject.atm.Atm.dbutil.Database;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Create Account \n2. Transaction \n choose Your option");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Your Customer Id is : " + InsertCustomer.insert());
                break;
            case 2:
                System.out.println("Enter your customer id: ");
                int customerId = scanner.nextInt();
                try {
                    Statement statement = Database.openConnection().createStatement();
                    ResultSet resultSet = statement.executeQuery("select * from cdata where cid=" + customerId);

                    if (resultSet.next()) {
                        System.out.println("Enter your pin: ");
                        int pin = scanner.nextInt();
                        if (resultSet.getInt(3) == pin) {
                            Double finalAmount = Transaction.transaction(resultSet.getDouble(4), customerId);
                            statement.executeQuery("update cdata set amount=" + finalAmount + " where cid= " + customerId);
                        } else {
                            System.out.println("Wrong pin entered.......");
                            System.out.println("You want to create new pin :(if Yes enter 1)");
                            int change = scanner.nextInt();
                            if (change == 1) {
                                int updatedPin = ForgotPin.forgotPin();
                                if (updatedPin > 999 && updatedPin < 10000) {
                                    statement.executeQuery(
                                            "update cdata set pin=" + updatedPin + " where cid= " + customerId);
                                } else {
                                    System.out.println("Entered pin is not in format");
                                }
                            } else {
                                System.out.println("Please reset your pin to use your account...");
                            }
                        }
                    } else {
                        System.out.println("No person found for this CustomerID");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } finally {
                    scanner.close();
                    try {
                        Database.closeConnection();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                }
        }
    }
}
