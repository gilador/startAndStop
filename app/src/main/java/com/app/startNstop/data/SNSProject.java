package com.app.startNstop.data;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by gilad on 3/12/15.
 */
@Table(name = "SNSProject")
public class SNSProject extends Model {

    @Column(name = "ProjectName")
    public String projectName;

    public static List<SNSProject> getAll() {
        return new Select()
                .from(SNSProject.class).orderBy("ProjectName ASC")
                .execute();
    }

}
