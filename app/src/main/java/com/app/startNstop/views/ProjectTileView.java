package com.app.startNstop.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.app.startNstop.R;

/**
 * Created by gilad on 3/8/15.
 */
public class ProjectTileView extends RelativeLayout {

    public ProjectTileView(Context context) {
        super(context);
    }

    public ProjectTileView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ProjectTileView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ProjectTileView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(){
        inflate(getContext(), R.layout.project_tile_view, this);
    }
}
