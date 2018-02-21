/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.config;

/**
 *
 * @author JAY
 */
public class AppIcon {
    public final static String PICTURE_PATH = "/pictures/";
    
    public final static String MENU_CAMPUS = PICTURE_PATH+"menu_campus.png";
    public final static String MENU_CONFIGURATION = PICTURE_PATH+"menu_config.png";
    public final static String MENU_EMPLOYEE = PICTURE_PATH+"menu_employee.png";
    public final static String MENU_EMPLOYEE_CATEGORY = PICTURE_PATH+"menu_cat.png";
    public final static String MENU_SECTION = PICTURE_PATH+"menu_section.png";
    public final static String MENU_USER = PICTURE_PATH+"menu_user.png";
    public final static String MENU_YEAR = PICTURE_PATH+"menu_year.png";
    public final static String MENU_STUDENT = PICTURE_PATH+"menu_student.png";
    public final static String MENU_SHIFTING = PICTURE_PATH+"menu_shift.png";
    public final static String MENU_EVENTS = PICTURE_PATH+"medal-silver-1-icon.png";
    public final static String MENU_SALARY = PICTURE_PATH+"menu_salary.png";
    public final static String MENU_CHALLAN = PICTURE_PATH+"menu_reciept.png";
    public final static String MENU_FEES_STRUCTURE = PICTURE_PATH+"menu_struct.png";
    public final static String MENU_ATTENDANCE = PICTURE_PATH+"menu_attend.png";
    public final static String MENU_EXAMINATION = PICTURE_PATH+"table-sheet-icon.png";
    public final static String MENU_CATEGORY = PICTURE_PATH+"category-icon.png";
    public final static String MENU_CHART = PICTURE_PATH+"Line Chart.png";
    public final static String MENU_REPORTS = PICTURE_PATH+"print-icon2.png";
    public final static String MENU_SMS = PICTURE_PATH+"sim-icon-small.png";
    public final static String MENU_EXIT = PICTURE_PATH+"Actions-window-close-icon.png";
    
    public final static String ADD = PICTURE_PATH+"database-add-icon.png";
    public final static String UPDATE = PICTURE_PATH+"op-update.png";
    public final static String DELETE = PICTURE_PATH+"op-delete.png";
    public final static String CLEAR = PICTURE_PATH+"empty-icon.png";
    public final static String RIGHT_ARROW = PICTURE_PATH+"Actions-go-next-icon.png";
    public final static String SAVE = PICTURE_PATH+"Actions-document-save-icon.png";
    
    public final static String LOGO = PICTURE_PATH+"logo.jpg";
 
    public static javax.swing.ImageIcon getInfo() {
        return new javax.swing.ImageIcon(AppIcon.class.getClass().getResource(PICTURE_PATH+"info.png"));
    }
    public static javax.swing.ImageIcon getError() {
        return new javax.swing.ImageIcon(AppIcon.class.getClass().getResource(PICTURE_PATH+"Error.png"));
    }
    public static javax.swing.ImageIcon getQueston() {
        return new javax.swing.ImageIcon(AppIcon.class.getClass().getResource(PICTURE_PATH+"Question.png"));
    }
    public static javax.swing.ImageIcon getWarning() {
        return new javax.swing.ImageIcon(AppIcon.class.getClass().getResource(PICTURE_PATH+"Warning.png"));
    }
    public static javax.swing.ImageIcon getLock() {
        return new javax.swing.ImageIcon(AppIcon.class.getClass().getResource(PICTURE_PATH+"Lock.png"));
    }
    
}
