package com.app.startNstop.DaggerModule;

import com.app.startNstop.presenter.MainPresenter;
import com.app.startNstop.presenter.MainPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gor on 10/05/2017.
 */

@Module
public class PresenterModule {

    @Provides
    @Singleton
    public MainPresenter providesMainPresenter() {
        return new MainPresenterImpl(null,null);
    }

}
