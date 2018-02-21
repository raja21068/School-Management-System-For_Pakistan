/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.report.bean;

/**
 *
 * @author JAY KUMAR
 */
public class EmployeeMonthsReportBean {
    // Variables declaration - do not modify
    private String employeeName;
    private String father;
    private String years;
    private String monthName;
    private int paid;
    private int casual;
    private int absent;
    private int warning;
    private int late;
    private int wentEarly;
    private int other;
    private int bonus;
    private String bankAccountNo;
    private String paidAmountFormatted;


public EmployeeMonthsReportBean(){}
public EmployeeMonthsReportBean(String years,String monthName,int paid,int casual,int absent,int warning,int late,int wentEarly,int other,int bonus){
    this.years=years;
    this.monthName=monthName;
    this.paid=paid;
    this.casual=casual;
    this.absent=absent;
    this.warning=warning;
    this.late=late;
    this.wentEarly=wentEarly;
    this.other=other;
    this.bonus=bonus;
}

//Setter Methods Generated
    public void setEmployeeName(String employeeName){
        this.employeeName = employeeName ;
    }
    public void setFather(String father){
        this.father = father ;
    }
    public void setYears(String years){
        this.years = years ;
    }
    public void setMonthName(String monthName){
        this.monthName = monthName ;
    }
    public void setPaid(int paid){
        this.paid = paid ;
    }
    public void setCasual(int casual){
        this.casual = casual ;
    }
    public void setAbsent(int absent){
        this.absent = absent ;
    }
    public void setWarning(int warning){
        this.warning = warning ;
    }
    public void setLate(int late){
        this.late = late ;
    }
    public void setWentEarly(int wentEarly){
        this.wentEarly = wentEarly ;
    }
    public void setOther(int other){
        this.other = other ;
    }
    public void setBonus(int bonus){
        this.bonus = bonus ;
    }




//Getter Methods Generated
    public String getEmployeeName(){
        return this.employeeName ;
    }
    public String getFather(){
        return this.father;
    }
    public String getYears(){
        return this.years ;
    }
    public String getMonthName(){
        return this.monthName ;
    }
    public int getPaid(){
        return this.paid ;
    }
    public int getCasual(){
        return this.casual ;
    }
    public int getAbsent(){
        return this.absent ;
    }
    public int getWarning(){
        return this.warning ;
    }
    public int getLate(){
        return this.late ;
    }
    public int getWentEarly(){
        return this.wentEarly ;
    }
    public int getOther(){
        return this.other ;
    }
    public int getBonus(){
        return this.bonus ;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public String getPaidAmountFormatted() {
        return paidAmountFormatted;
    }

    public void setPaidAmountFormatted(String paidAmountFormatted) {
        this.paidAmountFormatted = paidAmountFormatted;
    }
    
    
}
