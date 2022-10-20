package at.compus02.swd.ss2022.game.gameobjects.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import at.compus02.swd.ss2022.game.gameobjects.Tile;

public class Water extends Tile {
    public Water() {
        Texture texture = new Texture("tile_water.png");
        setSprite(new Sprite(texture));
    }

}
