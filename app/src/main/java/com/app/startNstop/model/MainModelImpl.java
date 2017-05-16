package com.app.startNstop.model;

/**
 * Created by gor on 15/05/2017.
 */

public class MainModelImpl<P extends MainModel.MainModelListener> implements MainModel {
    P mMainModelListener;

    public MainModelImpl(P mainModelListener){
        mMainModelListener = mainModelListener;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
