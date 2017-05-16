package com.app.startNstop.view.android.activity;

import android.support.v7.app.AppCompatActivity;

import com.app.startNstop.view.IView;


/**
 * Created by gor on 12/05/2017.
 */

public abstract class BaseActivity<V extends IView> extends AppCompatActivity {

    abstract V getView();

    protected void onResume() {
        super.onResume();
        getView().onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        getView().onPause();
    }

}
