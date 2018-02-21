/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.dao;

import com.school.constant.D_Msg;
import com.school.model.Module;
import com.school.enums.Forms;
import com.school.log.AppLog;
import com.school.utils.AppMsg;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author JAY KUMAR
 */
/**
 * Here Properties contains database's
 * <ul>
 * <li>Driver</li>
 * <li>URL</li>
 * <li>Username</li>
 * <li>Password</li>
 * </ul>
 */
public class Handler {

    public static final String DB_NAME = "tg_school";
    public static final String DB_DRIVER_KEY = "hibernate.connection.driver_class";
    public static final String DB_URL_KEY = "hibernate.connection.url";
    public static final String DB_USERNAME_KEY = "hibernate.connection.username";
    public static final String DB_PASSWORD_KEY = "hibernate.connection.password";
    public static String DB_DRIVER = "com.mysql.jdbc.Driver";
    public static String DB_URL = "jdbc:mysql://localhost:3306/tg_school?zeroDateTimeBehavior=convertToNull&createDatabaseIfNotExist=true";
    public static String DB_USERNAME = "root";
    public static String DB_PASSWORD = "root";
    public static final String CONFIG_FILE_NAME = "config.properties";

    /**
     * create the database configuration file derived from
     * AnnotationConfiguration or override the existing file, and if
     * configuration file exist then set the properties in
     * AnnotationConfiguration.
     *
     * @param conf - org.hibernate.cfg.AnnotationConfiguration from
     * HibernateUtil
     * @return org.hibernate.cfg.AnnotationConfiguration (used in
     * database.HibernateUtil)
     * @throws IOException
     * @throws Exception
     */
    public static AnnotationConfiguration setProps(AnnotationConfiguration conf) throws IOException, Exception {
        Properties prop = new Properties();
        File file = new File(CONFIG_FILE_NAME);
        if(!file.exists()){
            createDefaultPropsFile();
        }

        InputStream input = new FileInputStream(file);
        prop.load(input);
        input.close();
        
        conf.setProperty(DB_DRIVER_KEY, prop.getProperty(DB_DRIVER_KEY));
        conf.setProperty(DB_PASSWORD_KEY, prop.getProperty(DB_PASSWORD_KEY));
        conf.setProperty(DB_URL_KEY, prop.getProperty(DB_URL_KEY));
        conf.setProperty(DB_USERNAME_KEY, prop.getProperty(DB_USERNAME_KEY));

        DB_DRIVER = prop.getProperty(DB_DRIVER_KEY);
        DB_URL = prop.getProperty(DB_URL_KEY);
        DB_USERNAME = prop.getProperty(DB_USERNAME_KEY);
        DB_PASSWORD = prop.getProperty(DB_PASSWORD_KEY);


        return conf;
    }

