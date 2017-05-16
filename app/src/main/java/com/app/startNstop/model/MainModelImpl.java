package com.app.startNstop.model;

import com.app.startNstop.presenter.IPresenter;

/**
 * Created by gor on 15/05/2017.
 */

public class MainModelImpl<P extends IPresenter> implements IMainModel {
    P mPresenter;

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
