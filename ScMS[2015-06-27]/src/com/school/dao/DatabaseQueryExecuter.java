/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.dao;

import com.school.model.Attendence;
import com.school.model.Campus;
import com.school.model.Classes;
import com.school.model.EmpAccountCategory;
import com.school.model.EmpAccounts;
import com.school.model.ExamResult;
import com.school.model.Fees;
import com.school.model.FeesDiscount;
import com.school.model.FeesStructure;
import com.school.model.Months;
import com.school.model.Salary;
import com.school.model.Section;
import com.school.model.SmsHistory;
import com.school.model.Student;
import com.school.model.StudentAttachment;
import com.school.model.StudentCertificateIssue;
import com.school.model.StudentClassReg;
import com.school.model.Subjects;
import com.school.model.TgUser;
import com.school.model.Years;
import com.school.constant.ConsSubject;
import com.school.log.AppLog;
import com.school.model.Awards;
import com.school.model.Designation;
import com.school.model.EmpAccountAttachment;
import com.school.model.EmpCertificateIssue;
import com.school.model.Event;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import com.school.model.UserPrivilege;
import com.school.report.bean.PaySlipReportBean;
import com.school.report.bean.StudentReportBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.SimpleExpression;

/**
 *
 * @author JAY KUMAR
 */
public class DatabaseQueryExecuter {

    // Fees
    /**
     * @param camp indicates the bean.Campus
     * @param cl indicates the bean.Classes
     * @param years indicates the session bean.Years
     * @param mon indicates the bean.Months
     * @return List &lt;bean.Fees&gt; List of which Students in particular
     * (Campus, Class, Session, Month) which has <b>NOT PAID
     * (bean.Fees.paidFees=0)</b> their monthly fee.
     */
    public static List<Object[]> getUnpaidFees(Campus camp, Classes cl, Years years, Months mon) throws Exception {
        String hql = "SELECT fe,scr,st,m.monthName FROM Fees fe "
                + "INNER JOIN fe.studentClassReg scr "
                + "INNER JOIN scr.student st "
                + "INNER JOIN fe.months m "
                + "INNER JOIN scr.years y "
                + "INNER JOIN scr.campus c "
                + "INNER JOIN scr.classes cl "
                + "WHERE fe.remaining > 0"
                + " AND m.monthId = " + mon.getMonthId()
                + " AND y.yearId = " + years.getYearId()
                + " AND c.campusId = " + camp.getCampusId()
                + " AND cl.classId = " + cl.getClassId();

        return DatabaseManager.getData(hql);

    }

    /**
     * @param camp indicates the bean.Campus
     * @param cl indicates the bean.Classes
     * @param years indicates the session bean.Years
     * @param mon indicates the bean.Months
     * @param oneMonth Field oneMonth in bean.Student
     * @return List &lt;bean.Fees&gt; List of which Students in particular
     * (Campus, Class, Session, Month) which has <b>NOT PAID
     * (bean.Fees.paidFees=0)</b> their monthly fee.
     */
    public static List<Object[]> getUnpaidFees(Campus camp, Classes cl, Years years, Months mon, boolean oneMonth) throws Exception {
        String hql = "SELECT fe,scr,st,m.monthName FROM Fees fe "
                + "INNER JOIN fe.studentClassReg scr "
                + "INNER JOIN scr.student st "
                + "INNER JOIN fe.months m "
                + "INNER JOIN scr.years y "
                + "INNER JOIN scr.campus c "
                + "INNER JOIN scr.classes cl "
                + "INNER JOIN scr.student st "
                + "WHERE fe.remaining > 0"
                + " AND m.monthId = " + mon.getMonthId()
                + " AND y.yearId = " + years.getYearId()
                + " AND c.campusId = " + camp.getCampusId()
                + " AND st.oneMonth = " + oneMonth
                + " AND cl.classId = " + cl.getClassId();

        return DatabaseManager.getData(hql);

    }

    /**
     * @param camp indicates the bean.Campus
     * @param years indicates the session bean.Years
     * @param mon indicates the bean.Months
     * @return List &lt;bean.Fees&gt; List of which Students in particular
     * (Campus, Class, Session, Month) which has <b>NOT PAID
     * (bean.Fees.paidFees=0)</b> their monthly fee.
     */
    public static List<Object[]> getUnpaidFees(Campus camp, Years years, Months mon) throws Exception {
        String hql = "SELECT fe,scr,st,m.monthName FROM Fees fe "
                + "INNER JOIN fe.studentClassReg scr "
                + "INNER JOIN scr.student st "
                + "INNER JOIN fe.months m "
                + "INNER JOIN scr.years y "
                + "INNER JOIN scr.campus c "
                + "INNER JOIN scr.classes cl "
                + "WHERE fe.remaining > 0"
                + " AND m.monthId = " + mon.getMonthId()
                + " AND y.yearId = " + years.getYearId()
                + " AND c.campusId = " + camp.getCampusId();
        return DatabaseManager.getData(hql);

    }

    /**
     * @param camp indicates the bean.Campus
     * @param years indicates the session bean.Years
     * @param mon indicates the bean.Months
     * @param oneMonth Field oneMonth in bean.Student
     * @return List &lt;bean.Fees&gt; List of which Students in particular
     * (Campus, Class, Session, Month) which has <b>NOT PAID
     * (bean.Fees.paidFees=0)</b> their monthly fee.
     */
    public static List<Object[]> getUnpaidFees(Campus camp, Years years, Months mon, boolean oneMonth) throws Exception {
        String hql = "SELECT fe,scr,st,m.monthName FROM Fees fe "
                + "INNER JOIN fe.studentClassReg scr "
                + "INNER JOIN scr.student st "
                + "INNER JOIN fe.months m "
                + "INNER JOIN scr.years y "
                + "INNER JOIN scr.campus c "
                + "INNER JOIN scr.classes cl "
                + "INNER JOIN scr.student st "
                + "WHERE fe.remaining > 0"
                + " AND m.monthId = " + mon.getMonthId()
                + " AND y.yearId = " + years.getYearId()
                + " AND st.oneMonth = " + oneMonth
                + " AND c.campusId = " + camp.getCampusId();
        return DatabaseManager.getData(hql);

    }

