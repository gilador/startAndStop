package com.app.startNstop.view.fragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.app.startNstop.R;


/**
 * Created by gor on 08/10/2016.
 */

public class NewProjectDialogFragment extends DialogFragment implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.new_project, container, false);
        EditText newProjectName = (EditText) v.findViewById(R.id.new_project_name);
        Button cancelBtn = (Button) v.findViewById(R.id.cancel);
        Button okBtn = (Button) v.findViewById(R.id.ok);

        cancelBtn.setOnClickListener(this);
        okBtn.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ok:{

            }
            case R.id.cancel:{
                this.dismiss();
            }
        }
    }
}
