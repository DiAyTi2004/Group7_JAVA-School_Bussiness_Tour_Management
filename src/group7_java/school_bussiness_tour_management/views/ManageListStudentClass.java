/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package group7_java.school_bussiness_tour_management.views;

import group7_java.school_bussiness_tour_management.common.MessageDialog;
import static group7_java.school_bussiness_tour_management.common.Validator.isNumeric;
import static group7_java.school_bussiness_tour_management.common.Validator.isValidEmail;
import group7_java.school_bussiness_tour_management.models.Classroom;
import group7_java.school_bussiness_tour_management.models.Student;
import group7_java.school_bussiness_tour_management.services.StudentService;
import static group7_java.school_bussiness_tour_management.services.StudentService.isExistedStudentCode;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gialo
 */
public class ManageListStudentClass extends javax.swing.JFrame {

    /**
     * Creates new form ManageStudent
     */
    public Classroom classroomm = new Classroom();

    public ManageListStudentClass() {
        initComponents();
        setLocationRelativeTo(null);
        initializeTable();
    }

    public ManageListStudentClass(Classroom classroom) {
        initComponents();
        setLocationRelativeTo(null);
        classroomm.setName(classroom.getName());
        classroomm.setId(classroom.getId());
        initializeTable();
        jLabel1.setText("Danh sách sinh viên " + classroomm.getName());

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
        studentTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_first_name = new javax.swing.JTextField();
        txt_code = new javax.swing.JTextField();
        txt_last_name = new javax.swing.JTextField();
        txt_address = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_birth_date = new javax.swing.JTextField();
        txt_class_id = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        SĐT = new javax.swing.JLabel();
        txt_phone_number = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_back.setText("Trở lại trang chủ");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Danh sách sinh viên");

        studentTable.setModel(new javax.swing.table.DefaultTableModel(
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
        studentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(studentTable);

        jLabel2.setText("Mã sinh viên");

        jLabel3.setText("Họ");

        jLabel4.setText("Tên");

        jLabel5.setText("Địa chỉ");

        jLabel6.setText("Email");

        jLabel7.setText("Ngày sinh");

        jLabel8.setText("Class ID");

        txt_class_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_class_idActionPerformed(evt);
            }
        });

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

