/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.utils;

import com.school.constant.D_Msg;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author JAY KUMAR
 */
public class PrintChartHelper {

    public static void printChart(ChartPanel panel) {
        double PIXEL_PER_INCH = 72;
        double PAPER_HEIGHT = 11 * PIXEL_PER_INCH;
        double PAPER_WIDTH = 8 * PIXEL_PER_INCH;
        double LEFT_MARGIN = 0.5 * PIXEL_PER_INCH;
        double RIGHT_MARGIN = 1.5 * PIXEL_PER_INCH;
        double TOP_MARGIN = 0.5 * PIXEL_PER_INCH;
        double BOTTOM_MARGIN = 0.5 * PIXEL_PER_INCH;

        PrinterJob job = PrinterJob.getPrinterJob();

        PageFormat pf = new PageFormat();

        Paper paper = new Paper();
        paper.setSize(PAPER_WIDTH, PAPER_HEIGHT);
        paper.setImageableArea(LEFT_MARGIN, TOP_MARGIN, PAPER_WIDTH-(LEFT_MARGIN+RIGHT_MARGIN), PAPER_HEIGHT-(TOP_MARGIN+BOTTOM_MARGIN));

        pf.setPaper(paper);

        pf.setOrientation(PageFormat.LANDSCAPE);

        job.setPrintable(panel, pf);

        if (job.printDialog()) {
            try {
                job.print();
            } catch (PrinterException ex) {
                AppMsg.info(null, D_Msg.MSG_6, ex);
            }
        }
    }
}
