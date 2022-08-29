package com.josh.miniproject.atm.Atm.dao;

import com.josh.miniproject.atm.Atm.dbutil.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertCustomer {
    public static int insert() {
        ResultSet rs;
        int cid = 0;
        Scanner Input;
        try {
            Statement statement = Database.openConnection().createStatement();
            //using statement reference we are calling executeQuery for run the query.
            rs = statement.executeQuery("select max(cid) from cdata");
            Input = new Scanner(System.in);
            //This loop used for retrieving the data present in the database.
            if (rs.next()) {
                cid = rs.getInt(1) + 1;
            } else {
                System.out.println("Invalid");
            }
            System.out.println("Enter Name, Pin, Amount , Phone No :");
            String cname = Input.nextLine();
            int pin = Input.nextInt();
            double amount = Input.nextDouble();
            long pno = Input.nextLong();
            //PreparedStatement used to store the data in dynamically in run time.
            PreparedStatement pstmt = Database.openConnection().prepareStatement("insert into cdata(cid,cname,pin,amount,pno) values(?,?,?,?,?);");
            pstmt.setInt(1, cid);
            pstmt.setString(2, cname);
            pstmt.setInt(3, pin);
            pstmt.setDouble(4, amount);
            pstmt.setDouble(5, pno);
            pstmt.executeUpdate();
            System.out.println("Data added");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return cid;
    }
}