        SĐT.setText("SĐT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(697, 697, 697)
                        .addComponent(btn_edit)
                        .addGap(18, 18, 18)
                        .addComponent(btn_delete)
                        .addGap(18, 18, 18)
                        .addComponent(btn_clear)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_back)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(29, 29, 29))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btn_add)
                                            .addComponent(SĐT, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_email, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                    .addComponent(txt_birth_date, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                    .addComponent(txt_class_id, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                    .addComponent(txt_phone_number, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                    .addComponent(txt_last_name, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                    .addComponent(txt_address, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                    .addComponent(txt_first_name, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                    .addComponent(txt_code, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))))))
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(222, 222, 222))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txt_first_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(8, 8, 8)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_last_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(txt_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SĐT, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_phone_number, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_birth_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_class_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_add)
                            .addComponent(btn_edit)
                            .addComponent(btn_delete)
                            .addComponent(btn_clear)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_class_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_class_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_class_idActionPerformed

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

            String code = txt_code.getText().trim();
            String firstName = txt_first_name.getText().trim();
            String lastName = txt_last_name.getText().trim();
            String address = txt_address.getText().trim();
            String phoneNumber = txt_phone_number.getText().trim();
            String email = txt_email.getText().trim();
            String birthDate = txt_birth_date.getText().trim();
            String classId = txt_class_id.getText().trim();
            int ClassId = Integer.parseInt(classId);
            if (isEmpty(code) || isEmpty(firstName) || isEmpty(lastName) || isEmpty(address) || isEmpty(phoneNumber) || isEmpty(email) || isEmpty(birthDate) || isEmpty(classId)) {
                MessageDialog.showErrorDialog(this, "Nhập đủ dữ liệu", "Thông báo");
                return;
            }

            if (!isNumeric(phoneNumber) || !isNumeric(classId)) {
                MessageDialog.showErrorDialog(this, "dữ liệu nhập vào phải là số", "Thông báo");
                return;
            }
            if (!isValidEmail(email)) {
                MessageDialog.showErrorDialog(this, "Email không đúng định dạng", "Thông báo");
                return;
            }
            if (isExistedStudentCode(code)) {
                MessageDialog.showErrorDialog(this, "Sinh viên đã tồn tại ", "Thông báo");
                return;
            } else {
                StudentService.createNewStudent(code, firstName, lastName, address, phoneNumber, email, birthDate, ClassId);
                loadTableData();
                MessageDialog.showInfoDialog(this, "Thêm thành công", "Thông báo");
                clearAllFields();
            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Có lỗi xảy ra khi thêm mới, chi tiết: " + ex.getMessage() + "\n" + ex.toString() + "\n", "Có lỗi xảy ra");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        try {
            int index = studentTable.getSelectedRow();
            if (index == -1) {
                MessageDialog.showInfoDialog(this, "Vui chọn chọn doanh nghiệp muốn sửa", "Thông báo");
                return;
            }
            Student selectedStudent = StudentService.getStudentByIndex(index);
            String code = this.txt_code.getText().trim();
            String firstName = this.txt_first_name.getText().trim();
            String lastName = this.txt_last_name.getText().trim();
            String address = this.txt_address.getText().trim();
            String phoneNumber = this.txt_phone_number.getText().trim();
            String email = this.txt_email.getText().trim();
            String birthDate = this.txt_birth_date.getText().trim();
            String classId = this.txt_class_id.getText().trim();

            if (isEmpty(code) || isEmpty(firstName) || isEmpty(lastName) || isEmpty(address) || isEmpty(phoneNumber) || isEmpty(email) || isEmpty(birthDate) || isEmpty(classId)) {
                MessageDialog.showErrorDialog(this, "Nhập đủ dữ liệu", "Thông báo");
                return;
            }

            if (!isNumeric(phoneNumber) || !isNumeric(classId)) {
                MessageDialog.showErrorDialog(this, "dữ liệu nhập vào phải là số", "Thông báo");
                return;
            }
            if (!isValidEmail(email)) {
                MessageDialog.showErrorDialog(this, "Email không đúng định dạng", "Thông báo");
                return;
            }
            if (isExistedStudentCode(code)) {
                MessageDialog.showErrorDialog(this, "Sinh viên đã tồn tại ", "Thông báo");
                return;
            }

            selectedStudent.setCode(code);
            selectedStudent.setFirstName(firstName);
            selectedStudent.setLastName(lastName);
            selectedStudent.setAddress(address);
            selectedStudent.setPhoneNumber(phoneNumber);
            selectedStudent.setEmail(email);
            selectedStudent.setBirthDate(birthDate);
            selectedStudent.setClassId(Integer.parseInt(classId));
            StudentService.updateStudent(selectedStudent);

            MessageDialog.showInfoDialog(this, "Cập nhật thông tin thành công!", "Thông báo");
            clearAllFields();
            loadTableData();
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Xảy ra lỗi khi sửa thông tin doanh nghiệp, chi tiết: " + ex.getMessage() + "\n" + ex.toString() + "\n", "Phát hiện lỗi");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void studentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentTableMouseClicked
        try {
            int index = studentTable.getSelectedRow();
            if (index == -1) {
                MessageDialog.showInfoDialog(this, "Vui chọn chọn doanh nghiệp", "Thông báo");
                return;
            }
            Student selectedStudent = StudentService.getStudentByIndex(index);
            txt_code.setText(selectedStudent.getCode());
            txt_first_name.setText(selectedStudent.getFirstName());
            txt_last_name.setText(selectedStudent.getLastName());
            txt_address.setText(selectedStudent.getAddress());
            txt_phone_number.setText(selectedStudent.getPhoneNumber());
            txt_email.setText(selectedStudent.getEmail());
            txt_birth_date.setText(selectedStudent.getBirthDate());
            txt_class_id.setText(Integer.toString(selectedStudent.getClassId()));
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Có lỗi, chi tiết: " + ex.getMessage() + "\n" + ex.toString() + "\n", "Phát hiện lỗi");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_studentTableMouseClicked

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        try {
            int index = studentTable.getSelectedRow();
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
        txt_code.setText("");
        txt_first_name.setText("");
        txt_last_name.setText("");
        txt_address.setText("");
        txt_email.setText("");
        txt_phone_number.setText("");
        txt_birth_date.setText("");
        txt_class_id.setText("");
        txt_code.requestFocus();
    }

    private DefaultTableModel tableModel;

    private void loadTableData() {
        try {
            // neu sua lai classId la string thi tham chieu lay ra la getCode()

            List<Student> data = StudentService.getStudentByClassId(classroomm.getId());
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
        studentTable.setModel(tableModel);
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
            java.util.logging.Logger.getLogger(ManageListStudentClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageListStudentClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageListStudentClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageListStudentClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageListStudentClass().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SĐT;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable studentTable;
    private javax.swing.JTextField txt_address;
    private javax.swing.JTextField txt_birth_date;
    private javax.swing.JTextField txt_class_id;
    private javax.swing.JTextField txt_code;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_first_name;
    private javax.swing.JTextField txt_last_name;
    private javax.swing.JTextField txt_phone_number;
    // End of variables declaration//GEN-END:variables
}
