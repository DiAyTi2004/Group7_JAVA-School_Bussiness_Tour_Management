/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package group7_java.school_bussiness_tour_management.views;

import group7_java.school_bussiness_tour_management.common.MessageDialog;
import group7_java.school_bussiness_tour_management.common.TransmittedDataShowData;
import group7_java.school_bussiness_tour_management.models.Teacher;
import group7_java.school_bussiness_tour_management.models.Tour;
import group7_java.school_bussiness_tour_management.services.TeacherService;
import group7_java.school_bussiness_tour_management.services.TourService;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NGUYEN TRANG
 */
public class ManageToursOfTeacher extends javax.swing.JFrame {

    /**
     * Creates new form ManageToursOfTeacher
     */
    public ManageToursOfTeacher() {
        initComponents();
    }

    private int teacherId;

    public void setTeacherID(int teaID) {
        this.teacherId = teaID;
    }
    private DefaultTableModel tableModel;

    private void loadTableData() {
        try {
            List<Tour> data = TeacherService.listToursOfTeacher(teacherId);
            tableModel.setRowCount(0);
            if (data != null) {
                for (Tour tourItem : data) {
                    tableModel.addRow(new Object[]{
                        tourItem.getCode(), tourItem.getName(), tourItem.getStartDate(),
                        TeacherService.getNameCompanyFromIdCompany(tourItem.getCompanyId()),
                        TeacherService.getNumberOfStudents(tourItem.getStudentTours())
                    });
                }
            }
            tableModel.fireTableDataChanged();
        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, "Tải dữ liệu cho bảng có lỗi! Chi tiết: " + e.getMessage(), "Có lỗi xảy ra");
            e.printStackTrace();
        }
    }

    public void initializeTable() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã chuyến tham quan", "Tên chuyến tham quan", "Ngày tham quan", "Doanh nghiệp chủ quản", "Số lượng sinh viên tham gia"});
        toursTable.setModel(tableModel);
        loadTableData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backManageTeacher = new javax.swing.JButton();
        titleMain = new javax.swing.JLabel();
        teacherIdLabel = new javax.swing.JLabel();
        teacherPhoneNumberLabel = new javax.swing.JLabel();
        teacherNameLabel = new javax.swing.JLabel();
        teacherEmailLable = new javax.swing.JLabel();
        teacherAdressLable = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        toursTable = new javax.swing.JTable();
        showListStudents = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Xem chi tour của giáo viên");

        backManageTeacher.setText("Quay lại trang trước");
        backManageTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backManageTeacherActionPerformed(evt);
            }
        });

        titleMain.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titleMain.setText("Các chuyến tham quan doanh nghiệp do giáo viên đại diện");

        teacherIdLabel.setText("Mã giáo viên: ");

        teacherPhoneNumberLabel.setText("Họ tên:");

        teacherNameLabel.setText("Số điện thoại: ");

        teacherEmailLable.setText("Email: ");

        teacherAdressLable.setText("Địa chỉ: ");

        toursTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(toursTable);

        showListStudents.setText("Xem danh sách sinh viên của chuyến đi");
        showListStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showListStudentsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(teacherNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(teacherIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(teacherEmailLable, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(teacherPhoneNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79)
                        .addComponent(teacherAdressLable, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(showListStudents)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(backManageTeacher)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 923, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(30, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titleMain)
                .addGap(235, 235, 235))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backManageTeacher)
                .addGap(24, 24, 24)
                .addComponent(titleMain)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(teacherIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teacherPhoneNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teacherAdressLable, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(teacherNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teacherEmailLable, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(showListStudents)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showListStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showListStudentsActionPerformed
        try {
            int index = toursTable.getSelectedRow();
            if (index == -1) {
                MessageDialog.showInfoDialog(this, "Vui chọn chọn chọn chuyến tham quan để xem danh sách sinh viên tham quan", "Thông báo");
                return;
            }
            Tour selectedTour = TourService.getTourByIndex(index);
            dispose();
            TransmittedDataShowData data = new TransmittedDataShowData("studentTours", "managetoursofteacher", selectedTour.getId(), teacherId);
            ShowData showDataScreen = new ShowData(data);
            if (showDataScreen != null) {
                showDataScreen.setLocationRelativeTo(null);
                showDataScreen.setVisible(true);
            }
        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, "Có lỗi, chi tiết: " + e, "Lỗi");
        }
    }//GEN-LAST:event_showListStudentsActionPerformed

    private void backManageTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backManageTeacherActionPerformed
        dispose();
        ManageTeacher manageTeacherScreen = new ManageTeacher();
        manageTeacherScreen.setLocationRelativeTo(null);
        manageTeacherScreen.setVisible(true);
    }//GEN-LAST:event_backManageTeacherActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageToursOfTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageToursOfTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageToursOfTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageToursOfTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ManageToursOfTeacher().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backManageTeacher;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton showListStudents;
    private javax.swing.JLabel teacherAdressLable;
    private javax.swing.JLabel teacherEmailLable;
    private javax.swing.JLabel teacherIdLabel;
    private javax.swing.JLabel teacherNameLabel;
    private javax.swing.JLabel teacherPhoneNumberLabel;
    private javax.swing.JLabel titleMain;
    private javax.swing.JTable toursTable;
    // End of variables declaration//GEN-END:variables

    public JLabel getTeacherIdLabel() {
        return teacherIdLabel;
    }

    public JLabel getTeacherNameLabel() {
        return teacherNameLabel;
    }

    public JLabel getTeacherPhoneNumberLabel() {
        return teacherPhoneNumberLabel;
    }

    public JLabel getTeacherEmailLable() {
        return teacherEmailLable;
    }

    public JLabel getTeacherAdressLable() {
        return teacherAdressLable;
    }

}
