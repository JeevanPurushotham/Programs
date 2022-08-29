package com.josh.miniproject.atm.Atm.dao;

import java.sql.Statement;
import java.util.Scanner;

import static com.josh.miniproject.atm.Atm.dbutil.Database.connection;

public class ChangePin {
    static void changePin(int customerId) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter OTP");
            System.out.println("OTP should be four digit only : ");
            int updatedPin = 0;
            int otp = scanner.nextInt();
            // checking if the OTP is 4digit
            if (otp > 999 && otp < 10000) {
                System.out.println("Create a new pin :\nPin should be in four digit");
                updatedPin = scanner.nextInt();
                if (updatedPin > 999 && updatedPin < 10000) {
                    Statement statement = connection.createStatement();
                    statement.executeQuery(
                            "update cdata set pin =" + updatedPin + " where cid= " + customerId);
                    System.out.println("Your PIN is updated");
                } else {
                    System.out.println("Entered pin is not in format");
                }
            } else {
                System.out.println("Entered OTP is not valid");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
