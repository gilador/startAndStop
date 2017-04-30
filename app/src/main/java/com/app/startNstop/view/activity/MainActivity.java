package com.app.startNstop.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.app.startNstop.R;
import com.app.startNstop.model.DBHelper;
import com.app.startNstop.model.ProjectsTable;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;


public class MainActivity extends Activity implements View.OnClickListener {

    //=========================Static===============================================================
    private static final String TAG = MainActivity.class.getSimpleName();

    //=========================Private Members======================================================
    private DBHelper mDBHelper;
    private RecyclerView mProjectTilesList;
    private Button mFab;

    //=========================Activity Impl.=======================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();
    }

    //=========================View.OnClickListener Impl.===========================================
    @Override
    public void onClick(View v) {
        if (v.getId() == mFab.getId()) {
            createNewProject();
        }
    }
    //=========================Private Methods======================================================

    private DBHelper getHelper() {
        if (mDBHelper == null) {
            mDBHelper = OpenHelperManager.getHelper(this, DBHelper.class);
        }
        return mDBHelper;
    }

    private void initUi() {

        initFindElements();

        initUiList();

        initListener();

    }

    private void initUiList() {

        try {
            Dao<ProjectsTable, Long> dao = getHelper().getProjectsTableDao();
            List<ProjectsTable> allProjects = dao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        ArrayList<SNSProject> all = (ArrayList<SNSProject>) SNSProject.getAll();
//        mAdapter = new ProjectNamesAdapter(all, this);
//
//        mProjectTilesList.setAdapter(mAdapter);
    }

    private void initListener() {
        mFab.setOnClickListener(this);
    }

    private void initFindElements() {
        mProjectTilesList = (RecyclerView) findViewById(R.id.projectTilesList);
        mFab = (Button) findViewById(R.id.fabButton);
    }

    private void createNewProject() {
    }
}
