package com.app.startNstop.views.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

import com.app.startNstop.R;

/**
 * Created by gilad on 4/5/15.
 */
public class NewProjectDialog extends Dialog {

    int mLayoutRes = -1;
    private TextView mNewProjectName;


    public NewProjectDialog(Context context) {
        super(context);
        init();
    }

    public NewProjectDialog(Context context, int theme) {
        super(context, theme);
        init();
    }

    protected NewProjectDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init();
    }

    public NewProjectDialog(int layoutRes, Context context) {
        super(context);

        mLayoutRes = layoutRes;

        init();
    }

    private void init(){
        setContentView(R.layout.new_project_dialog);
        mNewProjectName = (TextView) findViewById(R.id.new_project_name);
    }
}
