package com.app.startNstop.view.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.app.startNstop.R;
import com.app.startNstop.model.db.Project;
import com.app.startNstop.presenter.IPresenter;
import com.app.startNstop.view.IView;
import com.app.startNstop.view.MainView;
import com.app.startNstop.view.MainViewImpl;
import com.app.startNstop.view.adapter.ProjectsAdapter;
import com.app.startNstop.view.fragment.NewProjectDialogFragment;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import io.realm.Sort;


public class MainActivity<M extends MainViewImpl> extends BaseActivity implements View.OnClickListener {

    //=========================Static===============================================================
    private static final String TAG = MainActivity.class.getSimpleName();

    //=========================Private Members======================================================
    private RecyclerView mProjectTilesList;
    private Button mFab;
    private ProjectsAdapter mProjectAdapter;
    private Realm mRealm;

    @Inject private MainView mainView;

    //=========================Activity Impl.=======================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRealm = Realm.getDefaultInstance();
        initUi();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    //=========================View.OnClickListener Impl.===========================================
    @Override
    public void onClick(View v) {
        if (v.getId() == mFab.getId()) {
            createNewProject();
        }
    }
    //=========================Private Methods======================================================

    private void initUi() {

        initFindElements();

        initUiList();

        initListener();

    }

    private void initUiList() {
        RealmResults<Project> result =  mRealm.where(Project.class).findAllSortedAsync("date", Sort.DESCENDING);
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

    private void createNewProject() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        // Create and show the dialog.
        NewProjectDialogFragment newFragment = new NewProjectDialogFragment();
        newFragment.show(ft, "dialog");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRealm.close();
    }


    @Override
    MainView getView() {
        return null;
    }
}
