/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group7_java.school_bussiness_tour_management.dao;

import group7_java.school_bussiness_tour_management.models.Account;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class AccountDAO {

    private static String filePath = "../files/Account.txt";

    public static List<Account> getAllAccounts() throws FileNotFoundException {
        List<Account> data = new ArrayList<Account>();
        try {
            BufferedReader read = new BufferedReader(new FileReader("../files/Account.txt"));
            String line;
            Account tk = null;
            while ((line = read.readLine()) != null) {
                String[] taikhoan = line.split(",");
                String tentk = taikhoan[0].trim();
                String matkhau = taikhoan[1].trim();
                tk = new Account(tentk, matkhau);
                System.out.println(tentk);
                data.add(tk);
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return data;
    }

    public static void addNewAccount() throws Exception {

    }
}
