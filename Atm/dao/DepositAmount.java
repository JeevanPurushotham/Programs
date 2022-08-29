package com.josh.miniproject.atm.Atm.dao;

import java.util.Scanner;

public class DepositAmount {
    static double DepositAmount(double Amount) {
        System.out.print("Enter Amount: ");
        Scanner scanner = new Scanner(System.in);
        Double depositAmount = scanner.nextDouble();
        if (depositAmount % 100 != 0) {
            System.out.println("Enter multiple of 100, 200, 500, 2000");
            return 0.0;
        }
        Amount += depositAmount;
        System.out.println(depositAmount + " /- deposited successfully");
        return Amount;
    }
}
