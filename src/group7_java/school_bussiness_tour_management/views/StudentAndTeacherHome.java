/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group7_java.school_bussiness_tour_management.views;

import com.itextpdf.text.Rectangle;
import group7_java.school_bussiness_tour_management.common.MessageDialog;
import group7_java.school_bussiness_tour_management.common.TransmittedDataShowData;
import group7_java.school_bussiness_tour_management.dao.StudentTourDAO;
import group7_java.school_bussiness_tour_management.dao.TeacherDAO;
import group7_java.school_bussiness_tour_management.dao.TourDAO;
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
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class StudentAndTeacherHome extends javax.swing.JFrame {

    private Student loggedInStudent;
    private Teacher loggedInTeacher;

    /**
     * Creates new form Home
     *
     * @param loggedInStudent
     */
    public StudentAndTeacherHome(Object obj) {
        initComponents();
        if (obj instanceof Student) {
            this.loggedInStudent = (Student) obj;
            String title = loggedInStudent.getLastName() + " " + loggedInStudent.getFirstName();
            if (title.contains("SV chưa nhập")) {
                welcomeLabel.setText("Xin chào");
            } else {
                welcomeLabel.setText("Xin chào " + title);
            }
        } else if (obj instanceof Teacher) {
            this.loggedInTeacher = (Teacher) obj;
            welcomeLabel.setText("Xin chào " + loggedInTeacher.getLastName() + " " + loggedInTeacher.getFirstName());
        } else {
            throw new IllegalArgumentException("Không hỗ trợ loại đối tượng này.");
        }
        if (loggedInStudent == null && loggedInTeacher == null) {
            MessageDialog.showErrorDialog(this, "Phải đăng nhập với tài khoản sinh viên để sử dụng GUI này", "Lỗi");
            return;
        }
        initializeTableOfTours();
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
                        if (currentDate.compareTo(inputDate) < 0) {
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
        tourNowTable.setModel(tableModel);

        loadTableDataOfTours();
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
        showTourInDay = new javax.swing.JButton();
        showUpcomingTours = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        todayTourTable = new javax.swing.JScrollPane();
        tourNowTable = new javax.swing.JTable();
        showStudentsOfTour = new javax.swing.JButton();
        addTour = new javax.swing.JButton();
        searchInput = new javax.swing.JTextField();
        searchButton = new javax.swing.JToggleButton();

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

        showTourInDay.setText("Chuyến tham quan hôm nay của bạn");
        showTourInDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showTourInDayActionPerformed(evt);
            }
        });

        showUpcomingTours.setText("Các chuyến tham quan sắp diễn ra");
        showUpcomingTours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showUpcomingToursActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(welcomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(updateProfileButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(registeredTourButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                        .addComponent(logoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(showTourInDay, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showUpcomingTours, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(registeredTourButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(updateProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(showTourInDay, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(showUpcomingTours, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setPreferredSize(new java.awt.Dimension(640, 523));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CÁC CHUYẾN THAM QUAN DOANH NGHIỆP SẮP DIỄN RA");

        tourNowTable.setModel(new javax.swing.table.DefaultTableModel(
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
        todayTourTable.setViewportView(tourNowTable);

        showStudentsOfTour.setBackground(new java.awt.Color(0, 153, 0));
        showStudentsOfTour.setForeground(new java.awt.Color(255, 255, 255));
        showStudentsOfTour.setText("Xem danh sách sinh viên tham gia chuyến tham quan");
        showStudentsOfTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showStudentsOfTourActionPerformed(evt);
            }
        });

        addTour.setBackground(new java.awt.Color(0, 153, 0));
        addTour.setForeground(new java.awt.Color(255, 255, 255));
        addTour.setText("Đăng ký tham gia chuyến tham quan");
        addTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTourActionPerformed(evt);
            }
        });

        searchInput.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        searchInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchInputKeyReleased(evt);
            }
        });

        searchButton.setBackground(new java.awt.Color(51, 102, 255));
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Tìm kiếm");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(todayTourTable, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addTour)
                        .addGap(18, 18, 18)
                        .addComponent(showStudentsOfTour)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(327, 327, 327))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(todayTourTable, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showStudentsOfTour, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTour, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showStudentsOfTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showStudentsOfTourActionPerformed

        try {
            int index = tourNowTable.getSelectedRow();
            if (index == -1) {
                MessageDialog.showInfoDialog(this, "Vui chọn chuyến tham quan mà bạn muốn xem danh sách sinh viên", "Thông báo");
                return;
            }
            List<Tour> data_tour = TourDAO.readFromFile();
            String tourCode = (String) tourNowTable.getValueAt(index, 0);
            int tourID = -1;
            for (Tour item : data_tour) {
                if (item.getCode().equalsIgnoreCase(tourCode)) {
                    tourID = item.getId();
                    break;
                }
            }
            dispose();
            TransmittedDataShowData data_show = null;
            if (loggedInTeacher != null) {
                data_show = new TransmittedDataShowData("studentTours", "studentAndTeacherHome", tourID, loggedInTeacher.getId(), false);
            } else if (loggedInStudent != null) {
                data_show = new TransmittedDataShowData("studentTours", "studentAndTeacherHome", tourID, loggedInStudent.getId(), true);
            }
            ShowData screen = new ShowData(data_show);
            screen.setLocationRelativeTo(null);
            screen.setVisible(true);
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(jPanel1, "Có lỗi ở màn StudentAndTeacherHome cụ thể là nút showStudentsOfTourActionPerformed, chi tiết: " + ex.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_showStudentsOfTourActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        searchByKey();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchInputKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            // Handle Enter key press
            searchByKey();
        }
    }//GEN-LAST:event_searchInputKeyReleased

    private void addTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTourActionPerformed
        try {
            int index = tourNowTable.getSelectedRow();
            if (index == -1) {
                MessageDialog.showInfoDialog(this, "Vui chọn chuyến tham quan mà bạn muốn thêm", "Thông báo");
                return;
            }
            String tourCode = (String) tourNowTable.getValueAt(index, 0);
            int id = -1;
            List<Tour> data_tours = TourDAO.readFromFile();
            Iterator<Tour> iterator = data_tours.iterator();
            while (iterator.hasNext()) {
                Tour tour = iterator.next();
                if (tour.getCode().equalsIgnoreCase(tourCode)) {
                    id = tour.getId();
                    break;
                }
            }
            Tour selectTour = TourService.getTourById(id);
            if (loggedInStudent != null) {
                List<StudentTour> data_student_tours = StudentTourDAO.readFromFile();
                List<StudentTour> data_students_of_this_tour = selectTour.getStudentTours();
                List<Tour> tours = StudentTourService.getToursForStudent(loggedInStudent.getId());
                if (data_students_of_this_tour != null && data_student_tours != null && tours != null) {
                    for (StudentTour item : data_students_of_this_tour) {
                        if (item.getStudentId() == loggedInStudent.getId()) {
                            MessageDialog.showInfoDialog(tourNowTable, "Bạn đã đăng ký chuyến tham quan này rồi", "Thông báo");
                            return;
                        }
                    }
                    for (Tour item : tours) {
                        if (item.getStartDate().compareTo(selectTour.getStartDate()) == 0) {
                            MessageDialog.showInfoDialog(tourNowTable, "Bạn đã có một chuyến tham quan vào ngày " + item.getStartDate() + " rồi.", "Thông báo");
                            return;
                        }
                    }
                }
                StudentTour newTour = new StudentTour(loggedInStudent.getId(), selectTour.getId(), 0);
                data_student_tours.add(newTour);
                if (data_tours != null) {
                    for (Tour item : data_tours) {
                        if (item.getId() == id) {
                            if (item.getStudentTours() == null) {
                                item.setStudentTours(new ArrayList<>());
                            }
                            item.getStudentTours().add(newTour);

                            break;
                        }
                    }
                }
                TourDAO.writeToFile(data_tours);
                StudentTourDAO.writeToFile(data_student_tours);
                MessageDialog.showInfoDialog(tourNowTable, "Đăng ký tham quan thành công", "Thông báo");
            } else if (loggedInTeacher != null) {
                List<Tour> data_tours_teacher = loggedInTeacher.getTours();
                List<Teacher> data_teachers = TeacherDAO.readFromFile();
                if (data_tours_teacher != null) {
                    for (Tour item : data_tours_teacher) {
                        if (item.getId() == selectTour.getId()) {
                            MessageDialog.showInfoDialog(tourNowTable, "Bạn đã đăng ký chuyến tham quan này rồi", "Thông báo");
                            return;
                        }
                        if (item.getStartDate().compareTo(selectTour.getStartDate()) == 0) {
                            MessageDialog.showInfoDialog(tourNowTable, "Bạn đã có một chuyến tham quan vào ngày " + item.getStartDate() + " rồi.", "Thông báo");
                            return;
                        }
                    }
                    for (Tour item : data_tours) {
                        if (item.getId() == id) {
                            item.setTeacherId(loggedInTeacher.getId());
                            break;
                        }
                    }
                    for (Teacher item : data_teachers) {
                        if (item.getId() == loggedInTeacher.getId()) {
                            item.getTours().add(selectTour);
                        }
                    }
                }
                TeacherDAO.writeToFile(data_teachers);
                TourDAO.writeToFile(data_tours);
                MessageDialog.showInfoDialog(tourNowTable, "Đăng ký tham quan thành công", "Thông báo");
            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(tourNowTable, "Có lỗi ở màn StudentAndTeacherHome cụ thể là nút showStudentsOfTourActionPerformed, chi tiết: " + ex.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_addTourActionPerformed

    private void showTourInDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showTourInDayActionPerformed
        try {
            jLabel3.setText("CHUYẾN THAM QUAN HÔM NAY CỦA BẠN");
            addTour.setVisible(false);
            searchInput.setVisible(false);
            searchButton.setVisible(false);
            tableModel = new DefaultTableModel();
            tableModel.setColumnIdentifiers(new String[]{"Mã chuyến", "Tên chuyến", "Mô tả",
                "Số lượng", "Người đại diện công ty", "Công ty", "Giáo viên"});
            tourNowTable.setModel(tableModel);
            tableModel.setRowCount(0);
            if (loggedInStudent != null) {
                List<Tour> tour_data = StudentTourService.getToursForStudent(loggedInStudent.getId());
                List<Company> company_data = CompanyService.getAllCompanies();
                List<Teacher> teacher_data = TeacherService.getAllTeachers();

                if (tour_data != null) {
                    for (Tour tour : tour_data) {
                        String dateString = tour.getStartDate();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        try {
                            LocalDate inputDate = LocalDate.parse(dateString, formatter);
                            LocalDate currentDate = LocalDate.now();
                            if (currentDate.compareTo(inputDate) == 0) {
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
            } else if (loggedInTeacher != null) {
                List<Tour> tour_data = loggedInTeacher.getTours();
                List<Company> company_data = CompanyService.getAllCompanies();
                List<Teacher> teacher_data = TeacherService.getAllTeachers();

                if (tour_data != null) {
                    for (Tour tour : tour_data) {
                        String dateString = tour.getStartDate();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        try {
                            LocalDate inputDate = LocalDate.parse(dateString, formatter);
                            LocalDate currentDate = LocalDate.now();
                            if (currentDate.compareTo(inputDate) == 0) {
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
            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Có lỗi! Chi tiết: " + ex.getMessage(), "Có lỗi xảy ra");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_showTourInDayActionPerformed

    private void showUpcomingToursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showUpcomingToursActionPerformed
        jLabel3.setText("CÁC CHUYẾN THAM QUAN DOANH NGHIỆP SẮP DIỄN RA");
        addTour.setEnabled(true);
        searchInput.setVisible(true);
        searchButton.setVisible(true);
        initializeTableOfTours();
    }//GEN-LAST:event_showUpcomingToursActionPerformed

    private void searchByKey() {
        try {
            String keyword = searchInput.getText().trim();
            int count = 0;
            if (keyword.trim().equals("")) {
                initializeTableOfTours();
                MessageDialog.showInfoDialog(tourNowTable, "Chưa có từ khóa tìm kiếm", "Thông báo");
                return;
            }
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
                            if (keyword.equalsIgnoreCase(tour.getCode()) || keyword.equalsIgnoreCase(tour.getName())) {
                                tableModel.addRow(new Object[]{tour.getCode(), tour.getName(), tour.getDescription(),
                                    tour.getAvailables(),
                                    tour.getPresentator(), companyName, teacherName});
                            }
                        }
                    } catch (Exception ex) {
                        MessageDialog.showErrorDialog(this, "Có lỗi! Chi tiết: " + ex.getMessage(), "Có lỗi xảy ra");
                        ex.printStackTrace();
                    }
                }
            }
            tableModel.fireTableDataChanged();
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Tải dữ liệu cho bảng có lỗi! Chi tiết: " + ex.getMessage(), "Có lỗi xảy ra");
            ex.printStackTrace();
        }
    }

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
            if (loggedInStudent != null) {
                dispose();
                Student stu = StudentService.getStudentByAccountId(loggedInStudent.getAccountId());
                PersonalAccountInformation personalAccountInformationScreen = new PersonalAccountInformation(loggedInStudent);

                personalAccountInformationScreen.setLocationRelativeTo(null);
                personalAccountInformationScreen.setVisible(true);
            }else if(loggedInTeacher != null){
                 dispose();
                 TeacherProfile screen = new TeacherProfile(loggedInTeacher);
                 screen.setLocationRelativeTo(null);
                 screen.setVisible(true);
            }
        } catch (Exception ex) {
            Logger.getLogger(StudentAndTeacherHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void registeredTourButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            dispose();
            ShowData screen = null;
            if (loggedInTeacher != null) {
                TransmittedDataShowData data = new TransmittedDataShowData("toursOfTeacher", "studentAndTeacherHome", loggedInTeacher.getId(), false);
                screen = new ShowData(data);
            } else if (loggedInStudent != null) {
                TransmittedDataShowData data = new TransmittedDataShowData("toursOfStudents", "studentAndTeacherHome", loggedInStudent.getId(), true);
                screen = new ShowData(data);
            }
            screen.setLocationRelativeTo(null);
            screen.setVisible(true);
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(jPanel1, "Có lỗi, chi tiết: " + ex.getMessage(), "Lỗi");
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentAndTeacherHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentAndTeacherHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentAndTeacherHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentAndTeacherHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            StudentAndTeacherHome view = new StudentAndTeacherHome(null);
            view.setLocationRelativeTo(null);
            view.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTour;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton registeredTourButton;
    private javax.swing.JToggleButton searchButton;
    private javax.swing.JTextField searchInput;
    private javax.swing.JButton showStudentsOfTour;
    private javax.swing.JButton showTourInDay;
    private javax.swing.JButton showUpcomingTours;
    private javax.swing.JScrollPane todayTourTable;
    private javax.swing.JTable tourNowTable;
    private javax.swing.JButton updateProfileButton;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
