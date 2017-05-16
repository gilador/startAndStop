package com.app.startNstop.view.android.fragment;

import android.app.DialogFragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.app.startNstop.R;

import io.realm.Realm;


/**
 * Created by gor on 08/10/2016.
 */

public class NewProjectDialogFragment extends DialogFragment implements View.OnClickListener {

    EditText mProjectName;
    Realm mRealm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRealm = Realm.getDefaultInstance();
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
                    createNewProject(mProjectName.getText());
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
        mRealm.close();
    }

    private void createNewProject(String text) {

    }

    private class DownloadFilesTask extends AsyncTask<URL, Integer, Long> {
        protected Long doInBackground(URL... urls) {
            int count = urls.length;
            long totalSize = 0;
            for (int i = 0; i < count; i++) {
                totalSize += Downloader.downloadFile(urls[i]);
                publishProgress((int) ((i / (float) count) * 100));
                // Escape early if cancel() is called
                if (isCancelled()) break;
            }
            return totalSize;
        }

        protected void onProgressUpdate(Integer... progress) {
            setProgressPercent(progress[0]);
        }

        protected void onPostExecute(Long result) {
            showDialog("Downloaded " + result + " bytes");
        }
    }
}
