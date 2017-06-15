package com.app.startNstop.presenter;

import android.content.Context;
import android.util.Log;

import com.app.startNstop.model.MainModel;
import com.app.startNstop.model.MainModelImpl;
import com.app.startNstop.model.db.Project;
import com.app.startNstop.view.main.MainView;

import io.realm.RealmResults;

/**
 * Created by gor on 10/05/2017.
 */

public class MainPresenterImpl implements MainPresenter {

    private static final String TAG = MainPresenterImpl.class.getSimpleName();
    private MainModel mModel;
    private MainView  mView;

    public MainPresenterImpl(MainView view, Context context) {
        mModel = new MainModelImpl(this, context);
        mView = view;
    }

    //==============================================================================================
    //                              Interface MainPresenter Impl
    //==============================================================================================

    @Override
    public void createNewProject(String projectName) {
        mView.showProgressBar(true);
        mModel.createNewProject(projectName);
    }

    @Override
    public void punchIn() {

    }

    @Override
    public void punchOut() {

    }

    //==============================================================================================
    //                              Interface IModelListener Impl
    //==============================================================================================
    @Override
    public void onModelStart() {

    }

    @Override
    public void onModelStop() {

    }

    //==============================================================================================
    //                              Interface  MainModelListener Impl
    //==============================================================================================
    @Override
    public void onProjectChange(RealmResults<Project> element, long selectedProject) {
        Log.d(TAG, "onProjectChange");
        mView.showProgressBar(false);
        mView.updateProjectList(element, selectedProject);

    }

    @Override
    public void onProjectSelectedChange(long projectId) {
        mView.updateSelectedProject(projectId);
    }

    //==============================================================================================
    //                              Interface IViewlListener Impl
    //==============================================================================================
    @Override
    public void onViewResume() {
        mModel.start();
//        mView.setSelectedProject(mModel.getSelectedProject());
    }

    @Override
    public void onViewPause() {
        mModel.stop();
    }

    //==============================================================================================
    //                              Interface MainViewListener Impl
    //==============================================================================================
    @Override
    public void onProjectSelected(long projectId) {
        mModel.setSelectedProjectId(projectId);
    }
}
