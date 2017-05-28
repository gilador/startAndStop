package com.app.startNstop.view;

import com.app.startNstop.presenter.MainPresenter;

/**
 * Created by gilad on 16/05/17.
 */

public interface MainView extends IView {

    void showProgressBar(boolean isToShow);
    interface MainViewListener extends IViewlListener{

    }
}
