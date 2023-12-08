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
public class Student extends Person {

    private List<StudentTour> studentTours;
    private int classId;

    public Student() {
    }

    public Student(int id, String code, String firstName, String lastName, String address, String phoneNumber, String email, String birthDate, int classId) {
        super(id, code, firstName, lastName, address, phoneNumber, email, birthDate);
        this.classId = classId;
    }

    public Student(String code, String firstName, String lastName, String address, String phoneNumber, String email, String birthDate,int classId) {
        super(code, firstName, lastName, address, phoneNumber, email, birthDate);
        this.classId = classId;
    }

    public List<StudentTour> getStudentTours() {
        return studentTours;
    }

    public void setStudentTours(List<StudentTour> studentTours) {
        this.studentTours = studentTours;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return id + "," + code + "," + firstName + "," + lastName + "," + address + "," + phoneNumber + "," + email + "," + birthDate + "," + studentTours + "," + classId;
    }
    
    public String toStringFile(){
        return id+","+ code + "," + firstName + "," + lastName + "," + address + "," + phoneNumber + "," + email + "," + birthDate +"," + classId;
        
    }

}
