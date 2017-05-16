package com.app.startNstop.model;

/**
 * Created by gilad on 16/05/17.
 */

public interface IModel {

    void start();
    void stop();

    interface IModelListener{
        void onModelStart();
        void onModelStop();
    }

}
