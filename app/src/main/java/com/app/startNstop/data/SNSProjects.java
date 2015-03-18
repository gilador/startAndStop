package com.app.startNstop.data;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by gilad on 3/12/15.
 */
@Table(name = "SNSProjectsTable")
public class SNSProjects extends Model {

    @Column(name = "ProjectName")
    public String projectName;



    public SNSProjects() {
    }

}
