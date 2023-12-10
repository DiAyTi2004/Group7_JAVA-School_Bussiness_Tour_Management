/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group7_java.school_bussiness_tour_management.models;

import java.util.List;

/**
 *
 * @author PC
 */
public class Teacher extends Person{
    private String username;
    private String password;
    private List<Tour> tours;
    public Teacher() {
    }

    public Teacher( int id, String code, String firstName, String lastName, String address, String phoneNumber, String email, String birthDate, String username, String password) {
        super(id, code, firstName, lastName, address, phoneNumber, email, birthDate);
        this.username = username;
        this.password = password;
    }


    public String getUsername() { 
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Person.count = count;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    
    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }

    @Override
    public String toString() {
        return id + "," + code + "," + firstName + "," + lastName + "," + address + "," + phoneNumber + "," + email + "," + birthDate + "," + tours;
    }

    public String toStringFile() {
        System.out.println(id + "," + code + "," + firstName + "," + lastName + "," + address + "," + phoneNumber + "," + email + "," + getBirthDate() + "," + getUsername()+ "," + getPassword());
        return id + "," + code + "," + firstName + "," + lastName + "," + address + "," + phoneNumber + "," + email + "," + getBirthDate() + "," + getUsername()+ "," + getPassword();
    }

}
