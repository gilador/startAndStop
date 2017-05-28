package com.app.startNstop.presenter;

import com.app.startNstop.model.MainModel;
import com.app.startNstop.model.MainModelImpl;
import com.app.startNstop.view.MainView;

/**
 * Created by gor on 10/05/2017.
 */

public class MainPresenterImpl implements MainPresenter {

    MainModel mModel;

    MainView mView;

    public  MainPresenterImpl(MainView view){
        mModel = new MainModelImpl<MainPresenter>(this);
        mView = view;
    }

    //==============================================================================================
    //                              Interface MainPresenter Impl
    //==============================================================================================

    @Override
    public void createNewProject(String projectName) {
        mModel.createNewProject(projectName);
        mView.showProgressBar(true);
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
    //                              Interface IViewlListener Impl
    //==============================================================================================
    @Override
    public void onViewResume() {

    }

    @Override
    public void onViewPause() {

    }
}
