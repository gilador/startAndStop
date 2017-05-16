package com.app.startNstop.view;

/**
 * Created by gilad on 16/05/17.
 */
public class MainViewImpl<P extends MainView.MainViewlListener> implements MainView {

    P mViewListener;

    public MainViewImpl(P viewListener) {
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
