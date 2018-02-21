/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.utils;

import com.school.report.bean.CustomYear;
import com.school.constant.D_Msg;
import com.school.model.Campus;
import com.school.model.Section;
import com.school.model.Years;
import com.school.dao.DatabaseManager;
import com.school.dao.DatabaseQueryExecuter;
import com.school.log.AppLog;
import com.school.model.Classes;
import com.school.model.Months;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import org.hibernate.criterion.Order;

/**
 *
 * @author JAY KUMAR
 */
public class ComponentHandler {

    static Class[] classes;
    static boolean[] canEdit;
    
    public synchronized static void emptyTable(JTable table){
        int rows = table.getRowCount();
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        for(int i=0;i<rows;i++){
            model.removeRow(0);
        }
    }
    
    // For JTable, to show total number of rows
    public static void setModelListener(JTable t) {
        DefaultTableModel model = (DefaultTableModel) t.getModel();
        model.addTableModelListener(new MyModelListener(t));
    }

    // For full screen the frame
    public static void setFullScreen(JFrame frame) {
        try {
            frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        } catch (Exception ex) {
            Logger.getLogger(AppLog.FATAL_LOG).log(Level.SEVERE, null, ex);
        }
    }

    // For seting all CAMPUS in combobox
    // created because same type of coding is repeated in every next frame
    public static void setCampus(JComboBox comboBoxCampus) {
        try {
            comboBoxCampus.setModel(new DefaultComboBoxModel(DatabaseManager.getData(Campus.class).toArray()));
        } catch (Exception ex) {
            AppMsg.info(null, D_Msg.MSG_6, ex);
            Logger.getLogger(AppLog.FATAL_LOG).log(Level.SEVERE, null, ex);
        }
    }

    // For seting all <SECTION> in combobox
    // created because same type of coding is repeated in every next frame
    public static void setSection(JComboBox comboBoxSection) {
        try {
            comboBoxSection.setModel(new DefaultComboBoxModel(DatabaseManager.getData(Section.class).toArray()));
        } catch (Exception ex) {
            AppMsg.info(null, D_Msg.MSG_6, ex);
            Logger.getLogger(AppLog.FATAL_LOG).log(Level.SEVERE, null, ex);
        }
    }

    // For table, if any CHECKBOX in JTABLE in SELECTED then
    // BUTTON will be enabled
    // COLUMN means AT WHICH POSITION CHECKBOX IS PLACED
    public static void setModelListenerForButton(JTable table, JButton but, int column) {
        table.getModel().addTableModelListener(new MyTableModelListener(table, new JButton[]{but}, column));
    }

    public static void setModelListenerForButton(JTable table, JButton[] but, int column) {
        table.getModel().addTableModelListener(new MyTableModelListener(table, but, column));
    }

    public static boolean isAnyCheckBoxSelect(JTable table, int column) {
        int totalRows = table.getRowCount();
        for (int i = 0; i < totalRows; i++) {
            if ((boolean) table.getValueAt(i, column)) {
                return true;
            }
        }
        return false;
    }

    public static void setClasses(JComboBox comboBoxSection,JComboBox comboBoxClasses) {
       Section sec = (Section) comboBoxSection.getSelectedItem();
       if (sec == null) {
            return;
       }
       List<Classes>  list = getClasses(sec);
       comboBoxClasses.setModel(new DefaultComboBoxModel(list.toArray()));
    }
    
    public static List<Classes> getClasses(Section sec){
        if (sec == null) {
            return null;
        }
        return DatabaseQueryExecuter.getClasses(sec);
    }

    private static class MyModelListener implements TableModelListener {

        JTable table;

        MyModelListener(JTable t) {
            table = t;
        }

