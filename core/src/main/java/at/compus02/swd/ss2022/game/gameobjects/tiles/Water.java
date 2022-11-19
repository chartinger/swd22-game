package at.compus02.swd.ss2022.game.gameobjects.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import at.compus02.swd.ss2022.game.gameobjects.Tile;
import at.compus02.swd.ss2022.repository.AssetRepository;
import at.compus02.swd.ss2022.repository.AssetRepository.TextureType;

public class Water extends Tile {
    public Water() {
        Texture texture = AssetRepository.getInstance().getTexture(TextureType.TILE_WATER);
        setSprite(new Sprite(texture));
    }

}
