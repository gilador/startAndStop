package com.app.startNstop;

import android.app.Application;

import com.app.startNstop.model.MainModel;
import com.app.startNstop.model.MainModelImpl;
import com.app.startNstop.presenter.MainPresenter;
import com.app.startNstop.presenter.MainPresenterImpl;
import com.app.startNstop.view.MainView;

/**
 * Created by gor on 11/05/2017.
 */

public class SNSApplication extends Application {

//    /**
//     * Newly added modules must be added to the @Component annotation here. You must also provide
//     * further inject() methods for new classes that want to perform injection.
//     */
//    @SingletAon
//    @Component(modules = {PresenterModule.class, ModelModule.class})
//    public interface ApplicationComponent {
//        void inject(MainActivity mainActivity);
//    }

    @Override
    public void onCreate() {
        super.onCreate();

        // This setups up the component which is used by other views (activities/fragments/etc., not Android views) for injection.
        // This pulls all modules which have statically declared @Provides methods automatically.
//        component = DaggerSNSApplication_ApplicationComponent.builder().build();

    }

//    public ApplicationComponent getComponent() {
//        return component;
//    }
}
