/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group7_java.school_bussiness_tour_management.services;

import group7_java.school_bussiness_tour_management.common.MessageDialog;
import group7_java.school_bussiness_tour_management.dao.StudentTourDAO;
import group7_java.school_bussiness_tour_management.models.StudentTour;
import group7_java.school_bussiness_tour_management.models.Tour;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gialo
 */
public class StudentTourService {

    public static List<Tour> getToursForStudent(int studentId) throws Exception{
        List<Tour> toursForStudent = new ArrayList<>();
        List<StudentTour>studentTours = StudentTourDAO.readFromFile();
        for (StudentTour studentTour : studentTours) {
            if (studentTour.getStudentId() == studentId) {
                int tourId = studentTour.getTourId();
                Tour tour = TourService.getTourById(tourId);
                if (tour != null) {
                    toursForStudent.add(tour);
                }
            }
        }
        return toursForStudent;
    }
    
    public static List<StudentTour> getStudentTour(int studentId) throws Exception{
        List<StudentTour> studentTour = new ArrayList<>();
        List<StudentTour> student = StudentTourDAO.readFromFile();
        for(StudentTour stu : student){
            if(stu.getStudentId() ==  studentId){
                studentTour.add(stu);
            }
        }
        return studentTour;
    }
}
