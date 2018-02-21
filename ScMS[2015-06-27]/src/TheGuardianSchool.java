/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.school.log.AppLog;
import com.school.view.frame.LoginJFrame;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author JAY KUMAR
 */
public class TheGuardianSchool {

    public static void main(String args[]) throws IOException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {

//            Properties props = new Properties();
//            props.put("logoString", "");
//            com.jtattoo.plaf.smart.SmartLookAndFeel.setTheme(props);
//            javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
//            javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppLog.ERROR_LOG).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppLog.ERROR_LOG).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AppLog.ERROR_LOG).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TheGuardianSchool.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        AppLog.configure();
        
        new LoginJFrame().setVisible(true);
    }
}
