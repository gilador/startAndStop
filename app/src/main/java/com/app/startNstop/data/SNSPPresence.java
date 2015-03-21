package com.app.startNstop.data;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by gilad on 3/12/15.
 */
@Table(name = "SNSPPresence")
public class SNSPPresence extends Model {

    @Column(name = "projectName")
    public SNSProject projectName;

    @Column(name = "startTime")
    public String startTime;

    @Column(name = "endTime")
    public String endTime;

    @Column(name = "startDate")
    public String startDate;

    @Column(name = "endDate")
    public String endDate;


    public SNSPPresence() {
    }

    public SNSPPresence(SNSProject projectName, String startTime, String endTime, String startDate, String endDate) {
        this.projectName = projectName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
