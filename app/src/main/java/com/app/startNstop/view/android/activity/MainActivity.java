package com.app.startNstop.view.android.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.MediaRouteButton;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.app.startNstop.R;
import com.app.startNstop.model.db.Project;
import com.app.startNstop.presenter.IPresenter;
import com.app.startNstop.presenter.MainPresenter;
import com.app.startNstop.presenter.MainPresenterImpl;
import com.app.startNstop.view.MainView;
import com.app.startNstop.view.android.adapter.ProjectsAdapter;
import com.app.startNstop.view.android.fragment.NewProjectDialogFragment;
import com.singh.daman.proprogressviews.DottedArcProgress;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import io.realm.Sort;


public class MainActivity extends BaseActivity implements MainView, View.OnClickListener {

    //==============================================================================================
    //                              Statics
    //==============================================================================================
    private static final String TAG = MainActivity.class.getSimpleName();

    //==============================================================================================
    //                              Privates
    //==============================================================================================
    private MainPresenter mMainPresenter;
    private Realm         mRealm;

    private RecyclerView      mProjectTilesList;
    private Button            mFab;
    private ProjectsAdapter   mProjectAdapter;
    private DottedArcProgress mProgress;

    //==============================================================================================
    //                              BaseActivity
    //==============================================================================================
    @Override
    public IPresenter getPresenter() {
        return mMainPresenter;
    }

    //==============================================================================================
    //                              Activity Impl
    //==============================================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRealm = Realm.getDefaultInstance();
        mMainPresenter = new MainPresenterImpl<>(this);
        initUi();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRealm.close();
    }

    //==============================================================================================
    //                              Interface MainView
    //==============================================================================================
    @Override
    public void showProgressBar(boolean isToShow) {
        int visibility = isToShow ? View.VISIBLE : View.GONE;
        mProgress.setVisibility(visibility);
    }

    //==============================================================================================
    //                              Interface View.OnClickListener Impl
    //==============================================================================================
    @Override
    public void onClick(View v) {
        if (v.getId() == mFab.getId()) {
            showNewProjectDialog();
        }
    }

    //==============================================================================================
    //                              Private methods
    //==============================================================================================

    private void initUi() {

        initFindElements();

        initUiList();

        initListener();

    }

    private void initUiList() {
        RealmResults<Project> result = mRealm.where(Project.class).findAllSortedAsync("date", Sort.DESCENDING);
        result.addChangeListener(new RealmChangeListener<RealmResults<Project>>() {
            @Override
            public void onChange(RealmResults<Project> element) {
                mProjectAdapter = new ProjectsAdapter(element, true);
//                mProjectTilesList.setAdapter(mProjectAdapter);
            }
        });

    }

    private void initListener() {
        mFab.setOnClickListener(this);
    }

    private void initFindElements() {
        mProjectTilesList = (RecyclerView) findViewById(R.id.projectTilesList);
        mFab = (Button) findViewById(R.id.fabButton);
    }

    private void showNewProjectDialog() {
        FragmentTransaction ft   = getFragmentManager().beginTransaction();
        Fragment            prev = getFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        // Create and show the dialog.
        NewProjectDialogFragment newFragment = new NewProjectDialogFragment();
        newFragment.setPresenter(mMainPresenter);
        newFragment.show(ft, "dialog");
    }
}
