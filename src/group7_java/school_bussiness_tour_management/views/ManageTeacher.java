package group7_java.school_bussiness_tour_management.views;

import group7_java.school_bussiness_tour_management.common.MessageDialog;
import static group7_java.school_bussiness_tour_management.common.Validator.isDate;
import static group7_java.school_bussiness_tour_management.common.Validator.isNumeric;
import static group7_java.school_bussiness_tour_management.common.Validator.isValidEmail;
import group7_java.school_bussiness_tour_management.models.Teacher;
import group7_java.school_bussiness_tour_management.services.TeacherService;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NGUYEN TRANG
 */
public class ManageTeacher extends javax.swing.JFrame {

    public ManageTeacher() {
        initComponents();
        initializeTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBackHome = new javax.swing.JButton();
        mainTitle = new javax.swing.JLabel();
        teacherIDLabel = new javax.swing.JLabel();
        teacherIDField = new javax.swing.JTextField();
        nameTeacherLabel = new javax.swing.JLabel();
        nameTeacherField = new javax.swing.JTextField();
        addressTeacherLabel = new javax.swing.JLabel();
        addressTeacherField = new javax.swing.JTextField();
        phoneNumberTeacherLabel = new javax.swing.JLabel();
        phoneNumberTeacherField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        teacherTable = new javax.swing.JTable();
        createTeacherBtn = new javax.swing.JButton();
        updateTeacherBtn = new javax.swing.JButton();
        deleteTeacherBtn = new javax.swing.JButton();
        clearTeacherBtn = new javax.swing.JButton();
        birthdayTeacherLabel = new javax.swing.JLabel();
        birthdayTeacherField = new javax.swing.JTextField();
        emailTeacherLabel = new javax.swing.JLabel();
        emailTeacherField = new javax.swing.JTextField();
        detailTour = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý giáo viên");

        btnBackHome.setText("Quay về trang chủ");
        btnBackHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackHomeActionPerformed(evt);
            }
        });

        mainTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mainTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainTitle.setText("Quản lý giáo viên");

        teacherIDLabel.setText("Mã giáo viên: ");

        nameTeacherLabel.setText("Họ tên:");

        addressTeacherLabel.setText("Địa chỉ: ");

        phoneNumberTeacherLabel.setText("Số điện thoại: ");

        teacherTable.setModel(new javax.swing.table.DefaultTableModel(
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
        teacherTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teacherTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(teacherTable);

        createTeacherBtn.setText("Thêm");
        createTeacherBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createTeacherBtnActionPerformed(evt);
            }
        });

        updateTeacherBtn.setText("Sửa");
        updateTeacherBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateTeacherBtnActionPerformed(evt);
            }
        });

        deleteTeacherBtn.setText("Xóa");
        deleteTeacherBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTeacherBtnActionPerformed(evt);
            }
        });

        clearTeacherBtn.setText("Nhập lại");
        clearTeacherBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearTeacherBtnActionPerformed(evt);
            }
        });

        birthdayTeacherLabel.setText("Ngày sinh:");

        birthdayTeacherField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                birthdayTeacherFieldActionPerformed(evt);
            }
        });

        emailTeacherLabel.setText("Email:");

        detailTour.setText("Xem danh sách chuyến tham quan của giáo viên");
        detailTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailTourActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBackHome)
                        .addGap(272, 272, 272)
                        .addComponent(mainTitle)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addressTeacherLabel)
                            .addComponent(teacherIDLabel)
                            .addComponent(birthdayTeacherLabel))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(birthdayTeacherField, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(addressTeacherField, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                                .addComponent(teacherIDField, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phoneNumberTeacherLabel)
                            .addComponent(emailTeacherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameTeacherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(phoneNumberTeacherField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                            .addComponent(nameTeacherField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(emailTeacherField))))
                .addGap(68, 68, 68))
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(createTeacherBtn)
                .addGap(66, 66, 66)
                .addComponent(updateTeacherBtn)
                .addGap(69, 69, 69)
                .addComponent(deleteTeacherBtn)
                .addGap(52, 52, 52)
                .addComponent(clearTeacherBtn)
                .addGap(52, 52, 52)
                .addComponent(detailTour)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBackHome))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(mainTitle)))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(nameTeacherLabel)
                    .addComponent(teacherIDLabel)
                    .addComponent(teacherIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTeacherField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressTeacherLabel)
                    .addComponent(addressTeacherField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneNumberTeacherLabel)
                    .addComponent(phoneNumberTeacherField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(birthdayTeacherField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(birthdayTeacherLabel)
                    .addComponent(emailTeacherField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailTeacherLabel))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(clearTeacherBtn)
                    .addComponent(deleteTeacherBtn)
                    .addComponent(updateTeacherBtn)
                    .addComponent(createTeacherBtn)
                    .addComponent(detailTour))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackHomeActionPerformed
        dispose();
        Home homeScreen = new Home();
        homeScreen.setLocationRelativeTo(null);
        homeScreen.setVisible(true);
    }//GEN-LAST:event_btnBackHomeActionPerformed
    private DefaultTableModel tableModel;

    private void loadTableData() {
        try {
            List<Teacher> data = TeacherService.getAllTeachers();
            tableModel.setRowCount(0);
            if (data != null) {
                for (Teacher tea : data) {
                    tableModel.addRow(new Object[]{tea.getCode(), tea.getLastName() + " " + tea.getFirstName(), tea.getAddress(), tea.getPhoneNumber(), tea.getEmail(), tea.getBirthDate()
                    });
                }
            }
            tableModel.fireTableDataChanged();
        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, "Tải dữ liệu cho bảng có lỗi! Chi tiết: " + e.getMessage(), "Có lỗi xảy ra");
            e.printStackTrace();
        }
    }

    private void initializeTable() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã giáo viên", "Họ tên",
            "Địa chỉ", "Điện thoại", "Email", "Ngày sinh"});
        teacherTable.setModel(tableModel);
        loadTableData();
    }
    private void clearTeacherBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearTeacherBtnActionPerformed
        clearField();
    }//GEN-LAST:event_clearTeacherBtnActionPerformed

    private void updateTeacherBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateTeacherBtnActionPerformed
        try {
            int index = teacherTable.getSelectedRow();
            if (index == -1) {
                MessageDialog.showInfoDialog(this, "Vui chọn chọn giáo viên muốn sửa", "Thông báo");
                return;
            }
            Teacher selectedTea = TeacherService.getTeacherByIndex(index);
            String teacherID = this.teacherIDField.getText().trim();
            String teacherName = this.nameTeacherField.getText().trim();
            String teacherAddress = this.addressTeacherField.getText().trim();
            String teacherPhoneNumber = this.phoneNumberTeacherField.getText().trim();
            String teacherBirthday = this.birthdayTeacherField.getText().trim();
            String teacherEmail = this.emailTeacherField.getText().trim();

            // Bắt lỗi, không nhập đủ
            if (teacherID.equals("")) {
                MessageDialog.showErrorDialog(this, "Bạn chưa nhập mã giáo viên", "Lỗi");
                return;
            }

            if (teacherName.equals("")) {
                MessageDialog.showErrorDialog(this, "Bạn chưa nhập họ tên giáo viên", "Lỗi");
                return;
            }

            if (teacherAddress.equals("")) {
                MessageDialog.showErrorDialog(this, "Bạn chưa nhập địa chỉ", "Lỗi");
                return;
            }
            if (teacherPhoneNumber.equals("")) {
                MessageDialog.showErrorDialog(this, "Bạn chưa nhập số điện thoại", "Lỗi");
                return;
            }
            if (!isNumeric(teacherPhoneNumber)) {
                MessageDialog.showErrorDialog(this, "Dữ liệu nhập vào phải là số", "Lỗi");
                return;
            }
            if (teacherBirthday.equals("")) {
                MessageDialog.showErrorDialog(this, "Bạn chưa nhập ngày sinh", "Lỗi");
                return;
            }

            if (!isDate(teacherBirthday)) {
                MessageDialog.showErrorDialog(this, "Ngày sinh nhập chưa đúng định dạng", "Lỗi");
                return;
            }
            if (teacherEmail.equals("")) {
                MessageDialog.showErrorDialog(this, "Bạn chưa nhập email", "Lỗi");
                return;
            }
            if (!isValidEmail(teacherEmail)) {
                MessageDialog.showErrorDialog(this, "Email không đúng định dạng", "Lỗi");
                return;
            }

            selectedTea.setCode(teacherID);
            selectedTea.setFirstName(TeacherService.FirstName(teacherName));
            selectedTea.setLastName(TeacherService.LastName(teacherName));
            selectedTea.setPhoneNumber(teacherPhoneNumber);
            selectedTea.setBirthDate(teacherBirthday);
            selectedTea.setEmail(teacherEmail);
            selectedTea.setAddress(teacherAddress);

            TeacherService.updateTeacher(selectedTea);
            MessageDialog.showInfoDialog(this, "Cập nhật thông tin thành công!", "Thông báo");
            clearField();
            loadTableData();
        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, "Xảy ra lỗi khi sửa thông tin giáo viên, chi tiết: " + e.getMessage() + "\n" + e.toString() + "\n", "Lỗi");
            e.printStackTrace();
        }

    }//GEN-LAST:event_updateTeacherBtnActionPerformed

    private void createTeacherBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createTeacherBtnActionPerformed
        try {
            String teacherID = this.teacherIDField.getText().trim();
            String teacherName = this.nameTeacherField.getText().trim();
            String teacherAddress = this.addressTeacherField.getText().trim();
            String teacherPhoneNumber = this.phoneNumberTeacherField.getText().trim();
            String teacherBirthday = this.birthdayTeacherField.getText().trim();
            String teacherEmail = this.emailTeacherField.getText().trim();

            // Bắt lỗi, không nhập đủ
            if (teacherID.equals("")) {
                MessageDialog.showErrorDialog(this, "Bạn chưa nhập mã giáo viên", "Lỗi");
                return;
            }

            if (teacherName.equals("")) {
                MessageDialog.showErrorDialog(this, "Bạn chưa nhập họ tên giáo viên", "Lỗi");
                return;
            }
            if (teacherAddress.equals("")) {
                MessageDialog.showErrorDialog(this, "Bạn chưa nhập địa chỉ", "Lỗi");
                return;
            }
            if (teacherPhoneNumber.equals("")) {
                MessageDialog.showErrorDialog(this, "Bạn chưa nhập số điện thoại", "Lỗi");
                return;
            }
            if (!isNumeric(teacherPhoneNumber)) {
                MessageDialog.showErrorDialog(this, "Dữ liệu nhập vào phải là số", "Lỗi");
                return;
            }
            if (teacherBirthday.equals("")) {
                MessageDialog.showErrorDialog(this, "Bạn chưa nhập ngày sinh", "Lỗi");
                return;
            }

            if (!isDate(teacherBirthday)) {
                MessageDialog.showErrorDialog(this, "Ngày sinh nhập chưa đúng định dạng", "Lỗi");
                return;
            }
            if (teacherEmail.equals("")) {
                MessageDialog.showErrorDialog(this, "Bạn chưa nhập email", "Lỗi");
                return;
            }
            if (!isValidEmail(teacherEmail)) {
                MessageDialog.showErrorDialog(this, "Email không đúng định dạng", "Lỗi");
                return;
            }
            // Thêm giáo viên
            if (!TeacherService.isCheckCodeTeacher(teacherID)) {
                TeacherService.createNewTeacher(teacherID, teacherName, teacherAddress, teacherPhoneNumber, teacherEmail, teacherBirthday);
                loadTableData();
                MessageDialog.showInfoDialog(this, "Đã thêm thành công", "Thông  báo");
                clearField();
            } else {
                MessageDialog.showErrorDialog(this, "Mã giáo viên " + teacherID + " đã tồn tại", "Thông báo");
                return;
            }

        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, "Xảy ra lỗi khi thêm giáo viên, chi tiết: " + e.getMessage() + "\n" + e.toString() + "\n", "Lỗi");
            e.printStackTrace();
        }

    }//GEN-LAST:event_createTeacherBtnActionPerformed

    private void deleteTeacherBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTeacherBtnActionPerformed
        try {
            int index = teacherTable.getSelectedRow();
            if (index == -1) {
                MessageDialog.showInfoDialog(this, "Vui chọn chọn giáo viên muốn xóa", "Thông báo");
                return;
            }
             Teacher selectedTea = TeacherService.getTeacherByIndex(index);
            int keyPress = MessageDialog.showConfirmDialog(this, "Bạn có chắc muốn xóa giáo viên " + selectedTea.getLastName() + " " + selectedTea.getFirstName(), "Xác nhận");
            if (keyPress == 0) {
                TeacherService.deleteTeacher(selectedTea.getId());
                loadTableData();
                clearField();
            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Xảy ra lỗi khi xóa, chi tiết: " + ex.getMessage() + "\n" + ex.toString() + "\n", "Phát hiện lỗi");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_deleteTeacherBtnActionPerformed

    private void teacherTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherTableMouseClicked
        try {
            int index = teacherTable.getSelectedRow();
            if (index == -1) {
                MessageDialog.showInfoDialog(this, "Vui chọn chọn giáo viên", "Thông báo");
                return;
            }
            Teacher selectedTea = TeacherService.getTeacherByIndex(index);
            teacherIDField.setText(selectedTea.getCode());
            nameTeacherField.setText(selectedTea.getLastName() + " " + selectedTea.getFirstName());
            phoneNumberTeacherField.setText(selectedTea.getPhoneNumber());
            birthdayTeacherField.setText(selectedTea.getBirthDate());
            emailTeacherField.setText(selectedTea.getEmail());
            addressTeacherField.setText(selectedTea.getAddress());
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Có lỗi, chi tiết: " + ex.getMessage() + "\n" + ex.toString() + "\n", "Phát hiện lỗi");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_teacherTableMouseClicked

    private void detailTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailTourActionPerformed
        try {
            int index = teacherTable.getSelectedRow();
            if (index == -1) {
                MessageDialog.showInfoDialog(this, "Vui chọn chọn giáo viên để xem các chuyến tham quan của giáo viên", "Thông báo");
                return;
            }
            Teacher selectedTea = TeacherService.getTeacherByIndex(index);
            ManageToursOfTeacher  manageToursOfTeacherScreen = new ManageToursOfTeacher();
            if (manageToursOfTeacherScreen != null) {
                manageToursOfTeacherScreen.setLocationRelativeTo(null);
                manageToursOfTeacherScreen.setVisible(true);
                manageToursOfTeacherScreen.getTeacherIdLabel().setText("Mã doanh nghiệp: " + selectedTea.getCode());
                manageToursOfTeacherScreen.getTeacherNameLabel().setText("Tên giáo viên: " + selectedTea.getLastName() + " " + selectedTea.getFirstName());
                manageToursOfTeacherScreen.getTeacherPhoneNumberLabel().setText("Số điện thoại: " + selectedTea.getPhoneNumber());
                manageToursOfTeacherScreen.getTeacherEmailLable().setText("Email: " + selectedTea.getEmail());
                manageToursOfTeacherScreen.getTeacherAdressLable().setText("Địa chỉ: " + selectedTea.getAddress());
                manageToursOfTeacherScreen.setTeacherID(selectedTea.getId());
                manageToursOfTeacherScreen.initializeTable();
                dispose();
            }
        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, "Có lỗi, chi tiết: " + e, "Lỗi");
        }
    }//GEN-LAST:event_detailTourActionPerformed

    private void birthdayTeacherFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_birthdayTeacherFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_birthdayTeacherFieldActionPerformed

    public void clearField() {
        teacherIDField.setText("");
        nameTeacherField.setText("");
        phoneNumberTeacherField.setText("");
        addressTeacherField.setText("");
        emailTeacherField.setText("");
        birthdayTeacherField.setText("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new ManageTeacher().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressTeacherField;
    private javax.swing.JLabel addressTeacherLabel;
    private javax.swing.JTextField birthdayTeacherField;
    private javax.swing.JLabel birthdayTeacherLabel;
    private javax.swing.JButton btnBackHome;
    private javax.swing.JButton clearTeacherBtn;
    private javax.swing.JButton createTeacherBtn;
    private javax.swing.JButton deleteTeacherBtn;
    private javax.swing.JButton detailTour;
    private javax.swing.JTextField emailTeacherField;
    private javax.swing.JLabel emailTeacherLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mainTitle;
    private javax.swing.JTextField nameTeacherField;
    private javax.swing.JLabel nameTeacherLabel;
    private javax.swing.JTextField phoneNumberTeacherField;
    private javax.swing.JLabel phoneNumberTeacherLabel;
    private javax.swing.JTextField teacherIDField;
    private javax.swing.JLabel teacherIDLabel;
    private javax.swing.JTable teacherTable;
    private javax.swing.JButton updateTeacherBtn;
    // End of variables declaration//GEN-END:variables

}
