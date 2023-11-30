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
public class Company {

    public static int count = 0;

    private int id;
    private String code;
    private String name;
    private String description;
    private String email;
    private String phoneNumber;
    private String address;
    private String presentator;
    private List<Tour> tours;

    public Company() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPresentator() {
        return presentator;
    }

    public void setPresentator(String presentator) {
        this.presentator = presentator;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }

    @Override
    public String toString() {
        return "Company{" + "id=" + id + ", code=" + code + ", name=" + name + ", description=" + description + ", email=" + email + ", phoneNumber=" + phoneNumber + ", address=" + address + ", presentator=" + presentator + ", tours=" + tours + '}';
    }

}
