package com.app.startNstop.model;

import com.app.startNstop.model.db.Project;

import io.realm.RealmResults;

/**
 * Created by gor on 15/05/2017.
 */

public interface MainModel extends IModel {
    void createNewProject(String projectName);
    void setSelectedProjectId(long projectId);

    interface MainModelListener extends IModelListener{
        void onProjectChange(RealmResults<Project> element, long selectedProject);
        void onProjectSelectedChange(long projectId);
    }
}
