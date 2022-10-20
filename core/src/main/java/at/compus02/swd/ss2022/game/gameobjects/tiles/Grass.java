package at.compus02.swd.ss2022.game.gameobjects.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import at.compus02.swd.ss2022.game.gameobjects.Tile;

public class Grass extends Tile {
    public Grass() {
        Texture texture = new Texture("tile_grass.png");
        setSprite(new Sprite(texture));
    }

}
