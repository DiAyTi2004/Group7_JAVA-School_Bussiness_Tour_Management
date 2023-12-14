package group7_java.school_bussiness_tour_management.services;

import group7_java.school_bussiness_tour_management.common.MessageDialog;
import static group7_java.school_bussiness_tour_management.common.Validator.formatName;
import group7_java.school_bussiness_tour_management.dao.TeacherDAO;
import group7_java.school_bussiness_tour_management.models.Teacher;
import java.util.Iterator;
import java.util.List;

public class TeacherService {

    public static String LastName(String name)
    {
        String[] splitName = formatName(name).split(" ");
        String firstName = "";
        for (int i = 0; i < splitName.length - 1; i++) {
            firstName += (splitName[i] + " ");
        }
        return firstName.trim();
    }
    
    public static String FirstName(String name)
    {
        String[] splitName = formatName(name).split(" ");
        return splitName[splitName.length - 1].trim();
    }
    
    
    public static List<Teacher> getAllTeachers() throws Exception {
        return TeacherDAO.readFromFile();
    }

    public static boolean isCheckCodeTeacher(String newCode) throws Exception {
        List<Teacher> teachers = TeacherDAO.readFromFile();
        for (Teacher next : teachers) {
            if (next.getCode().equalsIgnoreCase(newCode)) {
                return true;
            }
        }
        return false;
    }

    public static int getLastTeacherId() throws Exception {
        List<Teacher> data = TeacherDAO.readFromFile();
        if (data != null) {
            if (data.size() == 0) {
                return 0;
            }
            return data.get(data.size() - 1).getId();
        }
        return -1;
    }

    public static void createNewTeacher(String code, String name, String address, String phoneNumber, String email, String birthDate) throws Exception {
        if (!isCheckCodeTeacher(code)) {
            int lastId = getLastTeacherId();
            int id = ++lastId;
            List<Teacher> data = TeacherDAO.readFromFile();
            Teacher tea = new Teacher(id, code,FirstName(name), LastName(name), address, phoneNumber, email, birthDate);
            data.add(tea);
            TeacherDAO.writeToFile(data);
        }
    }

    public static Teacher getTeacherByIndex(int index) throws Exception {
        return TeacherDAO.readFromFile().get(index);
    }

    public static void updateTeacher(Teacher teacher) throws Exception {
        List<Teacher> data = TeacherDAO.readFromFile();
        for (Teacher tea : data) {
            if (tea.getId() == teacher.getId()) {
                tea.setCode(teacher.getCode());
                tea.setFirstName(teacher.getFirstName());
                tea.setLastName(teacher.getLastName());
                tea.setPhoneNumber(teacher.getPhoneNumber());
                tea.setBirthDate(teacher.getBirthDate());
                tea.setEmail(teacher.getEmail());
                tea.setAddress(teacher.getAddress());
                break;
            }
        }
        TeacherDAO.writeToFile(data);
    }
    
    public static void deleteTeacher(int teacherId) throws Exception {
        List<Teacher> data = TeacherDAO.readFromFile();
        Teacher delTea = null;
        for(Teacher tea : data) {
            if(tea.getId()==teacherId) {
                delTea = tea;
                break;
            }
        }
        if(delTea != null) {
            data.remove(delTea);
            TeacherDAO.writeToFile(data);
        }
    }
}
