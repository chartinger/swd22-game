package at.compus02.swd.ss2022.game.gameobjects.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import at.compus02.swd.ss2022.game.gameobjects.Tile;

public class Wall extends Tile {
    public Wall() {
        Texture texture = new Texture("tile_wall.png");
        setSprite(new Sprite(texture));
    }

}
