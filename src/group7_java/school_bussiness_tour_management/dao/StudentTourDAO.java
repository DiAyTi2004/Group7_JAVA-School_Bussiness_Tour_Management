package group7_java.school_bussiness_tour_management.dao;

import group7_java.school_bussiness_tour_management.models.StudentTour;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StudentTourDAO {

    private static String filePath = "src/group7_java/school_bussiness_tour_management/files/StudentTour.json";

    public static List<StudentTour> readFromFile() throws Exception {
        List<StudentTour> data = new ArrayList<>();

        // Check if the file exists and is not empty
        Path path = Paths.get(filePath);
        if (Files.exists(path) && Files.size(path) > 0) {
            try ( Reader reader = new FileReader(filePath)) {
                // Parse the JSON file
                JSONArray studentTourArray = (JSONArray) new org.json.simple.parser.JSONParser().parse(reader);

                // Iterate over the JSON array
                for (Object studentTourObject : studentTourArray) {
                    JSONObject studentTourJson = (JSONObject) studentTourObject;

                    // Extract data from the JSON object
                    int studentId = Integer.parseInt(studentTourJson.get("studentId").toString());
                    int tourId = Integer.parseInt(studentTourJson.get("tourId").toString());
                    int rate = Integer.parseInt(studentTourJson.get("rate").toString());

                    // Create StudentTour object and add it to the list
                    StudentTour studentTour = new StudentTour();
                    studentTour.setStudentId(studentId);
                    studentTour.setTourId(tourId);
                    studentTour.setRate(rate);

                    data.add(studentTour);
                }
            } catch (Exception e) {
                throw new IOException("Error reading StudentTour data from file", e);
            }
        }

        return data;
    }

    public static void writeToFile(List<StudentTour> studentTours) throws Exception {
        JSONArray studentTourArray = new JSONArray();

        // Convert each StudentTour object to JSON and add it to the array
        for (StudentTour studentTour : studentTours) {
            JSONObject studentTourJson = new JSONObject();
            studentTourJson.put("studentId", studentTour.getStudentId());
            studentTourJson.put("tourId", studentTour.getTourId());
            studentTourJson.put("rate", studentTour.getRate());

            studentTourArray.add(studentTourJson);
        }

        // Write the JSON array to the file
        try ( FileWriter file = new FileWriter(filePath)) {
            file.write(studentTourArray.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
