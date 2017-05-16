package com.app.startNstop.DaggerModule;

import com.app.startNstop.model.IMainModel;
import com.app.startNstop.model.MainModelImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gor on 10/05/2017.
 */

@Module
public class ModelModule {

    @Provides
    @Singleton
    IMainModel providesLocationModel(){
        return new MainModelImpl();
    }

}
