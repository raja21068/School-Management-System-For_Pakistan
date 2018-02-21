/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.view;

import com.school.model.UserPrivilege;

/**
 *
 * @author JAY
 */
public abstract class JkPanel extends javax.swing.JPanel{
    public UserPrivilege privilege;
    public JkPanel(UserPrivilege privilege){
        this.privilege = privilege;
        initComponentImplementation();
        postInit();
        handlePrivilege();
        com.school.utils.ComponentHandler.setStarkRed(this);
    }
    public abstract void refresh();
    protected abstract void postInit();
    protected abstract void handlePrivilege();
    protected abstract void initComponentImplementation();
}
