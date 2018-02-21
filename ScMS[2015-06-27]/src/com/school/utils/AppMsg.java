/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.utils;

import com.school.config.AppIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author JAY
 */
public class AppMsg {
    private static final String ERROR_TITLE = "Error";
    private static final String CONFIRM_TITLE = "Confirm";
    private static final String INFO_TITLE = "Information";
    private static final String WARNING_TITLE = "Warning";
    private static final String ACCESS_DENIED_TITLE = "Access Denied";
    
    public static void error(java.awt.Component c, Object ob) {
        JOptionPane.showMessageDialog(c, ob, ERROR_TITLE, JOptionPane.ERROR_MESSAGE, AppIcon.getError());
    }
    public static void info(java.awt.Component c, Object ob) {
        JOptionPane.showMessageDialog(c, ob, INFO_TITLE, JOptionPane.INFORMATION_MESSAGE, AppIcon.getInfo());
    }
    public static void lock(java.awt.Component c, Object ob) {
        JOptionPane.showMessageDialog(c, ob, ACCESS_DENIED_TITLE, JOptionPane.INFORMATION_MESSAGE, AppIcon.getLock());
    }
    public static void info(java.awt.Component c, Object ob, String title) {
        JOptionPane.showMessageDialog(c, ob, title, JOptionPane.INFORMATION_MESSAGE, AppIcon.getInfo());
    }
    public static void warning(java.awt.Component c, Object ob) {
        JOptionPane.showMessageDialog(c, ob, WARNING_TITLE, JOptionPane.WARNING_MESSAGE, AppIcon.getWarning());
    }
    public static int confirm3(java.awt.Component c, Object ob) {
        return JOptionPane.showConfirmDialog(c, ob, CONFIRM_TITLE, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, AppIcon.getQueston());
    }
    public static int confirm2(java.awt.Component c, Object ob) {
        return JOptionPane.showConfirmDialog(c, ob, CONFIRM_TITLE, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, AppIcon.getQueston());
    }
    
    public static String input(java.awt.Component c, Object ob) {
        return JOptionPane.showInputDialog(c, ob);
    }
    
    public static void error(java.awt.Component c, Object ob,Exception ex) {
        JOptionPane.showMessageDialog(c, ob+ex.getMessage(), ERROR_TITLE, JOptionPane.ERROR_MESSAGE, AppIcon.getError());
    }
    public static void info(java.awt.Component c, Object ob,Exception ex) {
        JOptionPane.showMessageDialog(c, ob+ex.getMessage(), INFO_TITLE, JOptionPane.INFORMATION_MESSAGE, AppIcon.getInfo());
    }
    public static void warning(java.awt.Component c, Object ob,Exception ex) {
        JOptionPane.showMessageDialog(c, ob+ex.getMessage(), WARNING_TITLE, JOptionPane.WARNING_MESSAGE, AppIcon.getWarning());
    }
}