        @Override
        public void tableChanged(TableModelEvent e) {
            JScrollPane pane = ((JScrollPane) ((JViewport) table.getParent()).getParent());
            pane.setViewportBorder(javax.swing.BorderFactory.createTitledBorder(null, table.getRowCount() + " rows ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_BOTTOM, new java.awt.Font("Lucida Console", 0, 10)));
            pane.setBounds(pane.getX() - 1, pane.getY(), pane.getWidth(), pane.getHeight());
            pane.setBounds(pane.getX() + 1, pane.getY(), pane.getWidth(), pane.getHeight());
        }
    }

    private static class MyTableModelListener implements TableModelListener {

        JTable table;
        int column;
        JButton[] button;

        MyTableModelListener(JTable t, JButton[] but, int col) {
            table = t;
            column = col;
            button = but;
        }

        @Override
        public void tableChanged(TableModelEvent e) {
            boolean enable = false;
            if (isAnyCheckBoxSelect(table, column)) {
                enable = true;
            } else {
                enable = false;
            }
            for (int i = 0; i < button.length; i++) {
                button[i].setEnabled(enable);
            }
        }
    }

    public static void setJFrameCenterPostion(JComponent f) {
        try {
            int w = f.getWidth() / 2;
            int h = f.getHeight() / 2;
            Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
            int centerX = d.width / 2;
            int centerY = d.height / 2;
            f.setBounds(centerX - w, centerY - h, f.getWidth(), f.getHeight());
        } catch (Exception ex) {
            Logger.getLogger(AppLog.FATAL_LOG).log(Level.SEVERE, null, ex);
        }

    }

        public static void setJFrameCenterPostion(JFrame f) {
        try {
            int w = f.getWidth() / 2;
            int h = f.getHeight() / 2;
            Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
            int centerX = d.width / 2;
            int centerY = d.height / 2;
            f.setBounds(centerX - w, centerY - h, f.getWidth(), f.getHeight());
        } catch (Exception ex) {
            Logger.getLogger(AppLog.FATAL_LOG).log(Level.SEVERE, null, ex);
        }

    }

    
    public static void setBatch(JComboBox comboBoxBatch) {
        try {
            Object[] list = DatabaseManager.getData(Years.class).toArray();
            ArrayList copy = new ArrayList();
            for (Object ob : list) {
                Years year = (Years) ob;
                copy.add(new CustomYear(year));
            }
            comboBoxBatch.setModel(new DefaultComboBoxModel(copy.toArray()));
        } catch (Exception ex) {
            AppMsg.info(null, D_Msg.MSG_6, ex);
            Logger.getLogger(AppLog.FATAL_LOG).log(Level.SEVERE, null, ex);
        }
    }

    public static void setYear(JComboBox comboBox) {
        try {
            Object[] list = DatabaseManager.getData(Years.class,Order.desc("yearName")).toArray();
            comboBox.setModel(new DefaultComboBoxModel(list));
        } catch (Exception ex) {
            AppMsg.info(null, D_Msg.MSG_6, ex);
            Logger.getLogger(AppLog.FATAL_LOG).log(Level.SEVERE, null, ex);
        }
    }

    public static void setMonth(JComboBox comboBoxYear, JComboBox comboBoxMonth) {
        Years y = (Years) comboBoxYear.getSelectedItem();
        if (y == null) {
            return;
        }
        List<Months> monthList = DatabaseQueryExecuter.getMonths(y);
        comboBoxMonth.setModel(new DefaultComboBoxModel(monthList.toArray()));
    }
    
    
    public static void setCurrentMonth(javax.swing.JComboBox comboBoxMonth){
        String str = new  SimpleDateFormat("MMM").format(new java.util.Date());
        int items = comboBoxMonth.getItemCount();
        for(int i=0;i<items;i++){
            Object ob = comboBoxMonth.getItemAt(i);
            if(ob !=null){
                if(ob.toString().toLowerCase().contains(str.toLowerCase())){
                    comboBoxMonth.setSelectedIndex(i);
                }
            }
        }
    }
    
     public static void hideOnEscape(Object ob) {
        if (ob instanceof JComponent) {
            final JComponent comp = (JComponent) ob;
            InputMap inputMap = comp.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
            ActionMap actionMap = comp.getRootPane().getActionMap();

            inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), actionMap);
            actionMap.put(actionMap, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    comp.setVisible(false);
                }
            });
        } else if (ob instanceof JDialog) {
            final JDialog dialog = (JDialog) ob;
            InputMap inputMap = dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
            ActionMap actionMap = dialog.getRootPane().getActionMap();

            inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), actionMap);
            actionMap.put(actionMap, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dialog.dispose();
                }
            });
        }
    }
     
     public static void setCapitalInputEvent(JTextComponent textComponent){
         textComponent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTextComponent field = (JTextComponent) evt.getSource();
                int caret = field.getCaretPosition();
                String str = field.getText().toUpperCase();
                field.setText(str);
                field.setCaretPosition(caret);
            }
        });
     }
     
     public static void setStarkRed(Container container) {
        Component[] components = container.getComponents();
        for (Component component : components) {
            if (component instanceof JLabel) {
                JLabel l = (JLabel) component;
                String text = l.getText();
                if (!text.endsWith("*")) {
                    continue;
                }
                text = "<html>" + text.substring(0, text.length() - 1) + "<font color='red' size='5'>*</font>";
                l.setText(text);
            } else if (component instanceof Container) {
                if (component instanceof JPanel) {
                    Border b = ((JPanel) component).getBorder();
                    if (b instanceof TitledBorder) {
                        TitledBorder tb = (TitledBorder) b;
                        String text = tb.getTitle();
                        if (text.endsWith("*")) {
                            text = "<html>" + text.substring(0, text.length() - 1) + "<font color='red' size='5'>*</font>";
                            tb.setTitle(text);
                        }
                    }
                }
                setStarkRed((Container) component);
            }
        }
    }
}
