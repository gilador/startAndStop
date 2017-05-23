package com.app.startNstop.presenter;

import com.app.startNstop.model.MainModel;
import com.app.startNstop.model.MainModelImpl;
import com.app.startNstop.view.MainViewImpl;

import javax.inject.Inject;

/**
 * Created by gor on 10/05/2017.
 */

public class MainPresenterImpl<MainView> implements MainPresenter {

    MainModel mModel;

    MainView mView;

    public  MainPresenterImpl(MainView view){
        mModel = new MainModelImpl<MainPresenter>(this);
        mView = view;
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

    @Override
    public void onNewProjectDemand() {

    }
}
