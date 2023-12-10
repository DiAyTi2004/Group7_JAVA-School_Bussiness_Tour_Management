/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package group7_java.school_bussiness_tour_management.views;

import group7_java.school_bussiness_tour_management.common.MessageDialog;
import group7_java.school_bussiness_tour_management.common.Validator;
import static group7_java.school_bussiness_tour_management.common.Validator.isNumeric;
import static group7_java.school_bussiness_tour_management.common.Validator.isValidEmail;
import group7_java.school_bussiness_tour_management.models.Student;
import group7_java.school_bussiness_tour_management.services.StudentService;
import static group7_java.school_bussiness_tour_management.services.StudentService.isExistedStudentCode;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gialo
 */
public class ManageTour extends javax.swing.JFrame {

    /**
     * Creates new form ManageStudent
     */
    public ManageTour() {
        initComponents();
        setLocationRelativeTo(null);
        initializeTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tourTable = new javax.swing.JTable();
        btn_add = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        codeInput = new javax.swing.JTextField();
        nameInput = new javax.swing.JTextField();
        descriptionInput = new javax.swing.JTextField();
        startDateInput = new javax.swing.JTextField();
        companyInput = new javax.swing.JComboBox<>();
        presentator = new javax.swing.JTextField();
        teacherInput = new javax.swing.JComboBox<>();
        availables = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_back.setText("Trở lại trang chủ");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Quản lí thông tin chuyến tham quan doanh nghiệp");

        tourTable.setModel(new javax.swing.table.DefaultTableModel(
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
        tourTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tourTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tourTable);

        btn_add.setText("Thêm");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_edit.setText("Sửa");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_delete.setText("Xóa");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_clear.setText("Nhập lại");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        jLabel9.setText("Mã chuyến tham quan:");

        jLabel10.setText("Tên chuyến: tham quan:");

        jLabel11.setText("Mô tả hoạt động chuyến đi:");

        jLabel12.setText("Ngày diễn ra: ");

        jLabel13.setText("Doanh nghiệp chủ quản:");

        jLabel14.setText("Người đại đại doanh nghiệp:");

        jLabel15.setText("Giảng viên đại diện trường:");

        jLabel16.setText("Số lượng sinh viên có thể đi:");

        companyInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        teacherInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_back)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(codeInput)
                                    .addComponent(nameInput)
                                    .addComponent(descriptionInput)
                                    .addComponent(startDateInput)
                                    .addComponent(companyInput, 0, 214, Short.MAX_VALUE)
                                    .addComponent(presentator)
                                    .addComponent(teacherInput, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(availables))))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btn_back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(codeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(descriptionInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(startDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(companyInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(presentator, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(teacherInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(availables, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_clear))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        clearAllFields();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        dispose();
        Home homeScreen = new Home();
        homeScreen.setLocationRelativeTo(null);
        homeScreen.setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        try {
//            isCheckInput();

//            String code = txt_code.getText().trim();
//            String firstName = txt_first_name.getText().trim();
//            String lastName = txt_last_name.getText().trim();
//            String address = txt_address.getText().trim();
//            String phoneNumber = txt_phone_number.getText().trim();
//            String email = txt_email.getText().trim();
//            String birthDate = txt_birth_date.getText().trim();
//            String classId = txt_class_id.getText().trim();
//            int ClassId = Integer.parseInt(classId);
//            if (isEmpty(code) || isEmpty(firstName) || isEmpty(lastName) || isEmpty(address) || isEmpty(phoneNumber) || isEmpty(email) || isEmpty(birthDate) || isEmpty(classId)) {
//                MessageDialog.showErrorDialog(this, "Nhập đủ dữ liệu", "Thông báo");
//                return;
//            }
//
//            if (!isNumeric(phoneNumber) || !isNumeric(classId)) {
//                MessageDialog.showErrorDialog(this, "dữ liệu nhập vào phải là số", "Thông báo");
//                return;
//            }
//            if (!isValidEmail(email)) {
//                MessageDialog.showErrorDialog(this, "Email không đúng định dạng", "Thông báo");
//                return;
//            }
//            if (isExistedStudentCode(code)) {
//                MessageDialog.showErrorDialog(this, "Sinh viên đã tồn tại ", "Thông báo");
//                return;
//            } else {
//                StudentService.createNewStudent(code, firstName, lastName, address, phoneNumber, email, birthDate, ClassId);
//                loadTableData();
//                MessageDialog.showInfoDialog(this, "Thêm thành công", "Thông báo");
//                clearAllFields();
//            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Có lỗi xảy ra khi thêm mới, chi tiết: " + ex.getMessage() + "\n" + ex.toString() + "\n", "Có lỗi xảy ra");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        try {
//            int index = tourTable.getSelectedRow();
//            if (index == -1) {
//                MessageDialog.showInfoDialog(this, "Vui chọn chọn doanh nghiệp muốn sửa", "Thông báo");
//                return;
//            }
//            Student selectedStudent = StudentService.getStudentByIndex(index);
//            String code = this.txt_code.getText().trim();
//            String firstName = this.txt_first_name.getText().trim();
//            String lastName = this.txt_last_name.getText().trim();
//            String address = this.txt_address.getText().trim();
//            String phoneNumber = this.txt_phone_number.getText().trim();
//            String email = this.txt_email.getText().trim();
//            String birthDate = this.txt_birth_date.getText().trim();
//            String classId = this.txt_class_id.getText().trim();
//
//            if (isEmpty(code) || isEmpty(firstName) || isEmpty(lastName) || isEmpty(address) || isEmpty(phoneNumber) || isEmpty(email) || isEmpty(birthDate) || isEmpty(classId)) {
//                MessageDialog.showErrorDialog(this, "Nhập đủ dữ liệu", "Thông báo");
//                return;
//            }
//
//            if (!isNumeric(phoneNumber) || !isNumeric(classId)) {
//                MessageDialog.showErrorDialog(this, "dữ liệu nhập vào phải là số", "Thông báo");
//                return;
//            }
//            if (!isValidEmail(email)) {
//                MessageDialog.showErrorDialog(this, "Email không đúng định dạng", "Thông báo");
//                return;
//            }
//            if (isExistedStudentCode(code)) {
//                MessageDialog.showErrorDialog(this, "Sinh viên đã tồn tại ", "Thông báo");
//                return;
//            }
//
//            selectedStudent.setCode(code);
//            selectedStudent.setFirstName(firstName);
//            selectedStudent.setLastName(lastName);
//            selectedStudent.setAddress(address);
//            selectedStudent.setPhoneNumber(phoneNumber);
//            selectedStudent.setEmail(email);
//            selectedStudent.setBirthDate(birthDate);
//            selectedStudent.setClassId(Integer.parseInt(classId));
//            StudentService.updateStudent(selectedStudent);
//
//            MessageDialog.showInfoDialog(this, "Cập nhật thông tin thành công!", "Thông báo");
//            clearAllFields();
//            loadTableData();
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Xảy ra lỗi khi sửa thông tin doanh nghiệp, chi tiết: " + ex.getMessage() + "\n" + ex.toString() + "\n", "Phát hiện lỗi");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void tourTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tourTableMouseClicked
        try {
//            int index = tourTable.getSelectedRow();
//            if (index == -1) {
//                MessageDialog.showInfoDialog(this, "Vui chọn chọn doanh nghiệp", "Thông báo");
//                return;
//            }
//            Student selectedStudent = StudentService.getStudentByIndex(index);
//            txt_code.setText(selectedStudent.getCode());
//            txt_first_name.setText(selectedStudent.getFirstName());
//            txt_last_name.setText(selectedStudent.getLastName());
//            txt_address.setText(selectedStudent.getAddress());
//            txt_phone_number.setText(selectedStudent.getPhoneNumber());
//            txt_email.setText(selectedStudent.getEmail());
//            txt_birth_date.setText(selectedStudent.getBirthDate());
//            txt_class_id.setText(Integer.toString(selectedStudent.getClassId()));
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Có lỗi, chi tiết: " + ex.getMessage() + "\n" + ex.toString() + "\n", "Phát hiện lỗi");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_tourTableMouseClicked

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        try {
            int index = tourTable.getSelectedRow();
            if (index == -1) {
                MessageDialog.showInfoDialog(this, "Chọn sinh viên muốn xóa", "Thông báo");
                return;
            }
            Student selectedStudent = StudentService.getStudentByIndex(index);
            int keyPress = MessageDialog.showConfirmDialog(this, "Bạn có chắc muốn xóa sinh viên có mã " + selectedStudent.getCode(), "Xác nhận");
            if (keyPress == 0) {
                StudentService.deleteStudent(selectedStudent.getId());
                loadTableData();
                clearAllFields();
            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Xảy ra lỗi khi xóa, chi tiết: " + ex.getMessage() + "\n" + ex.toString() + "\n", "Phát hiện lỗi");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

//    private void isCheckInput() {
//        String code = txt_code.getText().trim();
//        String first_name = txt_first_name.getText().trim();
//        String last_name = txt_last_name.getText().trim();
//        String address = txt_address.getText().trim();
//        String phone_number = txt_address.getText().trim();
//        String email = txt_email.getText().trim();
//        String birth_date = txt_birth_date.getText().trim();
//        String classId = txt_class_id.getText().trim();
//
//        if (isEmpty(code) || isEmpty(first_name) || isEmpty(last_name) || isEmpty(address) || isEmpty(phone_number) || isEmpty(email) || isEmpty(birth_date) || isEmpty(classId)) {
//            MessageDialog.showErrorDialog(this, "Nhập đủ dữ liệu", "Thông báo");
//            return;
//        }
//
//        if (!isNumeric(phone_number) || !isNumeric(classId)) {
//            MessageDialog.showErrorDialog(this, "dữ liệu nhập vào phải là số", "Thông báo");
//            return;
//        }
//        if (!isValidEmail(email)) {
//            MessageDialog.showErrorDialog(this, "Email không đúng định dạng", "Thông báo");
//            return;
//        }
//    }
    private boolean isEmpty(String str) {
        return str.isEmpty();
    }

    private void clearAllFields() {
//        txt_code.setText("");
//        txt_first_name.setText("");
//        txt_last_name.setText("");
//        txt_address.setText("");
//        txt_email.setText("");
//        txt_phone_number.setText("");
//        txt_birth_date.setText("");
//        txt_class_id.setText("");
//        txt_code.requestFocus();
    }

    private DefaultTableModel tableModel;

    private void loadTableData() {
        try {
            List<Student> data = StudentService.getAllStudents();
            tableModel.setRowCount(0);
            if (data != null) {
                for (Student stu : data) {
                    tableModel.addRow(new Object[]{stu.getCode(), stu.getFirstName(), stu.getLastName(), stu.getAddress(), stu.getPhoneNumber(), stu.getEmail(), stu.getBirthDate(), stu.getClassId()
                    });
                }
            }
            tableModel.fireTableDataChanged();
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Tải dữ liệu cho bảng có lỗi! Chi tiết: " + ex.getMessage(), "Có lỗi xảy ra");
            ex.printStackTrace();
        }
    }

    private void initializeTable() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã sinh viên", "Họ", "Tên", "Địa chỉ", "SĐT", "Email", "Ngày sinh", "Class id"});
        tourTable.setModel(tableModel);

        loadTableData();
    }

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
            java.util.logging.Logger.getLogger(ManageTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageTour().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField availables;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JTextField codeInput;
    private javax.swing.JComboBox<String> companyInput;
    private javax.swing.JTextField descriptionInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameInput;
    private javax.swing.JTextField presentator;
    private javax.swing.JTextField startDateInput;
    private javax.swing.JTable tourTable;
    private javax.swing.JComboBox<String> teacherInput;
    // End of variables declaration//GEN-END:variables
}
