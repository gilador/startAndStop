package com.app.startNstop.view;

/**
 * Created by gilad on 16/05/17.
 */

public interface IView{
    void onResume();
    void onPause();

    interface IViewlListener {
        void onViewResume();
        void onViewPause();
    }
}
