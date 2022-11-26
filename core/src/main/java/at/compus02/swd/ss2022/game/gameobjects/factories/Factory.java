package at.compus02.swd.ss2022.game.gameobjects.factories;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;

public interface Factory {
    public enum GameObjectType {
        PLAYER,
        TILE_GRASS,
        TILE_GRAVEL,
        TILE_WALL,
        TILE_WATER,
        SIGN,
        PROJECTILE,
    }

    public GameObject create(GameObjectType type);

    public void initalize();

    public GameObject[] getObjects();

}
