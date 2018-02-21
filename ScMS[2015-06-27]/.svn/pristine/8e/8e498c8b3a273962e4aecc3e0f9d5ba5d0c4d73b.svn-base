/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.report.bean;

import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author jay
 */
public class ReportExecuterReportBean {

    JRDataSource datasource;
    Map params;
    String filePackagePath;

    public ReportExecuterReportBean(JRDataSource datasource, Map params, String projectPath) {
        this.setDatasource(datasource);
        this.setParams(params);
        this.setFilePackagePath(filePackagePath);

    }

    public JRDataSource getDatasource() {
        return datasource;
    }

    public void setDatasource(JRDataSource datasource) {
        this.datasource = datasource;
    }

    public Map getParams() {
        return params;
    }

    public void setParams(Map params) {
        this.params = params;
    }

    public String getFilePackagePath() {
        return filePackagePath;
    }

    public void setFilePackagePath(String filePackagePath) {
        this.filePackagePath = filePackagePath;
    }

    public void execute() throws Exception {
        JasperReport report = JasperCompileManager.compileReport(getClass().getResource(filePackagePath).openStream());
        JasperPrint print = JasperFillManager.fillReport(report, params, datasource);
        JasperViewer.viewReport(print, false);
    }
}
