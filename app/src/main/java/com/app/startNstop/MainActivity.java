package com.app.startNstop;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.activeandroid.ActiveAndroid;
import com.app.startNstop.adapters.ProjectNamesAdapter;
import com.app.startNstop.data.SNSProject;
import com.app.startNstop.views.Dialogs.NewProjectDialog;
import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;

import java.util.ArrayList;


public class MainActivity extends Activity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ListView mProjectTilesList;
    private ProjectNamesAdapter mAdapter;
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

//        SNSProject project = new SNSProject();
//        project.projectName = "test1";
//        project.save();

        ArrayList<SNSProject> all = (ArrayList<SNSProject>) SNSProject.getAll();
        mAdapter = new ProjectNamesAdapter(all, this);

        mProjectTilesList.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == mFab.getId()) {
            createNewProject();
        }
    }

    private void createNewProject() {
        NewProjectDialog d = new NewProjectDialog(R.layout.new_project_dialog, this);
        d.create();

        final NiftyDialogBuilder dialogBuilder = NiftyDialogBuilder.getInstance(this);

        final View dialogView = View.inflate(this, R.layout.new_project_dialog, null);

        dialogBuilder.withDuration(700)
                .withTitle(getResources().getString(R.string.new_project_title)) //.withTitle(null)  no title
                .withTitleColor("#FFFFFF")                                  //def
                .withDividerColor("#11000000")                              //def
                .withMessage("This is a modal Dialog.")                     //.withMessage(null)  no Msg
                .withMessageColor("#FFFFFFFF")                              //def  | withMessageColor(int resid)
                .withDialogColor("#FFE74C3C")                               //def  | withDialogColor(int resid)
                .withEffect(Effectstype.Flipv)                                         //def Effectstype.Slidetop
                .withButton1Text("OK")                                      //def gone
                .withButton2Text("Cancel")                                  //def gone
                .isCancelableOnTouchOutside(true)                           //def    | isCancelable(true)
                .setCustomView(dialogView, dialogView.getContext())         //.setCustomView(View or ResId,context)
                .setButton1Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TextView t = (TextView) dialogView.findViewById(R.id.new_project_name);

                        SNSProject project = new SNSProject();
                        project.projectName = t.getText().toString();
                        project.save();

                        getResources().getColor(android.R.color.background_dark)

                        mAdapter.
                        dialogBuilder.dismiss();
                    }
                })
                .setButton2Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), "i'm btn2", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();


    }
}
