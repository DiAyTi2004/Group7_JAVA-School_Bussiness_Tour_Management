/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group7_java.school_bussiness_tour_management.common;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;


/**
 *
 * @author NGUYEN TRANG
 */
public class GetSizeOfDataFromJson {
    public int getSizeOfDataFromJson(String filePath) throws IOException
    {
        try {
            Object obj = new JSONParser().parse(new FileReader(filePath));
            if (obj instanceof JSONArray) {
                JSONArray jsonArray = (JSONArray) obj;

                int arraySize = jsonArray.size();
                return arraySize;
            } else {
                System.out.println("File không chứa một JSONArray.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
