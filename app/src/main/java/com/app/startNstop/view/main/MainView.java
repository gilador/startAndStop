package com.app.startNstop.view.main;

import com.app.startNstop.model.db.Project;
import com.app.startNstop.presenter.MainPresenter;
import com.app.startNstop.view.IView;

import io.realm.RealmResults;

/**
 * Created by gilad on 16/05/17.
 */

public interface MainView extends IView {

    void showProgressBar(boolean isToShow);
    void updateProjectList(RealmResults<Project> result, long selectedProject);
    void updateSelectedProject(long projectId);

    interface MainViewListener extends IViewlListener{
        void onProjectSelected(long projectId);
    }
}
