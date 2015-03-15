package com.app.startNstop;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.activeandroid.ActiveAndroid;
import com.app.startNstop.adapters.ProjectNamesAdapter;

import java.util.ArrayList;


public class MainActivity extends Activity implements View.OnClickListener {

    private ListView mProjectTilesList;
    private ArrayList<String> projectNamesList;
    private ProjectNamesAdapter mAdapter;
    private ImageButton mFab;

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
        mFab = (ImageButton) findViewById(R.id.fabButton);
    }

    private void initUiList() {

        projectNamesList.add("1");
        projectNamesList.add("2");
        projectNamesList.add("3");
        mAdapter = new ProjectNamesAdapter(projectNamesList, this);

        mProjectTilesList.setAdapter(mAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == mFab.getId()){
            createNewProject();
        }
    }

    private void createNewProject() {

    }
}
