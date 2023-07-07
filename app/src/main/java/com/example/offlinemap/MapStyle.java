package com.example.offlinemap;

import android.content.Context;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.MapTileProviderBasic;
import org.osmdroid.tileprovider.modules.DatabaseFileArchive;
import org.osmdroid.tileprovider.modules.IArchiveFile;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.tileprovider.tilesource.XYTileSource;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MapStyle {
    private MapTileProviderBasic tileProvider;

    public MapStyle(Context context, String tileSourcePath) {
        Configuration.getInstance().setUserAgentValue(context.getPackageName());

        File file = new File(tileSourcePath);
        XYTileSource tileSource = new XYTileSource("CustomMapStyle", 0, 18, 256, ".png", new String[]{});

        tileProvider = new MapTileProviderBasic(context, tileSource);
        tileProvider.setUseDataConnection(false);
        tileProvider.getTileWriter();
    }

    public List<Tile> getTiles(int x, int y, int zoomLevel) {
        List<Tile> tiles = new ArrayList<>();
        MapTile tile = new MapTile(zoomLevel, x, y);
        tiles.add(new Tile(tile));

        return tiles;
    }

    public MapTileProviderBasic getTileProvider() {
        return tileProvider;
    }
}
