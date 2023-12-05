/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package group7_java.school_bussiness_tour_management.views;

import group7_java.school_bussiness_tour_management.common.MessageDialog;
import group7_java.school_bussiness_tour_management.models.Company;
import group7_java.school_bussiness_tour_management.services.CompanyService;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LAM
 */
public class ManageCompany extends javax.swing.JFrame {

    /**
     * Creates new form ManageBusssiness
     */
    public ManageCompany() {
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

        turnBackHome = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        companyTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        companyNameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        companyEmailField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        companyPhoneField = new javax.swing.JTextField();
        companyAddressField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        companyDesField = new javax.swing.JTextField();
        createCompanyButton = new javax.swing.JButton();
        updateCompanyButton = new javax.swing.JButton();
        delCompanyButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        companyCodeField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        turnBackHome.setText("Quay lại trang chủ");
        turnBackHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                turnBackHomeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý thông tin doanh nghiệp");

        companyTable.setModel(new javax.swing.table.DefaultTableModel(
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
        companyTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                companyTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(companyTable);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tên doanh nghiệp: ");

        jLabel2.setText("Email: ");

        jLabel4.setText("Điện thoại: ");

        jLabel5.setText("Địa chỉ: ");

        jLabel7.setText("Mô tả: ");

        companyDesField.setToolTipText("");

        createCompanyButton.setText("Thêm");
        createCompanyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createCompanyActionPerformed(evt);
            }
        });

