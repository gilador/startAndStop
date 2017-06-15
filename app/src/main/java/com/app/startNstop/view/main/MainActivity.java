package com.app.startNstop.view.main;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.startNstop.R;
import com.app.startNstop.model.db.Project;
import com.app.startNstop.presenter.IPresenter;
import com.app.startNstop.presenter.MainPresenter;
import com.app.startNstop.presenter.MainPresenterImpl;
import com.app.startNstop.view.android.SNSWidget;
import com.app.startNstop.view.android.activity.BaseActivity;
import com.app.startNstop.view.android.adapter.ProjectsAdapter;
import com.app.startNstop.view.android.fragment.NewProjectDialogFragment;
import com.singh.daman.proprogressviews.DottedArcProgress;

import io.realm.RealmResults;


public class MainActivity extends BaseActivity implements MainView, View.OnClickListener, SNSWidget.OnChangeListener {

    //==============================================================================================
    //                              Statics
    //==============================================================================================
    private static final String TAG = MainActivity.class.getSimpleName();

    //==============================================================================================
    //                              Privates
    //==============================================================================================
    private MainPresenter mMainPresenter;

    private SNSWidget         mSnsWidget;
    private RecyclerView      mProjectTilesList;
    private Button            mFab;
    private ProjectsAdapter   mProjectAdapter;
    private DottedArcProgress mProgress;
    private TextView          mTimeCounter;

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
        mMainPresenter = new MainPresenterImpl(this, getApplicationContext());
        initUi();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    //==============================================================================================
    //                              Interface MainView
    //==============================================================================================
    @Override
    public void showProgressBar(boolean isToShow) {
        int visibility = isToShow ? View.VISIBLE : View.GONE;
        mProgress.setVisibility(visibility);
    }

    @Override
    public void updateProjectList(RealmResults<Project> result, long selectedProject) {
        Log.d(TAG, "updateProjectList, size:" + result.size());
        if (result != null && result.size() > 0) {
            if (mProjectAdapter != null) {
                mProjectAdapter.update(result);
            } else {
                mProjectAdapter = new ProjectsAdapter(result, mMainPresenter);
                mProjectTilesList.setAdapter(mProjectAdapter);
            }
        }
        setSelectedProject(selectedProject);
    }

    @Override
    public void updateSelectedProject(long selectedProject) {
        setSelectedProject(selectedProject);
    }

    public void setSelectedProject(long selectedProjectId) {
        if (mProjectAdapter != null) {
            int pos = mProjectAdapter.getPosition(selectedProjectId);
            mProjectAdapter.onSelectedUpdate(selectedProjectId);
            mProjectTilesList.scrollToPosition(pos);
        }
    }

    //==============================================================================================
    //                              Interface SNSWidget.OnChangeListener Impl
    //==============================================================================================
    @Override
    public void onSNSWidgetStart() {
        Log.d(TAG, "onSNSWidgetStart");
        mMainPresenter.punchIn();
    }

    @Override
    public void onSNSWidgetStop() {
        Log.d(TAG, "onSNSWidgetStop");
        mMainPresenter.punchOut();
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

        initListener();
    }

    private void initListener() {

        mSnsWidget.setClickListener(this);
        mFab.setOnClickListener(this);
    }

    private void initFindElements() {
        setContentView(R.layout.activity_main);
        mSnsWidget = (SNSWidget) findViewById(R.id.start_stop_button);
        mProjectTilesList = (RecyclerView) findViewById(R.id.projectTilesList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mProjectTilesList.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mProjectTilesList.getContext(), LinearLayout.VERTICAL);
        mProjectTilesList.addItemDecoration(dividerItemDecoration);
        mFab = (Button) findViewById(R.id.fabButton);
        mProgress = (DottedArcProgress) findViewById(R.id.progress_bar);
        mTimeCounter = (TextView) findViewById(R.id.time_counter);
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
