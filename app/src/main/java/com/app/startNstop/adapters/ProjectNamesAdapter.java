package com.app.startNstop.adapters;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

import com.app.startNstop.data.SNSProject;
import com.app.startNstop.views.ProjectTileView;

import java.util.ArrayList;

/**
 * Created by gilad on 3/8/15.
 */
public class ProjectNamesAdapter implements ListAdapter {

    ArrayList<SNSProject> mData;
    private Context mContext;

    public ProjectNamesAdapter(ArrayList<SNSProject> data, Context contxet) {

        mData = data;
        mContext = contxet;
    }


    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = new ProjectTileView(mContext);
        }

        if (mData.size() < position) {
            ((ProjectTileView) convertView).setName(mData.get(position).projectName);
        }

        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
