/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group7_java.school_bussiness_tour_management.services;

import group7_java.school_bussiness_tour_management.common.MessageDialog;
import group7_java.school_bussiness_tour_management.dao.CompanyDAO;
import group7_java.school_bussiness_tour_management.dao.StudentDAO;
import group7_java.school_bussiness_tour_management.dao.TourDAO;
import group7_java.school_bussiness_tour_management.models.Company;
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
    
    public static boolean isExistedTourCode(String tourCode) throws Exception {
        List<Tour> data = TourDAO.readFromFile();
        for(Tour tour : data) {
            if(tour.getCode().trim().equals(tourCode.trim())) {
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
    
    public static int getLastTourId() throws Exception{
        List<Tour> data = TourDAO.readFromFile();
        if(data!=null) {
            if(data.size() == 0) {
                return 0;
            }
            return data.get(data.size() - 1).getId();
        }
        return -1;
    }
    
    public static Tour getTourByIndex(int index) throws Exception {
        return TourDAO.readFromFile().get(index);
    }
    
    public static void createNewTour(String code, String name, String description, String startDate, int availables, int companyId, int teacherId, String presentator) throws Exception {    
        int lastId = getLastTourId();
        lastId++;
        Tour tour = new Tour(lastId, code, name, description, startDate,availables, companyId, teacherId, presentator);
        List<Tour> tour_data = TourDAO.readFromFile();
        List<Company> company_data = CompanyDAO.readFromFile();
        for(Company comp : company_data) {
            if(comp.getId() == companyId) {
                if (comp.getTours() == null) {
                    comp.setTours(new ArrayList<>()); // Khởi tạo danh sách nếu là null
                }
                comp.getTours().add(tour);
            }
        }
        tour_data.add(tour);
        TourDAO.writeToFile(tour_data);
        CompanyDAO.writeToFile(company_data);        
    }
    
    public static void updateTour(Tour uTour) throws Exception {
        List<Tour> tour_data = TourDAO.readFromFile();
        List<Company> company_data = CompanyDAO.readFromFile();
        for(Tour tour : tour_data) {
            if(tour.getId() == uTour.getId()) {
                tour.setCode(uTour.getCode());
                tour.setName(uTour.getName());
                tour.setDescription(uTour.getDescription());
                tour.setStartDate(uTour.getStartDate());
                tour.setAvailables(uTour.getAvailables());
                tour.setCompanyId(uTour.getCompanyId());
                tour.setTeacherId(uTour.getTeacherId());
                tour.setPresentator(uTour.getPresentator());
            }
        }
        for(Company comp : company_data) {
            if (comp.getTours() == null) {
                    comp.setTours(new ArrayList<>()); // Khởi tạo danh sách nếu là null
                }
            for(Tour comp_tour : comp.getTours()){
                if(comp_tour.getId() == uTour.getId()){
                    comp_tour.setCode(uTour.getCode());
                    comp_tour.setName(uTour.getName());
                    comp_tour.setDescription(uTour.getDescription());
                    comp_tour.setStartDate(uTour.getStartDate());
                    comp_tour.setAvailables(uTour.getAvailables());
                    comp_tour.setCompanyId(uTour.getCompanyId());
                    comp_tour.setTeacherId(uTour.getTeacherId());
                    comp_tour.setPresentator(uTour.getPresentator());
                }
            }
        }
        TourDAO.writeToFile(tour_data);
        CompanyDAO.writeToFile(company_data);
    }
    
    public static void deleteTour(int tourId) throws Exception {
        List<Tour> tour_data = TourDAO.readFromFile();
        List<Company> company_data = CompanyDAO.readFromFile();
        
        Tour delTour = null;
        for(Tour tour : tour_data) {
            if(tour.getId()==tourId) {
                delTour = tour;
                break;
            }
        }
        if(delTour!=null) {
            tour_data.remove(delTour);
            for(Company comp : company_data) {
                if(comp.getId() == delTour.getCompanyId()) {
                    comp.getTours().remove(delTour);
                }
            }
            CompanyDAO.writeToFile(company_data);
            TourDAO.writeToFile(tour_data);
        }
    }
}
