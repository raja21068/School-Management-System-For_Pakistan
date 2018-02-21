/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.enums;

/**
 *
 * @author JAY KUMAR
 */

/**
 * This forms is stored in database that will help the 
 * user for permissions and pervileges.
 */
public enum Forms {
    
    CAMPUS(com.school.view.panel.CampusPanel.class,"Campus"),
    CLASS_SHIFTING(com.school.view.panel.ClassShiftingPanel.class,"Class Shifting"),
    CONFIGURATION(com.school.view.panel.ConfigurationPanel.class,"Configuration"),
    EMPLOYEE_CATEGORY(com.school.view.panel.EmployeeCategoryPanel.class,"Emplyee / Account Category"),
    EMPLOYEE(com.school.view.panel.EmployeePanel.class,"Employee / Account"),
    EVENTS(com.school.view.panel.EventsPanel.class,"Events / Compitions"),
    EXAMINATION(com.school.view.panel.ExaminationPanel.class,"Examination"),
    EXAMINATION_TYPE(com.school.view.panel.ExaminationTypePanel.class,"Terms / Semester / Exam Categories"),
    FEES(com.school.view.panel.FeesPanel.class,"Fees Payment"),
    FEES_STRUCTURE(com.school.view.panel.FeesStructurePanel.class,"Fees Structure"),
    REPORTS(com.school.view.panel.ReportsPanel.class,"Reports"),
    SMS_SENDING(com.school.view.panel.SMSPanel.class,"SMS Sending"),
    SALARY(com.school.view.panel.SalaryManagePanel.class,"Salary Management"),
    SECTION(com.school.view.panel.SectionClassSubjectPanel.class,"Section, Class & Subject"),
    STUDENT_ATTENDANCE(com.school.view.panel.AttendancePanel.class,"Student Attendance"),
    STUDENT_CHART(com.school.view.panel.ChartsPanel.class,"Statistical Chart"),
    STUDENT(com.school.view.panel.StudentPanel.class,"Student Registration & Searching"),
    USERS(com.school.view.panel.UserManagePanel.class,"User Management"),
    YEAR(com.school.view.panel.YearRegisterPanel.class,"Year Registration");
    
    public Class panel;
    public String value;
    
    Forms(Class panel, String value){
        this.panel = panel;
        this.value = value;
    }

    public Class getPanel() {
        return panel;
    }

    public void setPanel(Class panel) {
        this.panel = panel;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
   
}
