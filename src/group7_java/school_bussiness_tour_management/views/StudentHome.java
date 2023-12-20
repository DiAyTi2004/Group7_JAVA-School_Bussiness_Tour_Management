/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group7_java.school_bussiness_tour_management.views;

import group7_java.school_bussiness_tour_management.common.MessageDialog;
import group7_java.school_bussiness_tour_management.dao.StudentTourDAO;
import group7_java.school_bussiness_tour_management.models.Company;
import group7_java.school_bussiness_tour_management.models.Student;
import group7_java.school_bussiness_tour_management.models.StudentTour;
import group7_java.school_bussiness_tour_management.models.Teacher;
import group7_java.school_bussiness_tour_management.models.Tour;
import group7_java.school_bussiness_tour_management.services.ClassroomService;
import group7_java.school_bussiness_tour_management.services.CompanyService;
import group7_java.school_bussiness_tour_management.services.StudentService;
import group7_java.school_bussiness_tour_management.services.StudentTourService;
import static group7_java.school_bussiness_tour_management.services.StudentTourService.isExistRegisteredTour;
import group7_java.school_bussiness_tour_management.services.TeacherService;
import group7_java.school_bussiness_tour_management.services.TourService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class StudentHome extends javax.swing.JFrame {

    private Student loggedInStudent;

    /**
     * Creates new form Home
     */
    public StudentHome(Student loggedInStudent) {
        if (loggedInStudent == null) {
            MessageDialog.showErrorDialog(this, "Phải đăng nhập với tài khoản sinh viên để sử dụng GUI này", "Lỗi");
            return;
        }
        this.loggedInStudent = loggedInStudent;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        initializeTableOfTours();
        String title = loggedInStudent.getLastName() + " " + loggedInStudent.getFirstName();
        if (title.contains("SV chưa nhập")) {
            welcomeLabel.setText("Xin chào");
        } else {
            welcomeLabel.setText("Xin chào " + title);
        }
        cancelRegister.setVisible(false);
    }

    private DefaultTableModel tableModel;

    private void loadTableDataOfTours() {
        try {
            List<Tour> tour_data = TourService.getAllTours();
            List<Company> company_data = CompanyService.getAllCompanies();
            List<Teacher> teacher_data = TeacherService.getAllTeachers();
            tableModel.setRowCount(0);
            if (tour_data != null) {
                for (Tour tour : tour_data) {
                    String dateString = tour.getStartDate();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    try {
                        LocalDate inputDate = LocalDate.parse(dateString, formatter);
                        LocalDate currentDate = LocalDate.now();
                        if (currentDate.equals(inputDate)) {
                            String companyName = "";
                            String teacherName = "";
                            for (Company comp : company_data) {
                                if (comp.getId() == tour.getCompanyId()) {
                                    companyName = comp.getName();
                                }
                            }
                            for (Teacher tea : teacher_data) {
                                if (tea.getId() == tour.getTeacherId()) {
                                    teacherName = tea.getLastName() + " " + tea.getFirstName();
                                }
                            }
                            tableModel.addRow(new Object[]{tour.getCode(), tour.getName(), tour.getDescription(),
                                tour.getAvailables(),
                                tour.getPresentator(), companyName, teacherName});
                        }
                    } catch (Exception ex) {
                        MessageDialog.showErrorDialog(this, "Có lỗi! Chi tiết: " + ex.getMessage(), "Có lỗi xảy ra");
                        ex.printStackTrace();
                    }
                }
            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Tải dữ liệu cho bảng có lỗi! Chi tiết: " + ex.getMessage(), "Có lỗi xảy ra");
            ex.printStackTrace();
        }
    }

    private void initializeTableOfTours() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã chuyến", "Tên chuyến", "Mô tả",
            "Số lượng", "Người đại diện công ty", "Công ty", "Giáo viên"});
        tourTodayTable.setModel(tableModel);
        loadComingTourTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        updateProfileButton = new javax.swing.JButton();
        registeredTourButton = new javax.swing.JButton();
        welcomeLabel = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        comingTourButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        title = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tourTodayTable = new javax.swing.JTable();
        registerButton = new javax.swing.JButton();
        cancelRegister = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trang chủ");

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        updateProfileButton.setText("Tài khoản cá nhân");
        updateProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateProfileButtonActionPerformed(evt);
            }
        });

        registeredTourButton.setText("Các chuyến tham quan đã đăng kí");
        registeredTourButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registeredTourButtonActionPerformed(evt);
            }
        });

        welcomeLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(255, 255, 255));
        welcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeLabel.setText("Xin chào");

        logoutButton.setBackground(new java.awt.Color(253, 0, 0));
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setText("Đăng xuất");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        comingTourButton.setText("Các chuyến tham quan sắp diễn ra");
        comingTourButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comingTourButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(welcomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(updateProfileButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(registeredTourButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comingTourButton, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE))
                    .addComponent(logoutButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comingTourButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(registeredTourButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(updateProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jPanel2.setPreferredSize(new java.awt.Dimension(640, 523));

        title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("CÁC CHUYẾN THAM QUAN DOANH NGHIỆP SẮP DIỄN RA");

        tourTodayTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tourTodayTable);

        registerButton.setBackground(new java.awt.Color(0, 102, 255));
        registerButton.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        registerButton.setForeground(new java.awt.Color(255, 255, 255));
        registerButton.setText("Đăng ký tham gia");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        cancelRegister.setBackground(new java.awt.Color(255, 51, 102));
        cancelRegister.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        cancelRegister.setForeground(new java.awt.Color(255, 255, 255));
        cancelRegister.setText("Hủy đăng ký");
        cancelRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelRegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cancelRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(registerButton))
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(410, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initializeTableOfComingTours() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã chuyến", "Tên chuyến", "Mô tả",
            "Số lượng", "Người đại diện công ty", "Công ty", "Giáo viên"});
        tourTodayTable.setModel(tableModel);

        loadComingTourTable();
    }

    private void comingTourButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comingTourButtonActionPerformed
        this.title.setText("CÁC CHUYẾN THAM QUAN DOANH NGHIỆP SẮP DIỄN RA");
        registerButton.setVisible(true);
        cancelRegister.setVisible(false);
        initializeTableOfComingTours();
    }//GEN-LAST:event_comingTourButtonActionPerformed

    private void loadComingTourTable() {
        try {
            List<Tour> comingTours_data = TourService.getComingTourByStudentId(loggedInStudent.getId());
            Set<Tour> uniqueToursSet = new HashSet<>(comingTours_data);
            List<Tour> comingTours = new ArrayList<>(uniqueToursSet);
            List<Company> company_data = CompanyService.getAllCompanies();
            List<Teacher> teacher_data = TeacherService.getAllTeachers();
            tableModel.setRowCount(0);
            if (comingTours != null) {
                for (Tour tour : comingTours) {
                    try {
                        String companyName = "";
                        String teacherName = "";
                        for (Company comp : company_data) {
                            if (comp.getId() == tour.getCompanyId()) {
                                companyName = comp.getName();
                            }
                        }
                        for (Teacher tea : teacher_data) {
                            if (tea.getId() == tour.getTeacherId()) {
                                teacherName = tea.getLastName() + " " + tea.getFirstName();
                            }
                        }

                        tableModel.addRow(new Object[]{tour.getCode(), tour.getName(), tour.getDescription(),
                            tour.getAvailables(),
                            tour.getPresentator(), companyName, teacherName});

                    } catch (Exception ex) {
                        MessageDialog.showErrorDialog(this, "Có lỗi! Chi tiết: " + ex.getMessage(), "Có lỗi xảy ra");
                        ex.printStackTrace();
                    }
                }
            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Tải dữ liệu cho bảng có lỗi! Chi tiết: " + ex.getMessage(), "Có lỗi xảy ra");
            ex.printStackTrace();
        }
    }

    private void cancelRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelRegisterActionPerformed
        try {
            int index = tourTodayTable.getSelectedRow();
            if (index < 0) {
                MessageDialog.showErrorDialog(this, "Bạn chưa chọn chuyến tham quan nào", "Thông báo");
                return;
            }

            Object value = tourTodayTable.getValueAt(index, 0);
            Tour selectedTour = TourService.getByTourCode(value.toString());
            int userChoice = JOptionPane.showConfirmDialog(this, "Hủy tham gia tham quan doanh nghiệp" + selectedTour.getName(), "Confirmation", JOptionPane.YES_NO_OPTION);

            if (userChoice == JOptionPane.YES_OPTION) {
                StudentTourService.deleteStudentTour(loggedInStudent.getId(), selectedTour.getId());
                MessageDialog.showInfoDialog(this, "Bạn đã hủy tham gia chuyến tham quan doanh nghiệp" + selectedTour.getName(), "Thông báo");
                loadRegisteredTable();
            }
        } catch (Exception ex) {
            Logger.getLogger(StudentHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cancelRegisterActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        try {
            int index = tourTodayTable.getSelectedRow();
            if (index == -1) {
                MessageDialog.showErrorDialog(this, "Bạn chưa chọn chuyến tham quan nào", "Thông báo");
                return;
            }

            Object value = tourTodayTable.getValueAt(index, 0);
            Tour selectedTour = TourService.getByTourCode(value.toString());
            if (!isExistRegisteredTour(loggedInStudent.getId(), selectedTour.getId())) {
                MessageDialog.showErrorDialog(this, "Bạn đã đăng ký tham quan doanh nghiệp này rồi", "Thông báo");
                return;
            }
            StudentTour studentTour = new StudentTour(loggedInStudent.getId(), selectedTour.getId(), 0);

            int choice = JOptionPane.showConfirmDialog(this, "Đăng ký tham gia " + selectedTour.getName(), "Thông báo", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                List<StudentTour> studentTours = StudentTourDAO.readFromFile();
                studentTours.add(studentTour);
                StudentTourDAO.writeToFile(studentTours);

                MessageDialog.showInfoDialog(this, "Đăng ký tham gia thành công", "Thông báo");
            }

        } catch (Exception ex) {
            Logger.getLogger(StudentHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_registerButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_logoutButtonActionPerformed
        int key = MessageDialog.showConfirmDialog(this, "Bạn có chắc muốn đăng xuất khỏi hệ thống?", "Xác nhận");
        if (key == 0) {
            dispose();
            Login loginScreen = new Login();
            loginScreen.setLocationRelativeTo(null);
            loginScreen.setVisible(true);
        }
    }// GEN-LAST:event_logoutButtonActionPerformed

    private void updateProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            dispose();
            Student stu = StudentService.getStudentByAccountId(loggedInStudent.getAccountId());
            PersonalAccountInformation personalAccountInformationScreen = new PersonalAccountInformation(loggedInStudent);

            personalAccountInformationScreen.setLocationRelativeTo(null);
            personalAccountInformationScreen.setVisible(true);

        } catch (Exception ex) {
            Logger.getLogger(StudentHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initializeTableOfRegisteredTours() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã chuyến", "Tên chuyến", "Mô tả",
            "Số lượng", "Người đại diện công ty", "Công ty", "Giáo viên"});
        tourTodayTable.setModel(tableModel);

        loadRegisteredTable();
    }

    private void registeredTourButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.title.setText("CÁC CHUYẾN THAM QUAN DOANH NGHIỆP ĐÃ ĐĂNG KÝ");
        registerButton.setVisible(false);
        cancelRegister.setVisible(true);
        initializeTableOfRegisteredTours();
    }

    private void loadRegisteredTable() {
        try {
            List<Tour> registeredTours = StudentTourService.getToursForStudent(loggedInStudent.getId());
            List<Company> company_data = CompanyService.getAllCompanies();
            List<Teacher> teacher_data = TeacherService.getAllTeachers();
            tableModel.setRowCount(0);
            if (registeredTours != null) {
                for (Tour tour : registeredTours) {
                    String dateString = tour.getStartDate();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                    try {

                        LocalDate inputDate = LocalDate.parse(dateString, formatter);
                        LocalDate currentDate = LocalDate.now();
                        String companyName = "";
                        String teacherName = "";
                        for (Company comp : company_data) {
                            if (comp.getId() == tour.getCompanyId()) {
                                companyName = comp.getName();
                            }
                        }
                        for (Teacher tea : teacher_data) {
                            if (tea.getId() == tour.getTeacherId()) {
                                teacherName = tea.getLastName() + " " + tea.getFirstName();
                            }
                        }

                        tableModel.addRow(new Object[]{tour.getCode(), tour.getName(), tour.getDescription(),
                            tour.getAvailables(),
                            tour.getPresentator(), companyName, teacherName});

                    } catch (Exception ex) {
                        MessageDialog.showErrorDialog(this, "Có lỗi! Chi tiết: " + ex.getMessage(), "Có lỗi xảy ra");
                        ex.printStackTrace();
                    }
                }
            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Tải dữ liệu cho bảng có lỗi! Chi tiết: " + ex.getMessage(), "Có lỗi xảy ra");
            ex.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
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
            StudentHome view = new StudentHome(null);
            view.setLocationRelativeTo(null);
            view.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelRegister;
    private javax.swing.JButton comingTourButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton registerButton;
    private javax.swing.JButton registeredTourButton;
    private javax.swing.JLabel title;
    private javax.swing.JTable tourTodayTable;
    private javax.swing.JButton updateProfileButton;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
