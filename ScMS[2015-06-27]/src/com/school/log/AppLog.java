/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.log;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author JAY
 */
public class AppLog {
    public static final String ERROR_LOG = "error";
    public static final String FATAL_LOG = "fatal";
    
    public static void configure() throws IOException{
        FileHandler errorLog  = new FileHandler("error-log.log");
        errorLog.setFormatter(new SimpleFormatter());
        
        FileHandler fatalLog  = new FileHandler("fatal-log.log");
        fatalLog.setFormatter(new SimpleFormatter());
        
        Logger.getLogger(ERROR_LOG).addHandler(errorLog);
        Logger.getLogger(FATAL_LOG).addHandler(fatalLog);
    }
    
    
}
