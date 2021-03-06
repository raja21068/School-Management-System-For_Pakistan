/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.constant;

/**
 * @author JAY KUMAR
 */

/**
 * This Fees Constant is used:
 *  to store student ( either student has to pay fixed 
 *      (particular)fee in every month).
 *  every month challan will be generated according to fixed fee.
 */
public class ConsFeesPayment {

    public static int FIXED_FEES = 1;
    public static int NOT_FIXED_FEES = 0;

    public static boolean getBoolean(Integer i) {
        if (i.intValue() == FIXED_FEES) {
            return true;
        } else {
            return false;
        }
    }

    public static Integer getInteger(boolean isFixed) {
        if (isFixed) {
            return FIXED_FEES;
        }
        return NOT_FIXED_FEES;
    }
}
