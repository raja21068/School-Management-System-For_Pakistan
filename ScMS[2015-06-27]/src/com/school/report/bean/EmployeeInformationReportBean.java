/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.report.bean;

import java.util.Date;
import java.util.List;

/**
 *
 * @author JAY
 */
public class EmployeeInformationReportBean {

    private String name;
    private String father;
    private String surname;
    private String contact;
    private String address;
    private String post;
    private Date joiningDate;
    private Date birthDate;
    private String gender;
    private Integer basicSalary;
    private Date leavingDate;
    private Integer travelingAllowance;
    private Integer otherAllowance;
    private String nic;
    private List<DesignationReportBean> designations;
    private Integer empAccountsId;
    private String campus;
    private String staffId;
    private List basicSalaryList;
    private List travellingAllowanceList;
    
    //    private String remarks;
    //    private Integer totalAmount;
    //    private String refLetter;
    //    private Integer headAllowance;
    //    private Integer coordinateAllowace;
    //    private Integer ctAllowance;
    //    private Integer medicalAllowance;
    //    private Integer fiveYearAllowance;
    //    private String bankAccountNo;
    //    private Integer orderNo;
    //    private String empAccountCategory;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Integer basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Date getLeavingDate() {
        return leavingDate;
    }

    public void setLeavingDate(Date leavingDate) {
        this.leavingDate = leavingDate;
    }

    public Integer getTravelingAllowance() {
        return travelingAllowance;
    }

    public void setTravelingAllowance(Integer travelingAllowance) {
        this.travelingAllowance = travelingAllowance;
    }

    public Integer getOtherAllowance() {
        return otherAllowance;
    }

    public void setOtherAllowance(Integer otherAllowance) {
        this.otherAllowance = otherAllowance;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public List<DesignationReportBean> getDesignations() {
        return designations;
    }

    public void setDesignations(List<DesignationReportBean> designations) {
        this.designations = designations;
    }

    public Integer getEmpAccountsId() {
        return empAccountsId;
    }

    public void setEmpAccountsId(Integer empAccountsId) {
        this.empAccountsId = empAccountsId;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public List getBasicSalaryList() {
        return basicSalaryList;
    }

    public void setBasicSalaryList(List basicSalaryList) {
        this.basicSalaryList = basicSalaryList;
    }

    public List getTravellingAllowanceList() {
        return travellingAllowanceList;
    }

    public void setTravellingAllowanceList(List travellingAllowanceList) {
        this.travellingAllowanceList = travellingAllowanceList;
    }
    
    
}
