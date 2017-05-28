package com.app.startNstop.presenter;

import com.app.startNstop.model.MainModel;
import com.app.startNstop.view.MainView;

/**
 * Created by gor on 10/05/2017.
 */

public interface MainPresenter extends IPresenter, MainModel.MainModelListener, MainView.MainViewListener {
    void createNewProject(String projectName);
}
