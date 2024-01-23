package org.hbrs.se1.ws23.uebung8_4.Report;

/**
 * @author dwang2s
 */
public class SkillReport extends Report{
    String skill, studentID;
    public SkillReport(Integer reportID,String skill,String studentID) {
        super(reportID);
        this.skill = skill;
        this.studentID = studentID;
    }
    @Override
    public int setReportID(Integer id) {
        this.reportID = reportID;
        return reportID;
    }

    public String getSkill() {
        return skill;
    }

    public String getStudentID() {
        return studentID;
    }
}
