package org.hbrs.se1.ws23.uebung8_4.Publisher;

import org.hbrs.se1.ws23.uebung8_4.Report.Report;
import org.hbrs.se1.ws23.uebung8_4.Report.SkillReport;
import org.hbrs.se1.ws23.uebung8_4.Subcriber.Subcriber;

import java.util.HashMap;
import java.util.List;

/**
 * @author dwang2s
 */
public class SkillReportPublisher extends Publisher{
    private HashMap<Integer, SkillReport> dataList;

    public SkillReportPublisher(List<Subcriber> subscribers, HashMap<Integer, SkillReport> dataList) {
        super(subscribers);
        this.dataList = dataList;
    }
    public void produce(){
        int id = 1;
        SkillReport report = dataList.get(1);
        notify(report.getReportID(),report.getSkill());
    }
    public Report getSkillReport(Integer id){
        return dataList.get(id);
    }
}
