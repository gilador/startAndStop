package com.app.startNstop.view;

import com.app.startNstop.presenter.IPresenter;

/**
 * Created by gilad on 16/05/17.
 */

public interface IView{

    IPresenter getPresenter();

    interface IViewlListener {
        void onViewResume();
        void onViewPause();
    }
}
