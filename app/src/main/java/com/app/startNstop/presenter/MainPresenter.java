package com.app.startNstop.presenter;

import android.content.Context;

import com.google.android.gms.maps.model.Marker;

/**
 * Created by gor on 10/05/2017.
 */

public interface MainPresenter<T> extends IPresenter<T> {

    void onMapReady(Context ctx);
    void onMarkerClick(Marker theMarker);
}
