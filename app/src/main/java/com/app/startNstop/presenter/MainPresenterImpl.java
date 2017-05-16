package com.app.startNstop.presenter;

import com.app.startNstop.model.MainModelImpl;
import com.app.startNstop.view.MainViewImpl;

import javax.inject.Inject;

/**
 * Created by gor on 10/05/2017.
 */

public class MainPresenterImpl<MainView> implements MainPresenter {

    @Inject
    MainModelImpl mModel;

    @Inject
    MainViewImpl mView;



    @Override
    public void onModelStart() {

    }

    @Override
    public void onModelStop() {

    }

    @Override
    public void onViewResume() {

    }

    @Override
    public void onViewPause() {

    }
}
