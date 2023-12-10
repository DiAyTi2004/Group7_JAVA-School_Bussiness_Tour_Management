package group7_java.school_bussiness_tour_management.dao;

import group7_java.school_bussiness_tour_management.models.Teacher;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NGUYEN TRANG
 */
public class TeacherDAO {

    private static String path = "src/group7_java/school_bussiness_tour_management/files/Teacher.txt";

    public static List<Teacher> readFromFile() throws Exception {
        List<Teacher> data = new ArrayList<>();
        BufferedReader read = new BufferedReader(new FileReader(path));
        String line;
        while ((line = read.readLine()) != null) {
            String[] parts = line.split(",");
            int id = Integer.parseInt(parts[0]);
            String code = parts[1];
            String lastname = parts[2];
            String firstname = parts[3];
            String address = parts[4];
            String phone = parts[5];
            String email = parts[6];
            String birthDate = parts[7];
            String username = parts[8];
            String password = parts[9];
            Teacher tea = new Teacher(id, code, firstname, lastname, address, phone, email, birthDate, username, password);
            data.add(tea);
        }
        return data;
    }

    public static void writeToFile(List<Teacher> teachers) throws Exception {
        FileWriter fw = new FileWriter(path);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Teacher teac : teachers) {
            bw.write(teac.toStringFile());
            bw.newLine();
        }
        bw.close();
        fw.close();
    }
}
