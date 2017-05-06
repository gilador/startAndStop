package com.app.startNstop.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.startNstop.R;

import static java.security.AccessController.getContext;

/**
 * Created by gor on 08/04/2017.
 */

public class ProjectsAdapter extends RecyclerView.CursorRecyclerViewAdapter<ProjectsAdapter.ViewHolder> {
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RelativeLayout view = (RelativeLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.project_tile_view, parent, false);
        TextView title = (TextView) view.findViewById(R.id.title);
        return new ViewHolder(view, title);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        if(convertView == null){
//            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = inflater.inflate(R.layout.project_tile_view, parent, false);
//
//        }
//        return super.getView(position, convertView, parent);
//    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView _title;

        public ViewHolder(View itemView, TextView title) {
            super(itemView);
            _title = title;
        }
    }
}
