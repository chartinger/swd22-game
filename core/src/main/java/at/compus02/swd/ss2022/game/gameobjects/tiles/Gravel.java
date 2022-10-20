package at.compus02.swd.ss2022.game.gameobjects.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import at.compus02.swd.ss2022.game.gameobjects.Tile;

public class Gravel extends Tile {
    public Gravel() {
        Texture texture = new Texture("tile_gravel.png");
        setSprite(new Sprite(texture));
    }

}
