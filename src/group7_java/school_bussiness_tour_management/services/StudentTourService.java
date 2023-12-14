/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group7_java.school_bussiness_tour_management.services;

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
    // Phương thức để lấy danh sách Tours của một sinh viên dựa trên studentId
    public static List<Tour> getToursForStudent(int studentId) throws Exception{
        List<Tour> toursForStudent = new ArrayList<>();
        List<StudentTour> studentTours = StudentTourDAO.readFromFile();

        for (StudentTour studentTour : studentTours) {
            if (studentTour.getStudentId() == studentId) {
                int tourId = studentTour.getTourId();
                Tour tour = TourService.getTourById(tourId); // Assuming you have a method to get a Tour by ID
                if (tour != null) {
                    toursForStudent.add(tour);
                }
            }
        }

        return toursForStudent;
    }
}
