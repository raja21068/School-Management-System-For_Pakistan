/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.report.bean;

import java.util.Date;
import java.util.Set;

/**
 *
 * @author JAY
 */
public class EventReportBean {
     private Integer years;
     private String desciption;
     private Date day;
     private Set<StudentReportBean> students;

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Set<StudentReportBean> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentReportBean> students) {
        this.students = students;
    }
     
     
}