    /**
     * @param mon indicates the bean.Months
     * @param st bean.Student
     * @return List &lt;bean.Fees&gt; List of which Students in particular
     * (Campus, Class, Session, Month) which has <b>NOT PAID
     * (bean.Fees.paidFees=0)</b> their monthly fee.
     */
    public static List<Fees> getUnpaidFees(Months mon, Student st) throws Exception {
        String hql = "SELECT fe,m.monthName FROM Fees fe "
                + "INNER JOIN fe.studentClassReg scr "
                + "INNER JOIN fe.months m "
                + "INNER JOIN scr.student st "
                + "WHERE fe.remaining > 0"
                + " AND m.monthId = " + mon.getMonthId()
                + " AND st.studentId = " + st.getStudentId();

        List<Object[]> list = DatabaseManager.getData(hql);
        List<Fees> feesList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Fees fees = (Fees) list.get(i)[0];
            fees.setMonthName((String) list.get(i)[1]);
            feesList.add(fees);
        }
        return feesList;
    }

    /**
     * @param camp indicates the bean.Campus
     * @param years indicates the session bean.Years
     * @param mon indicates the bean.Months
     * @return List &lt;bean.Fees&gt; List of which Students in particular
     * (Campus, Class, Session, Month) which has <b>PAID</b> their monthly fee.
     */
    public static List getPaidFees(Campus camp, Years years, Months mon) throws Exception {
        Session session = DatabaseManager.openSession();
        try {
            Criteria stdCrit = session.createCriteria(Fees.class, "fe").
                    add(Restrictions.le("fe.remaining", 0)).add(Restrictions.eq("fe.months.monthId", mon.getMonthId()))
                    .createCriteria("fe.studentClassReg", "scr")
                    .add(Restrictions.eq("scr.years.yearId", years.getYearId()))
                    .add(Restrictions.eq("scr.campus.campusId", camp.getCampusId()))
                    .createCriteria("scr.student", "st").addOrder(Order.asc("st.studentName"));
            return stdCrit.list();
        } catch (Exception ex) {
            Logger.getLogger(AppLog.FATAL_LOG).log(Level.SEVERE, null, ex);
        } finally {
            session.close();
        }
        return null;
    }

    /**
     * @param camp indicates the bean.Campus
     * @param years indicates the session bean.Years
     * @param mon indicates the bean.Months
     * @param oneMonth Field oneMonth in bean.Student
     * @return List &lt;bean.Fees&gt; List of which Students which has
     * <b>PAID</b> their monthly fee. Student filtered by, which has to pay one
     * month fees
     */
    public static List getPaidFees(Campus camp, Years years, Months mon, boolean oneMonth) throws Exception {
        Session session = DatabaseManager.openSession();
        try {
            Criteria stdCrit = session.createCriteria(Fees.class, "fe").
                    add(Restrictions.le("fe.remaining", 0)).add(Restrictions.eq("fe.months.monthId", mon.getMonthId()))
                    .createCriteria("fe.studentClassReg", "scr")
                    .add(Restrictions.eq("scr.years.yearId", years.getYearId()))
                    .add(Restrictions.eq("scr.campus.campusId", camp.getCampusId()))
                    .createCriteria("scr.student", "st")
                    .add(Restrictions.eq("st.oneMonth", oneMonth))
                    .addOrder(Order.asc("st.studentName"));
            return stdCrit.list();
        } catch (Exception ex) {
            Logger.getLogger(AppLog.FATAL_LOG).log(Level.SEVERE, null, ex);
        } finally {
            session.close();
        }
        return null;
    }

    /**
     * @param camp indicates the bean.Campus
     * @param cl indicates the bean.Classes
     * @param years indicates the session bean.Years
     * @param mon indicates the bean.Months
     * @return List &lt;bean.Fees&gt; List of which Students which has
     * <b>PAID</b> their monthly fee.
     */
    public static List getPaidFees(Campus camp, Classes cl, Years years, Months mon) throws Exception {
        Session session = DatabaseManager.openSession();
        try {
            Criteria stdCrit = session.createCriteria(Fees.class, "fe").
                    add(Restrictions.le("fe.remaining", 0)).add(Restrictions.eq("fe.months.monthId", mon.getMonthId()))
                    .createCriteria("fe.studentClassReg", "scr")
                    .add(Restrictions.eq("scr.years.yearId", years.getYearId()))
                    .add(Restrictions.eq("scr.campus.campusId", camp.getCampusId()))
                    .add(Restrictions.eq("scr.classes.classId", cl.getClassId())).
                    createCriteria("scr.student", "st").addOrder(Order.asc("st.studentName"));
            return stdCrit.list();
        } catch (Exception ex) {
            Logger.getLogger(AppLog.FATAL_LOG).log(Level.SEVERE, null, ex);
        } finally {
            session.close();
        }
        return null;
    }

    /**
     * @param camp indicates the bean.Campus
     * @param cl indicates the bean.Classes
     * @param years indicates the session bean.Years
     * @param mon indicates the bean.Months
     * @param oneMonth Field oneMonth in bean.Student
     * @return List &lt;bean.Fees&gt; List of which Students which has
     * <b>PAID</b> their monthly fee. Student filtered by, which has to pay one
     * month fees
     */
    public static List getPaidFees(Campus camp, Classes cl, Years years, Months mon, boolean oneMonth) throws Exception {
        Session session = DatabaseManager.openSession();
        try {
            Criteria stdCrit = session.createCriteria(Fees.class, "fe").
                    add(Restrictions.le("fe.remaining", 0)).add(Restrictions.eq("fe.months.monthId", mon.getMonthId()))
                    .createCriteria("fe.studentClassReg", "scr")
                    .add(Restrictions.eq("scr.years.yearId", years.getYearId()))
                    .add(Restrictions.eq("scr.campus.campusId", camp.getCampusId()))
                    .add(Restrictions.eq("scr.classes.classId", cl.getClassId())).
                    createCriteria("scr.student", "st")
                    .add(Restrictions.eq("st.oneMonth", oneMonth))
                    .addOrder(Order.asc("st.studentName"));
            return stdCrit.list();
        } catch (Exception ex) {
            Logger.getLogger(AppLog.FATAL_LOG).log(Level.SEVERE, null, ex);
        } finally {
            session.close();
        }
        return null;
    }

    /**
     * @return List &lt;bean.Fees&gt; List of which Students which has <b>NOT
     * PAID</b> their fee. Defaulter Students
     */
    public static List<Object[]> getDefaulter() {
        List<Object[]> list = null;
        Session session = DatabaseManager.openSession();
        try {
            list = session.createCriteria(Fees.class, "f")
                    .add(Restrictions.gt("f.remaining", 0))
                    .createCriteria("studentClassReg", "scr")
                    .createCriteria("scr.classes", "c")
                    .createCriteria("scr.student", "s")
                    .createCriteria("scr.years", "y")
                    .createCriteria("scr.campus", "cmp")
                    .setProjection(Projections.projectionList()
                    .add(Projections.groupProperty("s.grNo"))
                    .add(Projections.property("s.studentName"))
                    .add(Projections.property("s.fatherName"))
                    .add(Projections.property("c.className"))
                    .add(Projections.property("y.remarks"))
                    .add(Projections.property("cmp.name"), "campusName")
                    .add(Projections.sum("f.remaining"), "arrers"))
                    .list();
        } catch (Exception ex) {
            Logger.getLogger(AppLog.FATAL_LOG).log(Level.SEVERE, null, ex);
        } finally {
            session.close();

        }
        return list;
    }

    /**
     *
     * @param monthFrom
     * @param MonthTo
     * @return
     */
    public static List<Object[]> getDefaulter(com.school.model.Months monthFrom, com.school.model.Months MonthTo) {
        List<Object[]> list = null;
        Session session = DatabaseManager.openSession();
        try {
            list = session.createCriteria(Fees.class, "f")
                    .add(Restrictions.gt("f.remaining", 0))
                    .createCriteria("studentClassReg", "scr")
                    .createCriteria("scr.classes", "c")
                    .createCriteria("scr.student", "s")
                    .createCriteria("scr.years", "y")
                    .createCriteria("scr.campus", "cmp")
                    .add(Restrictions.between("f.months", monthFrom, MonthTo))
                    .setProjection(Projections.projectionList()
                    .add(Projections.groupProperty("s.grNo"))
                    .add(Projections.property("s.studentName"))
                    .add(Projections.property("s.fatherName"))
                    .add(Projections.property("c.className"))
                    .add(Projections.property("y.remarks"))
                    .add(Projections.property("cmp.name"), "campusName")
                    .add(Projections.sum("f.remaining"), "arrers"))
                    .list();
        } catch (Exception ex) {
            Logger.getLogger(AppLog.FATAL_LOG).log(Level.SEVERE, null, ex);
        } finally {
            session.close();
        }
        return list;
    }

    /**
     *
     * @param monthFrom
     * @param MonthTo
     * @return
     */
    public static List<Object[]> getDefaulter(com.school.model.Months monthFrom, com.school.model.Months MonthTo, boolean oneMonth) {
        List<Object[]> list = null;
        Session session = DatabaseManager.openSession();
        try {
            list = session.createCriteria(Fees.class, "f")
                    .add(Restrictions.gt("f.remaining", 0))
                    .createCriteria("studentClassReg", "scr")
                    .createCriteria("scr.classes", "c")
                    .createCriteria("scr.student", "s")
                    .createCriteria("scr.years", "y")
                    .createCriteria("scr.campus", "cmp")
                    .add(Restrictions.between("f.months", monthFrom, MonthTo))
                    .add(Restrictions.eq("s.oneMonth", oneMonth))
                    .setProjection(Projections.projectionList()
                    .add(Projections.groupProperty("s.grNo"))
                    .add(Projections.property("s.studentName"))
                    .add(Projections.property("s.fatherName"))
                    .add(Projections.property("c.className"))
                    .add(Projections.property("y.remarks"))
                    .add(Projections.property("cmp.name"), "campusName")
                    .add(Projections.sum("f.remaining"), "arrers"))
                    .list();
        } catch (Exception ex) {
            Logger.getLogger(AppLog.FATAL_LOG).log(Level.SEVERE, null, ex);
        } finally {
            session.close();
        }
        return list;
    }

    /**
     *
     * @param monthFrom
     * @param MonthTo
     * @param campus
     * @return
     */
    public static List<Object[]> getDefaulter(com.school.model.Months monthFrom, com.school.model.Months MonthTo, Campus campus) {
        List<Object[]> list = null;
        Session session = DatabaseManager.openSession();
        try {
            list = session.createCriteria(Fees.class, "f")
                    .add(Restrictions.gt("f.remaining", 0))
                    .createCriteria("studentClassReg", "scr")
                    .createCriteria("scr.classes", "c")
                    .createCriteria("scr.student", "s")
                    .createCriteria("scr.years", "y")
                    .createCriteria("scr.campus", "cmp")
                    .add(Restrictions.between("f.months", monthFrom, MonthTo))
                    .add(Restrictions.eq("scr.campus", campus))
                    .setProjection(Projections.projectionList()
                    .add(Projections.groupProperty("s.grNo"))
                    .add(Projections.property("s.studentName"))
                    .add(Projections.property("s.fatherName"))
                    .add(Projections.property("c.className"))
                    .add(Projections.property("y.remarks"))
                    .add(Projections.property("cmp.name"), "campusName")
                    .add(Projections.sum("f.remaining"), "arrers"))
                    .list();
        } catch (Exception ex) {
            Logger.getLogger(AppLog.FATAL_LOG).log(Level.SEVERE, null, ex);
        } finally {
            session.close();
        }
        return list;
    }

    /**
     *
     * @param monthFrom
     * @param MonthTo
     * @param campus
     * @return
     */
    public static List<Object[]> getDefaulter(com.school.model.Months monthFrom, com.school.model.Months MonthTo, Campus campus, boolean oneMonth) {
        List<Object[]> list = null;
        Session session = DatabaseManager.openSession();
        try {
            list = session.createCriteria(Fees.class, "f")
                    .add(Restrictions.gt("f.remaining", 0))
                    .createCriteria("studentClassReg", "scr")
                    .createCriteria("scr.classes", "c")
                    .createCriteria("scr.student", "s")
                    .createCriteria("scr.years", "y")
                    .createCriteria("scr.campus", "cmp")
                    .add(Restrictions.between("f.months", monthFrom, MonthTo))
                    .add(Restrictions.eq("scr.campus", campus))
                    .add(Restrictions.eq("s.oneMonth", oneMonth))
                    .setProjection(Projections.projectionList()
                    .add(Projections.groupProperty("s.grNo"))
                    .add(Projections.property("s.studentName"))
                    .add(Projections.property("s.fatherName"))
                    .add(Projections.property("c.className"))
                    .add(Projections.property("y.remarks"))
                    .add(Projections.property("cmp.name"), "campusName")
                    .add(Projections.sum("f.remaining"), "arrers"))
                    .list();
        } catch (Exception ex) {
            Logger.getLogger(AppLog.FATAL_LOG).log(Level.SEVERE, null, ex);
        } finally {
            session.close();
        }
        return list;
    }

    public static List<Object[]> getDefaulter(com.school.model.Months monthFrom, com.school.model.Months MonthTo, Classes classes) {
        List<Object[]> list = null;
        Session session = DatabaseManager.openSession();
        try {
            list = session.createCriteria(Fees.class, "f")
                    .add(Restrictions.gt("f.remaining", 0))
                    .createCriteria("studentClassReg", "scr")
                    .createCriteria("scr.classes", "c")
                    .createCriteria("scr.student", "s")
                    .createCriteria("scr.years", "y")
                    .createCriteria("scr.campus", "cmp")
                    .add(Restrictions.between("f.months", monthFrom, MonthTo))
                    .add(Restrictions.eq("scr.classes", classes))
                    .setProjection(Projections.projectionList()
                    .add(Projections.groupProperty("s.grNo"))
                    .add(Projections.property("s.studentName"))
                    .add(Projections.property("s.fatherName"))
                    .add(Projections.property("c.className"))
                    .add(Projections.property("y.remarks"))
                    .add(Projections.property("cmp.name"), "campusName")
                    .add(Projections.sum("f.remaining"), "arrers"))
                    .list();
        } catch (Exception ex) {
            Logger.getLogger(AppLog.FATAL_LOG).log(Level.SEVERE, null, ex);
        } finally {
            session.close();
        }
        return list;
    }

    public static List<Object[]> getDefaulter(com.school.model.Months monthFrom, com.school.model.Months MonthTo, Classes classes, boolean oneMonth) {
        List<Object[]> list = null;
        Session session = DatabaseManager.openSession();
        try {
            list = session.createCriteria(Fees.class, "f")
                    .add(Restrictions.gt("f.remaining", 0))
                    .createCriteria("studentClassReg", "scr")
                    .createCriteria("scr.classes", "c")
                    .createCriteria("scr.student", "s")
                    .createCriteria("scr.years", "y")
                    .createCriteria("scr.campus", "cmp")
                    .add(Restrictions.between("f.months", monthFrom, MonthTo))
                    .add(Restrictions.eq("s.oneMonth", oneMonth))
                    .add(Restrictions.eq("scr.classes", classes))
                    .setProjection(Projections.projectionList()
                    .add(Projections.groupProperty("s.grNo"))
                    .add(Projections.property("s.studentName"))
                    .add(Projections.property("s.fatherName"))
                    .add(Projections.property("c.className"))
                    .add(Projections.property("y.remarks"))
                    .add(Projections.property("cmp.name"), "campusName")
                    .add(Projections.sum("f.remaining"), "arrers"))
                    .list();
        } catch (Exception ex) {
            Logger.getLogger(AppLog.FATAL_LOG).log(Level.SEVERE, null, ex);
        } finally {
            session.close();
        }
        return list;
    }

    /**
     *
     * @param monthFrom
     * @param MonthTo
     * @param campus
     * @param classes
     * @return
     */
    public static List<Object[]> getDefaulter(com.school.model.Months monthFrom, com.school.model.Months MonthTo, Campus campus, Classes classes) {
        List<Object[]> list = null;
        Session session = DatabaseManager.openSession();
        try {
            list = session.createCriteria(Fees.class, "f")
                    .add(Restrictions.gt("f.remaining", 0))
                    .createCriteria("studentClassReg", "scr")
                    .createCriteria("scr.classes", "c")
                    .createCriteria("scr.student", "s")
                    .createCriteria("scr.years", "y")
                    .createCriteria("scr.campus", "cmp")
                    .add(Restrictions.between("f.months", monthFrom, MonthTo))
                    .add(Restrictions.eq("scr.campus", campus))
                    .add(Restrictions.eq("scr.classes", classes))
                    .setProjection(Projections.projectionList()
                    .add(Projections.groupProperty("s.grNo"))
                    .add(Projections.property("s.studentName"))
                    .add(Projections.property("s.fatherName"))
                    .add(Projections.property("c.className"))
                    .add(Projections.property("y.remarks"))
                    .add(Projections.property("cmp.name"), "campusName")
                    .add(Projections.sum("f.remaining"), "arrers"))
                    .list();
        } catch (Exception ex) {
            Logger.getLogger(AppLog.FATAL_LOG).log(Level.SEVERE, null, ex);
        } finally {
            session.close();
        }
        return list;
    }

    /**
     *
     * @param monthFrom
     * @param MonthTo
     * @param campus
     * @param classes
     * @return
     */
    public static List<Object[]> getDefaulter(com.school.model.Months monthFrom, com.school.model.Months MonthTo, Campus campus, Classes classes, boolean oneMonth) {
        List<Object[]> list = null;
        Session session = DatabaseManager.openSession();
        try {
            list = session.createCriteria(Fees.class, "f")
                    .add(Restrictions.gt("f.remaining", 0))
                    .createCriteria("studentClassReg", "scr")
                    .createCriteria("scr.classes", "c")
                    .createCriteria("scr.student", "s")
                    .createCriteria("scr.years", "y")
                    .createCriteria("scr.campus", "cmp")
                    .add(Restrictions.between("f.months", monthFrom, MonthTo))
                    .add(Restrictions.eq("scr.campus", campus))
                    .add(Restrictions.eq("scr.classes", classes))
                    .add(Restrictions.eq("s.oneMonth", oneMonth))
                    .setProjection(Projections.projectionList()
                    .add(Projections.groupProperty("s.grNo"))
                    .add(Projections.property("s.studentName"))
                    .add(Projections.property("s.fatherName"))
                    .add(Projections.property("c.className"))
                    .add(Projections.property("y.remarks"))
                    .add(Projections.property("cmp.name"), "campusName")
                    .add(Projections.sum("f.remaining"), "arrers"))
                    .list();
        } catch (Exception ex) {
            Logger.getLogger(AppLog.FATAL_LOG).log(Level.SEVERE, null, ex);
        } finally {
            session.close();
        }
        return list;
    }

    /**
     * @param minGr indicates the bean.Student.grNo
     * @param maxGr indicates the bean.Student.grNo
     * @return List &lt;bean.Student&gt; List of which Students from
     * <b>mixGr</b> to <b>maxGr</b>.
     */
    public static List<Student> getStudents(int minGR, int maxGR) {
        List<Student> list = null;
        Session session = DatabaseManager.openSession();
        try {
            list = session.createCriteria(Student.class)
                    .add(Restrictions.between("grNo", minGR, maxGR))
                    .addOrder(Order.asc("grNo"))
                    .list();
        } catch (Exception ex) {
            Logger.getLogger(AppLog.FATAL_LOG).log(Level.SEVERE, null, ex);
        } finally {
            session.close();
        }
        return list;
    }

    public static List<Student> getStudents(int minGR, int maxGR, boolean oneMonth) {
        List<Student> list = null;
        Session session = DatabaseManager.openSession();
        try {
            list = session.createCriteria(Student.class)
                    .add(Restrictions.between("grNo", minGR, maxGR))
                    .add(Restrictions.eq("oneMonth", oneMonth))
                    .addOrder(Order.asc("grNo"))
                    .list();
        } catch (Exception ex) {
            Logger.getLogger(AppLog.FATAL_LOG).log(Level.SEVERE, null, ex);
        } finally {
            session.close();
        }
        return list;
    }

    public static List<StudentReportBean> getRepeatedStudents(Years sesssion, Campus camp) {
        List<Object[]> list = DatabaseManager.getData("SELECT SCR.student.studentName, "
                + "                                 SCR.student.fatherName, "
                + "                                 SCR.student.grNo, "
                + "                                 SCR.student.contactNo, "
                + "                                 SCR.years.remarks, "
                + "                                 SCR.campus.name, "
                + "                                 SCR.classes.className "
                + " FROM StudentClassReg SCR"
                + " WHERE SCR.classes.classId in ( SELECT reg.classes.classId from StudentClassReg reg WHERE reg.student.studentId = SCR.student.studentId AND reg.years.yearId=" + sesssion.getYearId() + ")"
                + " AND SCR.years.yearId<" + sesssion.getYearId() + " AND campus.campusId=" + camp.getCampusId()
                + " GROUP BY SCR.student HAVING COUNT(SCR.classes.classId)>0");
        List<StudentReportBean> reportBeansList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            StudentReportBean reportBean = new StudentReportBean();
            Object[] obs = list.get(i);
            reportBean.setStudentName((String) obs[0]);
            reportBean.setFatherName((String) obs[1]);
            reportBean.setGrNo("" + obs[2]);
            reportBean.setContact((String) obs[3]);
            reportBean.setSesssionYear((String) obs[4]);
            reportBean.setCampusName((String) obs[5]);
            reportBean.setClassName((String) obs[6]);
            reportBeansList.add(reportBean);
        }
        return reportBeansList;
    }

    public static List<Student> getLeftStudents() {
        List<Student> list = null;
        Session session = DatabaseManager.openSession();
        try {
            String hql = " SELECT st FROM Student AS st "
                    + " WHERE st.dateOfLeaving IS NOT NULL "
                    + " ORDER BY st.grNo ";
            list = DatabaseManager.getData(hql);
            for(int i=0;i<list.size();i++){
                Student st = list.get(i);
                StudentClassReg scr = DatabaseQueryExecuter.getStudentClassRegLast(st, true);
                st.setLastClassName(scr.getClasses().getClassName());
            }   
            
//                    session.createCriteria(Student.class, "st")
//                    .add(Restrictions.isNotNull("st.dateOfLeaving"))
//                    .addOrder(Order.asc("st.grNo"))
//                    .list();
        } catch (Exception ex) {
            Logger.getLogger(AppLog.FATAL_LOG).log(Level.SEVERE, null, ex);
        } finally {
            session.close();
        }
        return list;

    }

    /**
     * @param monthFrom indicates the bean.Months
     * @param monthTo indicates the bean.Months
     * @return List &lt;Object[]&gt; List of category name and sum of amount
     * from a month to month
     * <ul>
     * <li> <b>category</b> : (bean.EmpAccountCategory.name)</li> .
     * <li> <b>amount</b> : (bean.Salary.amount)</li> .
     * </ul>
     */
    public static List<Object[]> getEmployeeExpense(Months monthFrom, Months monthTo) {
        return DatabaseManager.getData("SELECT cat.name,SUM(s.amount) FROM Salary s "
                + "INNER JOIN s.empAccounts emp "
                + "INNER JOIN emp.empAccountCategory cat "
                + "INNER JOIN s.months mon "
                + "WHERE mon.monthId BETWEEN " + monthFrom.getMonthId() + " AND " + monthTo.getMonthId()
                + " group by cat.empAccountCategoryId");
    }

    /**
     * @param monthFrom indicates the bean.Months
     * @param monthTo indicates the bean.Months
     * @return List &lt;Object&gt; return sum of remaining fees of students from
     * month to month
     * <ul>
     * <li> <b>remaining</b> : (bean.Fees.remaining)</li> .
     * </ul>
     */
    public static List<Object> getStudentTotalArrears(Months monthFrom, Months monthTo) {
        return DatabaseManager.getData("SELECT SUM(f.remaining) FROM Fees f "
                + "INNER JOIN f.months mon "
                + "WHERE mon.monthId BETWEEN " + monthFrom.getMonthId() + " AND " + monthTo.getMonthId()
                + "");
    }

    /**
     * @param monthFrom indicates the bean.Months
     * @param monthTo indicates the bean.Months
     * @return List &lt;Object&gt; return sum of paid fees of students from
     * month to month
     * <ul>
     * <li> <b>paid fees</b> : (bean.Fees.paidFee)</li> .
     * </ul>
     */
    public static List<Object> getStudentTotalPaid(Months monthFrom, Months monthTo) {
        return DatabaseManager.getData("SELECT SUM(f.paidFee) FROM Fees f "
                + "INNER JOIN f.months mon "
                + "WHERE mon.monthId BETWEEN " + monthFrom.getMonthId() + " AND " + monthTo.getMonthId()
                + "");
    }

    /**
     * @param emp indicates the bean.EmpAccount
     * @return List &lt;bean.Salary&gt; return variation in <b>basic salary</b>
     * of employee or account.
     */
    public static List<Object[]> getDistinctBasicSalary(EmpAccounts emp) {
        return DatabaseManager.getData("SELECT s, mon.monthName, y.yearName FROM Salary s"
                + " INNER JOIN s.empAccounts emp "
                + " INNER JOIN s.months mon "
                + " INNER JOIN mon.years y "
                + " WHERE emp.empAccountsId = " + emp.getEmpAccountsId()
                + " GROUP BY s.basicSalary");
    }

    /**
     * @param emp indicates the bean.EmpAccount
     * @return List &lt;bean.Salary&gt; return variation in <b>travelling
     * allowance</b> of employee or account.
     */
    public static List<Salary> getDistinctTravellingAllowance(EmpAccounts emp) {
        return DatabaseManager.getData("SELECT s FROM Salary s"
                + " INNER JOIN s.empAccounts emp"
                + " WHERE emp.empAccountsId = " + emp.getEmpAccountsId()
                + " GROUP BY s.basicSalary");
    }

    /**
     * @param st indicates the bean.Student
     * @return List &lt;Object&gt; return <b>total unpaid</b> fees of student
     * (means sum of remaining of fees).
     */
    public static List<Object> getArrears(Student st) {
        return DatabaseManager.getData("SELECT SUM(f.remaining) FROM Fees f"
                + " WHERE f.studentClassReg.student.studentId=" + st.getStudentId());
    }

    /**
     * @param username - Username
     * @param password - Password
     * @return List &lt;bean.TgUser&gt; return List of user which matches given
     * username and password
     */
    public static List<TgUser> login(String username, String password) {
        return DatabaseManager.getData("SELECT us FROM TgUser us "
                + " WHERE us.name = '" + username + "' AND us.password = '" + password + "' AND us.isDeleted = false ");
    }

    /**
     * @param reg - bean.StudentClassReg
     * @param mon - bean.Months
     * @return List &lt;bean.Attendence&gt; return List of attendence of student
     * of given month
     */
    public static List<Attendence> getAttendence(StudentClassReg reg, Months mon) {
        return DatabaseManager.getData("SELECT at FROM Attendence at WHERE "
                + " at.months.monthId=" + mon.getMonthId().intValue()
                + " AND  at.studentClassReg.studentClassRegId=" + reg.getStudentClassRegId().intValue());
    }

    /**
     * @param fromDate - java.util.Date
     * @param toDate - java.util.Date
     * @return List &lt;bean.SmsHistory&gt; return List of SMS send to student
     * from given date to date.
     */
    public static List<SmsHistory> getSMSHistory(java.util.Date fromDate, java.util.Date toDate) {
//        return DatabaseManager.getData("SELECT his FROM SmsHistory his"
//                + " WHERE sendDate BETWEEN "+fromDate + " AND "+toDate );
        List<SmsHistory> list = null;
        Session session = DatabaseManager.openSession();
        try {
            list = session.createCriteria(SmsHistory.class,"sh")
                    .createCriteria("sh.student", "st")
                    .add(Restrictions.between("sh.sendDate", fromDate, toDate))
                    .list();
        } finally {
            session.close();
        }
        return list;
    }

    public static List<StudentClassReg> getStudentClassRegsAll(int yearId, int campusId, boolean includeLeaved) {
        Session session = DatabaseManager.openSession();
        List<StudentClassReg> list = null;
        try {
            Criteria stclRegs = session.createCriteria(StudentClassReg.class, "scr")
                    .createCriteria("scr.years", "y").add(Restrictions.eq("y.yearId", yearId))
                    .createCriteria("scr.campus", "camp").add(Restrictions.eq("camp.campusId", campusId))
                    .createCriteria("scr.student", "st");

            if (!includeLeaved) {
                stclRegs.add(Restrictions.eq("scr.isLeaved", com.school.constant.ConsStudentClassReg.NOT_LEAVED.intValue()));
            }
            list = stclRegs.list();
        } finally {
            session.close();
        }
        return list;
    }

    public static List<StudentClassReg> getStudentClassRegs(int yearId, int campusId, int classId, boolean includeLeaved) {
        Session session = DatabaseManager.openSession();
        List<StudentClassReg> list = null;
        try {
            Criteria stclRegs = session.createCriteria(StudentClassReg.class, "scr")
                    .createCriteria("scr.years", "y").add(Restrictions.eq("y.yearId", yearId))
                    .createCriteria("scr.campus", "camp").add(Restrictions.eq("camp.campusId", campusId))
                    .createCriteria("scr.classes", "cl").add(Restrictions.eq("cl.classId", classId))
                    .createCriteria("scr.student", "st");
            if (!includeLeaved) {
                stclRegs.add(Restrictions.eq("scr.isLeaved", com.school.constant.ConsStudentClassReg.NOT_LEAVED.intValue()));
            }
            list = stclRegs.list();
        } finally {
            session.close();
        }
        return list;
    }

    public static List<Student> getStudentClassRegsWithStudent(int yearId, int campusId, int classId, Integer leaved, SimpleExpression expr) {
        Session session = DatabaseManager.openSession();
        List<Student> list = null;
        try {
            Criteria stclRegs = session.createCriteria(Student.class,"st")
                    .createCriteria("st.studentClassRegs", "scr")
                    .createCriteria("scr.years", "y").add(Restrictions.eq("y.yearId", yearId))
                    .createCriteria("scr.campus", "camp").add(Restrictions.eq("camp.campusId", campusId))
                    .createCriteria("scr.classes", "cl").add(Restrictions.eq("cl.classId", classId))
                    ;
            if (leaved != null) {
                stclRegs.add(Restrictions.eq("scr.isLeaved", leaved));
            }
            if (expr != null) {
                stclRegs.add(expr);
            }
            stclRegs.addOrder(Order.asc("st.studentName"));

            list = stclRegs.list();
        } finally {
            session.close();
        }
        return list;
    }

    public static List<StudentClassReg> getStudentClassRegs(int yearId, int campusId, int classId, boolean includeLeaved, SimpleExpression expr) {
        Session session = DatabaseManager.openSession();
        List<StudentClassReg> list = null;
        try {
            Criteria stclRegs = session.createCriteria(StudentClassReg.class, "scr")
                    .createCriteria("scr.student", "st")
                    .createCriteria("scr.years", "y").add(Restrictions.eq("y.yearId", yearId))
                    .createCriteria("scr.campus", "camp").add(Restrictions.eq("camp.campusId", campusId))
                    .createCriteria("scr.classes", "cl").add(Restrictions.eq("cl.classId", classId));
            if (!includeLeaved) {
                stclRegs.add(Restrictions.eq("scr.isLeaved", com.school.constant.ConsStudentClassReg.NOT_LEAVED.intValue()));
            }
            if (expr != null) {
                stclRegs.add(expr);
            }
            list = stclRegs.list();
        } finally {
            session.close();
        }
        return list;
    }

    public static List<Object[]> getStudentClassRegs(int yearId, int campusId, int classId, Months monthFrom, Months monthTo) {
        Session session = DatabaseManager.openSession();
        List<Object[]> list = null;
        try {
            Criteria cr = session.createCriteria(StudentClassReg.class, "scr")
                    .createCriteria("scr.student", "st")
                    .createCriteria("scr.years", "y").add(Restrictions.eq("y.yearId", yearId))
                    .createCriteria("scr.campus", "camp").add(Restrictions.eq("camp.campusId", campusId))
                    .createCriteria("scr.classes", "cl").add(Restrictions.eq("cl.classId", classId))
                    .createCriteria("scr.attendences", "at").setProjection(Projections.projectionList()
                    .add(Projections.sum("at.presentDays"))
                    .add(Projections.sum("at.totalDays"))
                    .add(Projections.property("st.studentName"))
                    .add(Projections.property("st.fatherName"))
                    .add(Projections.property("st.grNo"))
                    .add(Projections.groupProperty("scr.studentClassRegId"))).add(Restrictions.between("at.months", monthFrom, monthTo));
            list = cr.list();
        } finally {
            session.close();
        }
        return list;
    }

    public static List<StudentClassReg> getStudentClassRegsOrderByStudent(int yearId, int campusId, int classId, boolean includeLeaved) {
        Session session = DatabaseManager.openSession();
        List<StudentClassReg> list = null;
        try {
            Criteria stclRegs = session.createCriteria(StudentClassReg.class, "scr")
                    .createCriteria("scr.years", "y").add(Restrictions.eq("y.yearId", yearId))
                    .createCriteria("scr.classes", "cl").add(Restrictions.eq("cl.classId", classId))
                    .createCriteria("scr.campus", "camp").add(Restrictions.eq("camp.campusId", campusId))
                    .createCriteria("scr.student", "st").addOrder(Order.asc("st.studentName"));
            if (!includeLeaved) {
                stclRegs.add(Restrictions.eq("scr.isLeaved", com.school.constant.ConsStudentClassReg.NOT_LEAVED.intValue()));
            }
            list = stclRegs.list();
        } finally {
            session.close();
        }
        return list;
    }

    public static List<StudentClassReg> getStudentClassRegs(int yearId, int campusId, int classId, Integer studentId) {
        Session session = DatabaseManager.openSession();
        List<StudentClassReg> list = null;
        try {
            Criteria cr = session.createCriteria(StudentClassReg.class)
                    .add(Restrictions.eq("student.studentId", studentId))
                    .add(Restrictions.eq("campus.campusId", campusId))
                    .add(Restrictions.eq("years.yearId", yearId))
                    .add(Restrictions.eq("classes.classId", classId));
            list = cr.list();
        } finally {
            session.close();
        }
        return list;
    }

    public static List<StudentClassReg> getStudentClassRegs(int yearId, int classId, boolean isLeaved) {
        Session session = DatabaseManager.openSession();
        List<StudentClassReg> list = null;
        try {
            Criteria cr = session.createCriteria(StudentClassReg.class, "scr")
                    .createCriteria("scr.years", "y").add(Restrictions.eq("y.yearId", yearId))
                    .createCriteria("scr.campus", "camp");
            cr.createCriteria("scr.classes", "cl").add(Restrictions.eq("cl.classId", classId));
            cr.add(Restrictions.eq("scr.isLeaved", isLeaved ? com.school.constant.ConsStudentClassReg.LEAVED.intValue() : com.school.constant.ConsStudentClassReg.NOT_LEAVED.intValue()));
            list = cr.list();
        } finally {
            session.close();
        }
        return list;
    }

    public static List<StudentClassReg> getStudentClassRegsWithStudent(Integer yearId, Integer classId, boolean isLeaved) {
        Session session = DatabaseManager.openSession();
        List<StudentClassReg> list = null;
        try {
            Criteria cr = session.createCriteria(StudentClassReg.class, "scr")
                    .createCriteria("scr.years", "y").add(Restrictions.eq("y.yearId", yearId))
                    .createCriteria("scr.campus", "camp")
                    .createCriteria("scr.student", "st");
            cr.createCriteria("scr.classes", "cl").add(Restrictions.eq("cl.classId", classId));
            cr.add(Restrictions.eq("scr.isLeaved", isLeaved ? com.school.constant.ConsStudentClassReg.LEAVED.intValue() : com.school.constant.ConsStudentClassReg.NOT_LEAVED.intValue()));
            list = cr.list();
        } finally {
            session.close();
        }
        return list;
    }

    public static List<StudentClassReg> getStudentClassRegs(Student std) {
        Session session = DatabaseManager.openSession();
        List<StudentClassReg> list = null;
        try {
            Criteria cr = session.createCriteria(StudentClassReg.class, "scr")
                    .createCriteria("scr.years", "y")
                    .createCriteria("scr.campus", "cm");
            cr.add(Restrictions.eq("scr.student", std));
            cr.addOrder(Order.desc("scr.studentClassRegId"));
            list = cr.list();
        } finally {
            session.close();
        }
        return list;
    }

    public static StudentClassReg getStudentClassRegsFirst(Student std) {
        Session session = DatabaseManager.openSession();
        List<StudentClassReg> list = null;
        try {
            Criteria cr = session.createCriteria(StudentClassReg.class, "scr")
                    .createCriteria("scr.classes", "cl");
            cr.add(Restrictions.eq("scr.student", std));
            cr.addOrder(Order.desc("scr.studentClassRegId"));
            cr.setFirstResult(0);
            cr.setMaxResults(1);
            list = cr.list();
        } finally {
            session.close();
        }
        return list.get(0);
    }

    public static StudentClassReg getStudentClassRegLast(Student std, boolean isLeaved) {
        Session session = DatabaseManager.openSession();
        List<StudentClassReg> list = null;
        try {
            Criteria cr = session.createCriteria(StudentClassReg.class, "scr")
                    .createCriteria("scr.years", "y")
                    .add(Restrictions.eq("scr.isLeaved", isLeaved ? com.school.constant.ConsStudentClassReg.LEAVED : com.school.constant.ConsStudentClassReg.NOT_LEAVED))
                    .add(Restrictions.eq("scr.student", std))
                    .addOrder(Order.desc("y.yearName"));
            list = cr.list();
            if (!list.isEmpty()) {
                return (list.get(0));
            }
        } finally {
            session.close();
        }
        return null;
    }

    public static List<Object[]> getFieldForChart(Years batch, Campus campus, boolean isLeaved) {
        Session session = DatabaseManager.openSession();
        List<Object[]> list = null;
        try {
            list = session.createCriteria(StudentClassReg.class, "scr")
                    .createCriteria("scr.classes", "cl")
                    .add(Restrictions.eq("scr.years", batch))
                    .add(Restrictions.eq("scr.isLeaved", isLeaved ? com.school.constant.ConsStudentClassReg.LEAVED : com.school.constant.ConsStudentClassReg.NOT_LEAVED))
                    .add(Restrictions.eq("scr.campus", campus))
                    .setProjection(Projections.projectionList()
                    .add(Projections.property("cl.className"))
                    .add(Projections.count("scr.studentClassRegId"))
                    .add(Projections.groupProperty("cl.classId")))
                    .list();
        } finally {
            session.close();
        }
        return list;
    }

    public static List getExamResult(Integer examTypeId, Integer subjectId, Integer studentClassRegId) {
        Session session = DatabaseManager.openSession();
        try {
            return session.createCriteria(ExamResult.class, "er")
                    .add(Restrictions.eq("er.examType.examTypeId", examTypeId))
                    .add(Restrictions.eq("er.subjects.subjectId", subjectId))
                    .createCriteria("er.studentClassReg", "scr")
                    .add(Restrictions.eq("scr.studentClassRegId", studentClassRegId))
                    .list();
        } finally {
            session.close();
        }
    }

    public static List<Subjects> getSubjects(Integer classId, boolean currentSubject) {
        Session session = DatabaseManager.openSession();
        List<Subjects> list = null;
        try {
            Criteria ct = session.createCriteria(Subjects.class)
                    .add(Restrictions.eq("classes.classId", classId));

            if (currentSubject) {
                ct.add(Restrictions.eq("isOld", ConsSubject.NOT_OLD));
            }
            list = ct.list();
        } finally {
            session.close();
        }
        return list;
    }

    public static List<FeesStructure> getFeesStructure(Integer campusId, Integer classId) {
        Session session = DatabaseManager.openSession();
        List<FeesStructure> list = null;
        try {
            Criteria ct = session.createCriteria(FeesStructure.class, "fs")
                    .createCriteria("fs.campus", "cam").add(Restrictions.eq("cam.campusId", campusId))
                    .createCriteria("fs.classes", "cl").add(Restrictions.eq("cl.classId", classId));
            list = ct.list();
        } finally {
            session.close();
        }
        return list;
    }

    public static List<EmpAccounts> getEmpAccounts(Campus camp, EmpAccountCategory cat, boolean includeLeaved) {
        Session session = DatabaseManager.openSession();
        List<EmpAccounts> list = null;
        try {
            Criteria ct = session.createCriteria(EmpAccounts.class, "emp")
                    .createCriteria("emp.campus", "camp")
                    .add(Restrictions.eq("emp.deleted", false))
                    .add(Restrictions.eq("emp.campus", camp))
                    .add(Restrictions.eq("emp.empAccountCategory", cat))
                    .addOrder(Order.desc("emp.name"));
            if (!includeLeaved) {
                ct.add(Restrictions.isNull("emp.leavingDate"));
            }
            list = ct.list();
        } finally {
            session.close();
        }
        return list;
    }

    public static List<EmpAccounts> getEmpAccounts(Object obCamp, EmpAccountCategory cat, boolean isLeaved) {
        Session session = DatabaseManager.openSession();
        List<EmpAccounts> list = null;
        try {
            Criteria ct = session.createCriteria(EmpAccounts.class, "em")
                    .createCriteria("em.campus", "cm");

            if (obCamp instanceof Campus) {
                Campus camp = (Campus) obCamp;
                ct.add(Restrictions.eq("em.campus", camp));
            } else {
            }

            if (cat != null) {
                ct.add(Restrictions.eq("em.empAccountCategory", cat));
            }
            ct.add(Restrictions.eq("em.deleted", false));
            ct.addOrder(Order.asc("em.orderNo"));

            if (!isLeaved) {
                ct.add(Restrictions.isNull("em.leavingDate"));
            } else {
                ct.add(Restrictions.isNotNull("em.leavingDate"));
            }
            list = ct.list();
        } finally {
            session.close();
        }
        return list;
    }

    public static List<Student> getStudentForFee(Integer studentId, Integer monthId) {
        Session session = DatabaseManager.openSession();
        List<Student> list = null;
        try {
            Criteria ct = session.createCriteria(Student.class, "st")
                    .add(Restrictions.eq("st.studentId", studentId))
                    .createCriteria("st.studentClassRegs", "scr")
                    .createCriteria("scr.feeses", "fe")
                    .createCriteria("fe.months", "mo").add(Restrictions.eq("mo.monthId", monthId));
            list = ct.list();
        } finally {
            session.close();
        }
        return list;
    }

    public static List<StudentClassReg> getStudentClassRegsForFee(Integer yearId, Integer campusId, boolean allStudent, Integer classId, boolean includeLeaved, boolean oneMonth, boolean twoMonth) {
        Session session = DatabaseManager.openSession();
        List<StudentClassReg> list = null;
        try {
            Criteria stclRegs = session.createCriteria(StudentClassReg.class, "scr")
                    .createCriteria("scr.student", "st")
                    .createCriteria("scr.years", "y").add(Restrictions.eq("y.yearId", yearId))
                    .createCriteria("scr.campus", "camp").add(Restrictions.eq("camp.campusId", campusId));
            if (!allStudent) {
                stclRegs.createCriteria("scr.classes", "cl").add(Restrictions.eq("cl.classId", classId));
            }

            if (!includeLeaved) {
                stclRegs.add(Restrictions.eq("scr.isLeaved", com.school.constant.ConsStudentClassReg.NOT_LEAVED));
            }

            if (oneMonth && twoMonth) {
            } else if (oneMonth) {
                stclRegs.add(Restrictions.eq("st.oneMonth", true));
            } else {
                stclRegs.add(Restrictions.eq("st.oneMonth", false));
            }

            list = stclRegs.list();

        } finally {
            session.close();
        }
        return list;
    }

    public static List<UserPrivilege> getPrivileges(TgUser user) {
        Session session = DatabaseManager.openSession();
        List<UserPrivilege> list = null;
//        String hql = "SELECT up FROM UserPrivilege up "
//                + "  INNER JOIN up.tgUser tu "
//                + "  INNER JOIN up.module mo "
//                + " WHERE tu.id = "+user.getId();
        try {
            Criteria ct = session.createCriteria(UserPrivilege.class,"up")
                    .createCriteria("up.module","mo")
                    .add(Restrictions.eq("up.tgUser", user));
//            list = DatabaseManager.getData(hql);
            list = ct.list();
        } finally {
            session.close();
        }
        return list;
    }

    public static List<Object[]> getFees(Student st) {
        List<Object[]> list = null;
        String hql = "SELECT fe, y.yearName, mn.monthName "
                + "  FROM Fees fe "
                + "  INNER JOIN fe.studentClassReg scr "
                + "  INNER JOIN scr.student st "
                + "  INNER JOIN fe.months mn "
                + "  INNER JOIN mn.years y "
                + "  WHERE st.studentId = " + st.getStudentId();
        list = DatabaseManager.getData(hql);

        return list;
    }

    public static List<FeesDiscount> getFeesDiscounts(Student st) {
        Session session = DatabaseManager.openSession();
        List<FeesDiscount> list = null;
        try {
            Criteria ct = session.createCriteria(FeesDiscount.class, "fe")
                    .add(Restrictions.eq("fe.student", st));
            list = ct.list();
        } finally {
            session.close();
        }
        return list;
    }

    public static List<StudentAttachment> getStudentAttachements(Student st) {
        Session session = DatabaseManager.openSession();
        List<StudentAttachment> list = null;
        try {
            Criteria ct = session.createCriteria(StudentAttachment.class, "at")
                    .add(Restrictions.eq("at.student", st));
            list = ct.list();
        } finally {
            session.close();
        }
        return list;
    }

    public static List<ExamResult> getExamResult(StudentClassReg reg) {
        Session session = DatabaseManager.openSession();
        List<ExamResult> list = null;
        try {
            Criteria ct = session.createCriteria(ExamResult.class, "er")
                    .createCriteria("er.examType", "et")
                    .createCriteria("er.subjects", "sub")
                    .add(Restrictions.eq("er.studentClassReg", reg));
            list = ct.list();
        } finally {
            session.close();
        }
        return list;
    }

    public static List<StudentCertificateIssue> getStudentCertificateIssued(Student st) {
        Session session = DatabaseManager.openSession();
        List<StudentCertificateIssue> list = null;
        try {
            Criteria ct = session.createCriteria(StudentCertificateIssue.class, "sci")
                    .add(Restrictions.eq("sci.student", st));
            list = ct.list();
        } finally {
            session.close();
        }
        return list;
    }

    public static List<Classes> getClasses(Section sec) {
        Session session = DatabaseManager.openSession();
        List<Classes> list = null;
        try {
            Criteria ct = session.createCriteria(Classes.class, "cl")
                    .add(Restrictions.eq("cl.section", sec));
            list = ct.list();
        } finally {
            session.close();
        }
        return list;
    }

    public static void updateStudentClassRegLeaved(Student st) {
        Session session = DatabaseManager.openSession();
        try {
            String hql = "Update StudentClassReg scr set scr.isLeaved = :leaved where scr.student = :std ";
            Transaction tr = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter("leaved", com.school.constant.ConsStudentClassReg.LEAVED);
            query.setParameter("std", st);
            tr.commit();
        } finally {
            session.close();
        }

    }

    public static List<EmpAccountAttachment> getEmpAccountAttachements(EmpAccounts emp) {
        Session session = DatabaseManager.openSession();
        List<EmpAccountAttachment> list = null;
        try {
            Criteria ct = session.createCriteria(EmpAccountAttachment.class, "at")
                    .add(Restrictions.eq("at.empAccounts", emp));
            list = ct.list();
        } finally {
            session.close();
        }
        return list;
    }

    public static List<Salary> getSalaries(EmpAccounts emp) {
        Session session = DatabaseManager.openSession();
        List<Salary> list = null;
        try {
            Criteria ct = session.createCriteria(Salary.class, "sal")
                    .createCriteria("sal.months", "mn")
                    .createCriteria("mn.years", "y")
                    .add(Restrictions.eq("sal.empAccounts", emp));
            list = ct.list();
        } finally {
            session.close();
        }
        return list;
    }

    public static List<Object[]> getSalaries(Months mon) {
        List<Object[]> list = null;
        String hql = "SELECT emp.name, emp.father, sal.amount, camp.name,emp.bankAccountNo "
                + " FROM Salary sal "
                + " INNER JOIN sal.months mon "
                + " INNER JOIN mon.years y "
                + " INNER JOIN sal.empAccounts emp "
                + " INNER JOIN emp.campus camp "
                + " WHERE mon.monthId = " + mon.getMonthId();
        list = DatabaseManager.getData(hql);
        
        return list;
    }

    public static List<PaySlipReportBean> getPaySlipReportBeans(Months mon) {
        Session session = DatabaseManager.openSession();
        List<PaySlipReportBean> list = new ArrayList<>();
        try {
            String hql = "SELECT "
                    + " sal.basicSalary,sal.travellingAllowance,"
                    + " sal.otherAllowance,sal.coordinateAllowace,"
                    + " sal.fiveYearAllowance,sal.medicalAllowance,"
                    + " sal.ctAllowance,sal.headAllowance,"
                    + " sal.workingDays,sal.deposit,sal.casualLeave,"
                    + " sal.warning,sal.late,sal.wentEarly,"
                    + " sal.other,sal.bonus,"
                    + " emp.name,y.yearName,sal.amount,"
                    + " sal.casualLeaveRemarks, emp.staffId,camp.name,"
                    + " emp.joiningDate,emp.bankAccountNo "
                    + " FROM Salary sal "
                    + " INNER JOIN sal.months mon "
                    + " INNER JOIN mon.years y "
                    + " INNER JOIN sal.empAccounts emp "
                    + " INNER JOIN emp.campus camp "
                    + " WHERE mon.monthId = " + mon.getMonthId();
            List<Object[]> listObjectArray = DatabaseManager.getData(hql);
            int size = listObjectArray.size();
            for (int i = 0; i < size; i++) {
                Object[] objects = listObjectArray.get(i);
                PaySlipReportBean paySlipReportBean = new PaySlipReportBean();
                paySlipReportBean.setAmount((Integer) objects[18]);
                paySlipReportBean.setBasicSalary((Integer) objects[0]);
                paySlipReportBean.setBonus((Integer) objects[15]);
                paySlipReportBean.setCampusName((String) objects[21]);
                paySlipReportBean.setCasualLeave((Integer) objects[10]);
                paySlipReportBean.setCasualLeaveRemarks((String) objects[19]);
                paySlipReportBean.setCoordinateAllowace((Integer) objects[3]);
                paySlipReportBean.setCtAllowance((Integer) objects[6]);
                paySlipReportBean.setDeposit((Integer) objects[9]);
                paySlipReportBean.setEmpAccountName((String) objects[16]);
                paySlipReportBean.setEmpId((String) objects[20]);
                paySlipReportBean.setFiveYearAllowance((Integer) objects[4]);
                paySlipReportBean.setHeadAllowance((Integer) objects[7]);
                paySlipReportBean.setJoiningDate((Date) objects[22]);
                paySlipReportBean.setLate((Integer) objects[12]);
                paySlipReportBean.setMedicalAllowance((Integer) objects[5]);
                paySlipReportBean.setMonthName(mon.getMonthName());
                paySlipReportBean.setOther((Integer) objects[14]);
                paySlipReportBean.setOtherAllowance((Integer) objects[2]);
                paySlipReportBean.setSectionName(null);
                paySlipReportBean.setTravellingAllowance((Integer) objects[1]);
                paySlipReportBean.setWarning((Integer) objects[11]);
                paySlipReportBean.setWentEarly((Integer) objects[13]);
                paySlipReportBean.setWorkingDays((Integer) objects[8]);
                paySlipReportBean.setYearName((Integer) objects[17]);

                list.add(paySlipReportBean);
            }

        } finally {
            session.close();
        }
        return list;
    }

    public static List<EmpCertificateIssue> getEmpCertificateIssue(EmpAccounts emp) {
        Session session = DatabaseManager.openSession();
        List<EmpCertificateIssue> list = null;
        try {
            Criteria ct = session.createCriteria(EmpCertificateIssue.class, "cer")
                    .add(Restrictions.eq("cer.empAccounts", emp));
            list = ct.list();
        } finally {
            session.close();
        }
        return list;
    }

    public static List<Designation> getDesignations(EmpAccounts emp) {
        Session session = DatabaseManager.openSession();
        List<Designation> list = null;
        try {
            Criteria ct = session.createCriteria(Designation.class, "dg")
                    .createCriteria("dg.section", "sec")
                    .add(Restrictions.eq("dg.empAccounts", emp));
            list = ct.list();
        } finally {
            session.close();
        }
        return list;
    }

    public static Campus getCampus(EmpAccounts emp) {
        List<Campus> list = DatabaseManager.getData("SELECT cm FROM EmpAccounts emp "
                + " INNER JOIN emp.campus cm where emp.empAccountsId = " + emp.getEmpAccountsId());
        return list.get(0);
    }

    public static List<Awards> getAwards(Event event) {
        Session session = DatabaseManager.openSession();
        List<Awards> list = null;
        try {
            Criteria ct = session.createCriteria(Awards.class, "aw")
                    .createCriteria("aw.student", "st")
                    .add(Restrictions.eq("aw.event", event));
            list = ct.list();
        } finally {
            session.close();
        }
        return list;
    }

    public static void setLastDesignation(ArrayList<EmpAccounts> empAccountList) {
        Session session = DatabaseManager.openSession();
        try {
            for (int i = 0; i < empAccountList.size(); i++) {
                EmpAccounts emp = empAccountList.get(i);
                Criteria ct = session.createCriteria(Designation.class, "ds")
                        .add(Restrictions.eq("ds.empAccounts", emp))
                        .addOrder(Order.desc("ds.id"));
                ct.setFirstResult(0);
                ct.setMaxResults(1);
                Designation designation = (Designation) ct.list().get(0);
                emp.setDesignations(new HashSet());
                emp.getDesignations().add(designation);
            }
        } finally {
            session.close();
        }
    }

    public static List<Event> getEvents(Years year) {
        Session session = DatabaseManager.openSession();
        List<Event> list = null;
        try {
            Criteria ct = session.createCriteria(Event.class, "ev")
                    .add(Restrictions.eq("ev.years", year));
            list = ct.list();
        } finally {
            session.close();
        }
        return list;
    }

    public static List<TgUser> getUsers() {
        Session session = DatabaseManager.openSession();
        List<TgUser> list = null;
        try {
            Criteria ct = session.createCriteria(TgUser.class);
            list = ct.list();
        } finally {
            session.close();
        }
        return list;
    }

    public static List<Months> getMonths(Years y) {
        Session session = DatabaseManager.openSession();
        List<Months> list = null;
        try {
            Criteria ct = session.createCriteria(Months.class, "mn")
                    .createCriteria("mn.years", "y")
                    .add(Restrictions.eq("mn.years", y));
            list = ct.list();

        } finally {
            session.close();
        }
        return list;
    }

    /*
     SELECT S.STUDENT_ID, 
     (SELECT MAX(STUDENT_CLASS_REG_ID) FROM STUDENT_CLASS_REG WHERE STUDENT_ID = S.STUDENT_ID) AS MAX_ENROLL_ID
     FROM STUDENT S;
     */
    /**
     * SELECT S.STUDENT_ID , (SELECT COUNT(STUDENT_CLASS_REG_ID) FROM
     * STUDENT_CLASS_REG WHERE STUDENT_ID = S.STUDENT_ID ) AS TOTAL_REGS ,
     * (SELECT COUNT(DISTINCT(CLASS_ID)) FROM STUDENT_CLASS_REG WHERE STUDENT_ID
     * = S.STUDENT_ID ) AS DISTINCT_REGS FROM STUDENT S WHERE (SELECT
     * COUNT(STUDENT_CLASS_REG_ID) FROM STUDENT_CLASS_REG WHERE STUDENT_ID =
     * S.STUDENT_ID ) > (SELECT COUNT(DISTINCT(CLASS_ID)) FROM STUDENT_CLASS_REG
     * WHERE STUDENT_ID = S.STUDENT_ID );
     */
    /**
     * SELECT SR.STUDENT_ID, COUNT((SR.CLASS_ID)) FROM STUDENT_CLASS_REG SR
     * WHERE SR.CLASS_ID = (SELECT MAX(CLASS_ID) FROM STUDENT_CLASS_REG WHERE
     * STUDENT_ID = SR.STUDENT_ID) AND YEAR_ID = 2 GROUP BY SR.STUDENT_ID HAVING
     * COUNT(CLASS_ID) > 1;
     */
}
