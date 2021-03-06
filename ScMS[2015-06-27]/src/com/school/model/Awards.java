package com.school.model;
// Generated Dec 9, 2014 7:01:06 PM by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Awards generated by hbm2java
 */
@Entity
@Table(name="awards")
public class Awards  implements java.io.Serializable {


     private Integer id;
     private Event event;
     private Student student;
     private String awardsName;
     private String postion;
     private String remarks;

    public Awards() {
    }

	
    public Awards(Event event, Student student) {
        this.event = event;
        this.student = student;
    }
    public Awards(Event event, Student student, String awardsName, String postion, String remarks) {
       this.event = event;
       this.student = student;
       this.awardsName = awardsName;
       this.postion = postion;
       this.remarks = remarks;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="event_id", nullable=false)
    public Event getEvent() {
        return this.event;
    }
    
    public void setEvent(Event event) {
        this.event = event;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_student_id", nullable=false)
    public Student getStudent() {
        return this.student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }
    
    @Column(name="awards_name", length=100)
    public String getAwardsName() {
        return this.awardsName;
    }
    
    public void setAwardsName(String awardsName) {
        this.awardsName = awardsName;
    }
    
    @Column(name="postion", length=100)
    public String getPostion() {
        return this.postion;
    }
    
    public void setPostion(String postion) {
        this.postion = postion;
    }
    
    @Column(name="remarks", length=100)
    public String getRemarks() {
        return this.remarks;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

@Override
    public String toString() {
        return postion; //To change body of generated methods, choose Tools | Templates.
    }



}


