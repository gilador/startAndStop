package com.app.startNstop.view;

import com.app.startNstop.presenter.MainPresenterImpl;

/**
 * Created by gilad on 16/05/17.
 */
public class MainViewImpl<V extends MainView.MainViewlListener> implements MainView {

    V mViewListener;

    public MainViewImpl(V viewListener) {
        mViewListener = viewListener;
    }

    @Override
    public void onResume() {
        mViewListener.onViewResume();
    }

    @Override
    public void onPause() {
        mViewListener.onViewPause();
    }
}
