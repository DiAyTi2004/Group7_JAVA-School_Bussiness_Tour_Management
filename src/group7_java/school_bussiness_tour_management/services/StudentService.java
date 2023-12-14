/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group7_java.school_bussiness_tour_management.services;

import group7_java.school_bussiness_tour_management.dao.StudentDAO;
import group7_java.school_bussiness_tour_management.models.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gialo
 */
public class StudentService {
    
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
    
    public static int getLastStudentId() throws Exception{
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

    public static List<Student> getStudentByClassId(int classId) throws Exception {
        List<Student> data = StudentDAO.readFromFile();
        List<Student> trueData = new ArrayList<Student>();
        if(data != null){
            for(Student stu: data){
            // sua lai kieu du lieu cua student classId thanh string
            if(stu.getClassId() == classId){
                trueData.add(stu);
            }
            }
            
        }
        
        return trueData;
    }
    
    public static void createNewStudent(int id,String code, String firstName, String lastName, String address, String phoneNumber, String email, String birthDate, int classId) throws Exception {    
        id = getLastStudentId();
        Student stu = new Student(id,code, firstName, lastName, address, phoneNumber, email, birthDate,classId);
        List<Student> data = StudentDAO.readFromFile();
        data.add(stu);
        StudentDAO.writeToFile(data);
    }
    
    public static void updateStudent(Student student) throws Exception {
        List<Student> data = StudentDAO.readFromFile();
        for(Student stu : data) {
            if(stu.getCode().equals(student.getCode())) {
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