package com.example.offlinemap;

import android.content.Context;

import org.osmdroid.config.Configuration;
import org.osmdroid.views.MapView;

public class MapSDK {
    private Context context;
    private MapView mapView;
    private MapDataSource mapDataSource;

    public MapSDK(Context context, MapView mapView, String tileSourcePath) {
        this.context = context;
        this.mapView = mapView;
        Configuration.getInstance().setUserAgentValue(context.getPackageName());
        mapDataSource = new MapDataSource(context, tileSourcePath);
    }

    public void initialize() {
        mapView.setTileSource(mapDataSource.getTileSource());
        mapView.setUseDataConnection(mapDataSource.isDataConnectionEnabled());
    }
}
