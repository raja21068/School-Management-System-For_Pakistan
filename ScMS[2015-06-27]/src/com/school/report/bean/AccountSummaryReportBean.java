/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.report.bean;

/**
 *
 * @author JAY KUMAR
 */
public class AccountSummaryReportBean {

    private String name;
    private int amount;
    
    public void setName(String name){
        this.name = name;
    }
    public void setAmount(int amount){
        this.amount = amount;
    }
    
    public String getName(){
        return this.name;
    }
    public int getAmount(){
        return this.amount;
    }
    
}
