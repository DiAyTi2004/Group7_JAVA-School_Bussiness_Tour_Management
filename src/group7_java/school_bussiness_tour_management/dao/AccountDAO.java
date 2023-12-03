/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group7_java.school_bussiness_tour_management.dao;

import group7_java.school_bussiness_tour_management.models.Account;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author PC
 */
public class AccountDAO {

    private static String filePath = "src/group7_java/school_bussiness_tour_management/files/Account.txt";

//    public static List<Account> readFromFile() {
//        List<Account> data = new ArrayList<Account>();
//        try {
//            BufferedReader read = new BufferedReader(new FileReader(filePath));
//            String line;
//            Account tk = null;
//            while ((line = read.readLine()) != null) {
//                String[] taikhoan = line.split(",");
//                String tentk = taikhoan[0].trim();
//                String matkhau = taikhoan[1].trim();
//                tk = new Account(tentk, matkhau);
//                System.out.println(tentk);
//                data.add(tk);
//            }
//        } catch (Exception ex) {
//            System.out.println("Đọc dữ liệu từ file tài khoản có lỗi: " + ex.toString());
//        }
//        return data;
//    }
//
//    public static void writeToFile(List<Account> accounts) {
//        try {
//            FileWriter fw = new FileWriter(filePath);
//            BufferedWriter bw = new BufferedWriter(fw);
//            for (Account sv : accounts) {
//                bw.write(sv.toString());
//                bw.newLine();
//            }
//            bw.close();
//            fw.close();
//        } catch (Exception e) {
//            System.out.println("Lưu tài khoản có lỗi: " + e.getMessage());
//        }
//    }
    public static void writeToFile(List<Account> accounts) {
        try {
            FileOutputStream fo = new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(fo);
            out.writeObject(accounts);
            System.out.println("\nGhi du lieu vao file thanh cong!");
            out.close();
        } catch (Exception ex) {
            System.out.println("Ghi du lieu vao file co loi!");
        }
    }

    public static List<Account> readFromFile() {
        try {
            FileInputStream fi = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(fi);
            List<Account> dataFromFile = (List<Account>) in.readObject();
            in.close();
            return dataFromFile;
        } catch (Exception ex) {
            System.out.println("Doc du lieu tu file co loi!");
        }

        return null;
    }

}
