package group7_java.school_bussiness_tour_management.services;

import group7_java.school_bussiness_tour_management.dao.StudentDAO;
import group7_java.school_bussiness_tour_management.dao.StudentTourDAO;
import group7_java.school_bussiness_tour_management.dao.TourDAO;
import group7_java.school_bussiness_tour_management.models.Student;
import group7_java.school_bussiness_tour_management.models.StudentTour;
import group7_java.school_bussiness_tour_management.models.Tour;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PC
 */
public class StudentTourService {

    public static List<StudentTour> getAll() throws Exception {
        return StudentTourDAO.readFromFile();
    }

    public static StudentTour getByStudentIdAndTourId(int studentId, int tourId) throws Exception {
        List<StudentTour> data = StudentTourDAO.readFromFile();
        for (StudentTour item : data) {
            if (item.getTourId() == tourId && item.getStudentId() == studentId) {
                return item;
            }
        }
        return null;
    }

    public static void updateStudentTour(int studentId, int tourId, int rate) throws Exception {
        List<StudentTour> data = StudentTourDAO.readFromFile();
        for (StudentTour item : data) {
            if (item.getTourId() == studentId && tourId == item.getStudentId()) {
                item.setRate(rate);
                break;
            }
        }
        StudentTourDAO.writeToFile(data);

        List<Student> studentData = StudentDAO.readFromFile();
        Student needUpdateStudent = StudentService.getByIdFromList(studentId, studentData);
        for (StudentTour stuTour : needUpdateStudent.getStudentTours()) {
            if (stuTour.getStudentId() == studentId && stuTour.getTourId() == tourId) {
                stuTour.setRate(rate);
                break;
            }
        }
        StudentDAO.writeToFile(studentData);

        List<Tour> tourData = TourDAO.readFromFile();
        Tour needUpdateTour = TourService.getByIdFromList(tourId, tourData);
        for (StudentTour stuTour : needUpdateTour.getStudentTours()) {
            if (stuTour.getStudentId() == studentId && stuTour.getTourId() == tourId) {
                stuTour.setRate(rate);
                break;
            }
        }
        TourDAO.writeToFile(tourData);
    }

    public static void createStudentTour(int studentId, int tourId) throws Exception {
        StudentTour stuTour = new StudentTour();
        stuTour.setStudentId(studentId);
        stuTour.setTourId(tourId);
        List<StudentTour> data = StudentTourDAO.readFromFile();
        data.add(stuTour);
        StudentTourDAO.writeToFile(data);

        List<Student> studentData = StudentDAO.readFromFile();
        Student needUpdateStudent = StudentService.getByIdFromList(studentId, studentData);
        needUpdateStudent.getStudentTours().add(stuTour);
        StudentDAO.writeToFile(studentData);

        List<Tour> tourData = TourDAO.readFromFile();
        Tour needUpdateTour = TourService.getByIdFromList(tourId, tourData);
        needUpdateTour.getStudentTours().add(stuTour);
        TourDAO.writeToFile(tourData);
    }

    public static void deleteStudentTour(int studentId, int tourId) throws Exception {
        List<StudentTour> data = StudentTourDAO.readFromFile();
        StudentTour deleteItem = null;
        for (StudentTour item : data) {
            if (item.getStudentId() == studentId && item.getTourId() == tourId) {
                deleteItem = item;
                break;
            }
        }
        data.remove(deleteItem);
        StudentTourDAO.writeToFile(data);

        List<Student> studentData = StudentDAO.readFromFile();
        Student needUpdateStudent = StudentService.getByIdFromList(studentId, studentData);
        StudentTour needDelete = null;
        for (StudentTour stuTour : needUpdateStudent.getStudentTours()) {
            if (stuTour.getStudentId() == studentId && stuTour.getTourId() == tourId) {
                needDelete = stuTour;
                break;
            }
        }
        if (needDelete != null) {
            needUpdateStudent.getStudentTours().remove(needDelete);
        }
        StudentDAO.writeToFile(studentData);

        List<Tour> tourData = TourDAO.readFromFile();
        Tour needUpdateTour = TourService.getByIdFromList(tourId, tourData);
        needDelete = null;
        for (StudentTour stuTour : needUpdateTour.getStudentTours()) {
            if (stuTour.getStudentId() == studentId && stuTour.getTourId() == tourId) {
                needDelete = stuTour;
                break;
            }
        }
        if (needDelete != null) {
            needUpdateTour.getStudentTours().remove(needDelete);
        }
        TourDAO.writeToFile(tourData);
    }

    public static List<Student> getStudentsByTourId(int tourId) throws Exception {
        List<StudentTour> data = StudentTourDAO.readFromFile();
        Set<Integer> studentIds = new HashSet<>();
        for (StudentTour item : data) {
            if (item.getTourId() == tourId) {
                studentIds.add(item.getStudentId());
            }
        }
        List<Student> studentData = StudentDAO.readFromFile();
        List<Student> responseData = new ArrayList<>();
        for (Student student : studentData) {
            if (studentIds.contains(student.getId())) {
                responseData.add(student);
            }
        }
        return responseData;
    }

    public static List<Tour> getToursByStudentId(int studentId) throws Exception {
        List<StudentTour> data = StudentTourDAO.readFromFile();
        Set<Integer> tourIds = new HashSet<>();
        for (StudentTour item : data) {
            if (item.getStudentId() == studentId) {
                tourIds.add(item.getStudentId());
            }
        }
        List<Tour> tourData = TourDAO.readFromFile();
        List<Tour> responseData = new ArrayList<>();
        for (Tour tour : tourData) {
            if (tourIds.contains(tour.getId())) {
                responseData.add(tour);
            }
        }
        return responseData;
    }

}
