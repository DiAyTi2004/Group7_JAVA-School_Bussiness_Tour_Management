/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group7_java.school_bussiness_tour_management.common;

/**
 *
 * @author NGUYEN TRANG
 */
public class TransmittedDataShowData {

    private String typeData;
    private String backToPage;
    private int tourId;
    private int teacherId;

    public TransmittedDataShowData() {
    }

    public TransmittedDataShowData(String typeData, String backToPage, int tourId, int teacherId) {
        this.typeData = typeData;
        this.backToPage = backToPage;
        this.tourId = tourId;
        this.teacherId = teacherId;
    }

    public TransmittedDataShowData(String typeData, String backToPage) {
        this.typeData = typeData;
        this.backToPage = backToPage;
    }

    public void setTypeData(String typeData) {
        this.typeData = typeData;
    }

    public void setBackToPage(String backToPage) {
        this.backToPage = backToPage;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTypeData() {
        return typeData;
    }

    public String getBackToPage() {
        return backToPage;
    }

    public int getTourId() {
        return tourId;
    }

    public int getTeacherId() {
        return teacherId;
    }

}
