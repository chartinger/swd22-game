package at.compus02.swd.ss2022.game.gameobjects.factories;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;

public interface GameObjectFactory<T extends GameObject> {
    public enum GameObjectType {
        PLAYER,
        TILE_GRASS,
        TILE_GRAVEL,
        TILE_WALL,
        TILE_WATER,
        SIGN,
        PROJECTILE,
        ENEMY
    }

    public T create(GameObjectType type);

    public void initalize();

    public T[] getObjects();

}
