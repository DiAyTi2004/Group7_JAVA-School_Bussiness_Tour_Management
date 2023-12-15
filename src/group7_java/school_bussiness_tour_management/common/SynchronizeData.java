/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group7_java.school_bussiness_tour_management.common;

import static group7_java.school_bussiness_tour_management.dao.TeacherDAO.readFromFile;
import static group7_java.school_bussiness_tour_management.dao.TeacherDAO.writeToFile;
import group7_java.school_bussiness_tour_management.models.Teacher;
import group7_java.school_bussiness_tour_management.models.Tour;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NGUYEN TRANG
 */
public class SynchronizeData {
     public static void addTourForTeacher(int teacherId, Tour newTour) throws Exception {
        List<Teacher> teachers = readFromFile();

        for (Teacher teacher : teachers) {
            if (teacher.getId() == teacherId) {
                // Thêm tour mới cho giáo viên
                List<Tour> teacherTours = teacher.getTours();
                if (teacherTours == null) {
                    teacherTours = new ArrayList<>();
                }
                teacherTours.add(newTour);
                teacher.setTours(teacherTours);
                break;
            }
        }

        // Lưu dữ liệu giáo viên với tour mới vào tệp JSON
        writeToFile(teachers);
    }
}
