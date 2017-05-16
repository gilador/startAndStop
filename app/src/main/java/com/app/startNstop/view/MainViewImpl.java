package com.app.startNstop.view;

import com.app.startNstop.presenter.IPresenter;

/**
 * Created by gilad on 16/05/17.
 */

public class MainViewImpl<P extends IPresenter> implements MainView {

    P mPresenter;

    public MainViewImpl(P presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onResume() {
        mPresenter.onViewResume();
    }

    @Override
    public void onPause() {
        mPresenter.onViewPause();
    }
}
