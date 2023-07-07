package com.example.offlinemap;

public class Tile {
    private MapTile mapTile;

    public Tile(MapTile mapTile) {
        this.mapTile = mapTile;
    }

    public MapTile getMapTile() {
        return mapTile;
    }
}
