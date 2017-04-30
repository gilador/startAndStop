package com.app.startNstop.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.app.startNstop.model.ProjectsTable;

import java.util.List;

/**
 * Created by gor on 08/04/2017.
 */

public class ProjectsAdapter extends ArrayAdapter<ProjectsTable> {
    public ProjectsAdapter(Context context, int resource, List<ProjectsTable> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return super.getView(position, convertView, parent);
    }

    @Override
    public int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    @Override
    public int getCount() {
        return super.getCount();
    }
}
