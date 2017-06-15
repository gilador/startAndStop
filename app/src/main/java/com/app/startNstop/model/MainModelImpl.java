package com.app.startNstop.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.app.startNstop.model.db.Project;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Created by gor on 15/05/2017.
 */

public class MainModelImpl implements MainModel {

    public static final  String SELECTED_PROJECT_ID_KEY = "selected_project_id";
    private static final String TAG                     = MainModel.class.getSimpleName();
    private static final String SHARED_PREF_FILE_NAME   = "main_prefs";
    private MainModelListener mMainModelListener;
    private Realm             mRealm;
    private SharedPreferences mPrefs;

    public MainModelImpl(MainModelListener mainModelListener, Context context) {
        mMainModelListener = mainModelListener;
        Realm.init(context);
        mPrefs = context.getSharedPreferences(SHARED_PREF_FILE_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public void start() {
        Log.d(TAG, "start");
        mRealm = Realm.getDefaultInstance();
        queryProjects();
    }

    @Override
    public void stop() {
        mRealm.close();
        mRealm = null;
        Log.d(TAG, "stop");

    }

    @Override
    public void createNewProject(final String projectName) {
        Log.d(TAG, "createNewProject");

        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Project project = mRealm.createObject(Project.class, System.currentTimeMillis());
                project.setName(projectName);
            }
        });
    }

    @Override
    public void setSelectedProjectId(long projectId) {
        Log.d(TAG,"setSelectedProjectId id: " + projectId);
        mPrefs.edit().putLong(SELECTED_PROJECT_ID_KEY, projectId).apply();
        mMainModelListener.onProjectSelectedChange(projectId);
    }

    public long getSelectedProject() {
        long projectId = mPrefs.getLong(SELECTED_PROJECT_ID_KEY, 0);
        Log.d(TAG,"getSelectedProject id: " + projectId);
        return projectId;
    }

    private void queryProjects() {
        RealmResults<Project> result = mRealm.where(Project.class).findAllSortedAsync("date", Sort.DESCENDING);
        mMainModelListener.onProjectChange(result, getSelectedProject());
        result.addChangeListener(new RealmChangeListener<RealmResults<Project>>() {
            @Override
            public void onChange(RealmResults<Project> result1) {
                mMainModelListener.onProjectChange(result1, getSelectedProject());
            }
        });
    }
}
