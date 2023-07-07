package com.example.offlinemap;

import android.content.Context;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.MapTileProviderBasic;
import org.osmdroid.tileprovider.modules.ArchiveFileFactory;
import org.osmdroid.tileprovider.modules.DatabaseFileArchive;
import org.osmdroid.tileprovider.modules.IArchiveFile;
import org.osmdroid.tileprovider.modules.MBTilesFileArchive;
import org.osmdroid.tileprovider.tilesource.ITileSource;
import org.osmdroid.tileprovider.tilesource.OnlineTileSourceBase;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.tileprovider.tilesource.XYTileSource;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MapDataSource {
    private MapTileProviderBasic tileProvider;

    public MapDataSource(Context context, String tileSourcePath) {
        Configuration.getInstance().setUserAgentValue(context.getPackageName());

        File file = new File(tileSourcePath);

        tileProvider = new MapTileProviderBasic(context, TileSourceFactory.DEFAULT_TILE_SOURCE);

        tileProvider.setUseDataConnection(false);
        tileProvider.getTileWriter();
    }

    public List<Tile> getTiles(int x, int y, int zoomLevel) {
        List<Tile> tiles = new ArrayList<>();
        MapTile tile = new MapTile(zoomLevel, x, y);
        tiles.add(new Tile(tile));

        return tiles;
    }

    public boolean isDataConnectionEnabled() {
        return true;
    }

    public OnlineTileSourceBase getTileSource() {
        return TileSourceFactory.DEFAULT_TILE_SOURCE;
    }
}
