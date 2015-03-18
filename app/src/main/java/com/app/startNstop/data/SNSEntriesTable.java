package com.app.startNstop.data;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by gilad on 3/12/15.
 */
@Table(name = "SNSEntriesTable")
public class SNSEntriesTable extends Model {

    @Column(name = "SNSProjectsTable")
    public SNSProjects projectName;

    @Column(name = "startTime")
    public String startTime;

    @Column(name = "endTime")
    public String endTime;

    @Column(name = "startDate")
    public String startDate;

    @Column(name = "endDate")
    public String endDate;


    public SNSEntriesTable() {
    }

}
