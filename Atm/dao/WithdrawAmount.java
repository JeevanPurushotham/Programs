package com.josh.miniproject.atm.Atm.dao;

import java.util.Scanner;

public class WithdrawAmount {
    public static double withdrawAmount(double Amount) {
        System.out.print("Enter amount: ");
        Scanner scanner = new Scanner(System.in);
        Double withdrawAmount = scanner.nextDouble();
        if (withdrawAmount % 100 != 0) {
            System.out.println("Enter multiple of 100, 200, 500, 2000");
            return 0;
        }
        if (withdrawAmount > Amount) {
            System.out.println("Insufficient balance");
            return 0;
        }
        Amount -= withdrawAmount;
        System.out.println(withdrawAmount + " /- withdrew successfully");
        return Amount;
    }
}