    /**
     *
     * @return <tt>true</tt> if configuration file exist otherwise
     * <tt>false</tt>
     * @throws Exception
     */
    public static boolean isPropsExists() throws Exception {
        File f = new File(CONFIG_FILE_NAME);
        if (f.exists()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Prepare Properties which will be saved in configuration.props file.
     *
     * @return Properties
     * @throws IOException
     */
    public static Properties createDefaultPropsFile() throws IOException {
        return createPropsFile(DB_URL, DB_USERNAME, DB_PASSWORD, DB_DRIVER);
    }

    /**
     * creates the configuration.props file.
     *
     * @param url database url (with protocol)
     * @param username database username
     * @param password database user password
     * @param driver database driver
     * @return
     * @throws IOException
     */
    public static Properties createPropsFile(String url, String username, String password, String driver) throws IOException {
        File file = new File(CONFIG_FILE_NAME);
        Properties prop = new Properties();
        OutputStream output = new FileOutputStream(file);
        prop.setProperty(DB_DRIVER_KEY, driver);
        prop.setProperty(DB_URL_KEY, url);
        prop.setProperty(DB_USERNAME_KEY, username);
        prop.setProperty(DB_PASSWORD_KEY, password);
        prop.store(output, null);
        output.close();
        return prop;
    }

    /**
     * get the properties which is stored in configuration.props. if file
     * doesn't exist it will create a new one.
     *
     * @return Properties
     * @throws IOException
     */
    public static Properties getDatabaseProperties() throws IOException {
        Properties prop = null;
        try (InputStream input = new FileInputStream(CONFIG_FILE_NAME)) {
            prop=new Properties();
            prop.load(input);
        }
        return prop;
    }

    /**
     * Import all modules in database (Modules from constant.Forms)
     *
     * @throws Exception
     */
    public static void importModules() throws Exception {
        Forms[] f = Forms.values();
        int size = f.length;
        for (int i=0;i<size;i++) {
            String str = f[i].getValue();
            DatabaseManager.addData(new Module(str, ""));
        }
    }

    public Handler() {
    }


    /**
     * This method will restore the database from a backup file path.
     *
     * @param dbUserName Database Username
     * @param dbPassword Database Paaword
     * @param source - Backup file path
     * @return <tt>true</tt> if database successfully imported otherwise
     * <tt>false</tt>
     */
    public static boolean restoreDB(String dbUserName, String dbPassword, String source) {
        String[] executeCmd = new String[]{"mysql", "--user=" + dbUserName, "--password=" + dbPassword, "-e", "source " + source};

        Process runtimeProcess;
        try {
            HibernateUtil.closeSessionFactory();
            runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();

            if (processComplete == 0) {
                AppMsg.info(null, D_Msg.MSG_1);
//                System.out.println("Backup restored successfully");
                return true;
            } else {
                AppMsg.error(null, D_Msg.MSG_2);
                InputStream in = runtimeProcess.getErrorStream();
                int avaliable = in.available();
                byte[] b = new byte[avaliable];
                in.read(b);
                String str = new String(b);
                System.out.println("Could not restore the backup:" + str);
            }
        } catch (IOException | InterruptedException | HeadlessException ex) {
            AppMsg.error(null, D_Msg.MSG_3,ex);
            Logger.getLogger(AppLog.FATAL_LOG).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * This method will create the backup file of current database.
     *
     * @param dbUserName Database Username
     * @param dbPassword Database Paaword
     * @param path directory path where the dump file should save.
     * @return <tt>true</tt> if backup file is successfully created otherwise
     * <tt>false</tt>
     */
    public static boolean backupDB(String dbUserName, String dbPassword, String path) {

        String executeCmd = "mysqldump -u" + dbUserName + " -p" + dbPassword + "  -B " + DB_NAME + " -r \"" + path + "\"";
        System.out.println(executeCmd);
        Process runtimeProcess;
        try {

            runtimeProcess = Runtime.getRuntime().exec(executeCmd);

            int processComplete = runtimeProcess.waitFor();

            if (processComplete == 0) {
                AppMsg.info(null, D_Msg.MSG_4);
                return true;
            } else {
                AppMsg.info(null, D_Msg.MSG_5);
                InputStream in = runtimeProcess.getErrorStream();
                int avaliable = in.available();
                byte[] b = new byte[avaliable];
                in.read(b);
                String str = new String(b);
                System.out.println(avaliable + " Could not create the backup:" + str);

            }
        } catch (Exception ex) {
            Logger.getLogger(AppLog.FATAL_LOG).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    //    private String createSQLFile()throws Exception{
//        InputStream input = getClass().getResourceAsStream(DATABASE_FILE_NAME);
//        DataOutputStream output = new DataOutputStream(new FileOutputStream(DATABASE_FILE_NAME));
//        byte[] b = new byte[(int) input.available()];
//        input.read(b);
//        output.write(b);
//        input.close();
//        output.close();
//        return new File(DATABASE_FILE_NAME).getAbsolutePath();
//    }
    public void createDatabase() {
        Session session = DatabaseManager.openSession();
        session.close();
        HibernateUtil.closeSessionFactory();
    }
}
