/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group7_java.school_bussiness_tour_management.dao;

import group7_java.school_bussiness_tour_management.models.Student;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gialo
 */
public class TourDAO {

    private static String filePath = "src/group7_java/school_bussiness_tour_management/files/Tour.txt";

    public static List<Student> readFromFile() throws Exception {
        List<Student> data = new ArrayList<Student>();
        BufferedReader read = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = read.readLine()) != null) {
            String[] parts = line.split(",");
            int id = Integer.parseInt(parts[0]);
            String code = parts[1];
            String first_name = parts[2];
            String last_name = parts[3];
            String address = parts[4];
            String phone_number = parts[5];
            String email = parts[6];
            String birth_date = parts[7];
            int classId = Integer.parseInt(parts[8]);
            Student stu = new Student(id, code, first_name,last_name,address,phone_number,email,birth_date,classId);
            data.add(stu);
        }
        return data;
    }

    public static void writeToFile(List<Student> students) throws Exception {
        FileWriter fw = new FileWriter(filePath);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Student stu : students) {
            bw.write(stu.toStringFile());
            bw.newLine();
        }
        bw.close();
        fw.close();
    }
}
