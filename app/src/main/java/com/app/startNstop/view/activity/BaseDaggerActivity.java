package com.app.startNstop.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import gor.gettplaces.presenter.IPresenter;
import gor.gettplaces.view.IView;

/**
 * Created by gor on 12/05/2017.
 */

public abstract class BaseDaggerActivity<T> extends AppCompatActivity {

    abstract IPresenter<View> getPresenter();

    protected void onResume() {
        super.onResume();
        getPresenter().onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        getPresenter().onPause();
    }

}