        updateCompanyButton.setText("Sửa");
        updateCompanyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCompanyButtonActionPerformed(evt);
            }
        });

        delCompanyButton.setText("Xóa");
        delCompanyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delCompanyButtonActionPerformed(evt);
            }
        });

        resetButton.setText("Nhập lại");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Mã doanh nghiệp: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(turnBackHome)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(companyCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel3)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(companyPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(companyAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(companyDesField, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(companyEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(companyNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(createCompanyButton)
                        .addGap(71, 71, 71)
                        .addComponent(updateCompanyButton)
                        .addGap(87, 87, 87)
                        .addComponent(delCompanyButton)
                        .addGap(72, 72, 72)
                        .addComponent(resetButton)))
                .addGap(45, 45, 45))
            .addGroup(layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(turnBackHome)
                .addGap(5, 5, 5)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(companyCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(companyNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(companyPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(companyEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(companyAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(companyDesField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createCompanyButton)
                    .addComponent(updateCompanyButton)
                    .addComponent(delCompanyButton)
                    .addComponent(resetButton))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void turnBackHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_turnBackHomeActionPerformed
        dispose();
        Home homeScreen = new Home();
        homeScreen.setLocationRelativeTo(null);
        homeScreen.setVisible(true);
    }//GEN-LAST:event_turnBackHomeActionPerformed

    private void clearAllFields() {
        companyCodeField.setText("");
        companyNameField.setText("");
        companyPhoneField.setText("");
        companyEmailField.setText("");
        companyAddressField.setText("");
        companyDesField.setText("");
    }
    
    private DefaultTableModel tableModel;
    
    private void loadTableData() {
        try {
            List<Company> data = CompanyService.getAllCompanies();
            tableModel.setRowCount(0);
            if (data != null) {
                for (Company com : data) {
                    tableModel.addRow(new Object[]{com.getCode(),com.getName(),
                                                   com.getEmail(),com.getPhoneNumber(),
                                                   com.getDescription()});
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
        tableModel.setColumnIdentifiers(new String[]{"Mã doanh nghiệp", "Doanh nghiệp",
                                                     "Email","Điện thoại","Mô tả"});
        companyTable.setModel(tableModel);

        loadTableData();
    }

    
    private void createCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createCompanyActionPerformed
        try{
            String companyName = this.companyNameField.getText().trim();
            String companyCode = this.companyCodeField.getText().trim();
            String companyDes = this.companyDesField.getText().trim();
            String companyEmail = this.companyEmailField.getText().trim();
            String companyPhone = this.companyPhoneField.getText().trim();
            String companyAddress = this.companyAddressField.getText().trim();
            if(companyName.equalsIgnoreCase("")) {
                MessageDialog.showInfoDialog(this, "Tên doanh nghiệp không để trống", "Thông báo");
                return;
            }
            if(companyCode.equalsIgnoreCase("")) {
                MessageDialog.showInfoDialog(this, "Mã số doanh nghiệp không để trống", "Thông báo");
                return;
            }
            if(companyEmail.equalsIgnoreCase("")) {
                MessageDialog.showInfoDialog(this, "Mail doanh nghiệp không để trống", "Thông báo");
                return;
            }
            if(companyPhone.equalsIgnoreCase("")) {
                MessageDialog.showInfoDialog(this, "Số điện thoại doanh nghiệp không để trống", "Thông báo");
                return;
            }
            if(companyAddress.equalsIgnoreCase("")) {
                MessageDialog.showInfoDialog(this, "Địa chỉ doanh nghiệp không để trống", "Thông báo");
                return;
            }
            
            if(CompanyService.isExistedComCode(companyCode)) {
                MessageDialog.showInfoDialog(this, "Mã số doanh nghiệp đã tồn tại", "Thông báo");
            }else if(CompanyService.isExistedComName(companyName)) {
                MessageDialog.showInfoDialog(this, "Tên doanh nghiệp đã tồn tại", "Thông báo");
            }else{
                CompanyService.createNewCompany(companyCode, companyName, companyDes, companyEmail, companyPhone, companyAddress);
                loadTableData();
                MessageDialog.showInfoDialog(this, "Thêm thành công", "Thông báo");
                clearAllFields();
            }                        
        }catch(Exception ex) {
            MessageDialog.showErrorDialog(this, "Phát hiện lỗi khi thêm doanh nghiệp, chi tiết: " + ex.getMessage() + "\n" + ex.toString() + "\n", "Có lỗi xảy ra");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_createCompanyActionPerformed

    private void updateCompanyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCompanyButtonActionPerformed
        try{
            int index = companyTable.getSelectedRow();
            if (index == -1) {
                MessageDialog.showInfoDialog(this, "Vui chọn chọn doanh nghiệp muốn sửa", "Thông báo");
                return;
            }
            Company selectedCom = CompanyService.getCompanyByIndex(index);
            String companyName = this.companyNameField.getText().trim();
            String companyCode = this.companyCodeField.getText().trim();
            String companyDes = this.companyDesField.getText().trim();
            String companyEmail = this.companyEmailField.getText().trim();
            String companyPhone = this.companyPhoneField.getText().trim();
            String companyAddress = this.companyAddressField.getText().trim();
            if(companyName.equalsIgnoreCase("")) {
                MessageDialog.showInfoDialog(this, "Tên doanh nghiệp không để trống", "Thông báo");
                return;
            }
            if(companyCode.equalsIgnoreCase("")) {
                MessageDialog.showInfoDialog(this, "Mã số doanh nghiệp không để trống", "Thông báo");
                return;
            }
            if(companyEmail.equalsIgnoreCase("")) {
                MessageDialog.showInfoDialog(this, "Mail doanh nghiệp không để trống", "Thông báo");
                return;
            }
            if(companyPhone.equalsIgnoreCase("")) {
                MessageDialog.showInfoDialog(this, "Số điện thoại doanh nghiệp không để trống", "Thông báo");
                return;
            }
            if(companyAddress.equalsIgnoreCase("")) {
                MessageDialog.showInfoDialog(this, "Địa chỉ doanh nghiệp không để trống", "Thông báo");
                return;
            }
            if(CompanyService.isExistedComCode(companyCode) && !companyCode.equals(companyCode)) {
                MessageDialog.showInfoDialog(this, "Mã số doanh nghiệp đã tồn tại", "Thông báo");
                return;
            }
            if(CompanyService.isExistedComName(companyName) && !companyName.equals(companyName)) {
                MessageDialog.showInfoDialog(this, "Tên doanh nghiệp đã tồn tại", "Thông báo");
                return;
            }
            
            selectedCom.setName(companyName);
            selectedCom.setCode(companyCode);
            selectedCom.setDescription(companyDes);
            selectedCom.setPhoneNumber(companyPhone);
            selectedCom.setEmail(companyEmail);
            selectedCom.setAddress(companyAddress);
            
            CompanyService.updateCompany(selectedCom);
            MessageDialog.showInfoDialog(this, "Cập nhật thông tin thành công!", "Thông báo");
            clearAllFields();
            loadTableData();
        }catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Xảy ra lỗi khi sửa thông tin doanh nghiệp, chi tiết: " + ex.getMessage() + "\n" + ex.toString() + "\n", "Phát hiện lỗi");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_updateCompanyButtonActionPerformed

    private void delCompanyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delCompanyButtonActionPerformed
        try{
            int index = companyTable.getSelectedRow();
            if (index == -1) {
                MessageDialog.showInfoDialog(this, "Vui chọn chọn doanh nghiệp muốn xóa", "Thông báo");
                return;
            }
            Company selectedCom = CompanyService.getCompanyByIndex(index);
            int keyPress = MessageDialog.showConfirmDialog(this, "Bạn có chắc muốn xóa doanh nghiệp " + selectedCom.getName(), "Xác nhận");
            if (keyPress == 0) {
                CompanyService.deleteCompany(selectedCom.getId());
                loadTableData();
                clearAllFields();
            }
        }catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Xảy ra lỗi khi xóa, chi tiết: " + ex.getMessage() + "\n" + ex.toString() + "\n", "Phát hiện lỗi");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_delCompanyButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        clearAllFields();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void companyTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_companyTableMouseClicked
        try {
            int index = companyTable.getSelectedRow();
            if (index == -1) {
                MessageDialog.showInfoDialog(this, "Vui chọn chọn doanh nghiệp", "Thông báo");
                return;
            }
            Company selectedCom = CompanyService.getCompanyByIndex(index);
            companyCodeField.setText(selectedCom.getCode());
            companyNameField.setText(selectedCom.getName());
            companyDesField.setText(selectedCom.getDescription());
            companyEmailField.setText(selectedCom.getEmail());
            companyPhoneField.setText(selectedCom.getPhoneNumber());
            companyAddressField.setText(selectedCom.getAddress());
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Có lỗi, chi tiết: " + ex.getMessage() + "\n" + ex.toString() + "\n", "Phát hiện lỗi");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_companyTableMouseClicked

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
            java.util.logging.Logger.getLogger(ManageCompany.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageCompany.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageCompany.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageCompany.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageCompany().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField companyAddressField;
    private javax.swing.JTextField companyCodeField;
    private javax.swing.JTextField companyDesField;
    private javax.swing.JTextField companyEmailField;
    private javax.swing.JTextField companyNameField;
    private javax.swing.JTextField companyPhoneField;
    private javax.swing.JTable companyTable;
    private javax.swing.JButton createCompanyButton;
    private javax.swing.JButton delCompanyButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton turnBackHome;
    private javax.swing.JButton updateCompanyButton;
    // End of variables declaration//GEN-END:variables
}
