package org.hbrs.se1.ws23.uebung8_4.Report;

import org.hbrs.se1.ws23.uebung8_4.Subcriber.Subcriber;

/**
 * @author dwang2s
 */
public abstract class Report implements Subcriber {
    Integer reportID;
    public Report(Integer reportID) {
        this.reportID = reportID;
    }
    public abstract int setReportID(Integer id);
    public Integer getReportID() {
        return reportID;
    }
}
