package com.app.startNstop.view.activitiy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.activeandroid.ActiveAndroid;
import com.app.startNstop.R;


public class MainActivity extends Activity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ListView mProjectTilesList;
    private Button mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActiveAndroid.initialize(this);

        initUi();
    }

    private void initUi() {

        initFindElements();

        initUiList();

        initListener();


    }

    private void initListener() {
        mFab.setOnClickListener(this);
    }

    private void initFindElements() {
        mProjectTilesList = (ListView) findViewById(R.id.projectTilesList);
        mFab = (Button) findViewById(R.id.fabButton);
    }

    private void initUiList() {

//        ArrayList<SNSProject> all = (ArrayList<SNSProject>) SNSProject.getAll();
//        mAdapter = new ProjectNamesAdapter(all, this);
//
//        mProjectTilesList.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == mFab.getId()) {
            createNewProject();
        }
    }

    private void createNewProject() {
    }
}
