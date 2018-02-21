/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.view.panel;

import com.school.constant.D_Msg;
import com.school.dao.DatabaseManager;
import com.school.log.AppLog;
import com.school.model.EmpAccountCategory;
import com.school.model.UserPrivilege;
import com.school.utils.AppMsg;
import com.school.utils.Filter;
import com.school.view.JkPanel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author JAY
 */
public class EmployeeCategoryPanel extends JkPanel{


    public EmployeeCategoryPanel(UserPrivilege privilege) {
        super(privilege);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textFieldName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAreaRemarks = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        listCategory = new javax.swing.JList();
        buttonUpdate = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        buttonAdd = new javax.swing.JButton();

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DESIGNATION");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Name*");

        textFieldName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Remarks");

        textAreaRemarks.setColumns(20);
        textAreaRemarks.setRows(5);
        jScrollPane2.setViewportView(textAreaRemarks);

        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        listCategory.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listCategoryValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listCategory);

        buttonUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource(com.school.config.AppIcon.UPDATE)));
        buttonUpdate.setText("Update");
        buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateActionPerformed(evt);
            }
        });

        buttonDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource(com.school.config.AppIcon.DELETE)));
        buttonDelete.setText("Delete");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        buttonAdd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource(com.school.config.AppIcon.ADD)));
        buttonAdd.setText("Add");
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2)
                                    .addComponent(textFieldName)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonUpdate)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(textFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void listCategoryValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listCategoryValueChanged
        buttonUpdate.setEnabled(true);
        buttonDelete.setEnabled(true);
        EmpAccountCategory cat = (EmpAccountCategory) listCategory.getSelectedValue();
        if (cat == null) {
            return;
        }
        textFieldName.setText(cat.getName());
        textAreaRemarks.setText(cat.getRemarks());
    }//GEN-LAST:event_listCategoryValueChanged

    private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
        String name = textFieldName.getText();
        if (name.trim().isEmpty()) {
            AppMsg.warning(this, D_Msg.MSG_23);
            return;
        }
        name = Filter.filterString(name);
        String remarks = Filter.filterString(textAreaRemarks.getText());
        EmpAccountCategory cat = (EmpAccountCategory) listCategory.getSelectedValue();
        cat.setName(name);
        cat.setRemarks(remarks);
        try {
            DatabaseManager.updateData(cat);
            refreshCategory();
        } catch (Exception ex) {
            AppMsg.error(this, D_Msg.MSG_6,ex);
            Logger.getLogger(AppLog.ERROR_LOG).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonUpdateActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        EmpAccountCategory cat = (EmpAccountCategory) listCategory.getSelectedValue();
        try {
            DatabaseManager.deleteData(cat);
            refreshCategory();
        } catch (Exception ex) {
            AppMsg.error(this, D_Msg.MSG_6,ex);
            Logger.getLogger(AppLog.ERROR_LOG).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        String name = textFieldName.getText();
        if (name.trim().isEmpty()) {
            AppMsg.warning(this, D_Msg.MSG_23);
            return;
        }
        name = Filter.filterString(name);
        String remarks = Filter.filterString(textAreaRemarks.getText());
        try {
            EmpAccountCategory cat = new EmpAccountCategory(name);
            cat.setRemarks(remarks);
            DatabaseManager.addData(cat);
            refreshCategory();
        } catch (Exception ex) {
            AppMsg.error(this, D_Msg.MSG_6,ex);
            Logger.getLogger(AppLog.ERROR_LOG).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonAddActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listCategory;
    private javax.swing.JTextArea textAreaRemarks;
    private javax.swing.JTextField textFieldName;
    // End of variables declaration//GEN-END:variables

    @Override
    public void refresh() {
        refreshCategory();
    }
    
    
    /**
     * Refresh category (get bean.EmpAccountCategory from database and add in list).
     */
    private void refreshCategory() {
        try {
            listCategory.setListData(DatabaseManager.getData(EmpAccountCategory.class).toArray());
            buttonUpdate.setEnabled(false);
            buttonDelete.setEnabled(false);
        } catch (Exception ex) {
            AppMsg.error(this, D_Msg.MSG_6,ex);
            Logger.getLogger(AppLog.ERROR_LOG).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void postInit() {
        
    }

    @Override
    protected void handlePrivilege() {
         if (privilege.getIsAdd() == null || (!privilege.getIsAdd())) {
            buttonAdd.setVisible(false);
        }
        if (privilege.getIsDelete() == null || (!privilege.getIsDelete())) {
            buttonDelete.setVisible(false);
        }
        if (privilege.getIsUpdate() == null || (!privilege.getIsUpdate())) {
            buttonUpdate.setVisible(false);
        }
    }

    @Override
    protected void initComponentImplementation() {
        initComponents();
    }

 
}