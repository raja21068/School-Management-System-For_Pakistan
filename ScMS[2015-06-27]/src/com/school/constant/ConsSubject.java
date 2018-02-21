/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.constant;

/**
 * @author JAY KUMAR
 */

/**
 * Section has Classes
 * Classes has Subjects
 * According to course scheme, there is a varation in 
 * course scheme time to time, thats why these static 
 * values is to set either subject is current or
 * removed from course scheme.
 */
public class ConsSubject {
    public static Integer OLD = 1;
    public static Integer NOT_OLD = 0;
    private static int ABSENT = -1;
    
    public static String getMarksStatus(int obtainMarks){
        if(obtainMarks<=ABSENT){
            return "A";
        }
        return ""+obtainMarks;
    }
    
    public static int getMarksStatus(String obtainMarks){
        if(obtainMarks.trim().toLowerCase().equals("a")){
            return ABSENT;
        }
        return Integer.parseInt(obtainMarks);
    }
}
