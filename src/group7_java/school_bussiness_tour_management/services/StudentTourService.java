/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group7_java.school_bussiness_tour_management.services;

import group7_java.school_bussiness_tour_management.common.MessageDialog;
import group7_java.school_bussiness_tour_management.dao.StudentDAO;
import group7_java.school_bussiness_tour_management.dao.StudentTourDAO;
import group7_java.school_bussiness_tour_management.dao.TourDAO;
import group7_java.school_bussiness_tour_management.models.Student;
import group7_java.school_bussiness_tour_management.models.StudentTour;
import group7_java.school_bussiness_tour_management.models.Tour;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gialo
 */
public class StudentTourService {

    public static List<Tour> getToursForStudent(int studentId) throws Exception {
        List<Tour> toursForStudent = new ArrayList<>();
        List<StudentTour> studentTours = StudentTourDAO.readFromFile();
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

    public static List<StudentTour> getStudentTour(int studentId) throws Exception {
        List<StudentTour> studentTour = new ArrayList<>();
        List<StudentTour> student = StudentTourDAO.readFromFile();
        for (StudentTour stu : student) {
            if (stu.getStudentId() == studentId) {
                studentTour.add(stu);
            }
        }
        return studentTour;
    }

    public static void deleteStudentTour(StudentTour needDelete) throws Exception {
        List<StudentTour> studentTourData = StudentTourDAO.readFromFile();
        StudentTour willDelete = null;
        for (StudentTour current : studentTourData) {
            if (current.getStudentId() == needDelete.getStudentId() && current.getTourId() == needDelete.getTourId()) {
                willDelete = current;
                break;
            }
        }
        if (willDelete != null) {
            studentTourData.remove(willDelete);
            StudentTourDAO.writeToFile(studentTourData);
        }

        willDelete = null;
        List<Student> studentData = StudentDAO.readFromFile();
        for (Student student : studentData) {
            if (student.getId() == needDelete.getStudentId()) {
                if (student.getStudentTours() == null) {
                    student.setStudentTours(new ArrayList<>());
                }
                for (StudentTour current : student.getStudentTours()) {
                    if (current.getStudentId() == needDelete.getStudentId() && current.getTourId() == needDelete.getTourId()) {
                        willDelete = current;
                        break;
                    }
                }
                if (willDelete != null) {
                    student.getStudentTours().remove(willDelete);
                    break;
                }
            }
            if (willDelete != null) {
                break;
            }
        }
        StudentDAO.writeToFile(studentData);

        willDelete = null;
        List<Tour> tourData = TourDAO.readFromFile();
        for (Tour tour : tourData) {
            if (tour.getId() == needDelete.getTourId()) {
                if (tour.getStudentTours() == null) {
                    tour.setStudentTours(new ArrayList<>());
                }
                for (StudentTour current : tour.getStudentTours()) {
                    if (current.getStudentId() == needDelete.getStudentId() && current.getTourId() == needDelete.getTourId()) {
                        willDelete = current;
                        break;
                    }
                }
                if (willDelete != null) {
                    tour.getStudentTours().remove(willDelete);
                    break;
                }
            }
            if (willDelete != null) {
                break;
            }
        }
        TourDAO.writeToFile(tourData);

    }

    public static void deleteStudentTour(int studentId, int tourId) throws Exception {
        StudentTour needDelete = new StudentTour(studentId, tourId, 0);

        List<StudentTour> studentTourData = StudentTourDAO.readFromFile();
        StudentTour willDelete = null;
        for (StudentTour current : studentTourData) {
            if (current.getStudentId() == needDelete.getStudentId() && current.getTourId() == needDelete.getTourId()) {
                willDelete = current;
                break;
            }
        }
        if (willDelete != null) {
            studentTourData.remove(willDelete);
            StudentTourDAO.writeToFile(studentTourData);
        }

        willDelete = null;
        List<Student> studentData = StudentDAO.readFromFile();
        for (Student student : studentData) {
            if (student.getId() == needDelete.getStudentId()) {
                if (student.getStudentTours() == null) {
                    student.setStudentTours(new ArrayList<>());
                }
                for (StudentTour current : student.getStudentTours()) {
                    if (current.getStudentId() == needDelete.getStudentId() && current.getTourId() == needDelete.getTourId()) {
                        willDelete = current;
                        break;
                    }
                }
                if (willDelete != null) {
                    student.getStudentTours().remove(willDelete);
                    break;
                }
            }
            if (willDelete != null) {
                break;
            }
        }
        StudentDAO.writeToFile(studentData);

        willDelete = null;
        List<Tour> tourData = TourDAO.readFromFile();
        for (Tour tour : tourData) {
            if (tour.getId() == needDelete.getTourId()) {
                if (tour.getStudentTours() == null) {
                    tour.setStudentTours(new ArrayList<>());
                }
                for (StudentTour current : tour.getStudentTours()) {
                    if (current.getStudentId() == needDelete.getStudentId() && current.getTourId() == needDelete.getTourId()) {
                        willDelete = current;
                        break;
                    }
                }
                if (willDelete != null) {
                    tour.getStudentTours().remove(willDelete);
                    break;
                }
            }
            if (willDelete != null) {
                break;
            }
        }
        TourDAO.writeToFile(tourData);

    }
}
