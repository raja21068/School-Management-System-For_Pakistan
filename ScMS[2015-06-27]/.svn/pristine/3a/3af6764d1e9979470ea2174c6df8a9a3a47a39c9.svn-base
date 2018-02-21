package com.school.utils;

/**
 * Title:        Database for Industrial Management
 * Description:  The designed system solve all major problems of existing system.
 * Copyright:    Copyright (c) 2014
 * @author Jay Kumar
 * @version 2.0
 */


public class NumberToWord {

private static void pw(int n,String ch, StringBuffer bulider){

       String one[]={""," One"," Two"," Three"," Four"," Five"," Six"," Seven"," Eight"," Nine"," Ten"," Eleven"," Twelve"," Thirteen"," Fourteen","Fifteen"," Sixteen"," Seventeen"," Eighteen"," Nineteen"};

       String ten[]={""," "," Twenty"," Thirty"," Forty"," Fifty"," Sixty","Seventy"," Eighty"," Ninety"};

       if(n>19) {
           bulider.append(ten[n/10]).append(" ").append(one[n%10]);
       } else {
           bulider.append(one[n]);
       }
       if(n>0){
           bulider.append(ch);
       }

   }

   public static String numberToWords(int n){
       if(n == 0){
           return "Zero";
       }
       StringBuffer words = new StringBuffer();

       pw((n/1000000000)," Hundred ",words);
       pw((n/10000000)%100," Crore ",words);
       pw(((n/100000)%100)," Lakh ",words);
       pw(((n/1000)%100)," Thousand ",words);
       pw(((n/100)%10)," Hundred ",words);
       pw((n%100)," ",words);
       return (words.toString()+" ");
   }

}