package com.school.utils;

import java.text.SimpleDateFormat;
import java.util.StringTokenizer;


public class DateFormatter {
    public static String dateToStringDMY(java.util.Date d){
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(d);
    }
    public static String dateToStringYMD(java.util.Date d){
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(d);
    }
    public static String dateToStringMDY(java.util.Date d){
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MM-dd-yyyy");
        return sdf.format(d);
    }
    public static String FlipDateAndMonth(String date){
        String dates[] = date.split("-");
        date = dates[1]+"-"+dates[0]+"-"+dates[2];
        return date;
    }
    public static String toDateAndTime(java.util.Date d){
        SimpleDateFormat sdf = new SimpleDateFormat("dd,MM,k,m");
        String s =sdf.format(d);
        return s;
    }
    
    public static String DMYToYMD(String d){
        StringTokenizer tokens = new StringTokenizer(d,"-");
        String dd = tokens.nextToken();
        String mm = tokens.nextToken();
        String yy = tokens.nextToken();
        
        return yy+"-"+mm+"-"+dd;
    }

    public static String dateToStringYMD(String from) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
