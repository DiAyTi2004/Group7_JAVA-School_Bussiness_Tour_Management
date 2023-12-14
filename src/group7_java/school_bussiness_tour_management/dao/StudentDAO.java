/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group7_java.school_bussiness_tour_management.dao;

import group7_java.school_bussiness_tour_management.models.Student;
import group7_java.school_bussiness_tour_management.models.StudentTour;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author gialo
 */
public class StudentDAO {

     private static String filePath = "src/group7_java/school_bussiness_tour_management/files/Student.json";

    public static void writeToFile(List<Student> students) throws IOException {
        JSONArray studentArray = new JSONArray();

        for (Student student : students) {
            JSONObject studentJson = new JSONObject();
            studentJson.put("id", student.getId());
            studentJson.put("code", student.getCode());
            studentJson.put("firstName", student.getFirstName());
            studentJson.put("lastName", student.getLastName());
            studentJson.put("address", student.getAddress());
            studentJson.put("phoneNumber", student.getPhoneNumber());
            studentJson.put("email", student.getEmail());
            studentJson.put("birthDate", student.getBirthDate());
            studentJson.put("classId", student.getClassId());

//            List<StudentTour> studentTours = student.getStudentTours();
//            if (studentTours != null && !studentTours.isEmpty()) {
//                JSONArray studentToursArray = new JSONArray();
//                for (StudentTour studentTour : studentTours) {
//                    JSONObject studentTourJson = new JSONObject();
//                    // Set fields of StudentTour as needed
//                    studentToursArray.add(studentTourJson);
//                }
//                studentJson.put("studentTours", studentToursArray);
//            }
            studentArray.add(studentJson);
        }

        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(studentArray.toJSONString());
        } catch (IOException e) {
            throw new IOException("Error writing Student data to file", e);
        }
    }

    public static List<Student> readFromFile() throws IOException {
        List<Student> students = new ArrayList<>();

        // Check if the file exists and is not empty
        Path path = Paths.get(filePath);
        if (Files.exists(path) && Files.size(path) > 0) {
            try (Reader reader = new FileReader(filePath)) {
                // Parse the JSON file
                JSONArray studentArray = (JSONArray) new org.json.simple.parser.JSONParser().parse(reader);

                // Iterate over the JSON array
                for (Object studentObject : studentArray) {
                    JSONObject studentJson = (JSONObject) studentObject;
                    
                    int id = Integer.parseInt(studentJson.get("id").toString());
                    String code = (String) studentJson.get("code");
                    String firstName = (String) studentJson.get("firstName");
                    String lastName = (String) studentJson.get("lastName");
                    String address = (String) studentJson.get("address");
                    String phoneNumber = (String) studentJson.get("phoneNumber");
                    String email = (String) studentJson.get("email");
                    String birthDate = (String) studentJson.get("birthDate");
                    int classId = Integer.parseInt(studentJson.get("classId").toString());

                    // Create Student object and add it to the list
                    Student student = new Student(id, code, firstName, lastName, address, phoneNumber, email, birthDate, classId);
                    students.add(student);
                }
            } catch (Exception e) {
                throw new IOException("Error reading Student data from file", e);
            }
        }

        return students;
    }

}
