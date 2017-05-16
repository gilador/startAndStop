package com.app.startNstop.model.db;

import io.realm.RealmObject;

/**
 * Created by gor on 06/05/2017.
 */

public class LogEntery extends RealmObject {

    private Project project;
    private long start;
    private long end;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }
}
