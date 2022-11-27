package at.compus02.swd.ss2022.game.gameobjects.factories;

import java.util.ArrayList;
import java.util.List;

import at.compus02.swd.ss2022.game.gameobjects.Tile;
import at.compus02.swd.ss2022.game.gameobjects.tiles.Grass;
import at.compus02.swd.ss2022.game.gameobjects.tiles.Gravel;
import at.compus02.swd.ss2022.game.gameobjects.tiles.Wall;
import at.compus02.swd.ss2022.game.gameobjects.tiles.Water;

public class TileFactory implements GameObjectFactory {
    private static TileFactory instance;
    private List<Tile> objects;

    private TileFactory() {
        initalize();
    }

    public static TileFactory getInstance() {
        if (instance == null) {
            instance = new TileFactory();
        }
        return instance;
    }

    @Override
    public Tile create(GameObjectType type) {
        Tile tile = null;

        switch (type) {
            case TILE_GRASS:
                tile = new Grass();
                break;
            case TILE_GRAVEL:
                tile = new Gravel();
                break;
            case TILE_WALL:
                tile = new Wall();
                break;
            case TILE_WATER:
                tile = new Water();
                break;
            default:
                System.out.println("Unknown GameObjectType");
                break;
        }

        objects.add(tile);

        return tile;
    }

    @Override
    public void initalize() {
        objects = new ArrayList<>();
    }

    @Override
    public Tile[] getObjects() {
        Tile[] objectArray = new Tile[objects.size()];
        return objects.toArray(objectArray);
    }

}
