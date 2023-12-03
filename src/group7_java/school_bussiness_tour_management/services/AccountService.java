/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group7_java.school_bussiness_tour_management.services;

import group7_java.school_bussiness_tour_management.dao.AccountDAO;
import group7_java.school_bussiness_tour_management.models.Account;
import java.util.List;

/**
 *
 * @author PC
 */
public class AccountService {
    public static boolean isExisted(Account account){
        List<Account> data = AccountDAO.readFromFile();
        for(Account acc:data){
            if(acc.getUsername().equals(account.getUsername()) && acc.getPassword().equals(account.getPassword())) return true;
        }
        return false;
    }
    
    public static boolean isExistedUsername(String username){
        List<Account> data = AccountDAO.readFromFile();
        for(Account acc:data){
            if(acc.getUsername().trim().equals(username.trim())) return true;
        }
        return false;
    }
    
    public static void createNewAccount(String username, String password){
        Account acc = new Account();
        Account.count++;
        acc.setId(Account.count);
        acc.setUsername(username);
        acc.setPassword(password);
        List<Account> data = AccountDAO.readFromFile();
        data.add(acc);
        AccountDAO.writeToFile(data);
    }
    
    public static void updateAccount(Account account){
        List<Account> data = AccountDAO.readFromFile();
        for( Account acc: data){
            if(acc.getId() == account.getId()){
                acc.setPassword(account.getPassword());
                acc.setUsername(account.getUsername());
                break;
            }
        }
        AccountDAO.writeToFile(data);
    }
    
    public static void deleteAccount(int accountId){
        List<Account> data = AccountDAO.readFromFile();
        Account deleteAccount = null;
        for(Account acc: data){
            if(acc.getId() == accountId){
                deleteAccount = acc;
                break;
            }
        }
        if(deleteAccount != null){
            data.remove(deleteAccount);
            AccountDAO.writeToFile(data);
        }
    }
}
