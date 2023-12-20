/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package group7_java.school_bussiness_tour_management.views;

import group7_java.school_bussiness_tour_management.common.MessageDialog;
import group7_java.school_bussiness_tour_management.models.Classroom;
import group7_java.school_bussiness_tour_management.models.Company;
import group7_java.school_bussiness_tour_management.models.Student;
import group7_java.school_bussiness_tour_management.models.StudentTour;
import group7_java.school_bussiness_tour_management.models.Teacher;
import group7_java.school_bussiness_tour_management.models.Tour;
import group7_java.school_bussiness_tour_management.services.ClassroomService;
import group7_java.school_bussiness_tour_management.services.CompanyService;
import group7_java.school_bussiness_tour_management.services.StudentService;
import group7_java.school_bussiness_tour_management.services.StudentTourService;
import group7_java.school_bussiness_tour_management.services.TeacherService;
import group7_java.school_bussiness_tour_management.services.TourService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gialo
 */
public class ListOfStudentInTheTour extends javax.swing.JFrame {

    private DefaultTableModel tableModel;
    private Tour selectedTour;
    private Student loggedInStudent;

    public ListOfStudentInTheTour(Student loggedInStudent, Tour selectedTour) {
        initComponents();
        this.loggedInStudent = loggedInStudent;
        this.selectedTour = selectedTour;
        initializeTable();
    }

    private void initializeTable() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã sinh viên", "Họ", "Tên", "Địa chỉ", "SĐT", "Email", "Ngày sinh", "Lớp", "Đánh giá","Xếp loại"});
        ListOfStudentParticipatingTourTable.setModel(tableModel);

        loadListStudentInTour();
    }

    private void loadListStudentInTour() {
        try {
            List<Student> student_data = StudentService.getListStudentInTourByTourId(selectedTour.getId());
            List<Classroom> classroom_data = ClassroomService.getAllClassroom();
            tableModel.setRowCount(0);

            if (student_data != null) {
                for (Student student : student_data) {
                    String classroomName = "";
                    for (Classroom classroom : classroom_data) {
                        if (classroom.getId() == student.getClassId()) {
                            classroomName = classroom.getName();
                        }
                    }
                    StudentTour studentTour = StudentTourService.getStudentTourByStudenIdAndTourId(student.getId(), selectedTour.getId());
                    int rate = studentTour.getRate();
                    String result = studentTour.getResult();
                    tableModel.addRow(new Object[]{student.getCode(), student.getLastName(),
                        student.getFirstName(), student.getAddress(), student.getPhoneNumber(), student.getEmail(), student.getBirthDate(), classroomName,rate,result});

                }
            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Tải dữ liệu cho bảng có lỗi! Chi tiết: " + ex.getMessage(), "Có lỗi xảy ra");
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListOfStudentParticipatingTourTable = new javax.swing.JTable();
        searchField = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BackButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BackButton.setText("Trở lại");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("DANH SÁCH SINH VIÊN THAM QUAN DOANH NGHIỆP");

        ListOfStudentParticipatingTourTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(ListOfStudentParticipatingTourTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
        );

        searchField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchField.setText("Nhập tên sinh viên");

        SearchButton.setBackground(new java.awt.Color(0, 102, 255));
        SearchButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SearchButton.setForeground(new java.awt.Color(255, 255, 255));
        SearchButton.setText("Tìm Kiếm");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(12, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        dispose();
        StudentHome studentHomeScreen = new StudentHome(loggedInStudent);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchButtonActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            ListOfStudentInTheTour view = new ListOfStudentInTheTour(null, null);
            view.setLocationRelativeTo(null);
            view.setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JTable ListOfStudentParticipatingTourTable;
    private javax.swing.JButton SearchButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}
