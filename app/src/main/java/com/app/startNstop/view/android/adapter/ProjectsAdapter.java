package com.app.startNstop.view.android.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.startNstop.R;
import com.app.startNstop.model.db.Project;
import com.app.startNstop.presenter.MainPresenter;

import io.realm.OrderedRealmCollection;

/**
 * Created by gor on 08/04/2017.
 */

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ViewHolder> {


    private final MainPresenter                   mMainPresenter;
    private       OrderedRealmCollection<Project> mData;
    private       int                             mSelectedPos;
    private       ViewHolder                      mSelectedViewHolder;


    public ProjectsAdapter(@Nullable OrderedRealmCollection<Project> data, MainPresenter presenter) {
        mData = data;
        mMainPresenter = presenter;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RelativeLayout view = (RelativeLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.project_tile_view, parent, false);
        TextView title = (TextView) view.findViewById(R.id.title);
        return new ViewHolder(view, title);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        if (mData.size() > position) {
            if (mSelectedViewHolder == null) {
                mSelectedViewHolder = holder;
            }
            holder._title.setText(getItem(position).getName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mMainPresenter.onProjectSelected(getItem(position).getId());
                }
            });

            if (position == mSelectedPos) {
                applySelected(holder, position);
            } else {
                setColors(holder, false);
            }
        }
    }

    private void applySelected(ViewHolder holder, int position) {
        mSelectedPos = position;
        setColors(mSelectedViewHolder, false);
        setColors(holder, true);
        mSelectedViewHolder = holder;
    }

    private void setColors(ViewHolder holder, boolean isSelected) {
        holder.itemView.setSelected(isSelected);
        int color = isSelected ? holder.itemView.getResources().getColor(R.color.yellow, null) : holder.itemView.getResources().getColor(R.color.blue, null);
        holder._title.setTextColor(color);
    }

    private Project getItem(int position) {
        return mData.get(position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public void update(OrderedRealmCollection<Project> data) {
        mData = data;
        notifyDataSetChanged();
    }

    public int getPosition(long selectedProjectId) {
        for (int i = 0; i < mData.size(); i++) {
            if (mData.get(i).getId() == selectedProjectId) {
                return i;
            }
        }

        return -1;
    }

    public void onSelectedUpdate(long selectedId){
        int pos = getPosition(selectedId);
        int pre = mSelectedPos;
        mSelectedPos = pos;
        notifyItemChanged(pre);
        notifyItemChanged(mSelectedPos);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView _title;

        public ViewHolder(View itemView, TextView title) {
            super(itemView);
            _title = title;
        }
    }
}
