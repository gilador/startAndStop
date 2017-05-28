package com.app.startNstop.model;

/**
 * Created by gor on 15/05/2017.
 */

public interface MainModel extends IModel {
    void createNewProject(String projectName);

    interface MainModelListener extends IModelListener{

    }
}
