package com.app.startNstop.view.android.activity;


import android.support.v7.app.AppCompatActivity;

import com.app.startNstop.presenter.IPresenter;
import com.app.startNstop.view.IView;

/**
 * Created by gor on 26/05/2017.
 */

public abstract class BaseActivity extends AppCompatActivity implements IView{

    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().onViewResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        getPresenter().onViewPause();
    }
}
