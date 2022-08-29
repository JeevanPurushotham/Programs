package com.josh.miniproject.atm.Atm.dao;

import java.util.Scanner;

public class ForgotPin {
    public static int forgotPin() {
        Scanner sc = new Scanner(System.in);
        // you have to put 4digit OTP for creating new pin
        System.out.println("Enter OTP");
        System.out.println("OTP should be four digit only : ");
        int newPin = 0;
        try {
            int otp = sc.nextInt();
            // checking if the OTP is 4digit
            if (otp > 999 && otp < 10000) {
                System.out.println("Create a new pin :\nPin should be in four digit");
                newPin = sc.nextInt();
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
        // returning the pin for updating in database
        return newPin;
    }
}
