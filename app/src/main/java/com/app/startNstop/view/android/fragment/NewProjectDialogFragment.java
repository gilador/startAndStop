package com.app.startNstop.view.android.fragment;

import android.app.DialogFragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.app.startNstop.R;
import com.app.startNstop.presenter.MainPresenter;

import io.realm.Realm;


/**
 * Created by gor on 08/10/2016.
 */

public class NewProjectDialogFragment extends DialogFragment implements View.OnClickListener {

    private MainPresenter mMainPresenter;
    EditText mProjectName;
//    Realm mRealm;

    public void setPresenter(MainPresenter mainPresenter) {
        mMainPresenter = mainPresenter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mRealm = Realm.getDefaultInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.new_project, container, false);
        mProjectName = (EditText) v.findViewById(R.id.new_project_name);
        ((Button) v.findViewById(R.id.cancel)).setOnClickListener(this);
        ((Button) v.findViewById(R.id.ok)).setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ok:{
                if(mProjectName.getText() != null && !mProjectName.equals("")){
                    mMainPresenter.createNewProject(String.valueOf(mProjectName.getText()));
                }
            }
            case R.id.cancel:{
                this.dismiss();
            }
        }
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
//        mRealm.close();
    }

    private void createNewProject(String text) {
    }

}
