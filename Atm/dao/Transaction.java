package com.josh.miniproject.atm.Atm.dao;

import java.util.Scanner;

public class Transaction {
    // this method receives amount from database
    public static Double transaction(double Amount, int cid) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            // options to execute
            System.out.println("1.Deposit \n2.Withdraw\n3.Check Balance\n4.Change Pin\nEnter your choice: ");
            // taking option
            int n = scanner.nextInt();

            switch (n) {
                case 1:// for deposit
                    Amount = DepositAmount.DepositAmount(Amount);
                    break;
                case 2:// Withdraw
                    Amount = WithdrawAmount.withdrawAmount(Amount);
                    break;
                case 3:// checking balance
                    System.out.println("Balance: " + Amount);
                    break;
                case 4: // for changing pin
                    ChangePin.changePin(cid);
                    break;
                default:
                    System.out.println("Your choice is invalid");
            }

            System.out.print("Want to continue?? /Enter 1 for yes, any other for no/: ");
            int choice = scanner.nextInt();

            System.out.println();
            if (choice != 1) {
                break;
            }
        } // closed while-block
        System.out.println("Thank you, visit again......\n");
        scanner.close();

        // returning amount to main class for updating the value in database
        return Amount;
    } // closed method
}
