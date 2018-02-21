/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.report.bean;

import com.school.model.StudentClassReg;
import java.util.List;

/**
 *
 * @author JAY KUMAR
 */
public class ClassReportBean {

    private String className;
    private List<StudentReportBean> students;
    private List<AttendenceReportBean> attendence;
    private List<com.school.model.StudentClassReg> classReg;

    public List<StudentClassReg> getClassReg() {
        return classReg;
    }

    public void setClassReg(List<StudentClassReg> classReg) {
        this.classReg = classReg;
    }
    
    public void setClassName(String s) {
        className = s;
    }
    
    public void setStudents(List<StudentReportBean> s) {
        students = s;
    }
    
    public void setAttendence(List<AttendenceReportBean> s) {
        attendence = s;
    }
    
    public String getClassName() {
        return className;
    }
    
    public List<StudentReportBean> getStudents() {
        return students;
    }
    
    public List<AttendenceReportBean> getAttendence() {
        return attendence;
    }
}
