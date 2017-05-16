package com.app.startNstop.view.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.startNstop.R;
import com.app.startNstop.model.db.Project;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

/**
 * Created by gor on 08/04/2017.
 */

public class ProjectsAdapter extends RealmRecyclerViewAdapter<Project, ProjectsAdapter.ViewHolder> {


    public ProjectsAdapter(@Nullable OrderedRealmCollection<Project> data, boolean autoUpdate) {
        super(data, autoUpdate);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RelativeLayout view = (RelativeLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.project_tile_view, parent, false);
        TextView title = (TextView) view.findViewById(R.id.title);
        return new ViewHolder(view, title);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder._title.setText(getItem(position).getName());
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView _title;

        public ViewHolder(View itemView, TextView title) {
            super(itemView);
            _title = title;
        }
    }
}
