package com.app.startNstop.DaggerModule;

import com.app.startNstop.model.MainModel;
import com.app.startNstop.presenter.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import gor.gettplaces.model.ILocationModel;
import gor.gettplaces.presenter.MainPresenter;
import gor.gettplaces.presenter.MainPresenterImpl;

/**
 * Created by gor on 10/05/2017.
 */

@Module
public class PresenterModule {


    @Provides
    @Singleton
    MainPresenter providesMainPresenter(MainModel locationModel){
        return new MainPresenterImpl(locationModel);
    }

}
