package com.app.startNstop.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.startNstop.R;

/**
 * Created by gilad on 3/8/15.
 */
public class ProjectTileView extends RelativeLayout {

    TextView mName;

    public ProjectTileView(Context context) {
        super(context);
        init();
    }

    public ProjectTileView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ProjectTileView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ProjectTileView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {

        inflate(getContext(), R.layout.project_tile_view, this);
        mName = (TextView) findViewById(R.id.title);


    }

    public void setName(String name) {
        mName.setText(name);
    }
}
