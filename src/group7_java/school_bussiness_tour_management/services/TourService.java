/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group7_java.school_bussiness_tour_management.services;

import group7_java.school_bussiness_tour_management.dao.StudentDAO;
import group7_java.school_bussiness_tour_management.dao.TourDAO;
import group7_java.school_bussiness_tour_management.models.Student;
import group7_java.school_bussiness_tour_management.models.Tour;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gialo
 */
public class TourService {
    
    public static boolean isExistedStudentCode(String student_code ) throws Exception {
        List<Student> data = StudentDAO.readFromFile();
        for(Student stu : data){
            if(stu.getCode().trim().equals(student_code.trim())){
                return true;
            }
        }
        return false;
    }
    
    public static List<Student> getAllStudents() throws Exception{
        return StudentDAO.readFromFile();
    }
    
    public static List<Tour> getAllTours() throws Exception{
        return TourDAO.readFromFile();
    }
    
    public static List<Tour> getAllToursByCompanyId(int companyId) throws Exception{
        List<Tour> data = TourDAO.readFromFile();
        List<Tour> tourByComId = new ArrayList<>();
        for(Tour tour : data) {
            if(tour.getCompanyId() == companyId)
                tourByComId.add(tour);
        }
        return tourByComId;
    }
    
    public static int getLastCompanyId() throws Exception{
        List<Student> data = StudentDAO.readFromFile();
        if(data!=null) {
            if(data.size() == 0) {
                return 0;
            }
            return data.get(data.size() - 1).getId();
        }
        return -1;
    }
    
    public static Student getStudentByIndex(int index) throws Exception {
        return StudentDAO.readFromFile().get(index);
    }
    
    public static void createNewStudent(String code, String firstName, String lastName, String address, String phoneNumber, String email, String birthDate, int classId) throws Exception {    
        Student stu = new Student(code, firstName, lastName, address, phoneNumber, email, birthDate,classId);
        List<Student> data = StudentDAO.readFromFile();
        data.add(stu);
        StudentDAO.writeToFile(data);
    }
    
    public static void updateStudent(Student student) throws Exception {
        List<Student> data = StudentDAO.readFromFile();
        for(Student stu : data) {
            if(stu.getId()==student.getId()) {
                stu.setCode(student.getCode());
                stu.setFirstName(student.getFirstName());
                stu.setLastName(student.getLastName());
                stu.setAddress(student.getAddress());
                stu.setPhoneNumber(student.getPhoneNumber());
                stu.setEmail(student.getEmail());
                stu.setBirthDate(student.getBirthDate());
                stu.setClassId(student.getClassId());
               
                break;
            }
        }
        StudentDAO.writeToFile(data);
    }
    
    public static void deleteStudent(int studentId) throws Exception {
        List<Student> data = StudentDAO.readFromFile();
        Student delStu = null;
        for(Student stu : data) {
            if(stu.getId()==studentId) {
                delStu = stu;
                break;
            }
        }
        if(delStu!=null) {
            data.remove(delStu);
            StudentDAO.writeToFile(data);
        }
    }
}
