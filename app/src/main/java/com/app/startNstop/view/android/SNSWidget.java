package com.app.startNstop.view.android;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.app.startNstop.R;


/**
 * Created by gor on 02/06/2017.
 */

public class SNSWidget extends View {

    private OnChangeListener mListener;
    private boolean isStart = false;

    public SNSWidget(Context context) {
        super(context);
        init();
    }

    public SNSWidget(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SNSWidget(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setStop();
    }

    public void setClickListener(OnChangeListener listener) {
        mListener = listener;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {

            if (isStart) {
                setStop();
            } else {
                setStart();
            }
        }
        return true;
    }

    private void setStart() {
        isStart = true;
        setBackgroundResource(R.drawable.round_green_button);
        if (mListener != null) {
            mListener.onSNSWidgetStart();
        }

    }

    private void setStop() {
        isStart = false;
        setBackgroundResource(R.drawable.round_red_button);
        if (mListener != null) {
            mListener.onSNSWidgetStop();
        }

    }

    public interface OnChangeListener {
        void onSNSWidgetStart();
        void onSNSWidgetStop();
    }
}
